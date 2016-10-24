package mx.com.armandroid.cineartapp.presentation.presenter;

import mx.com.armandroid.cineartapp.logic.interactor.InteractorImpl;
import mx.com.armandroid.cineartapp.logic.interfacecallback.CinetecaCallback;
import mx.com.armandroid.cineartapp.presentation.interfacepresenter.PresenterSplash;
import mx.com.armandroid.cineartapp.presentation.interfaceview.SplashView;
import mx.com.armandroid.cineartapp.data.model.Respuesta;

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
