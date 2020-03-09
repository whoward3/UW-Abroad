using System.Linq;
using System.Threading.Tasks;
using System.Web.Http;
using System.Web.Http.Controllers;
using System.Web.Http.OData;
using Microsoft.Azure.Mobile.Server;
using SapWebApp.DataObjects;
using SapWebApp.Models;

namespace SapWebApp.Controllers
{
    public class MajorController : TableController<Major>
    {
        protected override void Initialize(HttpControllerContext controllerContext)
        {
            base.Initialize(controllerContext);
            SapWebAppContext context = new SapWebAppContext();
            DomainManager = new EntityDomainManager<Major>(context, Request);
        }

        // GET tables/Major
        public IQueryable<Major> GetAllMajors()
        {
            return Query();
        }

        // GET tables/Major/48D68C86-6EA6-4C25-AA33-223FC9A27959
        public SingleResult<Major> GetMajor(string id)
        {
            return Lookup(id);
        }

        // PATCH tables/Major/48D68C86-6EA6-4C25-AA33-223FC9A27959
        public Task<Major> PatchMajor(string id, Delta<Major> patch)
        {
            return UpdateAsync(id, patch);
        }

        // Major tables/Major
        public async Task<IHttpActionResult> MajorContent(Major item)
        {
            Major current = await InsertAsync(item);
            return CreatedAtRoute("Tables", new { id = current.Id }, current);
        }

        // DELETE tables/Major/48D68C86-6EA6-4C25-AA33-223FC9A27959
        public Task DeleteMajor(string id)
        {
            return DeleteAsync(id);
        }
    }
}
