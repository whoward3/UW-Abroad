using Microsoft.Azure.Mobile.Server;
using SapWebApp.DataObjects;

namespace SapWebApp.DataObjects
{
    public class School : EntityData
    {
        public string SchoolName { get; set; }
        public string Description { get; set; }
        public string OfferedDate { get; set; }
        public string Region { get; set; }
        public string PrimaryLanguage { get; set; }

    }
}