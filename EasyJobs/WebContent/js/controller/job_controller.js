'use strict';

angular
		.module('myApp')
		.controller(
				'JobControl',
				[
						'$scope',
						'JobService',
						'$location',
						'$window',
						function($scope, JobService, $location, $window) {
							var self = this;
							self.job = {
									jobTitle : '',
									companyName : '',
									jobDescription : '',
									jobSkillsRequired : '',
									jobLocation : '',
									salaryPerMonth : '',
									experienceRequired : ''
							};
								
							self.jobs=[];
							
							self.submit = submit;
							self.edit = edit;
							self.remove = remove;
							self.reset = reset;
							self.login = login;
							self.alljobs=alljobs;
							
							fetchAllJobs();
							
							function fetchAllJobs() {
								JobService
										.fetchAllJobs()
										.then(
												function(d) {
													self.jobs = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching jobs');
												});
							}

							function createJob(job) {
								$window.alert(job.jobTitle);
								
								JobService.createJob(job)
										.then(
												function(response) {
													$window
													.alert("The Job Added");
														
													var url = "http://localhost:9050/EasyJobs/#/job";
													$window.location.href = url;
												},
												function(errResponse) {
													$window
															.alert("The job Already Exists");
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
								console.log('hello im in job');
								
								createJob(self.job);

							}

						
							function alljobs() {
								console.log("inside all jobs");
								fetchAllJobs();

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
