'use strict';

var App = angular.module("myApp", ["ngRoute"]);
	App.value('bid',{id:123});
	
App.config(function($routeProvider,$locationProvider) {
    $routeProvider
    .when("#/", {
        templateUrl : "index.html"
    })
    .when("/temp", {
        templateUrl : "temp.html"
    })
    .when("/login", {
        templateUrl : "login.html"        
    })
    .when("/register", {
        templateUrl : "register.html"        
    })
    .when("/aboutus", {
        templateUrl : "aboutus.html"
    })
     .when("/contactus", {
        templateUrl : "contactus.html"
    })
    .when("/userreg", {
        templateUrl : "userreg.html"        
    })
    .when("/blog", {
        templateUrl : "blog.html"        
    })
    .when("/addblog", {
        templateUrl : "addblog.html"        
    })
    .when("/job", {
        templateUrl : "job.html"        
    })
    .when("/addjob", {
        templateUrl : "addjob.html"        
    })

    .when("/openModal", {
        templateUrl : "#openModal"        
    })
    .when("/forum", {
        templateUrl : "forum.html"        
    })
    .when("/comments", {
        templateUrl : "singlepost.html"        
    })
        .when("/addforum", {
        templateUrl : "addforum.html"        
    });
    $locationProvider.html5Mode({
    	 	  requireBase: false
    	});
});
