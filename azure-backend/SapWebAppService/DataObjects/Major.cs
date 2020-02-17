using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Microsoft.Azure.Mobile.Server;
using SapWebApp.DataObjects;

namespace SapWebApp.DataObjects
{
    public class Major
    {
        public Major()
        {
            this.Schools = new HashSet<School>();
        }
        public string MajorName { get; set; }
        public string Id { get; internal set; }
        public virtual ICollection<School> Schools { get; set; }
    }
}