package mx.com.armandroid.cineartapp.presentation.interfacepresenter;

import java.util.List;

import mx.com.armandroid.cineartapp.data.model.Pelicula;
import mx.com.armandroid.cineartapp.presentation.adapters.RecyclerCarteleraAdapter;

/**
 * Created by armando.dominguez on 09/03/2016.
 */
public interface PresenterCartelera {

    RecyclerCarteleraAdapter getCarteleraAdapter(List<Pelicula> data);
    void clickMenuButtonAdapter(int id);
    void getCarteleraFromApi(String date);
    void getCarteleraFromRepo();
}
