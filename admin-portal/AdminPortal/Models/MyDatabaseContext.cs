using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace AdminPortal.Models
{
    public class MyDatabaseContext : DbContext
    {
    
        public MyDatabaseContext() : base("name=MyDbConnection")
        {
        }

        public DbSet<School> Schools { get; set; }
        public DbSet<Post> Posts { get; set; }
        public DbSet<Major> Majors { get; set; }
    }
}
