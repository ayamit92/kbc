package com.balli.kbc;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

public class FirebaseIDService extends FirebaseInstanceIdService {
    private static final String TAG = "FirebaseIDService";

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken="bbb";
        if (FirebaseInstanceId.getInstance().getToken()!=null){
            refreshedToken = FirebaseInstanceId.getInstance().getToken();
            Log.i(TAG, "Refreshed token: " + refreshedToken);
            sendRegistrationToServer(refreshedToken);
            FirebaseMessaging.getInstance().subscribeToTopic("allDevices");
        }
    }

    /**
     * Persist token to third-party servers.
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private void sendRegistrationToServer(String token) {
        // Add custom implementation, as needed.
    }
}
