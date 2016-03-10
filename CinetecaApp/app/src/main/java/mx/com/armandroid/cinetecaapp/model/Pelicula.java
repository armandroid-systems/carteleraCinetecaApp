package mx.com.armandroid.cinetecaapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by armando.dominguez on 07/03/2016.
 */
public class Pelicula implements Parcelable {

    public String peliculaTitulo;
    public String peliculaMiniFicha;
    public String peliculaSinopsis;
    public String horarios;
    public String urlImg;
    public String urlDetail;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.peliculaTitulo);
        dest.writeString(this.peliculaMiniFicha);
        dest.writeString(this.peliculaSinopsis);
        dest.writeString(this.horarios);
        dest.writeString(this.urlImg);
        dest.writeString(this.urlDetail);
    }

    public Pelicula() {
    }

    protected Pelicula(Parcel in) {
        this.peliculaTitulo = in.readString();
        this.peliculaMiniFicha = in.readString();
        this.peliculaSinopsis = in.readString();
        this.horarios = in.readString();
        this.urlImg = in.readString();
        this.urlDetail = in.readString();
    }

    public static final Parcelable.Creator<Pelicula> CREATOR = new Parcelable.Creator<Pelicula>() {
        public Pelicula createFromParcel(Parcel source) {
            return new Pelicula(source);
        }

        public Pelicula[] newArray(int size) {
            return new Pelicula[size];
        }
    };
}
