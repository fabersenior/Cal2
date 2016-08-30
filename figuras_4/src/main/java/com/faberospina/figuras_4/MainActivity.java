package com.faberospina.figuras_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioButton;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText lado,base,altura,radio ;
    TextView resultado;
    RadioGroup group;
    int sel=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group = (RadioGroup) findViewById(R.id.rGroup);
        lado= (EditText) findViewById(R.id.eLado);
        base= (EditText) findViewById(R.id.eBase);
        altura= (EditText) findViewById(R.id.eAltura);
        radio= (EditText) findViewById(R.id.eRadio);
        resultado = (TextView) findViewById(R.id.Resultado);
        lado.setVisibility(View.INVISIBLE);        
        base.setVisibility(View.INVISIBLE);
        altura.setVisibility(View.INVISIBLE);
        radio.setVisibility(View.INVISIBLE);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        lado.setVisibility(View.INVISIBLE);
        base.setVisibility(View.INVISIBLE);
        altura.setVisibility(View.INVISIBLE);
        radio.setVisibility(View.INVISIBLE);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.Rcuadro:
                if (checked){
                    lado.setText("");
                    lado.setVisibility(View.VISIBLE);
                    sel=1;
                }else {
                    sel=0;
                }
               // lado.setVisibility(View.INVISIBLE);
                    // Pirates are the best
                    break;
            case R.id.Rtri:
                if (checked){
                    base.setText("");
                    altura.setText("");
                    base.setVisibility(View.VISIBLE);
                    altura.setVisibility(View.VISIBLE);
                    sel=2;

                }else{
                    sel=0;
                }

                    break;

            case R.id.Rcircle:
                if (checked){
                    radio.setText("");
                    radio.setVisibility(View.VISIBLE);
                    sel=3;
                }else{
                    sel=0;
                }

                break;

            case R.id.Rsquare:
                if (checked){
                    lado.setText("");
                    base.setText("");
                    lado.setVisibility(View.VISIBLE);
                    base.setVisibility(View.VISIBLE);
                    sel=4;
                }else{
                    sel=0;
                }

                break;

            default:
                Toast.makeText(this,"Escoja una Opcion"
                        , Toast.LENGTH_SHORT).show();
                break;

        }
    }

    public  void onButtonClicked(View view){

        if(lado.length()==0 && sel==1){
            //resultado.setText("Campos Vacios");
            Toast.makeText(this,"Campo de Lado Vacio"
                    , Toast.LENGTH_SHORT).show();
        }else if(sel==1){

            int n1 = Integer.parseInt(lado.getText().toString());
            resultado.setText("El area del cuadrado es: " + Integer.toString(n1*n1));
        }

        if((base.length()==0 || altura.length()==0) && sel==2){
            //resultado.setText("Campos Vacios");
            Toast.makeText(this,"Campo de base o altura Vacio"
                    , Toast.LENGTH_SHORT).show();
        }else if(sel==2){
            int n1 = Integer.parseInt(base.getText().toString());
            int n2 = Integer.parseInt((altura.getText().toString()));
            resultado.setText("El area del Triangulo es: " + Double.toString((double)(n1*n2)/2 ));
        }
        if(radio.length()==0 && sel==3 ){
            //resultado.setText("Campos Vacios");
            Toast.makeText(this,"Campo de Radio Vacio"
                    , Toast.LENGTH_SHORT).show();
        }else if(sel==3) {

            int n1 = Integer.parseInt(radio.getText().toString());
            resultado.setText("El area del Triangulo es: " + Double.toString((double)(2*Math.PI*n1*n1 )));
        }

        if((lado.length()==0 || base.length()==0) && sel ==4){
            //resultado.setText("Campos Vacios");
            Toast.makeText(this,"Campo de lado Vacio"
                    , Toast.LENGTH_SHORT).show();
        }else if(sel==4){

            int n1 = Integer.parseInt(base.getText().toString());
            int n2 = Integer.parseInt(lado.getText().toString());
            resultado.setText("El area del Rectangulo es: " + Double.toString((double)(n1*n2 )));
        }

    }
}
