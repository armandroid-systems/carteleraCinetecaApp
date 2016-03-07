package mx.com.armandroid.cinetecaapp.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import mx.com.armandroid.cinetecaapp.utils.Constants;

/**
 * Created by armando.dominguez on 07/03/2016.
 */
public class BaseFragment extends Fragment{

    protected Object mParam;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        if(getArguments() != null){
            mParam = getArguments().get(Constants.KEY_PARAM);
        }
        super.onCreate(savedInstanceState);
    }
}
