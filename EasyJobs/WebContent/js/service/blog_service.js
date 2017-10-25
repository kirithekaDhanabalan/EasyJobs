'use strict';

angular.module('myApp').factory('BlogService', ['$http', '$q',function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:9050/EasyJobsbd/blog';
    
       
    var factory = {
    	fetchAllBlogs: fetchAllBlogs,
    	fetchSingleBlog:fetchSingleBlog,
        createBlog: createBlog,
        updateUser:updateUser,
        deleteUser:deleteUser,
    };
    return factory;
    function fetchAllBlogs()
    {
    	console.log("entered service");
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) 
            {
            	deferred.resolve(response.data);     
            },
            function(errResponse){
                console.error('Error while fetching blogs');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    } 
    
    function fetchSingleBlog(id)
    {
    	console.log("entered service  for single blog"+id);
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+"/"+id)
            .then(
            function (response) 
            {
            	deferred.resolve(response.data);            	
            },
            function(errResponse){
                console.error('Error while fetching blogs');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createBlog(blog) 
    {
    	console.log('hello im in service');
    	console.log(blog.blogName);
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, blog)
            .then(
            function (response) 
            {
                deferred.resolve(response);
            },
            function(errResponse)
            {
                console.error('Error while creating blog');
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
