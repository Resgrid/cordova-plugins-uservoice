package resgrid.cordvoa.plugins.uservoice;

import java.net.URL;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.res.Resources;

import com.uservoice.uservoicesdk.Config;
import com.uservoice.uservoicesdk.UserVoice;

public class CDVUserVoice extends CordovaPlugin {
	public static final String INIT = "init";
    public static final String LAUNCH_FEEDBACK = "launchFeedback";
	public static final String CONTACT_US = "contactUs";
	public static final String VIEW_FORUM = "viewForum";
	public static final String POST_IDEA = "postIdea";

    private String packageName;
	private Config userVoiceConfig;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Context context = this.cordova.getActivity();
        packageName = context.getPackageName();
        Resources resources = context.getResources();
    }

    @Override
    public boolean execute(String action, final JSONArray args,
                           CallbackContext callbackContext) throws JSONException {
        try {
            if (INIT.equals(action)) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
						final String site = args.getString(0);
						
						if (args.length > 1) 
						{
							final String key = args.getString(1);
							final String secret = args.getString(2);
							
							if (!key.equals(null) && !secret.equals(null))
							{
								userVoiceConfig = new Config(site, key, secret);
							}
						} 
						
						if (userVoiceConfig.equals(null))
							userVoiceConfig = new Config(site);
						
						UserVoice.init(userVoiceConfig, context);
                    }
                });
                return true;
            } else if (LAUNCH_FEEDBACK.equals(action)) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
						UserVoice.launchUserVoice(this);
                    }
                });
                return true;
            } else if (CONTACT_US.equals(action)) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
						UserVoice.launchContactUs(this);
                    }
                });
                return true;
            } else if (VIEW_FORUM.equals(action)) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
						UserVoice.launchForum(this);
                    }
                });
                return true;
            } else if (POST_IDEA.equals(action)) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
						UserVoice.launchPostIdea(this);
                    }
                });
                return true;
            } 

            return false;
        } catch (ThreadDeath td) {
            throw td;
        } catch (Throwable t) {
            return false;
        }
    }
}
