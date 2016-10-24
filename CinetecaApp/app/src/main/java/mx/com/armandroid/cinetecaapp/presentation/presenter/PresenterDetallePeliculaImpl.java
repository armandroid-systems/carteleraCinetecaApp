package mx.com.armandroid.cinetecaapp.presentation.presenter;

import android.util.Log;

import mx.com.armandroid.cinetecaapp.R;
import mx.com.armandroid.cinetecaapp.logic.interactor.InteractorImpl;
import mx.com.armandroid.cinetecaapp.logic.interfacecallback.CinetecaCallback;
import mx.com.armandroid.cinetecaapp.presentation.interfaceview.DetallePeliculaView;
import mx.com.armandroid.cinetecaapp.presentation.interfacepresenter.PresenterDetallePelicula;
import mx.com.armandroid.cinetecaapp.data.model.Respuesta;

/**
 * Created by zadtankus on 10/03/16.
 */
public class PresenterDetallePeliculaImpl implements PresenterDetallePelicula, CinetecaCallback{
    private static final String TAG = PresenterDetallePeliculaImpl.class.getSimpleName();

    private InteractorImpl detalleInteractor;
    private DetallePeliculaView detalleView;

    public PresenterDetallePeliculaImpl(InteractorImpl detalleInteractor, DetallePeliculaView detalleView) {
        this.detalleInteractor = detalleInteractor;
        this.detalleView = detalleView;
    }

    @Override
    public void getDetallePelicula(String idPelicula) {
        detalleInteractor.detallePelicula(idPelicula, this);
    }

    @Override
    public void eventClick(int id) {
        switch(id){
            case R.id.verTrailer:
                detalleView.verTrailer();
                break;
            default:
                detalleView.veAtras();
                break;
        }
    }

    @Override
    public void onError(String message) {
        Log.e(TAG, message);
        detalleView.ocultarLoader();
        detalleView.colocaMensaje(message);
        detalleView.mostrarImagen();
        //TODO debug only

        //detalleView.colocarDatos((new Gson().fromJson(Constants.API_DETAIL_FAKE,Respuesta.class)).peliculas.get(0));

    }

    @Override
    public void onSuccess(Respuesta param) {
        detalleView.ocultarLoader();
        if(!param.peliculas.isEmpty()){
            Log.d(TAG, "CON PELICULAS...");
           if(!param.peliculas.get(0).trailer.isEmpty()){ detalleView.muestraBotonTrailer(); }
           detalleView.colocarDatos(param.peliculas.get(0));
        }else{
            detalleView.mostrarImagen();
        }
    }
}
