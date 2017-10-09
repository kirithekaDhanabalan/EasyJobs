'use strict';

angular
		.module('myApp')
		.controller(
				'BlogControl',
				[
						'$scope',
						'BlogService',
						'$location',
						'$window',
						function($scope, BlogService, $location, $window) {
							var self = this;
							self.blog = {
									blogId : '',
									createdOn : '',
									blogName : '',
									blogTitle : '',
									blogDescription : '',
									blogAuthor : ''
							};
								
							self.blogs=[];
							self.submit = submit;
							self.edit = edit;
							self.remove = remove;
							self.reset = reset;
							self.login = login;

							function fetchAllBlogs() {
								$window.alert("going to get all blogs");
								BlogService
										.fetchAllBlogs()
										.then(
												function(d) {
													self.blogs = d;
													$scope.allblogs=blogs;
												},
												function(errResponse) {
													console
															.error('Error while fetching Blogs');
												});
							}

							function createBlog(blog) {
								$window.alert(blog.blogName);
								
								BlogService.createBlog(blog)
										.then(
												function(response) {
													
														
													var url = "http://localhost:9050/EasyJobs/#/blog";
													$window.location.href = url;
												},
												function(errResponse) {
													$window
															.alert("The User Name Already Exists");
												});
							}

							function updateUser(user, id) {
								UserService
										.updateUser(user, id)
										.then(
												fetchAllUsers,
												function(errResponse) {
													console
															.error('Error while updating User');
												});
							}

							function deleteUser(id) {
								UserService
										.deleteUser(id)
										.then(
												fetchAllUsers,
												function(errResponse) {
													console
															.error('Error while deleting User');
												});
							}

							function submit() {
								console.log('hello im in');
								
								createBlog(self.blog);

							}

							function login() {
								
								loginUser(self.usercred);

							}

							function edit(id) {
								console.log('id to be edited', id);
								for (var i = 0; i < self.users.length; i++) {
									if (self.users[i].id === id) {
										self.user = angular.copy(self.users[i]);
										break;
									}
								}
							}

							function remove(id) {
								console.log('id to be deleted', id);
								if (self.user.id === id) {// clean form if the
															// user to be
															// deleted is shown
															// there.
									reset();
								}
								deleteUser(id);
							}

							function reset() {
								self.user = {
									id : null,
									username : '',
									address : '',
									email : ''
								};
								$scope.myForm.$setPristine(); // reset Form
							}
							
							

						} ]);
