using Microsoft.Azure.Mobile.Server;

namespace SapWebApp.DataObjects
{
    public class School : EntityData
    {
        public string SchoolName { get; set; }
        public string Country { get; set; }       
        public string ImageURL { get; set; }
        public string PageURL { get; set; }
    }
}