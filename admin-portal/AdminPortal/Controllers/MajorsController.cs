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
    [System.Web.Mvc.AllowAnonymous]
    public class MajorsController : Controller
    {
        private MyDatabaseContext db = new MyDatabaseContext();

        // GET: Majors
        public ActionResult Index()
        {
            Trace.WriteLine("GET /Majors/Index");
            return View(db.Majors.ToList());
        }

        // GET: Majors/Details/5
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
        public ActionResult Create()
        {
            Trace.WriteLine("GET /Majors/Create");
            return View(new Major { });
        }

        // TODO -> POST: Majors/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "MajorName")] Major major)
        {
            /*
             * TODO: Allow new major creation to be saved upon AD Authentication
             * 
            Trace.WriteLine("POST /Majors/Create");
            if (ModelState.IsValid)
            {
                db.Majors.Add(major);
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            */
            return View(major);
        }

        // GET: Majors/Edit/5
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
        public ActionResult Edit([Bind(Include = "MajorName")] Major major)
        {
           /*
            * TODO: Allow new major creation to be saved upon AD Authentication
            * 
           Trace.WriteLine("POST /Majors/Edit/" + major);
           if (ModelState.IsValid)
           {
               db.Entry(major).State = EntityState.Modified;
               db.SaveChanges();
               return RedirectToAction("Index");
           }
           */
            return View(major);
        }

        // GET: Majors/Delete/5
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
        public ActionResult DeleteConfirmed(string id)
        {
           /*
            * TODO: Allow new major creation to be saved upon AD Authentication
            * 
            Trace.WriteLine("POST /Majors/Delete/" + id);
            Major major = db.Majors.Find(id);
            db.Majors.Remove(major);
            db.SaveChanges();
            */
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
