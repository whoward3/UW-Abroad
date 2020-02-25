using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.Entity;
using System.Web.Http;
using Microsoft.Azure.Mobile.Server;
using Microsoft.Azure.Mobile.Server.Authentication;
using Microsoft.Azure.Mobile.Server.Config;
using SapWebApp.DataObjects;
using SapWebApp.Models;
using Owin;
using Newtonsoft.Json.Linq;
using System.IO;
using Newtonsoft.Json;

namespace SapWebApp
{
    public partial class Startup
    {
        public static void ConfigureMobileApp(IAppBuilder app)
        {
            HttpConfiguration config = new HttpConfiguration();

            //For more information on Web API tracing, see http://go.microsoft.com/fwlink/?LinkId=620686 
            config.EnableSystemDiagnosticsTracing();

            new MobileAppConfiguration()
                .UseDefaultConfiguration()
                .ApplyTo(config);

            // Use Entity Framework Code First to create database tables based on your DbContext
            Database.SetInitializer(new SapWebAppInitializer());

            // To prevent Entity Framework from modifying your database schema, use a null database initializer
            // Database.SetInitializer<ZUMOAPPNAMEContext>(null);

            MobileAppSettingsDictionary settings = config.GetMobileAppSettingsProvider().GetMobileAppSettings();

            if (string.IsNullOrEmpty(settings.HostName))
            {
                // This middleware is intended to be used locally for debugging. By default, HostName will
                // only have a value when running in an App Service application.
                app.UseAppServiceAuthentication(new AppServiceAuthenticationOptions
                {
                    SigningKey = ConfigurationManager.AppSettings["SigningKey"],
                    ValidAudiences = new[] { ConfigurationManager.AppSettings["ValidAudience"] },
                    ValidIssuers = new[] { ConfigurationManager.AppSettings["ValidIssuer"] },
                    TokenHandler = config.GetAppServiceTokenHandler()
                });
            }
            app.UseWebApi(config);
        }
    }

    public class SapWebAppInitializer : CreateDatabaseIfNotExists<SapWebAppContext>
    {
        protected override void Seed(SapWebAppContext context)
        {
            List<JSchool> jschools = new List<JSchool>
            {
                new JSchool {  Country = "Australia", SchoolName = "Exchange: Queensland University of Technology (QUT)", ImageURL = "https://uwyo-sa.terradotta.com/_customtags/ct_Image.cfm?Image_ID=284226", PageURL = "https://uwyo-sa.terradotta.com/index.cfm?FuseAction=Programs.ViewProgramAngular&id=23391" },
                new JSchool {  Country = "Australia", SchoolName = "Exchange: Queensland University of Technology (QUT)", ImageURL = "https://uwyo-sa.terradotta.com/_customtags/ct_Image.cfm?Image_ID=284226", PageURL = "https://uwyo-sa.terradotta.com/index.cfm?FuseAction=Programs.ViewProgramAngular&id=23391" }
            };

            List<School> schools = new List<School> { };

            //using (StreamReader r = new StreamReader("seeder.json"))
            //{
            //    string json = r.ReadToEnd();
            //    jschools = JsonConvert.DeserializeObject<List<JSchool>>(json);
            //}

            foreach (var school in jschools)
            {
                schools.Add(new School { Id = Guid.NewGuid().ToString(), PageURL = school.PageURL, Country = school.Country, ImageURL = school.ImageURL, SchoolName = school.SchoolName });
            }

            foreach (School s in schools)
            {
                context.Set<School>().Add(s);
            }

            base.Seed(context);
        }
    }
}
public class JSchool
{
    public string Country { get; set; }
    public string SchoolName { get; set; }
    public string ImageURL { get; set; }
    public string PageURL { get; set; }
}

