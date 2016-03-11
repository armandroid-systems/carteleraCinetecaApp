package mx.com.armandroid.cinetecaapp.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import mx.com.armandroid.cinetecaapp.R;
import mx.com.armandroid.cinetecaapp.interactor.InteractorImpl;
import mx.com.armandroid.cinetecaapp.interfaces.DetallePeliculaView;
import mx.com.armandroid.cinetecaapp.model.Pelicula;
import mx.com.armandroid.cinetecaapp.presenter.PresenterDetallePeliculaImpl;
import mx.com.armandroid.cinetecaapp.utils.Utils;

/**
 * Created by zadtankus on 7/03/16.
 */
public class FragmentDetallePelicula extends BaseFragment implements DetallePeliculaView, View.OnClickListener {
    private static final String TAG = FragmentDetallePelicula.class.getSimpleName();

    private ImageView imgDetalle;
    private TextView title;
    private TextView sinopsis;
    private TextView horarios;
    private Pelicula peliDeCartelera;
    private FloatingActionButton fabTrailer;
    private PresenterDetallePeliculaImpl presenterDetalle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View detalleView = inflater.inflate(R.layout.fragment_detalle_pelicula, container,false);

        presenterDetalle =  new PresenterDetallePeliculaImpl(new InteractorImpl(getContext()),this);

        imgDetalle = (ImageView) detalleView.findViewById(R.id.imageViewImgDetalle);
        title = (TextView) detalleView.findViewById(R.id.textViewTituloDetalle);
        sinopsis = (TextView) detalleView.findViewById(R.id.textViewSinopsisCompleta);
        horarios = (TextView) detalleView.findViewById(R.id.textViewHorariosDetalle);
        fabTrailer = (FloatingActionButton) detalleView.findViewById(R.id.verTrailer);

        if(mParam != null){
            peliDeCartelera = (Pelicula)mParam;
           presenterDetalle.getDetallePelicula(peliDeCartelera.urlDetail);
        }

        fabTrailer.setOnClickListener(this);

        return detalleView;
    }

    @Override
    public void ocultaImagen() {

    }

    @Override
    public void colocaMensaje(String mensaje) {

    }

    @Override
    public void verTrailer() {
        Utils.watchYoutubeVideo(peliDeCartelera.trailer,getActivity());

    }

    @Override
    public void colocarDatos(Pelicula datos) {
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
