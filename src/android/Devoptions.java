
package cordova.mao.devoptions;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;

import android.R;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class Devoptions extends CordovaPlugin {


  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

    try {

      if (action.equals("areEnabled")) {
          int result = areEnabled() ? 1 : 0;
          callbackContext.success(result);
          return true;
      }

    } catch(Exception e) {

        callbackContext.error(e.toString());
        return false;
    }


    return false;
  }

  @android.annotation.TargetApi(17)
  public boolean areEnabled() {
    if(Integer.valueOf(android.os.Build.VERSION.SDK) == 16) {
      return android.provider.Settings.Secure.getInt(cordova.getActivity().getApplicationContext().getContentResolver(),
        android.provider.Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED , 0) != 0;
    } else if (Integer.valueOf(android.os.Build.VERSION.SDK) >= 17) {
      return android.provider.Settings.Secure.getInt(cordova.getActivity().getApplicationContext().getContentResolver(),
        android.provider.Settings.Global.DEVELOPMENT_SETTINGS_ENABLED , 0) != 0;
    } else {
      return false;
    }
  }
}
