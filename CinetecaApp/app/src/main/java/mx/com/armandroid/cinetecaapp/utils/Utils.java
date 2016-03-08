package mx.com.armandroid.cinetecaapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat;

/**
 * Created by armando.dominguez on 07/03/2016.
 */
public class Utils {

    public static boolean isConnectedToInternet(Context context){
        ConnectivityManager managerCompat = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = managerCompat.getActiveNetworkInfo();
        return (info != null && info.isConnectedOrConnecting());
    }
}
