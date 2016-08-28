package com.faberospina.formulario;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import  android.support.v4.app.DialogFragment;
import  android.app.DatePickerDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {


    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    private Spinner spinner;
    private ArrayAdapter<CharSequence> adapter;
    private String login,pass,correo,info,sex=" ",city=" ",hobbies;
    private EditText eLogin,ePass1,ePass2,eCorreo;
    private TextView show;
    private  int ok=0;
    ;// 0 men or 1 women
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eLogin = (EditText) findViewById(R.id.eLogin);
        ePass1 = (EditText) findViewById(R.id.ePass1);
        ePass2 = (EditText) findViewById(R.id.ePass2);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        show = (TextView) findViewById(R.id.Tinfo);
        //show.setText();

        dateView = (TextView) findViewById(R.id.tFecha);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
        hobbies="Hobbies\n";
        spinner = (Spinner) findViewById(R.id.spinner_citys);
        //spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
// Create an ArrayAdapter using the string array and a default spinner layout
        adapter = ArrayAdapter.createFromResource(this,
                R.array.citys_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ok++;
                switch (i){

                    case  0://medellin
                        //Toast.makeText(getApplicationContext(),"Medellin",Toast.LENGTH_SHORT).show();
                        city= "Medellin";
                        break;

                    case 1://Bogota
                        Toast.makeText(getApplicationContext(),"Bogota",Toast.LENGTH_SHORT).show();
                        city = "Bogota";
                        break;

                    case 2://Cartagena
                        Toast.makeText(getApplicationContext(),"Cartagena",Toast.LENGTH_SHORT).show();
                        city = "Cartagena";
                        break;

                    case 3://Barranquilla
                        Toast.makeText(getApplicationContext(),"Barranquilla",Toast.LENGTH_SHORT).show();
                        city = "Barranquilla";
                        break;

                    case  4://Otras
                        Toast.makeText(getApplicationContext(),"Otra",Toast.LENGTH_SHORT).show();
                        city= "Otra";
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                    city = " ";

            }
        });
    }

    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "Defina la Fecha de nacimiento", Toast.LENGTH_SHORT)
                .show();
    }

    protected Dialog onCreateDialog(int id) {//id del dialogo

        if (id == 999) {//pregunto si el id es igual al dialogo del suceso
            ok++;
            return new DatePickerDialog(this, myDateListener, year, month, day);

        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {

            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        ok++;
        switch(view.getId()) {
            case R.id.checkbox_comer:
                if (checked){
                    Toast.makeText(getApplicationContext(), "Comer", Toast.LENGTH_SHORT)
                            .show();
                    hobbies+="Comer\n";
                }else{
                    hobbies.replace("Comer"," ");
                }

                break;
            case R.id.checkbox_deporte:
                if (checked){
                    Toast.makeText(getApplicationContext(), "deportes", Toast.LENGTH_SHORT)
                            .show();
                    hobbies+="Deportes\n";
                }else{
                    hobbies.replace("Deportes"," ");
                }

                break;

            case R.id.checkbox_cine:
                if (checked){
                    Toast.makeText(getApplicationContext(), "Cine", Toast.LENGTH_SHORT)
                            .show();
                    hobbies+="Cine\n";
                }else{
                    hobbies.replace("Cine"," ");
                }
                    break;

            case R.id.checkbox_leer:
                if (checked){
                    Toast.makeText(getApplicationContext(), "Leer", Toast.LENGTH_SHORT)
                            .show();
                    hobbies+="Leer\n";
                }else{
                    hobbies.replace("Leer"," ");
                }
                break;

        }
    }

    public void BtnClick(View view)
    {

         Toast.makeText(getApplicationContext(), "Aceptar", Toast.LENGTH_SHORT)
                .show();
        info="Informacion: \n";
        if(eLogin.length()==0){
            Toast.makeText(getApplicationContext(), "Ingrese Login", Toast.LENGTH_SHORT)
                    .show();

            info+="Ingrese login\n";
            show.setText(info);

        }else{
            login=eLogin.getText().toString();
            ok++;
        }
        if(ePass1.length()==0){
            Toast.makeText(getApplicationContext(), "Ingrese Password", Toast.LENGTH_SHORT)
                    .show();
            //info="Informacion: ";
            info+="Ingrese password\n";
            show.setText(info);

        }else{
            pass=ePass1.getText().toString();
            ok++;
        }
        if(ePass2.length()==0){
            Toast.makeText(getApplicationContext(), "Ingrese Password", Toast.LENGTH_SHORT)
                    .show();
            //info="Informacion: ";
            info+="Ingrese password\n";
            show.setText(info);


        }else{
            if(pass.equals(ePass2.getText().toString()) ){
                Toast.makeText(getApplicationContext(), "Password correct", Toast.LENGTH_SHORT)
                        .show();

            }else{
                Toast.makeText(getApplicationContext(), "Password Incorrect", Toast.LENGTH_SHORT)
                        .show();
            }
        }

        if (eCorreo.length()==0){
            Toast.makeText(getApplicationContext(), "Ingrese Correo", Toast.LENGTH_SHORT)
                    .show();

            info+="Ingrese correo\n";
            show.setText(info);

        }else{
            correo=eCorreo.getText().toString();
        }

       if (sex.length()<=2){
            Toast.makeText(getApplicationContext(), "Escoja el Sexo", Toast.LENGTH_SHORT)
                    .show();

            info+="Escoja el Sexo\n";
            show.setText(info);
        }

        if (city.length()==0){
            Toast.makeText(getApplicationContext(), "Escoja la ciudad", Toast.LENGTH_SHORT)
                    .show();

            info+="Escoja la ciudad\n";
            show.setText(info);
        }

        if(hobbies.length()>=9){
//            Toast.makeText(getApplicationContext(), "si cumple", Toast.LENGTH_SHORT)
//                    .show();
//            info+=Integer.toString(city.length());
//            show.setText(info);
        }else{
            Toast.makeText(getApplicationContext(), "Escoja un Hobbie", Toast.LENGTH_SHORT)
                    .show();
            info+="Escoja un hobbie\n";
            show.setText(info);
        }

        if(ok>=6){
            show.setText("Informacion:\n"+login+"\n"+pass+"\n"+correo+"\n"+
            sex+"\n"+new StringBuilder().append(day).append("/")
                            .append(month).append("/").append(year)+"\n"+city+"\n"+hobbies
            );
        }


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        ok++;
        switch (view.getId()) {
            case R.id.RFemenino:
                if (checked){
                    sex="Femenino";
                }
                break;
            case R.id.RMasculino:
                if (checked){
                    sex="Masculino";
                }
                break;
        }
    }





}
