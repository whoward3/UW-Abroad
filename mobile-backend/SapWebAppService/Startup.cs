using Microsoft.Owin;
using Owin;

[assembly: OwinStartup(typeof(SapWebApp.Startup))]

namespace SapWebApp
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureMobileApp(app);
        }
    }
}