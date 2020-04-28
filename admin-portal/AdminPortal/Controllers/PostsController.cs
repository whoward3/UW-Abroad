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
        [System.Web.Mvc.AllowAnonymous]
        public ActionResult Index()
        {
            Trace.WriteLine("GET /Posts/Index");
            return View(db.Posts.ToList());
        }

        // GET: Posts/Details/5
        [System.Web.Mvc.AllowAnonymous]
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
        [System.Web.Mvc.Authorize]
        public ActionResult Create()
        {
            Trace.WriteLine("GET /Posts/Create");
            return View(new Post { });
        }

        // TODO -> POST: Posts/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        [System.Web.Mvc.Authorize]
        public ActionResult Create([Bind(Include = "UserName, Id, SchoolName, PostContent")] Post post)
        {
         
            Trace.WriteLine("POST /Posts/Create");
            if (ModelState.IsValid)
            {
                post.CreatedAt = DateTimeOffset.Now;
                post.UpdatedAt = DateTimeOffset.Now;
                post.Id = Guid.NewGuid().ToString();
                post.Deleted = false;
                db.Posts.Add(post);
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            
            return View(post);
        }

        // GET: Posts/Edit/5
        [System.Web.Mvc.Authorize]
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
        [System.Web.Mvc.Authorize]
        public ActionResult Edit([Bind(Include = "UserName, Id, SchoolName, PostContent")] Post post)
        {
           
            Trace.WriteLine("POST /Posts/Edit/" + post);
            if (ModelState.IsValid)
            {
                post.UpdatedAt = DateTimeOffset.Now;
                post.CreatedAt = DateTimeOffset.Now;
                db.Entry(post).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            
            return View(post);
        }

        // GET: Posts/Delete/5
        [System.Web.Mvc.Authorize]
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
        [System.Web.Mvc.Authorize]
        public ActionResult DeleteConfirmed(string id)
        {
            
            Trace.WriteLine("POST /Posts/Delete/" + id);
             Post post = db.Posts.Find(id);
             db.Posts.Remove(post);
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