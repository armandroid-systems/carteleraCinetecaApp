package mx.com.armandroid.cinetecaapp.interfaces;

/**
 * Created by armando.dominguez on 08/03/2016.
 */
public interface Interactor {

    void compruebaConexion(CinetecaCallback cb);
    void cartelera(String fecha, CinetecaCallback cb);
    void detallePelicula(String titulo, CinetecaCallback cb);
}
