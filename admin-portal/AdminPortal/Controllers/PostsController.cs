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
    public class PostsController : Controller
    {
        private MyDatabaseContext db = new MyDatabaseContext();

        // GET: Posts
        public ActionResult Index()
        {
            Trace.WriteLine("GET /Posts/Index");
            return View(db.Posts.ToList());
        }

        // GET: Posts/Details/5
        public ActionResult Details(string id)
        {
            Trace.WriteLine("GET /Posts/Details/" + id);
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Post post = db.Posts.Find(id);
            if (post == null)
            {
                return HttpNotFound();
            }
            return View(post);
        }

        // GET: Posts/Create
        public ActionResult Create()
        {
            Trace.WriteLine("GET /Posts/Create");
            return View(new Post { });
        }

        // TODO -> POST: Posts/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "UserName")] Post post)
        {
            /*
             * TODO: Allow new post creation to be saved upon AD Authentication
             * 
            Trace.WriteLine("POST /Posts/Create");
            if (ModelState.IsValid)
            {
                db.Posts.Add(post);
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            */
            return View(post);
        }

        // GET: Posts/Edit/5
        public ActionResult Edit(string id)
        {
            Trace.WriteLine("GET /Posts/Edit/" + id);
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Post post = db.Posts.Find(id);
            if (post == null)
            {
                return HttpNotFound();
            }
            return View(post);
        }

        // TODO -> POST: Posts/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "UserName")] Post post)
        {
            /*
             * TODO: Allow new post creation to be saved upon AD Authentication
             * 
            Trace.WriteLine("POST /Posts/Edit/" + post);
            if (ModelState.IsValid)
            {
                db.Entry(post).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            */
            return View(post);
        }

        // GET: Posts/Delete/5
        public ActionResult Delete(string id)
        {
            Trace.WriteLine("GET /Posts/Delete/" + id);
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Post post = db.Posts.Find(id);
            if (post == null)
            {
                return HttpNotFound();
            }
            return View(post);
        }

        // TODO -> POST: Posts/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(string id)
        {
            /*
             * TODO: Allow new post creation to be saved upon AD Authentication
             * 
             Trace.WriteLine("POST /Posts/Delete/" + id);
             Post post = db.Posts.Find(id);
             db.Posts.Remove(post);
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