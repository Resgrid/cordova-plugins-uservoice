//
//  UserVoice Cordova iOS Plugin
//	by Resgrid (http://resgrid.com)
//  
//

#import "CDVUserVoice.h"

@implementation CDVUserVoice

- (void)init:(CDVInvokedUrlCommand*)command
{
    NSString* site = [command.arguments objectAtIndex:0];
	NSString* key = [command.arguments objectAtIndex:1];
	NSString* secret = [command.arguments objectAtIndex:2];
	UVConfig* config = nil;
	
    if (key != nil && secret != nil) {
        config = [UVConfig configWithSite:site];
		config = [UVConfig configWithSite:site andKey:key andSecret:secret];
    } else {
       config = [UVConfig configWithSite:site];
    }
	
	[UserVoice initialize:config];
}

- (void)launchFeedback {
    [UserVoice presentUserVoiceInterfaceForParentViewController:self];
}

- (void)contactUs {
    [UserVoice presentUserVoiceContactUsFormForParentViewController:self];
}

- (void)viewForum {
    [UserVoice presentUserVoiceForumForParentViewController:self];
}

- (void)postIdea:(NSMutableDictionary*)options {
    [UserVoice presentUserVoiceNewIdeaFormForParentViewController:self];
}

@end
