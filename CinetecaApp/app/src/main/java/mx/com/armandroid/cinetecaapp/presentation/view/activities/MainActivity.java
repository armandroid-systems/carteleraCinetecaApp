package mx.com.armandroid.cinetecaapp.presentation.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import mx.com.armandroid.cinetecaapp.R;
import mx.com.armandroid.cinetecaapp.utils.Constants;
import mx.com.armandroid.cinetecaapp.utils.ScreenManager;
import mx.com.armandroid.cinetecaapp.presentation.view.fragments.FragmentCartelera;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.screenWrapper) != null){
            if(savedInstanceState == null) {
                try {
                    ScreenManager.screenChange(MainActivity.this,
                            R.id.screenWrapper,
                            FragmentCartelera.class,null,
                            Constants.VIEW_SUMMARY,
                            Constants.BIN_TRUE);
                } catch (IllegalAccessException e) {
                    Log.e(TAG,"ERROR "+e);
                } catch (InstantiationException e) {
                    Log.e(TAG, "ERROR " + e);
                }
            }
        }
    }
}
