package mx.com.armandroid.cinetecaapp.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import mx.com.armandroid.cinetecaapp.R;
import mx.com.armandroid.cinetecaapp.adapters.RecyclerCarteleraAdapter;
import mx.com.armandroid.cinetecaapp.interactor.InteractorImpl;
import mx.com.armandroid.cinetecaapp.interfaces.CarteleraView;
import mx.com.armandroid.cinetecaapp.model.Pelicula;
import mx.com.armandroid.cinetecaapp.presenter.PresenterCarteleraImpl;
import mx.com.armandroid.cinetecaapp.utils.Constants;
import mx.com.armandroid.cinetecaapp.utils.ScreenManager;

/**
 * Created by zadtankus on 7/03/16.
 */
public class FragmentCartelera extends BaseFragment implements CarteleraView {
    private static final String TAG = FragmentCartelera.class.getSimpleName();

    private ProgressBar mProgress;
    private ImageView imageView;
    private RecyclerView cartelera;

    private PresenterCarteleraImpl presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View carteleraView = inflater.inflate(R.layout.fragment_cartelera,container,false);

        mProgress = (ProgressBar) carteleraView.findViewById(R.id.progressBarCartelera);
        imageView = (ImageView) carteleraView.findViewById(R.id.imageViewFail);
        cartelera = (RecyclerView) carteleraView.findViewById(R.id.recyclerCartelera);

        presenter = new PresenterCarteleraImpl(new InteractorImpl(getContext()),this);
        presenter.getCarteleraFromApi("2016-03-11");

        return carteleraView;
    }

    @Override
    public void escondeLoader() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void muestraImgError() {
        imageView.setVisibility(View.VISIBLE);
    }

    @Override
    public void muestraMensaje(String msj) {

    }

    @Override
    public void veADetallePelicula(Pelicula pelicula) {
        try {
            Bundle mBundle = new Bundle();
            mBundle.putParcelable(Constants.KEY_PARAM, pelicula );
            ScreenManager.screenChange(getActivity(),
                    R.id.screenWrapper,
                    FragmentDetallePelicula.class,
                    mBundle,
                    Constants.VIEW_DETAIL,
                    Constants.BIN_FALSE);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createRecyclerView(RecyclerCarteleraAdapter adapter) {
        cartelera.setVisibility(View.VISIBLE);
        Log.d(TAG,"SETTING RECYCLER");
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        cartelera.setLayoutManager(llm);
        cartelera.setAdapter(adapter);
    }

    @Override
    public void agregaACalendario(String evento) {

    }

    @Override
    public void compartirPelicula(String pelicula) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, pelicula);
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.label_compartir_ventana)));
    }
}
