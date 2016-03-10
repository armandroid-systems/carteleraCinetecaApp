package mx.com.armandroid.cinetecaapp.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.net.ConnectivityManagerCompat;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import mx.com.armandroid.cinetecaapp.model.Pelicula;

/**
 * Created by armando.dominguez on 07/03/2016.
 */
public class Utils {
    private static final String TAG = Utils.class.getSimpleName();

    public static boolean isConnectedToInternet(Context context){
        ConnectivityManager managerCompat = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = managerCompat.getActiveNetworkInfo();
        return (info != null && info.isConnectedOrConnecting());
    }

    public static List<Pelicula> jsonList(String param, int index) throws JSONException {
        JSONObject object =  new JSONObject(param);
        JSONArray a =new JSONArray(object.getString("peliculas"));
        Log.d(TAG,"UNO "+ a);
        Type token = new TypeToken<List<Pelicula>>() {}.getType();
        List<Pelicula> listaObjetos = new Gson().fromJson(object.getString("peliculas"), token);
        Log.d(TAG,"UNO "+ listaObjetos.size());
        return listaObjetos;

    }

    public static void watchYoutubeVideo(String id, Activity mActivity){
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
            mActivity.startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(Constants.URL_YOUTUBE + id));
            mActivity.startActivity(intent);
        }
    }
}
