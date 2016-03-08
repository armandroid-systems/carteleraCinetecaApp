package mx.com.armandroid.cinetecaapp.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import mx.com.armandroid.cinetecaapp.R;

/**
 * Created by armando.dominguez on 08/03/2016.
 */
public class ItemCarteleraHolder extends RecyclerView.ViewHolder{

    public TextView tituloFicha;
    public TextView sinopsis;
    public TextView horario;

    public ItemCarteleraHolder(View itemView) {
        super(itemView);
        tituloFicha = (TextView) itemView.findViewById(R.id.textViewTitulo);
        sinopsis = (TextView) itemView.findViewById(R.id.textViewSinopsis);
        horario = (TextView) itemView.findViewById(R.id.textViewHorarios);
    }
}
