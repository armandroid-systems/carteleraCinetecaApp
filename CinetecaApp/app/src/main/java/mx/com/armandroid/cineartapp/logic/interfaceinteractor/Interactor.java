package mx.com.armandroid.cineartapp.logic.interfaceinteractor;

import mx.com.armandroid.cineartapp.logic.interfacecallback.CinetecaCallback;
import mx.com.armandroid.cineartapp.data.model.Respuesta;

/**
 * Created by armando.dominguez on 08/03/2016.
 */
public interface Interactor {

    Respuesta getCacheCartelera();
    void cartelera(String fecha, CinetecaCallback cb);
    void detallePelicula(String titulo, CinetecaCallback cb);
}
