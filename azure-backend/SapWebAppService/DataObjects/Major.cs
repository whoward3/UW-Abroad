using Microsoft.Azure.Mobile.Server;

namespace SapWebApp.DataObjects
{
    public class Major : EntityData
    {
        public string MajorName { get; set; }
        public bool Bachelors { get; set; }
        public bool Masters { get; set; }
        public bool PhD { get; set; }
    }
}