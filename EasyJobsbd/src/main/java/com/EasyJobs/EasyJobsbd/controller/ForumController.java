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

import com.EasyJobs.EasyJobsbd.dao.ForumDAO;
import com.EasyJobs.EasyJobsbd.model.Forum;

@RestController
public class ForumController {

		@Autowired
		ForumDAO forumService;
		
		// Save Forum
			@RequestMapping(value = "/forum", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<String> createNewForum(@RequestBody Forum forum) {
				System.out.println("Creating New Forum" + forum.getForumId());
				forumService.saveForum(forum);
				return new ResponseEntity<String>(HttpStatus.CREATED);
			}

			// Delete Forum By Id
			@RequestMapping(value = "/forum/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Forum> deleteUser(@PathVariable("id") int id) {
				System.out.println("Fetching & Deleting Forum with id " + id);
				Forum forum = forumService.findById(id);
				if (forum == null) {
					System.out.println("Unable to delete. Forum with id " + id + " not found");
					return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
				}

				forumService.deleteForumById(id);
				return new ResponseEntity<Forum>(HttpStatus.OK);
			}

			// Retrieve All Forum
			@RequestMapping(value = "/forum", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<Forum>> listAllForum() {
				List<Forum> forum = forumService.findAllForum();
				return new ResponseEntity<List<Forum>>(forum, HttpStatus.OK);
			}

			// Retrieve Single Forum
			@GetMapping(value = "/forum/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Forum> getForum(@PathVariable("id") int id) {
				System.out.println("Fetching Forum With Id " + id);
				Forum forum = forumService.findById(id);
				if (forum == null) {
					System.out.println("Forum With Id " + id + " not found");
					return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
				} else {
					return new ResponseEntity<Forum>(forum, HttpStatus.OK);
				}
			}


}
