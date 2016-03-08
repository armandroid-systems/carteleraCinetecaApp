package mx.com.armandroid.cinetecaapp.network;

import mx.com.armandroid.cinetecaapp.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zadtankus on 7/03/16.
 */
public class CinetecaApi {
    private static final String TAG = CinetecaApi.class.getSimpleName();

    private final CinetecaService cinetecaService;

    private CinetecaService init(){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(CinetecaService.class);
    }

    public CinetecaApi(CinetecaService cinetecaService) {
        this.cinetecaService = init();
    }

    public CinetecaService getCinetecaService() {
        return cinetecaService;
    }
}
