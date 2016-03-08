package mx.com.armandroid.cinetecaapp.interfaces;

import mx.com.armandroid.cinetecaapp.model.Respuesta;

/**
 * Created by armando.dominguez on 08/03/2016.
 */
public interface CinetecaCallback {

    void onError(String message);
    void onSuccess(Respuesta param);
}
