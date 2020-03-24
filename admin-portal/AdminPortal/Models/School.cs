using System;

namespace AdminPortal.Models
{
    public class School
    {
        public string Id { get; set; }
        public string SchoolName { get; set; }
        public string Country { get; set; }       
        public string ImageURL { get; set; }
        public string PageURL { get; set; }
        public DateTimeOffset CreatedAt { get; set; }
        public DateTimeOffset UpdatedAt { get; set; }
    }
}