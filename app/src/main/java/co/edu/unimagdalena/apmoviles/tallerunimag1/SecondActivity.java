package co.edu.unimagdalena.apmoviles.tallerunimag1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    EditText n1, n2;
    Button sumar, restar, multiplicacion, division, mcm, mcd, mayor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        n1 = findViewById(R.id.edtn1);
        n2 = findViewById(R.id.edtn2);
        sumar = findViewById(R.id.btnsumar);
        restar = findViewById(R.id.btnrestar);
        multiplicacion = findViewById(R.id.btnmultiplicacion);
        division = findViewById(R.id.btndivision);
        mcm = findViewById(R.id.btnmcm);
        mcd = findViewById(R.id.btnmcd);
        mayor = findViewById(R.id.btnmayor);
        sumar.setOnClickListener(this);
        restar.setOnClickListener(this);
        multiplicacion.setOnClickListener(this);
        division.setOnClickListener(this);
        mcd.setOnClickListener(this);
        mcm.setOnClickListener(this);
        mayor.setOnClickListener(this);
    }

    private int themcd(int a, int b){
        int mcd = a;
        int aux = b;
        int r;
        do{
            r = mcd % aux;
            mcd = aux;
            aux = r;
        }while (r != 0);
        return mcd;
    }

    private float themayor(float a, float b){
        if( a > b ){
            return a;
        }
        else{
            return b;
        }
    }

    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(n1.getText().toString()) ||
                TextUtils.isEmpty(n2.getText().toString())){
            Toast.makeText(getApplicationContext(), "Datos inválidos", Toast.LENGTH_LONG).show();
        }
        else {
            float num1 = Integer.parseInt(n1.getText().toString());
            float num2 = Integer.parseInt(n2.getText().toString());
            switch (v.getId()) {
                case R.id.btnsumar:
                    Toast.makeText(this, "Suma = " + (num1 + num2), Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnrestar:
                    Toast.makeText(this, "Resta = " + (num1 - num2), Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnmultiplicacion:
                    Toast.makeText(this, "Multiplicación = " + (num1 * num2), Toast.LENGTH_LONG).show();
                    break;
                case R.id.btndivision:
                    if(num2 == 0){
                        Toast.makeText(getApplicationContext(), "No se puede dividir entre cero", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(this, "División = " + (num1 / num2), Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.btnmcd:
                    if(num1 != 0 && num2 != 0) {
                        Toast.makeText(this, "MCD = " + (themcd((int) num1, (int) num2)), Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "no puedes ingresar cero", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.btnmcm:
                    if(num1 != 0 && num2 != 0) {
                        Toast.makeText(this, "MCM = " + ((int) num1 * (int) num2 / themcd((int) num1, (int) num2)), Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "no puedes ingresar cero", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.btnmayor:
                    if(num1 == num2){
                        Toast.makeText(getApplicationContext(), "Son iguales", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(this, "Mayor = " + (themayor(num1, num2)), Toast.LENGTH_LONG).show();
                    }
                    break;
            }
        }
    }
}