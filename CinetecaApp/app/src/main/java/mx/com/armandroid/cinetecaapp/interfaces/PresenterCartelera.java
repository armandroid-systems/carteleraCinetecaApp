package mx.com.armandroid.cinetecaapp.interfaces;

import java.util.List;

import mx.com.armandroid.cinetecaapp.adapters.RecyclerCarteleraAdapter;
import mx.com.armandroid.cinetecaapp.model.Pelicula;

/**
 * Created by armando.dominguez on 09/03/2016.
 */
public interface PresenterCartelera {

    RecyclerCarteleraAdapter getCarteleraAdapter(List<Pelicula> data);
    void clickButtonAdapter();
    void getCarteleraFromApi(String date);
}
