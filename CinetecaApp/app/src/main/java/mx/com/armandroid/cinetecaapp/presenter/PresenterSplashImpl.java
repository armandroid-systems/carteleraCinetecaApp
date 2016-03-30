package mx.com.armandroid.cinetecaapp.presenter;

import mx.com.armandroid.cinetecaapp.interactor.InteractorImpl;
import mx.com.armandroid.cinetecaapp.interfaces.interfacecallback.CinetecaCallback;
import mx.com.armandroid.cinetecaapp.interfaces.interfacepresenter.PresenterSplash;
import mx.com.armandroid.cinetecaapp.interfaces.interfaceview.SplashView;
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
    public void obtenerCartelera() {
        mInteractor.cartelera(null,this);
    }

    @Override
    public void clickDialogAlert() {
        viewSplash.cierraAplicacion();
    }

    @Override
    public void onError(String message) {
        viewSplash.muestraDialogo(message);
    }

    @Override
    public void onSuccess(Respuesta param) {
        viewSplash.veAprincipal();
    }
}
