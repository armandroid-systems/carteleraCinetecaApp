package mx.com.armandroid.cinetecaapp.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import mx.com.armandroid.cinetecaapp.R;
import mx.com.armandroid.cinetecaapp.adapters.RecyclerCarteleraAdapter;
import mx.com.armandroid.cinetecaapp.interactor.InteractorImpl;
import mx.com.armandroid.cinetecaapp.interfaces.CardClick;
import mx.com.armandroid.cinetecaapp.interfaces.CarteleraView;
import mx.com.armandroid.cinetecaapp.model.Respuesta;
import mx.com.armandroid.cinetecaapp.presenter.PresenterCarteleraImpl;

/**
 * Created by zadtankus on 7/03/16.
 */
public class FragmentCartelera extends BaseFragment implements CarteleraView {
    private static final String TAG = FragmentCartelera.class.getSimpleName();

    private ProgressBar mProgress;
    private ImageView imageView;
    private RecyclerView cartelera;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View carteleraView = inflater.inflate(R.layout.fragment_cartelera,container,false);

        mProgress = (ProgressBar) carteleraView.findViewById(R.id.progressBarCartelera);
        imageView = (ImageView) carteleraView.findViewById(R.id.imageViewFail);
        cartelera = (RecyclerView) carteleraView.findViewById(R.id.recyclerCartelera);

        PresenterCarteleraImpl presenter = new PresenterCarteleraImpl(new InteractorImpl(getContext()),this);
        presenter.getCarteleraFromApi(null);

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
    public void veADetallePelicula(String id, String param) {

    }

    @Override
    public void createRecyclerView(RecyclerCarteleraAdapter adapter) {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        cartelera.setLayoutManager(llm);
        cartelera.setAdapter(adapter);
    }

    @Override
    public void agregaACalendario(String evento) {

    }
}
