package com.android.tareas3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        inicializarListaMascotas();

        rvMascotas = findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        inicializaAdaptatador();

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Subir una foto", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Catty",125,R.drawable.perro1));
        mascotas.add(new Mascota("Ronny",136,R.drawable.perro2));
        mascotas.add(new Mascota("Ducke",147,R.drawable.perro6));
        mascotas.add(new Mascota("Simon",158,R.drawable.perro4));
        mascotas.add(new Mascota("Tobby",225,R.drawable.perro5));
        mascotas.add(new Mascota("Luna",234,R.drawable.perro7));
        mascotas.add(new Mascota("Sol",287,R.drawable.perro8));
        mascotas.add(new Mascota("Lucy",293,R.drawable.perro9));
        mascotas.add(new Mascota("Oso",297,R.drawable.perro3));
    }

    public void inicializaAdaptatador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        rvMascotas.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mFavoritos:
                Intent intent = new Intent(MainActivity.this, MascotaFavorita.class);
                startActivity(intent);
                break;
            case R.id.mAcerca:
                Toast.makeText(getApplicationContext(),"©Pablo Sayanes",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}