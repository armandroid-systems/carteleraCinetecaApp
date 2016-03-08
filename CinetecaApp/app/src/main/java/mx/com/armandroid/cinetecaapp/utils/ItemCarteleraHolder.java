package mx.com.armandroid.cinetecaapp.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import mx.com.armandroid.cinetecaapp.R;
import mx.com.armandroid.cinetecaapp.interfaces.CardClick;

/**
 * Created by armando.dominguez on 08/03/2016.
 */
public class ItemCarteleraHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView tituloFicha;
    public TextView sinopsis;
    public TextView horario;
    public TextView mas;
    public TextView compartir;
    public TextView calendario;
    private CardClick cardClick;

    public ItemCarteleraHolder(View itemView, CardClick mCard) {
        super(itemView);
        this.cardClick = mCard;
        tituloFicha = (TextView) itemView.findViewById(R.id.textViewTitulo);
        sinopsis = (TextView) itemView.findViewById(R.id.textViewSinopsis);
        horario = (TextView) itemView.findViewById(R.id.textViewHorarios);
        mas = (TextView) itemView.findViewById(R.id.textViewMas);
        compartir = (TextView) itemView.findViewById(R.id.textViewCompartir);
        calendario = (TextView) itemView.findViewById(R.id.addCalendar);

        mas.setOnClickListener(this);
        compartir.setOnClickListener(this);
        calendario.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        cardClick.hacerAccion(v.getId());
    }
}
