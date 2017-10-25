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
						'bid',
						function($scope, BlogService, $location, $window,bid) {
							var id;
							var self = this;
							self.blog = {
									blogId : '',
									createdOn : '',
									blogName : '',
									blogTitle : '',
									blogDescription : '',
									blogAuthor : ''
							};
								
							self.blog1 = {
									blogId : '',
									createdOn : '',
									blogName : '',
									blogTitle : '',
									blogDescription : '',
									blogAuthor : ''
							};
							self.singleblogg = {
									blogId : '',
									createdOn : '',
									blogName : '',
									blogTitle : '',
									blogDescription : '',
									blogAuthor : ''
							};
							
							self.blogs=[];
							self.sblog=[];
								
							
							self.submit = submit;
							self.edit = edit;
							self.remove = remove;
							self.reset = reset;
							self.login = login;
							self.allblogs=allblogs;
							self.readMore=readMore;
							self.exm=exm;
							self.jst=jst;

							
							
							fetchAllBlogs();
							
							fetchSingleBlog(bid.id);

							function fetchAllBlogs() {
								
								BlogService
										.fetchAllBlogs()
										.then(
												function(d) {
													self.blogs = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Blogs');
												});
							}
							
							
							
							
								function fetchSingleBlog(id) {
								BlogService
										.fetchSingleBlog(id)
										.then(
												function(d) {
													self.blog1=d;
													$window.alert(self.blog1.blogId);
													console.log(self.blog1);
													var url = "http://localhost:9050/EasyJobs/#/singleblog";
													$window.location.href = url;
												},
												function(errResponse) {
													console
															.error('Error while fetching Blogs');
												});
							}


							function createBlog(blog) {
								
								BlogService.createBlog(blog)
										.then(
												function(response) {
													
														
													var url = "http://localhost:9050/EasyJobs/#/blog";
													$window.location.href = url;
												},
												function(errResponse) {
													$window
															.alert("The blog Already Exists");
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
							
							function readMore(id){

								bid.id=id;
								fetchSingleBlog(id);
								

								
							}
							
							function exm(singleblog)
							{
								fetchSingleBlog(singleblog.blogId);
								self.sblog=singleblog;
								console.log(self.sblog);
								
							}
							

							function allblogs() {
								console.log('hello im in');
								
								fetchAllBlogs();

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
							
							function jst(blogname)
							{
								console.log(blogname);
								$window.alert(blogname);
							}
							

						} ]);
