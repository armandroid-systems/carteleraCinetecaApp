package mx.com.armandroid.cinetecaapp.interfaces;

import mx.com.armandroid.cinetecaapp.model.Pelicula;

/**
 * Created by zadtankus on 10/03/16.
 */
public interface DetallePeliculaView {

    void colocarDatos(Pelicula datos);
    void verTrailer();
    void colocaMensaje(String mensaje);
    void ocultaImagen();
}
