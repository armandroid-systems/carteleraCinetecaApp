package mx.com.armandroid.cinetecaapp.view.fragments;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import mx.com.armandroid.cinetecaapp.R;
import mx.com.armandroid.cinetecaapp.interfaces.DetallePeliculaView;
import mx.com.armandroid.cinetecaapp.model.Pelicula;
import mx.com.armandroid.cinetecaapp.presenter.PresenterDetallePeliculaImpl;

/**
 * Created by zadtankus on 7/03/16.
 */
public class FragmentDetallePelicula extends BaseFragment implements DetallePeliculaView {
    private static final String TAG = FragmentDetallePelicula.class.getSimpleName();

    private ImageView imgDetalle;
    private TextView title;
    private TextView sinopsis;
    private TextView horarios;
    private PresenterDetallePeliculaImpl presenterDetalle;
    private Pelicula peliDeCartelera;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View detalleView = inflater.inflate(R.layout.fragment_detalle_pelicula, container,false);

        imgDetalle = (ImageView) detalleView.findViewById(R.id.imageViewImgDetalle);
        title = (TextView) detalleView.findViewById(R.id.textViewTituloDetalle);
        sinopsis = (TextView) detalleView.findViewById(R.id.textViewSinopsisCompleta);
        horarios = (TextView) detalleView.findViewById(R.id.textViewHorariosDetalle);

        if(mParam != null){
            peliDeCartelera = (Pelicula)mParam;
            presenterDetalle.getDetallePelicula(peliDeCartelera.urlDetail);
        }

        return detalleView;
    }

    @Override
    public void ocultaImagen() {

    }

    @Override
    public void colocaMensaje(String mensaje) {

    }

    @Override
    public void verTrailer(String id) {

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
}
