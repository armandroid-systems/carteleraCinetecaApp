package mx.com.armandroid.cinetecaapp.interfaces;

import mx.com.armandroid.cinetecaapp.model.Respuesta;

/**
 * Created by armando.dominguez on 08/03/2016.
 */
public interface Interactor {

    Respuesta getCacheCartelera();
    void cartelera(String fecha, CinetecaCallback cb);
    void detallePelicula(String titulo, CinetecaCallback cb);
}
