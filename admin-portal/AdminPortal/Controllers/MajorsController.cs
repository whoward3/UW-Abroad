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
  
    public class MajorsController : Controller
    {
        private MyDatabaseContext db = new MyDatabaseContext();

        // GET: Majors
        [System.Web.Mvc.AllowAnonymous]
        public ActionResult Index()
        {
            Trace.WriteLine("GET /Majors/Index");
            return View(db.Majors.ToList());
        }

        // GET: Majors/Details/5
        [System.Web.Mvc.AllowAnonymous]
        public ActionResult Details(string id)
        {
            Trace.WriteLine("GET /Majors/Details/" + id);
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Major major = db.Majors.Find(id);
            if (major == null)
            {
                return HttpNotFound();
            }
            return View(major);
        }

        // GET: Majors/Create
        [System.Web.Mvc.Authorize]
        public ActionResult Create()
        {
            Trace.WriteLine("GET /Majors/Create");
            return View(new Major { });
        }

        // TODO -> POST: Majors/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        [System.Web.Mvc.Authorize]
        public ActionResult Create([Bind(Include = "MajorName, Id, Bachelors, Masters, Doctorate, Other")] Major major)
        {
            Trace.WriteLine("POST /Majors/Create");
            if (ModelState.IsValid)
            {
                major.Id = Guid.NewGuid().ToString();
                major.Deleted = false;
                major.CreatedAt = DateTimeOffset.Now;
                major.UpdatedAt = DateTimeOffset.Now;
                db.Majors.Add(major);
                db.SaveChanges();
                return RedirectToAction("Index");
            }
           
            return View(major);
        }

        // GET: Majors/Edit/5
        [System.Web.Mvc.Authorize]
        public ActionResult Edit(string id)
        {
            Trace.WriteLine("GET /Majors/Edit/" + id);
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Major major = db.Majors.Find(id);
            if (major == null)
            {
                return HttpNotFound();
            }
            return View(major);
        }

        // TODO -> POST: Majors/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        [System.Web.Mvc.Authorize]
        public ActionResult Edit([Bind(Include = "MajorName, Id, Bachelors, Masters, Doctorate, Other")] Major major)
        {
            
            Trace.WriteLine("POST /Majors/Edit/" + major);
           if (ModelState.IsValid)
           {
                major.CreatedAt = DateTimeOffset.Now;
                major.UpdatedAt = DateTimeOffset.Now;
               db.Entry(major).State = EntityState.Modified;
               db.SaveChanges();
               return RedirectToAction("Index");
           }
           
            return View(major);
        }

        // GET: Majors/Delete/5
        [System.Web.Mvc.Authorize]
        public ActionResult Delete(string id)
        {
            Trace.WriteLine("GET /Majors/Delete/" + id);
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Major major = db.Majors.Find(id);
            if (major == null)
            {
                return HttpNotFound();
            }
            return View(major);
        }

        // TODO -> POST: Majors/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        [System.Web.Mvc.Authorize]
        public ActionResult DeleteConfirmed(string id)
        {
           
            Trace.WriteLine("POST /Majors/Delete/" + id);
            Major major = db.Majors.Find(id);
            db.Majors.Remove(major);
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
