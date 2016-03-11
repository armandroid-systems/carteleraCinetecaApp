package mx.com.armandroid.cinetecaapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by armando.dominguez on 08/03/2016.
 */
public class DetallePelicula implements Parcelable {

    public String sinopsisCompleta;
    public String trailer;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sinopsisCompleta);
        dest.writeString(this.trailer);
    }

    public DetallePelicula() {
    }

    protected DetallePelicula(Parcel in) {
        this.sinopsisCompleta = in.readString();
        this.trailer = in.readString();
    }

    public static final Parcelable.Creator<DetallePelicula> CREATOR = new Parcelable.Creator<DetallePelicula>() {
        public DetallePelicula createFromParcel(Parcel source) {
            return new DetallePelicula(source);
        }

        public DetallePelicula[] newArray(int size) {
            return new DetallePelicula[size];
        }
    };
}
