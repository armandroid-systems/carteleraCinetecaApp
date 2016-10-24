package mx.com.armandroid.cinetecaapp.presentation.interfaceview;

import mx.com.armandroid.cinetecaapp.data.model.Pelicula;

/**
 * Created by zadtankus on 10/03/16.
 */
public interface DetallePeliculaView {

    void colocarDatos(Pelicula datos);
    void verTrailer();
    void colocaMensaje(String mensaje);
    void mostrarImagen();
    void ocultarLoader();
    void muestraBotonTrailer();
    void veAtras();
}
