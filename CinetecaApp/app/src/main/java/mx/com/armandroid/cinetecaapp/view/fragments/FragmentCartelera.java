package mx.com.armandroid.cinetecaapp.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wang.avi.AVLoadingIndicatorView;

import mx.com.armandroid.cinetecaapp.R;
import mx.com.armandroid.cinetecaapp.adapters.RecyclerCarteleraAdapter;
import mx.com.armandroid.cinetecaapp.interactor.InteractorImpl;
import mx.com.armandroid.cinetecaapp.interfaces.interfaceview.CarteleraView;
import mx.com.armandroid.cinetecaapp.model.Pelicula;
import mx.com.armandroid.cinetecaapp.presenter.PresenterCarteleraImpl;
import mx.com.armandroid.cinetecaapp.utils.Constants;
import mx.com.armandroid.cinetecaapp.utils.ScreenManager;
import mx.com.armandroid.cinetecaapp.utils.Utils;

/**
 * Created by zadtankus on 7/03/16.
 */
public class FragmentCartelera extends BaseFragment implements CarteleraView, Toolbar.OnMenuItemClickListener {
    private static final String TAG = FragmentCartelera.class.getSimpleName();

    private AVLoadingIndicatorView mProgress;
    private ImageView imageView;
    private RecyclerView cartelera;
    private Toolbar carteleraToolbar;

    private PresenterCarteleraImpl presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View carteleraView = inflater.inflate(R.layout.fragment_cartelera,container,false);

        carteleraToolbar = (Toolbar)carteleraView.findViewById(R.id.carteleraToolbar);
        mProgress = (AVLoadingIndicatorView) carteleraView.findViewById(R.id.progressBarCartelera);
        imageView = (ImageView) carteleraView.findViewById(R.id.imageViewFail);
        cartelera = (RecyclerView) carteleraView.findViewById(R.id.recyclerCartelera);

        carteleraToolbar.setOnMenuItemClickListener(this);
        carteleraToolbar.inflateMenu(R.menu.menu_cartelera);
        carteleraToolbar.setTitle(getString(R.string.title_cartelera));

        presenter = new PresenterCarteleraImpl(new InteractorImpl(getActivity().getBaseContext()),this);
        presenter.getCarteleraFromRepo();

        return carteleraView;
    }

    @Override
    public void escondeLoader() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void escondeRecycler() {
        cartelera.setVisibility(View.GONE);
    }

    @Override
    public void escondeImagenError() {
        imageView.setVisibility(View.GONE);
    }

    @Override
    public void muestraLoader() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void muestraImgError() {
        imageView.setVisibility(View.VISIBLE);
    }

    @Override
    public void muestraMensaje(String msj) {
        Utils.showSnackBar(getView(),getString(R.string.message_server_error));
    }
    @Override
    public void muestraDatePicker() {
        FragmentDatePicker mDatePicker = new FragmentDatePicker();
        mDatePicker.setmViewCartelera(this);
        mDatePicker.show(getActivity().getFragmentManager(),Constants.VIEW_PICKER);
    }
    @Override
    public void veADetallePelicula(Pelicula pelicula) {
        try {
            Bundle mBundle = new Bundle();
            mBundle.putParcelable(Constants.KEY_PARAM, pelicula );
            ScreenManager.screenChange((AppCompatActivity)getActivity(),
                    R.id.screenWrapper,
                    FragmentDetallePelicula.class,
                    mBundle,
                    Constants.VIEW_DETAIL,
                    Constants.BIN_FALSE);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "ERROR ON NAVIGATIION [" + e + "]");
        } catch (java.lang.InstantiationException e) {
            Log.e(TAG, "ERROR ON NAVIGATIION [" + e + "]");
        }
    }

    @Override
    public void createRecyclerView(RecyclerCarteleraAdapter adapter) {
        cartelera.setVisibility(View.VISIBLE);
        Log.d(TAG,"SETTING RECYCLER");
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getBaseContext());
        cartelera.setLayoutManager(llm);
        cartelera.setAdapter(adapter);
    }

    @Override
    public void agregaACalendario(Pelicula evento) {
        Utils.addEvent(evento.peliculaTitulo,
                Constants.CINETECA_LOCATION,
                Utils.dateParser(evento.horarios),
                getActivity());
    }

    @Override
    public void compartirPelicula(String pelicula) {
       Utils.shareIntent(getActivity(),
                getString(R.string.label_compartir_ventana),
                pelicula);
    }

    @Override
    public void obtenCarteleraDia(String date) {
        presenter.getCarteleraFromApi(date);
    }

    @Override
    public void colocarFechaEnBarra(String date) {
        carteleraToolbar.setSubtitle(date);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        presenter.clickMenuButtonAdapter(item.getItemId());
        return false;
    }
}
