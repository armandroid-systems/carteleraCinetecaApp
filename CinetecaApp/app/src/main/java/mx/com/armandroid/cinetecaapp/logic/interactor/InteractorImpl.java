package mx.com.armandroid.cinetecaapp.logic.interactor;

import android.content.Context;

import mx.com.armandroid.cinetecaapp.logic.interfacecallback.CinetecaCallback;
import mx.com.armandroid.cinetecaapp.logic.interfaceinteractor.Interactor;
import mx.com.armandroid.cinetecaapp.data.model.Respuesta;
import mx.com.armandroid.cinetecaapp.data.network.CinetecaApi;
import mx.com.armandroid.cinetecaapp.data.repository.Repository;
import mx.com.armandroid.cinetecaapp.utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by armando.dominguez on 08/03/2016.
 */
public class InteractorImpl implements Interactor{
    private static final String TAG = InteractorImpl.class.getSimpleName();

    private Context mContext;
    private CinetecaApi restApi;

    public InteractorImpl(Context mContext) {
        this.mContext = mContext;
        this.restApi = new CinetecaApi();
    }

    @Override
    public Respuesta getCacheCartelera() {
        return Repository.getInstance().getmRespuesta();
    }

    @Override
    public void cartelera(String fecha, final CinetecaCallback cb) {
        if(Utils.isConnectedToInternet(mContext)){
            restApi.getCinetecaService().carteleraDia(fecha).enqueue(new Callback<Respuesta>() {
                @Override
                public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                    Repository.getInstance().setmRespuesta(response.body());
                    cb.onSuccess(response.body());
                }

                @Override
                public void onFailure(Call<Respuesta> call, Throwable t) {
                    cb.onError(t.getMessage());
                }
            });

        }else{
            cb.onError(null);
        }
    }

    @Override
    public void detallePelicula(String titulo, final CinetecaCallback cb) {
        if(Utils.isConnectedToInternet(mContext)){

            restApi.getCinetecaService().detallePelicula(titulo).enqueue(new Callback<Respuesta>() {
                @Override
                public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                    cb.onSuccess(response.body());
                }

                @Override
                public void onFailure(Call<Respuesta> call, Throwable t) {
                    cb.onError(t.getMessage());
                }
            });

        }else{
            cb.onError(null);
        }

    }

    public Context getmContext() {
        return mContext;
    }
}
