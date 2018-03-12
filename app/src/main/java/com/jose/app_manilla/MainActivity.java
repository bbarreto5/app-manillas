package com.jose.app_manilla;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup op1,op2;
    private EditText cantidad,precio;
    private Button cotizar;
    private Spinner spiner;
    private Switch sw1,sw2;
    double valor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        op1 = findViewById(R.id.rg1);
        op2 = findViewById(R.id.rg2);
        cantidad = findViewById(R.id.txtcantidad);
        precio = findViewById(R.id.txtprecio);
        cotizar = findViewById(R.id.button);
        spiner = findViewById(R.id.spinner);
        sw1 = findViewById(R.id.switch1);
        sw2 = findViewById(R.id.switch2);
    }
    public void mostrar(View v){
        pago();
        int n = Integer.parseInt(cantidad.getText().toString());
        valor*=n;
        tipo_moneda();
        precio.setText(valor+"");
        //Toast.makeText(MainActivity.this,"valor: "+(valor), Toast.LENGTH_SHORT).show();
    }

    public void pago() {
        if (op1.getCheckedRadioButtonId() == R.id.rb1) {
            tipo_dijen(1);
        }else{
            tipo_dijen(2);
        }
    }
    public void tipo_dijen(int n){
        switch (n) {
            case 1:
                if (op2.getCheckedRadioButtonId() == R.id.rb3) {
                    tipo_tipo();
                }else{
                    tipo_tipo2();
                }
                break;
            case 2:
                if (op2.getCheckedRadioButtonId() == R.id.rb3) {
                    tipo_tipo3();
                }else{
                    tipo_tipo4();
                }
                break;
        }
    }
    public void tipo_tipo(){
        int opcion = spiner.getSelectedItemPosition();
        switch (opcion) {
            case 0:
                valor=100;
                break;
            case 1:
                valor=80;
                break;
            case 2:
                valor=70;
                break;
        }
    }
    public void tipo_tipo2(){
        int opcion = spiner.getSelectedItemPosition();
        switch (opcion) {
            case 0:  valor=120;
                break;
            case 1: valor=100;
                break;
            case 2:  valor=90;
                break;
        }
    }
    public void tipo_tipo4(){
        int opcion = spiner.getSelectedItemPosition();
        switch (opcion) {
            case 0:  valor=110;
                break;
            case 1: valor=90;
                break;
            case 2:  valor=80;
                break;
        }
    }
    public void tipo_tipo3(){
        int opcion = spiner.getSelectedItemPosition();
        switch (opcion) {
            case 0:  valor=90;
                break;
            case 1: valor=70;
                break;
            case 2:  valor=50;
                break;
        }
    }
    public void tipo_moneda(){
        if(sw2.isChecked()==true){
            valor*=3200;
        }
    }
}
