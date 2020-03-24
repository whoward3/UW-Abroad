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
            // Database.SetInitializer<SAPAPPNAMEContext>(null);

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
            List<School> jSchools = new List<School> { };
            List<School> schools = new List<School> { };

            List<Major> jMajors = new List<Major> { };
            List<Major> majors = new List<Major> { };

            using (StreamReader r = new StreamReader("D:\\home\\site\\wwwroot\\App_start\\schools-seed.json"))
            {
                string json = r.ReadToEnd();
                jSchools = JsonConvert.DeserializeObject<List<School>>(json);
            }

            foreach (var school in jSchools)
            {
                schools.Add(new School { Id = Guid.NewGuid().ToString(), PageURL = school.PageURL, Country = school.Country, ImageURL = school.ImageURL, SchoolName = school.SchoolName });
            }

            foreach (School s in schools)
            {
                context.Set<School>().Add(s);
            }           

            using (StreamReader r = new StreamReader("D:\\home\\site\\wwwroot\\App_start\\majors-seed.json"))
            {
                string json = r.ReadToEnd();
                jMajors = JsonConvert.DeserializeObject<List<Major>>(json);
            }

            foreach (var major in jMajors)
            {
                majors.Add(new Major { Id = Guid.NewGuid().ToString(), MajorName = major.MajorName, Bachelors = major.Bachelors, Masters = major.Masters, Doctorate = major.Doctorate, Other = major.Other });
            }

            foreach (Major m in majors)
            {
                context.Set<Major>().Add(m);
            }

            base.Seed(context);
        }

    }
}
