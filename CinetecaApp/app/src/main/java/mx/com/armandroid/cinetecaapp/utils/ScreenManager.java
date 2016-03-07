package mx.com.armandroid.cinetecaapp.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by armando.dominguez on 07/03/2016.
 */
public class ScreenManager {

    public static void screenChange(FragmentActivity origin,int viewContainer, Class fragment,
                                    Bundle params, String id,
                                    int isMain) throws IllegalAccessException, InstantiationException {
        FragmentTransaction transaction = origin.getSupportFragmentManager().beginTransaction();
        Fragment mFragment = (Fragment) fragment.newInstance();
        if(params != null){
            mFragment.setArguments(params);
        }
        if (isMain == 0) {
            transaction.addToBackStack(id);
        }
        transaction.replace(viewContainer, mFragment);
        transaction.commit();
    }
}
