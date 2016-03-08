package mx.com.armandroid.cinetecaapp.presenter;

import mx.com.armandroid.cinetecaapp.interactor.InteractorImpl;
import mx.com.armandroid.cinetecaapp.interfaces.CinetecaCallback;
import mx.com.armandroid.cinetecaapp.interfaces.PresenterSplash;
import mx.com.armandroid.cinetecaapp.interfaces.SplashView;
import mx.com.armandroid.cinetecaapp.model.Respuesta;

/**
 * Created by armando.dominguez on 08/03/2016.
 */
public class PresenterSplashImpl implements PresenterSplash, CinetecaCallback {
    private static final String TAG = PresenterSplashImpl.class.getSimpleName();

    private InteractorImpl mInteractor;
    private SplashView viewSplash;

    public PresenterSplashImpl(InteractorImpl mInteractor, SplashView viewSplash) {
        this.mInteractor = mInteractor;
        this.viewSplash = viewSplash;
    }

    @Override
    public void conexionActiva() {
        mInteractor.compruebaConexion(this);
    }

    @Override
    public void onError(String message) {
        viewSplash.cierraAplicacion();
    }

    @Override
    public void onSuccess(Respuesta param) {
        viewSplash.veAprincipal();
    }
}
