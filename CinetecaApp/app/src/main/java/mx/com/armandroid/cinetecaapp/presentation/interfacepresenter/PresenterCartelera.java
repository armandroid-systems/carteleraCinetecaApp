package mx.com.armandroid.cinetecaapp.presentation.interfacepresenter;

import java.util.List;

import mx.com.armandroid.cinetecaapp.presentation.adapters.RecyclerCarteleraAdapter;
import mx.com.armandroid.cinetecaapp.data.model.Pelicula;

/**
 * Created by armando.dominguez on 09/03/2016.
 */
public interface PresenterCartelera {

    RecyclerCarteleraAdapter getCarteleraAdapter(List<Pelicula> data);
    void clickMenuButtonAdapter(int id);
    void getCarteleraFromApi(String date);
    void getCarteleraFromRepo();
}
