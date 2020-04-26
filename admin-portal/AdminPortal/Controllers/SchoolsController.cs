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
    [System.Web.Mvc.Authorize]
    public class SchoolsController : Controller
    {
        private MyDatabaseContext db = new MyDatabaseContext();

        // GET: Schools
        public ActionResult Index()
        {
            Trace.WriteLine("GET /Schools/Index");
            return View(db.Schools.ToList());
        }

        // GET: Schools/Details/5
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

        public ActionResult Create()
        {
            Trace.WriteLine("GET /Schools/Create");
            return View(new School { });
        }

        // TODO -> POST: Schools/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "SchoolName")] School school)
        {
            /*
             * TODO: Allow new school creation to be saved upon AD Authentication
             * 
            Trace.WriteLine("POST /Schools/Create");
            if (ModelState.IsValid)
            {
                db.Schools.Add(school);
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            */
            return View(school);
        }

        // GET: Schools/Edit/5
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
        public ActionResult Edit([Bind(Include = "SchoolName")] School school)
        {
            /*
             * TODO: Allow new school creation to be saved upon AD Authentication
             * 
            Trace.WriteLine("POST /Schools/Edit/" + school);
            if (ModelState.IsValid)
            {
                db.Entry(school).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            */
            return View(school);
        }

        // GET: Schools/Delete/5
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
        public ActionResult DeleteConfirmed(string id)
        {
            /*
             * TODO: Allow new school creation to be saved upon AD Authentication
             * 
             Trace.WriteLine("POST /Schools/Delete/" + id);
             School school = db.Schools.Find(id);
             db.Schools.Remove(school);
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
