package org.iesch.a05_dashboard_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.iesch.a05_dashboard_menu.adaptadores.AdaptadorDiscos;
import org.iesch.a05_dashboard_menu.models.Disco;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity {

    private ListView lvDiscos;
    private AdaptadorDiscos adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);


        lvDiscos = findViewById(R.id.lvLista);
        adaptador = new AdaptadorDiscos(obtenerListaDiscos(), this);

        lvDiscos.setAdapter(adaptador);
    }

    private ArrayList<Disco> obtenerListaDiscos(){
        ArrayList<Disco> listaDiscos = new ArrayList<>();

        listaDiscos.add(new Disco(R.drawable.salsa_tequila,"Salsa tequila","Anders Nilsen", "2014"));
        listaDiscos.add(new Disco(R.drawable.la_gran_obra_maestra,"La gran obra maestra","Frank T", "1998"));
        listaDiscos.add(new Disco(R.drawable.zenitown,"Zenitown","Zenit", "2006"));
        listaDiscos.add(new Disco(R.drawable.phonky_tribu,"Phonky Tribu","Funk Tribu", "2022"));
        listaDiscos.add(new Disco(R.drawable.idgafos,"I.D.G.A.F.O.S","Dillon Francis", "2011"));
        listaDiscos.add(new Disco(R.drawable.ez4ence,"EZ4ENCE","The Verkkars", "2019"));
        listaDiscos.add(new Disco(R.drawable.malbec,"Malbec","Duki", "2020"));
        listaDiscos.add(new Disco(R.drawable.all_star,"All Star","Smash Mouth", "1999"));
        listaDiscos.add(new Disco(R.drawable.life_is_life,"Life is Life","Opus", "1984"));
        listaDiscos.add(new Disco(R.drawable.alone,"Alone","Marshmello", "2016"));

        return listaDiscos;
    }
}