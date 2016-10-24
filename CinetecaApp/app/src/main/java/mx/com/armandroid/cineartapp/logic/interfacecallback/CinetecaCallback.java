package mx.com.armandroid.cineartapp.logic.interfacecallback;

import mx.com.armandroid.cineartapp.data.model.Respuesta;

/**
 * Created by armando.dominguez on 08/03/2016.
 */
public interface CinetecaCallback {

    void onError(String message);
    void onSuccess(Respuesta param);
}
