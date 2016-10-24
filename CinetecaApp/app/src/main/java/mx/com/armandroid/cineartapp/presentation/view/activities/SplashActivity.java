package mx.com.armandroid.cineartapp.presentation.view.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import mx.com.armandroid.cineartapp.logic.interactor.InteractorImpl;
import mx.com.armandroid.cinetecaapp.R;
import mx.com.armandroid.cineartapp.presentation.interfaceview.SplashView;
import mx.com.armandroid.cineartapp.presentation.presenter.PresenterSplashImpl;

public class SplashActivity extends AppCompatActivity implements SplashView, AlertDialog.OnClickListener {
    private static final String TAG = SplashActivity.class.getSimpleName();

    private PresenterSplashImpl presenterSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void cierraAplicacion() {
        Log.d(TAG,"SIN CONEXION, CERRANDO APP...");
        finish();
    }

    @Override
    public void veAprincipal() {
        Log.d(TAG,"REDIRIGIENDO A LA PANTALLA PRINCIPAL...");
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void muestraDialogo(String mensaje) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle(getString(R.string.app_name));
        if(mensaje != null){
            alertBuilder.setMessage(getString(R.string.message_server_error));
        }else{
            alertBuilder.setMessage(getString(R.string.message_no_network));
        }
        alertBuilder.setPositiveButton(android.R.string.ok,this);
        alertBuilder.create();
        alertBuilder.show();

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        presenterSplash.clickDialogAlert();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenterSplash = new PresenterSplashImpl(new InteractorImpl(SplashActivity.this),this);
        presenterSplash.obtenerCartelera();
    }
}
