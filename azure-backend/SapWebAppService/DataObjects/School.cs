using Microsoft.Azure.Mobile.Server;
using SapWebApp.DataObjects;
using System.Collections.Generic;

namespace SapWebApp.DataObjects
{
    public class School : EntityData
    {
        public School()
        {
            this.Majors = new HashSet<Major>();
        }
        public string SchoolName { get; set; }
        public string Description { get; set; }
        public string OfferedDate { get; set; }
        public string Region { get; set; }
        public string PrimaryLanguage { get; set; }
        public virtual ICollection<Major> Majors { get; set; }

    }


}