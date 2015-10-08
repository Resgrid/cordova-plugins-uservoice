/**
 * uservoice.js
 *
 * Cordova UserVoice plugin for version >= 3.0.0
 *
 * Copyright(c) Resgrid 2015 (http://resgrid.com)
 */

var exec = require('cordova/exec');

var Uservoice = function(){};

Uservoice.launch = function(site, key, secret, task, cfg){
	cfg = cfg?cfg:{};
	if(Object.prototype.toString.call(cfg)!='[object Object]'){
		alert('Invalid UserVoice Config');
		cfg = {};
	}
	var config = {
		//task:'viewForum',//[launchFeedback|contactUs|viewForum|postIdea]
		task:task,

		site:site,
		key:key,
		secret:secret,
		
		topicId:1,//[0|453|333 (any valid topicId)]
		showContactUs:0,//[0|1]
		showForum:0,//[0|1]
		showPostIdea:0,//[0|1]
		showKnowledgeBase:0//[0|1]
	};
	//Ext.Msg.alert('', Ext.encode(config))
	for(var key in config){
		if (typeof cfg[key] !== "undefined"){
			if(key=='task' && cfg[key]!='launchFeedback' && cfg[key]!='contactUs' && cfg[key]!='viewForum' && cfg[key]!='postIdea'){
				alert('UserVoice task "'+cfg[key]+'" not supported. Supported tasks are launchFeedback,contactUs,viewForum and postIdea,  so we are using "launchFeedback" ');
				cfg[key]='launchFeedback';
			}else if(key=='topicId'){
				cfg[key]=parseInt(cfg[key]);
			}else if(key.indexOf('show')>-1){
				cfg[key] = (cfg[key]==1)?1:0;
			}
			config[key] = cfg[key];
		}
	}
	
	cordova.exec(successCallback, errorCallback, "CDVUserVoice", "init", [config]);	
};

module.exports = Uservoice;