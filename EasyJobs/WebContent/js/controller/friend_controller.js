'use strict';

angular
		.module('myApp')
		.controller(
				'FriendControl',
				[
						'$scope',
						'FriendService',
						'$location',
						'$window',
						function($scope, FriendService, $location, $window) {
							var self = this;
							
							self.friend = {
									user1 : '',
									user2 : ''
									
							};
							self.friendrequest = {
									sendername : '',
									receivername : '',
									status : 'false'
								    
							};
							self.user = {
									username : '',
									email : '',
									phonenumber : '',
								    upassword : ''
							};
							
							self.users=[];
                            self.friends=[];
                            self.friendrequests=[];
                            self.suggestuser=[];
							
                            self.suggestedusers=suggestedusers;
							self.allFriends=allFriends;
							self.alluser=alluser;
							self.sendRequest=sendRequest;
							
							suggestedusers();
							 
							function suggestedusers(){
								FriendService
								        .suggestedUsers()
							            .then(
												function(d) {
													self.users = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching suggested users');
												});
							}
						
							
							
							function allFriends() {
								FriendService
										.allFriends()
										.then(
												function(d) {
													self.friends = d;
												},
												function(errResponse) {
													console
															.error('Error while getting friends');
												});
							}
							
							
							function alluser()
							{
								$window.alert("getting all jobs");
								suggestedusers();
							}
							
							
							function sendRequest(uname)
							{
								$window.alert(uname)
							}
								
								}]);
