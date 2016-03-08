package mx.com.armandroid.cinetecaapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

import mx.com.armandroid.cinetecaapp.R;
import mx.com.armandroid.cinetecaapp.interfaces.CardClick;
import mx.com.armandroid.cinetecaapp.model.Pelicula;
import mx.com.armandroid.cinetecaapp.model.Respuesta;
import mx.com.armandroid.cinetecaapp.utils.ItemCarteleraHolder;

/**
 * Created by armando.dominguez on 08/03/2016.
 */
public class RecyclerCarteleraAdapter extends RecyclerView.Adapter<ItemCarteleraHolder> {
    private static final String TAG = RecyclerCarteleraAdapter.class.getSimpleName();

    private Respuesta mData;
    private Pelicula peli;
    private CardClick clickCard;

    public RecyclerCarteleraAdapter(Respuesta data, CardClick click) {
        this.mData = data;
        this.clickCard = click;
    }

    @Override
    public ItemCarteleraHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cartelera,parent, false);
        return new ItemCarteleraHolder(viewItem, clickCard);
    }

    @Override
    public void onBindViewHolder(ItemCarteleraHolder holder, int position) {
        peli = ((Pelicula)mData.peliculas.get(position));
        holder.tituloFicha.setText(peli.peliculaTitulo + peli.peliculaMiniFicha);
        holder.sinopsis.setText(peli.peliculaSinopsis);
        holder.horario.setText(peli.horarios);
    }

    @Override
    public int getItemCount() {
        return null != mData ? mData.peliculas.size() : 0;
    }
}
