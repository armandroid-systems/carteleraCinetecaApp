package mx.com.armandroid.cinetecaapp.presenter;

import mx.com.armandroid.cinetecaapp.R;
import mx.com.armandroid.cinetecaapp.interactor.InteractorImpl;
import mx.com.armandroid.cinetecaapp.interfaces.CinetecaCallback;
import mx.com.armandroid.cinetecaapp.interfaces.DetallePeliculaView;
import mx.com.armandroid.cinetecaapp.interfaces.PresenterDetallePelicula;
import mx.com.armandroid.cinetecaapp.model.Respuesta;

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
            case R.id.addCalendar:
                detalleView.verTrailer("");
                break;
            default:
                break;
        }
    }

    @Override
    public void onError(String message) {
    detalleView.colocaMensaje(message);
    }

    @Override
    public void onSuccess(Respuesta param) {
        if(param.peliculas.isEmpty()){
           detalleView.colocarDatos(param.peliculas.get(0));
        }else{

        }
    }
}