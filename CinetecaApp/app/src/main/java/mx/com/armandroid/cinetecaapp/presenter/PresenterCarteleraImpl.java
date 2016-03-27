package mx.com.armandroid.cinetecaapp.presenter;

import android.util.Log;

import com.google.gson.Gson;

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
    public void getCarteleraFromApi(String date) {
        mCartelera.escondeRecycler();
        mCartelera.escondeImagenError();
        mCartelera.muestraLoader();
        mInteractor.cartelera(date, this);
    }

    @Override
    public void getCarteleraFromRepo() {
        colocaDatos(mInteractor.getCacheCartelera());
    }


    @Override
    public void clickMenuButtonAdapter(int id) {
        switch (id){
            case R.id.calendarSearch:
                mCartelera.muestraDatePicker();
                break;
            default:
                break;
        }

    }

    @Override
    public RecyclerCarteleraAdapter getCarteleraAdapter(List<Pelicula> data) {
        Log.d(TAG, "SOLICITANDO DATOS A LA API...");
        return new RecyclerCarteleraAdapter(data, this, mInteractor.getmContext());
    }

    @Override
    public void onError(String message) {
        Log.e(TAG, "ERROR API [" + message + " ]");
        mCartelera.escondeLoader();
        mCartelera.muestraMensaje(message);
        mCartelera.muestraImgError();

    }

    @Override
    @SuppressWarnings("unchecked")
    public void onSuccess(Respuesta param) {
        colocaDatos(param);
    }

    @Override
    public void hacerAccion(int id, int idElement) {
        switch(id){
            case R.id.textViewMas:
                Log.d(TAG,"REDIRIGIENDO A DETALLE...");
                mCartelera.veADetallePelicula(comodin.peliculas.get(idElement));
                break;
            case R.id.textViewCompartir:
                Log.d(TAG,"SHARE INTENT ...");
                mCartelera.compartirPelicula(Constants.URL_CINETECA+comodin.peliculas.get(idElement).urlDetail);
                break;
            case R.id.textViewCalendario:
                Log.d(TAG,"ENVIANDO DATOS A CALENDARIO...");
                mCartelera.agregaACalendario(comodin.peliculas.get(idElement));
                break;

        }
    }

    private void colocaDatos(Respuesta param){
        Log.d(TAG,"CONSULTA EXITOSA ["+param.error+" ]");
        mCartelera.escondeLoader();
        comodin = param;
        if(!param.peliculas.isEmpty()){
            Log.d(TAG,"SE ENCONTRARON DATOS...");
            mCartelera.colocarFechaEnBarra(param.peliculas.get(0).horarios.split("\n")[0]);
            mCartelera.escondeImagenError();
            mCartelera.createRecyclerView(getCarteleraAdapter(param.peliculas));
        }else{
            mCartelera.colocarFechaEnBarra("Fecha no disponible");
            mCartelera.escondeRecycler();
            mCartelera.muestraMensaje("Sin datos que mostrar");
            mCartelera.muestraImgError();
        }
    }
}
