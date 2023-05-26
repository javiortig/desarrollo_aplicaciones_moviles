package com.example.practica_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.practica_final.databinding.ActivitySecondBinding
import com.example.practica_final.model.Producto
import com.google.android.material.snackbar.Snackbar


class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    public var productos: ArrayList<Producto> = ArrayList()
    public var productosCarrito: ArrayList<Producto> = ArrayList()

    public fun anadirProductoCarrito(index: Int){
        productosCarrito.add(productos[index])
        var carritoFragment = supportFragmentManager.findFragmentByTag("YourFragmentTag") as FragmentCarrito?
        if (carritoFragment != null && carritoFragment.isAdded && carritoFragment.isResumed) {
            carritoFragment.modificarPrecioTotal(productos[index].precio)
        }

    }

    fun crearSnackBar(string: String){
        Snackbar.make(binding.root,string, Snackbar.LENGTH_SHORT).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace<FragmentProductos>(R.id.contenedorFrame)
            setReorderingAllowed(true)
            addToBackStack("Productos")
        }
    }

    fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedorFrame, fragment)
            .addToBackStack(tag)
            .commit()
    }
}