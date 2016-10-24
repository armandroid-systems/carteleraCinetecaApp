package mx.com.armandroid.cineartapp.data.repository;

import android.app.Application;

import mx.com.armandroid.cineartapp.data.model.Respuesta;

/**
 * Created by zadtankus on 25/03/16.
 */
public class Repository extends Application {
    private final static String TAG = Repository.class.getSimpleName();

    private Respuesta mRespuesta;

    private static Repository ourInstance = new Repository();

    public static Repository getInstance() {
        return ourInstance;
    }

    public Respuesta getmRespuesta() {
        return mRespuesta;
    }

    public void setmRespuesta(Respuesta mRespuesta) {
        this.mRespuesta = mRespuesta;
    }

    private Repository() {
    }


}
