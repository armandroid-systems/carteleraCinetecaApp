package mx.com.armandroid.cinetecaapp.network;

import mx.com.armandroid.cinetecaapp.model.Respuesta;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by zadtankus on 7/03/16.
 */
public interface CinetecaService {
    @GET("/getCheerioToDay")
    Call<Respuesta> carteleraDia(@Path("dia") String dia);

    @GET("/getDetail")
    Call<Respuesta> detallePelicula(@Path("idTit") String idTit);
}
