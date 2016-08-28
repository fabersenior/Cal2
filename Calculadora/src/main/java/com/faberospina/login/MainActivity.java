package com.faberospina.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText eto,esubject;
    TextView eResultado;

    RadioGroup group;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         eResultado = (TextView) findViewById(R.id.TexResultado);
         eto = (EditText) findViewById(R.id.editNumero1);
         esubject = (EditText) findViewById(R.id.editNumero2);
           group = (RadioGroup) findViewById(R.id.rdgroup);
//      bSend.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View view) {

//              int toper = Integer.parseInt(eto.getText().toString()) ; //cast de String to Int
       // esubject.setText(Integer.toString(toper));// cast de int to String
//              String subject = esubject.getText().toString();
//             // String message = emessage.getText().toString();
//
//
//          }
//      });


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.suma:
                if (checked) {
                    if(eto.length()==0 || esubject.length()==0){
                        eResultado.setText("Campos Vacios");
                    }else {
                        int n1 = Integer.parseInt(eto.getText().toString());
                        int n2 = Integer.parseInt(esubject.getText().toString());
                        eResultado.setText("Resultado de la suma es: " + Integer.toString(n1 + n2));
                    }
                }
                    // Pirates are the best
                    break;
            case R.id.resta:
                if (checked) {
                    if(eto.length()==0 || esubject.length()==0){
                        eResultado.setText("Campos Vacios");
                    }else {
                        int n1 = Integer.parseInt(eto.getText().toString());
                        int n2 = Integer.parseInt(esubject.getText().toString());
                        eResultado.setText("Resultado de la resta es: " + Integer.toString(n1 - n2));
                    }
                }
                    // Ninjas rule
                    break;

            case  R.id.Multi:
                if (checked) {
                    if(eto.length()==0 || esubject.length()==0){
                        eResultado.setText("Campos Vacios");
                    }else {
                        int n1 = Integer.parseInt(eto.getText().toString());
                        int n2 = Integer.parseInt(esubject.getText().toString());
                        eResultado.setText("Resultado de la Multipicacion es: " + Integer.toString(n1 * n2));
                    }
                }
                break;

            case  R.id.div:
                if (checked) {
                    if(eto.length()==0 || esubject.length()==0){
                        eResultado.setText("Campos Vacios");
                    }else {
                        int n1 = Integer.parseInt(eto.getText().toString());
                        int n2 = Integer.parseInt(esubject.getText().toString());
                        if (n2 == 0) {
                            eResultado.setText("Numero 2 es igual a cero, Division no definida");
                        } else {
                            eResultado.setText("Resultado de la division es: " + Double.toString((double) n1/n2));
                        }
                    }
                }
                break;

            default :
                eResultado.setText("Incorrecto");
                break;
        }
    }





}
