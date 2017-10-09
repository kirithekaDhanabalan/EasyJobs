'use strict';

angular.module('myApp').factory('ForumService', ['$http', '$q',function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:9050/EasyJobsbd/forum';
    
       
    var factory = {
        fetchAllUsers: fetchAllUsers,
        createForum: createForum,
        updateUser:updateUser,
        deleteUser:deleteUser,
        
    };
    return factory;
    function fetchAllUsers()
    {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) 
            {
            	deferred.resolve(response.data);            	
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createForum(forum) 
    {
    	console.log('hello im in Forum');
    	console.log(forum.forumName);
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, forum)
            .then(
            function (response) 
            {
                deferred.resolve(response);
            },
            function(errResponse)
            {
                console.error('Error while creating Forum');
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
