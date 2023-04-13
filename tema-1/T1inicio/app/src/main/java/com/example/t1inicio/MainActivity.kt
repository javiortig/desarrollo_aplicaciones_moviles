package com.example.t1inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var botonPulsar: Button;
    private lateinit var textoSaludo: Text;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonPulsar = this.findViewById(R.id.boton_saludo);
        textoSaludo = this.findViewById(R.id.texto_saludo);
    }
}