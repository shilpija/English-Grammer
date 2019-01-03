package com.rdseducation.english.grammer.firebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.rdseducation.english.grammer.SharedData;

public class FCMNotification extends FirebaseInstanceIdService {

    SharedData sharedData;

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("Token", "Refreshed token: " + refreshedToken);

        sharedData = new SharedData(this);
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.


        sharedData.AddData("token",refreshedToken);
//        PrefHelper.setString(PrefHelper.KEY_DEVICE_TOKEN, refreshedToken);

        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(final String refreshedToken) {
        Log.d("tokenn",refreshedToken);

//        String getPdf = subscribe;
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, getPdf,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        Log.d("responseToken",response);
//                    }
//                }
//                , new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("token",refreshedToken);
//                params.put("type","android");
//                return params;
//            }
//        };

//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);

    }
}
