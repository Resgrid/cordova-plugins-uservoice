/**
 * uservoice.js
 *
 * Cordova UserVoice plugin for version >= 3.0.0
 *
 * Copyright(c) Resgrid 2015 (http://resgrid.com)
 */

var exec = require('cordova/exec');

var Uservoice = function(){};

Uservoice.init = function(site, key, secret){
	cordova.exec(successCallback, errorCallback, "CDVUserVoice", 'init', [site, key, secret]);	
};

Uservoice.launchFeedback = function(){
	cordova.exec(successCallback, errorCallback, "CDVUserVoice", 'launchFeedback', []);	
};

Uservoice.launchForum = function(){
	cordova.exec(successCallback, errorCallback, "CDVUserVoice", 'launchForum', []);	
};

Uservoice.launchContactUs = function(){
	cordova.exec(successCallback, errorCallback, "CDVUserVoice", 'launchContactUs', []);	
};

Uservoice.launchPostIdea = function(){
	cordova.exec(successCallback, errorCallback, "CDVUserVoice", 'launchPostIdea', []);	
};

module.exports = Uservoice;