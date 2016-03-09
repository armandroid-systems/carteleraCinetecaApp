package mx.com.armandroid.cinetecaapp.interfaces;

import mx.com.armandroid.cinetecaapp.adapters.RecyclerCarteleraAdapter;
import mx.com.armandroid.cinetecaapp.model.Respuesta;

/**
 * Created by armando.dominguez on 09/03/2016.
 */
public interface PresenterCartelera {

    RecyclerCarteleraAdapter getCarteleraAdapter(Respuesta data);
    void clickButtonAdapter();
    void getCarteleraFromApi(String date);

}
