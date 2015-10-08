//
//  UserVoice Cordova iOS Plugin
//	by Resgrid (http://resgrid.com)
//  
//
    
#import <Foundation/Foundation.h>
#import <Cordova/CDVPlugin.h>
#import "UserVoice.h"

@interface CDVUserVoice : CDVPlugin {

}
- (void)launch:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;

- (void)launchFeedback:(NSMutableDictionary*)options;
- (void)contactUs:(NSMutableDictionary*)options;
- (void)viewForum:(NSMutableDictionary*)options;
- (void)postIdea:(NSMutableDictionary*)options;

@end
