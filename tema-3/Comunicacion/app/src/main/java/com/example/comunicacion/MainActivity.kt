package com.example.comunicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.comunicacion.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

    }

    fun acciones(){
        binding.botonComprobar.setOnClickListener {
            Snackbar.make(binding.root, "El estado del Toggle es ${binding.toggle.isChecked}", Snackbar.LENGTH_SHORT)
                .show();
        }
        

        binding.toggle.setOnCheckedChangeListener {compoundButton, b ->
            Snackbar.make(binding.root, "El estado del Toggle es ${binding.toggle.isChecked}", Snackbar.LENGTH_SHORT)
                .show();

        }
    }
}