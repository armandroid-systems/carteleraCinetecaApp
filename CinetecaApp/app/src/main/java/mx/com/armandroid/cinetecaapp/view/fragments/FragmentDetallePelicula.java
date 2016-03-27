package mx.com.armandroid.cinetecaapp.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wang.avi.AVLoadingIndicatorView;

import mx.com.armandroid.cinetecaapp.R;
import mx.com.armandroid.cinetecaapp.interactor.InteractorImpl;
import mx.com.armandroid.cinetecaapp.interfaces.DetallePeliculaView;
import mx.com.armandroid.cinetecaapp.model.Pelicula;
import mx.com.armandroid.cinetecaapp.presenter.PresenterDetallePeliculaImpl;
import mx.com.armandroid.cinetecaapp.utils.ScreenManager;
import mx.com.armandroid.cinetecaapp.utils.Utils;

/**
 * Created by zadtankus on 7/03/16.
 */
public class FragmentDetallePelicula extends BaseFragment implements DetallePeliculaView, View.OnClickListener {
    private static final String TAG = FragmentDetallePelicula.class.getSimpleName();

    private ImageView imgDetalle;
    private ImageView imgFail;
    private TextView title;
    private TextView sinopsis;
    private TextView horarios;
    private Pelicula peliDeCartelera;
    private FloatingActionButton fabTrailer;
    private PresenterDetallePeliculaImpl presenterDetalle;
    private AVLoadingIndicatorView progressDetalle;
    private LinearLayout linearWrapper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View detalleView = inflater.inflate(R.layout.fragment_detalle_pelicula, container,false);

        Toolbar mToolbar = (Toolbar) detalleView.findViewById(R.id.detalleToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_white_24dp);
        mToolbar.setTitle(getString(R.string.title_detail));
        mToolbar.setNavigationOnClickListener(this);

        presenterDetalle =  new PresenterDetallePeliculaImpl(new InteractorImpl(getActivity().getBaseContext()),this);

        linearWrapper = (LinearLayout) detalleView.findViewById(R.id.detailMainWrapper);
        progressDetalle = (AVLoadingIndicatorView) detalleView.findViewById(R.id.progressBarDetalle);
        imgDetalle = (ImageView) detalleView.findViewById(R.id.imageViewImgDetalle);
        imgFail = (ImageView) detalleView.findViewById(R.id.imageViewFail);
        title = (TextView) detalleView.findViewById(R.id.textViewTituloDetalle);
        sinopsis = (TextView) detalleView.findViewById(R.id.textViewSinopsisCompleta);
        horarios = (TextView) detalleView.findViewById(R.id.textViewHorariosDetalle);
        fabTrailer = (FloatingActionButton) detalleView.findViewById(R.id.verTrailer);

        if(mParam != null){
            peliDeCartelera = (Pelicula)mParam;
            Log.d(TAG, "PARAMETRO ENCONTRADO...");
            presenterDetalle.getDetallePelicula(peliDeCartelera.urlDetail);
        }

        fabTrailer.setOnClickListener(this);

        return detalleView;
    }

    @Override
    public void mostrarImagen() {
        imgFail.setVisibility(View.VISIBLE);
    }

    @Override
    public void ocultarLoader() {
        progressDetalle.setVisibility(View.GONE);
    }

    @Override
    public void muestraBotonTrailer() {
        fabTrailer.setVisibility(View.VISIBLE);
    }

    @Override
    public void colocaMensaje(String mensaje) {
        Utils.showSnackBar(getView(),getString(R.string.message_server_error));
    }

    @Override
    public void verTrailer() {
        Utils.watchYoutubeVideo(peliDeCartelera.trailer,getActivity());

    }

    @Override
    public void veAtras() {
        Log.d(TAG,"REGRESANDO A VISTA ANTERIOR...");
        ScreenManager.screenBack((AppCompatActivity)getActivity());
    }

    @Override
    public void colocarDatos(Pelicula datos) {
        linearWrapper.setVisibility(View.VISIBLE);
        peliDeCartelera.trailer = datos.trailer;
        title.setText(peliDeCartelera.peliculaTitulo);
        sinopsis.setText(datos.sinopsisCompleta);
        horarios.setText(peliDeCartelera.horarios);
        Picasso.with(getContext())
                .load(datos.imgUrl)
                .placeholder(R.drawable.cineteca_logo)
                .resize(1100,550)
                .centerCrop()
                .into(imgDetalle);
    }

    @Override
    public void onClick(View v) {
        presenterDetalle.eventClick(v.getId());
    }
}
