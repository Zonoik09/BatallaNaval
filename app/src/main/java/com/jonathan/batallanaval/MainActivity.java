package com.jonathan.batallanaval;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TableLayout table = findViewById(R.id.table);
        String[] letras = {"", "A", "B", "C", "D", "E","F","G","H","I","J"};

        // Crear 6 filas
        for (int fila = 0; fila < 10; fila++) {
            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams params = new TableRow.LayoutParams(110, 110);

            // Crear columnas
            for (int columna = 0; columna < 10; columna++) {
                // Si es la primera fila insertar letras
                if (fila == 0) {
                    TextView button = new TextView(this);
                    button.setTextSize(12);
                    button.setGravity(Gravity.CENTER);
                    button.setPadding(16,16,16,16);
                    button.setText(letras[columna]);
                    tableRow.addView(button);

                }
                // Insertar números en la primera columna
                else if (columna == 0) {
                    TextView button = new TextView(this);
                    button.setTextSize(12);
                    button.setPadding(15,15,15,15);
                    button.setText(String.valueOf(fila));
                    tableRow.addView(button);
                }
                // Insertar botones en el resto de las celdas
                else {
                    Button button = new Button(this);
                    button.setLayoutParams(params);
                    button.setTextSize(12);
                    button.setPadding(12, 12, 12, 12);
                    button.setText("?");
                    tableRow.addView(button);
                    // Asignar el OnClickListener
                    final int filaActual = fila;
                    final int columnaActual = columna;
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String coordenada = letras[columnaActual] + filaActual;
                            Log.d("Coordenada", "Has pulsado el botón en: " + coordenada);
                        }
                    });
                }
            }

            table.addView(tableRow);
        }
    }
}
