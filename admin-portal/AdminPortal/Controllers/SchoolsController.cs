using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using AdminPortal.Models;
using System.Diagnostics;

namespace AdminPortal.Controllers
{
    
    public class SchoolsController : Controller
    {
        private MyDatabaseContext db = new MyDatabaseContext();

        // GET: Schools
        [System.Web.Mvc.AllowAnonymous]
        public ActionResult Index()
        {
            Trace.WriteLine("GET /Schools/Index");
            return View(db.Schools.ToList());
        }

        // GET: Schools/Details/5
        [System.Web.Mvc.AllowAnonymous]
        public ActionResult Details(string id)
        {
            Trace.WriteLine("GET /Schools/Details/" + id);
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            School school = db.Schools.Find(id);
            if (school == null)
            {
                return HttpNotFound();
            }
            return View(school);
        }

        // GET: Schools/Create
        [System.Web.Mvc.Authorize]
        public ActionResult Create()
        {
            Trace.WriteLine("GET /Schools/Create");
            return View(new School { });
        }

        // TODO -> POST: Schools/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        [System.Web.Mvc.Authorize]
        public ActionResult Create([Bind(Include = "SchoolName, Id, Country, ImageURL, PageURL")] School school)
        {
          
            Trace.WriteLine("POST /Schools/Create");
            if (ModelState.IsValid)
            {
                school.Id = Guid.NewGuid().ToString();
                school.Deleted = false;
                school.CreatedAt = DateTimeOffset.Now;
                school.UpdatedAt = DateTimeOffset.Now;
                db.Schools.Add(school);
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            
            return View(school);
        }

        // GET: Schools/Edit/5
        [System.Web.Mvc.Authorize]
        public ActionResult Edit(string id)
        {
            Trace.WriteLine("GET /Schools/Edit/" + id);
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            School school = db.Schools.Find(id);
            if (school == null)
            {
                return HttpNotFound();
            }
            return View(school);
        }

        // TODO -> POST: Schools/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        [System.Web.Mvc.Authorize]
        public ActionResult Edit([Bind(Include = "SchoolName, Id, Country, ImageURL, PageURL")] School school)
        {
            Trace.WriteLine("POST /Schools/Edit/" + school);
            if (ModelState.IsValid)
            {
                school.CreatedAt = DateTimeOffset.Now;
                school.UpdatedAt = DateTimeOffset.Now;
                db.Entry(school).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            
            return View(school);
        }

        // GET: Schools/Delete/5
        [System.Web.Mvc.Authorize]
        public ActionResult Delete(string id)
        {
            Trace.WriteLine("GET /Schools/Delete/" + id);
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            School school = db.Schools.Find(id);
            if (school == null)
            {
                return HttpNotFound();
            }
            return View(school);
        }

        // TODO -> POST: Schools/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        [System.Web.Mvc.Authorize]
        public ActionResult DeleteConfirmed(string id)
        {
            Trace.WriteLine("POST /Schools/Delete/" + id);
             School school = db.Schools.Find(id);
             db.Schools.Remove(school);
             db.SaveChanges();
            
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
