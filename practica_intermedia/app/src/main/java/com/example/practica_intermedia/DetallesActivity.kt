package com.example.practica_intermedia

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.practica_intermedia.databinding.DetallesLayoutBinding


class DetallesActivity : AppCompatActivity() {
    private lateinit var binding: DetallesLayoutBinding
    private lateinit var nombreDiscoRecuperado: String
    private lateinit var nombreGrupoRecuperado: String
    private lateinit var nombreDiscograficaRecuperado: String
    private lateinit var imagenDiscoRecuperado: String
    private var anioRecuperado: Int = 0
    private lateinit var email_button: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetallesLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // recepciono datos
        imagenDiscoRecuperado = intent.extras?.getString("imagenDisco","https://blog.eduonix.com/wp-content/uploads/2015/02/404-Error.jpg") ?: "https://blog.eduonix.com/wp-content/uploads/2015/02/404-Error.jpg"
        nombreDiscoRecuperado = intent.extras?.getString("nombreDiscoRecuperado","DEFAULT") ?: "defecto"
        nombreGrupoRecuperado = intent.extras?.getString("nombreGrupoRecuperado","DEFAULT") ?: "defecto"
        nombreDiscograficaRecuperado = intent.extras?.getString("nombreDiscograficaRecuperado","DEFAULT") ?: "defecto"
        anioRecuperado = intent.extras?.getInt("anioRecuperado", 0) ?: 0

        binding.nombreDiscosDetalle.text = nombreDiscoRecuperado
        binding.nombreArtistaDetalle.text = nombreGrupoRecuperado
        binding.nombreDiscograficaDetalle.text = nombreDiscograficaRecuperado
        binding.anioDiscoDetalle.text = anioRecuperado.toString()
        Glide.with(this).load(imagenDiscoRecuperado)
            .into(binding.imagenDiscoDetalle)

        email_button = findViewById(R.id.email_button)
        email_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("direccion@ext.live.u-tad.es"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Quiero compartir este disco contigo")
            intent.putExtra(Intent.EXTRA_TEXT, "Disco: $nombreDiscoRecuperado\nGrupo: $nombreGrupoRecuperado")
            intent.type = "message/rfc822"
            startActivity(intent)
        }
    }
}