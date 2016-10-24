package mx.com.armandroid.cineartapp.presentation.interfaceview;

import mx.com.armandroid.cineartapp.data.model.Pelicula;
import mx.com.armandroid.cineartapp.presentation.adapters.RecyclerCarteleraAdapter;

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
