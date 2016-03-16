package mx.com.armandroid.cinetecaapp.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.net.ConnectivityManagerCompat;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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
        Log.d(TAG,"ID "+id);
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
            intent.putExtra("VIDEO_ID",id);
            intent.putExtra("force_fullscreen",true);
            mActivity.startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(Constants.URL_YOUTUBE + id));
            mActivity.startActivity(intent);
        }
    }
    public static Calendar dateParser(String date) {
        Calendar cal = Calendar.getInstance();
        DateFormat sdf = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy", Locale.getDefault());
        DateFormat mdf = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
        date = date.split("\n")[0];
        try {
            cal.setTime(mdf.parse(mdf.format(sdf.parse(date))));
        } catch (ParseException e) {
            Log.e(TAG,"ERROR "+e);
        }
        return cal;
    }

    public static  void addEvent(String title, String location, Calendar begin, Activity mActivity) {
        try{
            Intent intent = new Intent(Intent.ACTION_INSERT)
                    .setData (CalendarContract.Events.CONTENT_URI)
                    .putExtra(CalendarContract.Events.TITLE, title)
                    .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin.getTimeInMillis());
            mActivity.startActivity(intent);
        }catch(ActivityNotFoundException anfe){
            Log.e(TAG, "INTENT ERROR [" + anfe + "]");
        }

    }
}
