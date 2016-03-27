package mx.com.armandroid.cinetecaapp.interfaces;

import mx.com.armandroid.cinetecaapp.adapters.RecyclerCarteleraAdapter;
import mx.com.armandroid.cinetecaapp.model.Pelicula;
import mx.com.armandroid.cinetecaapp.model.Respuesta;

/**
 * Created by armando.dominguez on 09/03/2016.
 */
public interface CarteleraView {

    void escondeLoader();
    void escondeRecycler();
    void escondeImagenError();
    void muestraMensaje(String msj);
    void muestraImgError();
    void muestraDatePicker();
    void muestraLoader();
    void createRecyclerView(RecyclerCarteleraAdapter adapter);
    void veADetallePelicula(Pelicula pelicula);
    void agregaACalendario(Pelicula evento);
    void compartirPelicula(String pelicula);
    void obtenCarteleraDia(String date);
    void colocarFechaEnBarra(String date);


}
