package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

//import android.annotation.SuppressLint;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    EditText TxtNumero;
    TextView TxtCantidad,ly;
    Button Limpiar, BtnBlanco, BtnNegro, Color1,Color2,Color3;
    //LinearLayout ly;
    private Window window;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Limpiar= (Button) findViewById(R.id.Limpiar);
        TxtNumero= (EditText) findViewById(R.id.TxtNumero);
        TxtCantidad = (TextView) findViewById(R.id.TxtCantidad);

        BtnBlanco= (Button) findViewById(R.id.BtnBlanco);
        Color1= (Button)findViewById(R.id.BtnColor1);
        Color2= (Button)findViewById(R.id.BtnColor2);
        Color3= (Button)findViewById(R.id.BtnColor3);
        BtnNegro= (Button)findViewById(R.id.BtnNegro);

        this.window= getWindow();
        //ly=(TextView) findViewById(R.id.Ly1);

        /*ly.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float initialX = 0;
                float initialY;
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        initialX= motionEvent.getX();
                        initialY= motionEvent.getY();
                        ly.setText("Mueve a la derecha");
                        break;
                    case MotionEvent.ACTION_UP:
                        float finalX=motionEvent.getX();
                        float finalY= motionEvent.getY();
                        if(initialX<finalX && finalX<200||initialX<finalX && initialX<200){
                            TxtCantidad.setText(" ");
                            TxtNumero.setText(" ");
                        }
                        break;
                }
                return false;
            }
        });*/
        Limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TxtCantidad.setText("");
                TxtNumero.setText("");
            }
        });

        BtnBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String background= "#FFFFFFFF";
                Cambiar(background);
            }
        });

        Color1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String background= "#68686D";
                Cambiar(background);
            }
        });

        Color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String background= "#545457";
                Cambiar(background);
            }
        });
        Color3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String background= "#414142";
                Cambiar(background);
            }
        });
        BtnNegro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String background= "#2F2F30";
                Cambiar(background);
            }
        });


        TxtNumero.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keycode, KeyEvent event) {
                if(event.getAction()== MotionEvent.ACTION_DOWN){
                    if(keycode==KeyEvent.KEYCODE_VOLUME_UP){
                        double Cantidad= Double.parseDouble(TxtNumero.getText().toString());

                        int NumeroEntero=(int)Cantidad;
                        double ParteResiduo= Cantidad - NumeroEntero;
                        int b100 = NumeroEntero / 100;
                        NumeroEntero = NumeroEntero % 100;
                        int b50 = NumeroEntero / 50;
                        NumeroEntero = NumeroEntero % 50;
                        int b20 = NumeroEntero / 20;
                        NumeroEntero = NumeroEntero % 20;
                        /*int m10 = NumeroEntero / 10;
                        NumeroEntero = NumeroEntero % 10;
                        int m5 = NumeroEntero / 5;
                        NumeroEntero = NumeroEntero % 5;
                        int m1 = NumeroEntero;*/

                        int parteDecimal = (int)(ParteResiduo*1000);
                        int m010 = parteDecimal / 10;
                        parteDecimal = parteDecimal % 100;
                        int m005 = parteDecimal / 5;
                        parteDecimal = parteDecimal % 50;
                        int m001 = parteDecimal / 1;
                        TxtCantidad.setText(("Billetes de 100:\t\t\t\t\t" + String.valueOf(b100) +
                                "\n Billetes de 50:\t\t\t\t\t" + String.valueOf(b50) +
                                "\n Billetes de 20:\t\t\t\t\t\t\t" + String.valueOf(b20) +
                                "\n monedas de 10:\t\t\t\t\t\t\t" + String.valueOf(m010) +
                                "\n Moneda de 5:\t\t\t\t\t" + String.valueOf(m005)));
                    }
                }
                return true;
            }
        });


    }
    private void Cambiar(String background){
        //window.setStatusBarColor(Color.parseColor(PrimaryDark));
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(primary)));
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor(background)));
        //window.setNavigationBarColor(Color.parseColor(primary));
    }
}