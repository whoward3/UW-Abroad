using System;

namespace AdminPortal.Models
{
    public class Major
    {
        public string Id { get; set; }
        public string MajorName { get; set; }
        public bool Bachelors { get; set; }
        public bool Masters { get; set; }
        public bool Doctorate { get; set; }
        public bool Other { get; set; }
        public bool Deleted { get; set; }
        public DateTimeOffset CreatedAt { get; set; }
        public DateTimeOffset UpdatedAt { get; set; }
    }
}