package edu.upc.eseiaat.pma.kmamilles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Button btn_a_millas = (Button) findViewById(R.id.btn_a_millas); //botón a millas
        Button btn_a_km = (Button) findViewById(R.id.btn_a_kilometros);

        btn_a_millas.setOnClickListener(new View.OnClickListener() { //new+espacio+(ctrl+espacio)
            @Override
            public void onClick(View v) {
                String skm = edit_km.getText().toString(); //para coger los km(gettxt) y hacerlo string(toString)
                float km = Float.parseFloat(skm);           // pasamos string a float
                float milles = km/1.609f;                   // la 'f' indica que es float, transforma a millas
                String smillas = String.format("%f", milles); //pasamos a string el float(%f)
                edit_millas.setText(smillas);               // escribe las millas en la caja

                Log.i("manu", "btn_a_millas funciona");     //nombre cualquiera, mensaje informativo
            }
        });

        btn_a_km.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smillas = edit_millas.getText().toString();
                float milles = Float.parseFloat(smillas);
                float km = milles*1.609f;
                String skm = String.format("%f",km);
                edit_km.setText(skm);
            }
        });
        */


        final EditText edit_km = (EditText) findViewById(R.id.Edit_km); //para coger el texto de los km
        final EditText edit_millas = (EditText) findViewById(R.id.Edit_millas); //cambiar el texto de milas
        final String merror = getResources().getString(R.string.Toast1); //para traducir mensajes string
        final  Toast toast1 =                                       //para sacar mensajes de error por ejemplo
                Toast.makeText(getApplicationContext(),
                        merror, Toast.LENGTH_LONG);

        EditText txt_millas = (EditText) findViewById(R.id.Edit_km);
        EditText txt_km = (EditText) findViewById(R.id.Edit_millas);

        txt_millas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String skm = edit_km.getText().toString();
               //  if(skm==null || skm.equals("")) return;  //si esta vacio no convierte nada y evita error
                float milles;

                try{
                    float km = Float.parseFloat(skm);
                    milles = km/1.609f;
                }
                catch (NumberFormatException e) {

                            toast1.show();
                            return;
                }


                String smillas = String.format("%f", milles);
                edit_millas.setText(smillas);


            }
        });

        txt_km.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smillas = edit_millas.getText().toString();
                //if(smillas==null || smillas.equals("")) return;
                float km;
                try {
                    float milles = Float.parseFloat(smillas);
                    km = milles * 1.609f;
                }
                catch(NumberFormatException e) {
                    toast1.show();
                    return;
                }
                String sk = String.format("%f",km);
                edit_km.setText(sk);


            }
        });
    }
}
