package mx.com.armandroid.cinetecaapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.List;
import java.util.zip.Inflater;

import mx.com.armandroid.cinetecaapp.R;
import mx.com.armandroid.cinetecaapp.interfaces.CardClick;
import mx.com.armandroid.cinetecaapp.model.Pelicula;
import mx.com.armandroid.cinetecaapp.model.Respuesta;
import mx.com.armandroid.cinetecaapp.utils.ItemCarteleraHolder;
import mx.com.armandroid.cinetecaapp.utils.Utils;

/**
 * Created by armando.dominguez on 08/03/2016.
 */
public class RecyclerCarteleraAdapter extends RecyclerView.Adapter<ItemCarteleraHolder> {
    private static final String TAG = RecyclerCarteleraAdapter.class.getSimpleName();

    private List<Pelicula> mData;
    private Pelicula peli;
    private CardClick clickCard;
    private Context mContext;

    public RecyclerCarteleraAdapter(List<Pelicula> data, CardClick click, Context theContext) {
        this.mData = data;
        this.clickCard = click;
        this.mContext = theContext;
    }

    @Override
    public ItemCarteleraHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cartelera,parent, false);
        return new ItemCarteleraHolder(viewItem, clickCard);
    }

    @Override
    public void onBindViewHolder(ItemCarteleraHolder holder, int position) {
        holder.tituloFicha.setText(mData.get(position).peliculaTitulo + mData.get(position).peliculaMiniFicha);
        holder.sinopsis.setText(mData.get(position).peliculaSinopsis);
        holder.horario.setText(mData.get(position).horarios);
        Picasso.with(mContext)
                .load(mData.get(position).urlImg)
                .placeholder(R.drawable.cineteca_logo)
                .resize(1100,550)
                .centerCrop()
                .into(holder.peliculaFoto);
    }

    @Override
    public int getItemCount() {
        return null != mData ? mData.size() : 0;
    }
}
