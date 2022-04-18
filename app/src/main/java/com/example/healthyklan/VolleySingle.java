package com.example.healthyklan;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingle {

    private RequestQueue requestQueue;
    private static VolleySingle mInstance;

    VolleySingle(Context context){
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleySingle getmInstance(Context context){
        if(mInstance == null){
            mInstance = new VolleySingle(context);
        }

        return mInstance;
    }

    public RequestQueue getRequestQueue(){return requestQueue;}


}
