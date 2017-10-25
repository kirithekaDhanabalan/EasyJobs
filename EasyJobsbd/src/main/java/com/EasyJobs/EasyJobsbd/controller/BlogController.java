package com.EasyJobs.EasyJobsbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EasyJobs.EasyJobsbd.dao.BlogDAO;
import com.EasyJobs.EasyJobsbd.model.Blog;

@RestController
public class BlogController {
	@Autowired
	BlogDAO blogService;

	// Save Blog
	@RequestMapping(value = "/blog", method = RequestMethod.POST)
	public ResponseEntity<String> createNewBlog(@RequestBody Blog blogg) {
		System.out.println("Creating New Blog" + blogg.getBlogName());
		System.out.println("Creating New Blog" + blogg.getBlogTitle());
		System.out.println("Creating New Blog" + blogg.getBlogAuthor());
		blogg.setCreatedOn();
		if(blogService.saveBlog(blogg))
		{
			System.out.println("im blog");
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}
		else
		{
			
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete bLOG By Id
	@RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> deleteUser(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting blog with id " + id);
		Blog blog = blogService.findById(id);
		if (blog == null) {
			System.out.println("Unable to delete. Blog with id " + id + " not found");
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}

		blogService.deleteBlogById(id);
		return new ResponseEntity<Blog>(HttpStatus.OK);
	}

	// Retrieve All Blog
	@RequestMapping(value = "/blog", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Blog>> listAllBlogs() {
		List<Blog> blog = blogService.findAllBlog();
		return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
	}

	// Retrieve Single Blog
	@GetMapping(value = "/blog/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> getBlog(@PathVariable("id") int id) {
		System.out.println("Fetching Blog With Id " + id);
		Blog blog = blogService.findById(id);
		if (blog == null) {
			System.out.println("Blog With Id " + id + " not found");
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		} else {
			
			System.out.println(blog.getBlogId()+"    "+blog.getBlogName());
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		}
	}
}
