package com.ankit.assignment.grabbd.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {

    private Context mContext;

    public NetworkUtils(Context context){
        this.mContext = context;
    }

    public boolean isConnectingToInternet(){

        ConnectivityManager mManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (mManager != null){
            NetworkInfo[] info = mManager.getAllNetworkInfo();
            if (info != null){
                for (int i = 0 ; i< info.length ;i++){
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
