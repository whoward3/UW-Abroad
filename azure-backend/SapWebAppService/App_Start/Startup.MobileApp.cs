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

            /*
             *  TODO: Below instead of creating a hardcoded list of schools, we will import a file of default information for the db on startup
             */
            List<School> schools = new List<School>
            {
                new School { Id = Guid.NewGuid().ToString(), SchoolName = "an Example School Name", Description = "an Example Description" , OfferedDate = "date/time", Region = "region", PrimaryLanguage = "a language"},

                new School { Id = Guid.NewGuid().ToString(), SchoolName = "another School Name", Description = "another Description" , OfferedDate = "date/time", Region = "region", PrimaryLanguage = "a language"},
            };

            List<Major> majors = new List<Major>
            {
                new Major { Id = Guid.NewGuid().ToString(), SchoolName = "another School Name", MajorName = "COSC" },

                new Major { Id = Guid.NewGuid().ToString(), SchoolName = "another School Name", MajorName = "STAT" },
            };

            foreach (School school in schools)
            {
                context.Set<School>().Add(school);
            }

            foreach (Major major in majors)
            {
                context.Set<Major>().Add(major);
            }

            base.Seed(context);
            }
    }
}

