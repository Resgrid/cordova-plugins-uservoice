//
//  UserVoice Cordova iOS Plugin
//	by Resgrid (http://resgrid.com)
//  
//
    
#import <Foundation/Foundation.h>
#import <Cordova/CDVPlugin.h>
#import "UserVoice.h"

@interface CDVUserVoice : CDVPlugin
- (void)init:(CDVInvokedUrlCommand*)command
- (void)launchFeedback;
- (void)contactUs;
- (void)viewForum;
- (void)postIdea;
@end
