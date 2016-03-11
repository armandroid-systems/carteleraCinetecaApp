package mx.com.armandroid.cinetecaapp.presenter;

import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import mx.com.armandroid.cinetecaapp.R;
import mx.com.armandroid.cinetecaapp.adapters.RecyclerCarteleraAdapter;
import mx.com.armandroid.cinetecaapp.interactor.InteractorImpl;
import mx.com.armandroid.cinetecaapp.interfaces.CardClick;
import mx.com.armandroid.cinetecaapp.interfaces.CarteleraView;
import mx.com.armandroid.cinetecaapp.interfaces.CinetecaCallback;
import mx.com.armandroid.cinetecaapp.interfaces.PresenterCartelera;
import mx.com.armandroid.cinetecaapp.model.Pelicula;
import mx.com.armandroid.cinetecaapp.model.Respuesta;
import mx.com.armandroid.cinetecaapp.utils.Constants;
import mx.com.armandroid.cinetecaapp.utils.Utils;

/**
 * Created by armando.dominguez on 09/03/2016.
 */
public class PresenterCarteleraImpl implements PresenterCartelera, CinetecaCallback, CardClick{
    private static final String TAG = PresenterCarteleraImpl.class.getSimpleName();

    private InteractorImpl mInteractor;
    private CarteleraView mCartelera;
    private Respuesta comodin;

    public PresenterCarteleraImpl(InteractorImpl mInteractor, CarteleraView mCartelera) {
        this.mInteractor = mInteractor;
        this.mCartelera = mCartelera;
    }


    @Override
    public void clickButtonAdapter() {

    }

    @Override
    public RecyclerCarteleraAdapter getCarteleraAdapter(List<Pelicula> data) {
        return new RecyclerCarteleraAdapter(data, this, mInteractor.getmContext());
    }

    @Override
    public void getCarteleraFromApi(String date) {
        mInteractor.cartelera(date, this);
    }

    @Override
    public void onError(String message) {
        //TODO only for debug
        /* try {
        mCartelera.createRecyclerView(getCarteleraAdapter(Utils.jsonList(Constants.API_RESPONSE_FAKE,1)));
    } catch (JSONException e) {
        e.printStackTrace();
    }*/
        Log.d(TAG,"ERROR"+message);
        mCartelera.muestraMensaje(message);
        mCartelera.muestraImgError();

    }

    @Override
    @SuppressWarnings("unchecked")
    public void onSuccess(Respuesta param) {
        mCartelera.escondeLoader();
        comodin = param;
        if(!param.peliculas.isEmpty()){
          mCartelera.createRecyclerView(getCarteleraAdapter(param.peliculas));
        }else{
            mCartelera.muestraImgError();
        }
    }

    @Override
    public void hacerAccion(int id, int idElement) {
        switch(id){
            case R.id.textViewMas:
                Log.d(TAG,"PRESIONO MAS");
                mCartelera.veADetallePelicula(comodin.peliculas.get(idElement));
                break;
            case R.id.textViewCompartir:
                break;
            case R.id.addCalendar:
                break;

        }
    }

    public Respuesta getComodin() {
        return comodin;
    }
}
