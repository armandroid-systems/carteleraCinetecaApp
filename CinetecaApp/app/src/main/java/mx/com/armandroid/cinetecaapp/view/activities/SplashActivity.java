package mx.com.armandroid.cinetecaapp.view.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import mx.com.armandroid.cinetecaapp.R;
import mx.com.armandroid.cinetecaapp.interactor.InteractorImpl;
import mx.com.armandroid.cinetecaapp.interfaces.SplashView;
import mx.com.armandroid.cinetecaapp.presenter.PresenterSplashImpl;

public class SplashActivity extends AppCompatActivity implements SplashView {
    private static final String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new PresenterSplashImpl(new InteractorImpl(SplashActivity.this),this).conexionActiva();
    }

    @Override
    public void cierraAplicacion() {
        Log.d(TAG,"Cerrando aplicacion debido a la falta de conexion...");
        finish();
    }

    @Override
    public void veAprincipal() {
        Log.d(TAG,"REDIRIGIENDO A LA PANTALLA PRINCIPAL...");
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
