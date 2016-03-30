package mx.com.armandroid.cinetecaapp.view.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;

import mx.com.armandroid.cinetecaapp.interfaces.interfaceview.CarteleraView;
import mx.com.armandroid.cinetecaapp.utils.Utils;

/**
 * Created by zadtankus on 21/03/16.
 */
public class FragmentDatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener{
    private static final String TAG = FragmentDatePicker.class.getSimpleName();

    private CarteleraView mViewCartelera;

    public void setmViewCartelera(CarteleraView mViewCartelera) {
        this.mViewCartelera = mViewCartelera;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.d(TAG,"CREANDO FRAGMENT DATEPICKER...");
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Log.d(TAG,"OIBTENIENDO FECHA...");
        mViewCartelera.obtenCarteleraDia(Utils.dateFromPicker(year,monthOfYear,dayOfMonth));
    }
}
