'use strict';

angular.module('myApp').factory('FriendService', ['$http', '$q',function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:9050/EasyJobsbd/suggesteduser';
    
   var factory = {
		   suggestedUsers:suggestedUsers
    		
        };
        return factory;
        
        function suggestedUsers()
        {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI)
                .then(
                function (response) 
                {
                	deferred.resolve(response.data);            	
                },
                function(errResponse){
                    console.error('Error while fetching suggestedusers');
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;
        }   
        }]); 

