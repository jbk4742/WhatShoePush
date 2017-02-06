package com.gae.scaffolder.plugin;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Felipe Echanique on 08/06/2016.
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "FCMPlugin";

    @Override
    public void onTokenRefresh(){
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
		FCMPlugin.sendTokenRefresh( refreshedToken );

        // TODO: Implement this method to send any registration to your app's servers.
        sendRegistrationToServer(refreshedToken);
    }

     private void sendRegistrationToServer(String token) {
            // Add custom implementation, as needed.

            OkHttpClient client = new OkHttpClient();
            RequestBody body = new FormBody.Builder()
                    .add("Token", token)
                    .build();

            //request
            Request request = new Request.Builder()
                    .url("http://byeongkwan.dothome.co.kr/php/register.php")
                    .post(body)
                    .build();

            try {
                Log.d("success");
                client.newCall(request).execute();
            } catch (IOException e) {
                Log.d("error");
                e.printStackTrace();

            }

        }
}
