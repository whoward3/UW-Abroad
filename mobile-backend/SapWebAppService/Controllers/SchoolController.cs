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
    public class SchoolController : TableController<School>
    {
        protected override void Initialize(HttpControllerContext controllerContext)
        {
            base.Initialize(controllerContext);
            SapWebAppContext context = new SapWebAppContext();
            DomainManager = new EntityDomainManager<School>(context, Request);
        }

        // GET tables/School
        public IQueryable<School> GetAllSchools()
        {
            return Query();
        }

        // GET tables/School/48D68C86-6EA6-4C25-AA33-223FC9A27959
        public SingleResult<School> GetSchool(string id)
        {
            return Lookup(id);
        }

        // PATCH tables/School/48D68C86-6EA6-4C25-AA33-223FC9A27959
        public Task<School> PatchSchool(string id, Delta<School> patch)
        {
            return UpdateAsync(id, patch);
        }

        // POST tables/School
        public async Task<IHttpActionResult> PostSchool(School item)
        {
            School current = await InsertAsync(item);
            return CreatedAtRoute("Tables", new { id = current.Id }, current);
        }

        // DELETE tables/School/48D68C86-6EA6-4C25-AA33-223FC9A27959
        public Task DeleteSchool(string id)
        {
            return DeleteAsync(id);
        }
    }
}