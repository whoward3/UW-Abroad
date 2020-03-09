using Microsoft.Azure.Mobile.Server;

namespace SapWebApp.DataObjects
{
    public class Post : EntityData
    {
        public string SchoolName { get; set; }
        public string UserName { get; set; }
        public string PostContent { get; set; }
    }
}