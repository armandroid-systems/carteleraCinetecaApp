package mx.com.armandroid.cineartapp.presentation.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;


import mx.com.armandroid.cineartapp.utils.Constants;

/**
 * Created by armando.dominguez on 07/03/2016.
 */
public class BaseFragment extends Fragment {

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
