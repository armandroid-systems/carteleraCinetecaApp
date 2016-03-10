package mx.com.armandroid.cinetecaapp.presenter;

import android.util.Log;

import org.json.JSONException;

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
        mCartelera.escondeLoader();
        /*mCartelera.muestraMensaje(message);
        mCartelera.muestraImgError();*/
        try {
            mCartelera.createRecyclerView(getCarteleraAdapter(Utils.jsonList(Constants.API_RESPONSE_FAKE,1)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(Respuesta param) {
        comodin = param;
        mCartelera.escondeLoader();
        if(!param.peliculas.isEmpty()){
           // mCartelera.createRecyclerView(getCarteleraAdapter(param));
        }else{
            mCartelera.muestraImgError();
        }
    }

    @Override
    public void hacerAccion(int id, int idElement) {
        switch(id){
            case R.id.textViewMas:
                Log.d(TAG,"PRESIONO MAS");
                try {
                    mCartelera.veADetallePelicula(Utils.jsonList(Constants.API_RESPONSE_FAKE,1).get(idElement).urlDetail);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.textViewCompartir:
                break;
            case R.id.addCalendar:
                break;

        }
    }
}