using System;

namespace AdminPortal.Models
{
    public class Post
    {
        public string Id { get; set; }
        public string SchoolName { get; set; }
        public string UserName { get; set; }
        public string PostContent { get; set; }
        public bool Deleted { get; set; }
        public DateTimeOffset CreatedAt { get; set; }
        public DateTimeOffset UpdatedAt { get; set; }
    }
}