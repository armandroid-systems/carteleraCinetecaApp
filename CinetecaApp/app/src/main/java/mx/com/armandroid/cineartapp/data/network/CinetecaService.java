package mx.com.armandroid.cineartapp.data.network;

import mx.com.armandroid.cineartapp.data.model.Respuesta;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zadtankus on 7/03/16.
 */
public interface CinetecaService {
    @GET("getCartelera")
    Call<Respuesta> carteleraDia(@Query("dia") String dia);

    @GET("getDetail/{pelicula}")
    Call<Respuesta> detallePelicula(@Query("pelicula") String pelicula);
}
