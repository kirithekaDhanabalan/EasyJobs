'use strict';

angular.module('myApp').factory('JobService', ['$http', '$q',function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:9050/EasyJobsbd/job';
    
       
    var factory = {
        fetchAllJobs: fetchAllJobs,
        createJob: createJob,
        updateUser:updateUser,
        deleteUser:deleteUser,
        
    };
    return factory;
    function fetchAllJobs()
    {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) 
            {
            	deferred.resolve(response.data);            	
            },
            function(errResponse){
                console.error('Error while fetching Jobs');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createJob(job) 
    {
    	console.log('hello im in job');
    	console.log(job.jobTitle);
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, job)
            .then(
            function (response) 
            {
                deferred.resolve(response);
            },
            function(errResponse)
            {
                console.error('Error while creating job');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    function updateUser(user, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    function deleteUser(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
