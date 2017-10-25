'use strict';

angular
		.module('myApp')
		.controller(
				'ForumControl',
				[
						'$scope',
						'ForumService',
						'$location',
						'$window',
						function($scope, ForumService, $location, $window) {
							var self = this;
							self.forum = {
									forumTitle : '',
									forumDescription : ''
							};
								
							self.forums=[];
							
							self.submit = submit;
							self.edit = edit;
							self.remove = remove;
							self.reset = reset;
							self.login = login;
							self.allforums=allforums;
							
							function fetchAllForums() {
								ForumService
										.fetchAllForums()
										.then(
												function(d) {
													self.forums = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Forum');
												});
							}

							function createForum(forum) {
								$window.alert(forum.forumTitle);
								
								ForumService.createForum(forum)
										.then(
												function(response) {
													$window
													.alert("The forum Added");
														
													var url = "http://localhost:9050/EasyJobs/#/forum";
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
								
								createForum(self.forum);

							}

							function allforums() {
								console.log('he forum');
								
								fetchAllForums();

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
