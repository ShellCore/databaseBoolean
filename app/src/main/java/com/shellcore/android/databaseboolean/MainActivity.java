package com.shellcore.android.databaseboolean;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.shellcore.android.databaseboolean.database.DBBoolBase;
import com.shellcore.android.databaseboolean.models.BoolBase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_ITERACIONES = 10000;
    // Variables
    List<BoolBase> lista;

    // Servicios
    DBBoolBase dbBoolBase;

    // Componentes
    private TextInputLayout tilIteracion;
    private TextInputLayout tilBase;
    private TextInputLayout tilIncidencias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getServices();
        inicializeElements();
        setUpDatabase();
        obtainIncidences();
    }

    private void getServices() {
        dbBoolBase = new DBBoolBase(getApplicationContext());
    }

    private void inicializeElements() {
        tilIteracion = (TextInputLayout) findViewById(R.id.til_iteracion);
        tilBase = (TextInputLayout) findViewById(R.id.til_iteracion_base);
        tilIncidencias = (TextInputLayout) findViewById(R.id.til_incidences);
    }

    private void setUpDatabase() {
        lista = new ArrayList<>();
        ProgressBar progressBar = new ProgressBar(getApplicationContext());
        progressBar.setMax(NUM_ITERACIONES);
        for (int i = 0; i < 10000; i++) {
            BoolBase boolBase = new BoolBase();
            boolBase.setValue(true);
            lista.add(boolBase);
            progressBar.setProgress(i);

            if (tilIteracion.getEditText() != null) {
                tilIteracion.getEditText().setText("" + i);
            }
        }

        for (BoolBase bb : lista) {
            dbBoolBase.create(bb);
        }

        lista = null;
    }

    private void obtainIncidences() {
        int incidences = 0;
        lista = dbBoolBase.getAll();
        int iter = 0;
        for (BoolBase bb : lista) {
            iter++;
            if (tilBase.getEditText() != null) {
                tilBase.getEditText().setText("" + iter);
            }
            if (!bb.isValue()) {
                incidences++;
            }
        }
        if (tilIncidencias.getEditText() != null) {
            tilIncidencias.getEditText().setText("" + incidences);
        }
    }
}
