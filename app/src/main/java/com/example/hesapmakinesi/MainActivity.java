package com.example.hesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double ilkSayi = 0;
    String gorev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sayi0 = findViewById(R.id.sayi0);
        Button sayi1 = findViewById(R.id.sayi1);
        Button sayi2 = findViewById(R.id.sayi2);
        Button sayi3 = findViewById(R.id.sayi3);
        Button sayi4 = findViewById(R.id.sayi4);
        Button sayi5 = findViewById(R.id.sayi5);
        Button sayi6 = findViewById(R.id.sayi6);
        Button sayi7 = findViewById(R.id.sayi7);
        Button sayi8 = findViewById(R.id.sayi8);
        Button sayi9 = findViewById(R.id.sayi9);

        Button ac = findViewById(R.id.ac);
        Button kapat = findViewById(R.id.kapat);
        Button temizle = findViewById(R.id.temizle);
        Button sil = findViewById(R.id.sil);
        Button bol = findViewById(R.id.bol);
        Button carp = findViewById(R.id.carp);
        Button cikar = findViewById(R.id.cikar);
        Button topla = findViewById(R.id.topla);
        Button esittir = findViewById(R.id.esittir);
        Button nokta = findViewById(R.id.nokta);

        TextView ekran = findViewById(R.id.ekran);

        temizle.setOnClickListener(view -> {
            ilkSayi = 0;
            ekran.setText("0");
        });

        kapat.setOnClickListener(view -> ekran.setVisibility(view.GONE));
        ac.setOnClickListener(view -> {
            ekran.setVisibility(view.VISIBLE);
            ekran.setText("0");
        });

        ArrayList<Button> sayilar = new ArrayList<>();
        sayilar.add(sayi0);
        sayilar.add(sayi1);
        sayilar.add(sayi2);
        sayilar.add(sayi3);
        sayilar.add(sayi4);
        sayilar.add(sayi5);
        sayilar.add(sayi6);
        sayilar.add(sayi7);
        sayilar.add(sayi8);
        sayilar.add(sayi9);

        for(Button b : sayilar){
            b.setOnClickListener(view -> {
                if(!ekran.getText().toString().equals("0")){
                    ekran.setText(ekran.getText().toString() + b.getText().toString());
                }
                else{
                    ekran.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> operatörler = new ArrayList<>();
        operatörler.add(bol);
        operatörler.add(carp);
        operatörler.add(topla);
        operatörler.add(cikar);

        for (Button b : operatörler){
            b.setOnClickListener(view -> {
                ilkSayi = Double.parseDouble(ekran.getText().toString());
                gorev = b.getText().toString();
                ekran.setText("0");
            });
        }

        sil.setOnClickListener(view -> {
            String sayi = ekran.getText().toString();
            if(sayi.length() > 1){
                ekran.setText(sayi.substring(0,sayi.length()-1));
            }
            else if (sayi.length() == 1 && !sayi.equals("0")){
                ekran.setText("0");
            }
        });

        nokta.setOnClickListener(view -> {
            if(!ekran.getText().toString().contains(".")){
                ekran.setText(ekran.getText().toString() + ".");
            }
        });

        esittir.setOnClickListener(view -> {
            double ikinciSayi = Double.parseDouble(ekran.getText().toString());
            double sonuc;
            switch (gorev){
                case "/":
                    sonuc = ilkSayi / ikinciSayi;
                    break;
                case "X":
                    sonuc = ilkSayi * ikinciSayi;
                    break;
                case "+":
                    sonuc = ilkSayi + ikinciSayi;
                    break;
                case "-":
                    sonuc = ilkSayi - ikinciSayi;
                    break;
                default:
                    sonuc = ilkSayi + ikinciSayi;
            }
            ekran.setText(String.valueOf(sonuc));
            ilkSayi = sonuc;
        });

    }
}