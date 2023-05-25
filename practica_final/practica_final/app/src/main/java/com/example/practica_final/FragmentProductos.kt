package com.example.practica_final

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica_final.adapter.AdaptadorProductos
import com.example.practica_final.databinding.FragmentProductosBinding
import com.example.practica_final.model.Producto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class FragmentProductos : Fragment() {
    private lateinit var binding: FragmentProductosBinding
    private lateinit var productos: ArrayList<Producto>
    private lateinit var adaptadorProductos: AdaptadorProductos

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getProducts()
        /*
        productos.add(Producto("Ifon", 999f, "https://i.dummyjson.com/data/products/1/1.jpg"))
        productos.add(Producto("Samsum", 544f, "https://i.dummyjson.com/data/products/1/1.jpg"))
        productos.add(Producto("Pixel", 345f, "https://i.dummyjson.com/data/products/1/1.jpg"))
        */

        println("Productos array:")
        for (p in productos){
            println(p.nombre)
        }
        adaptadorProductos = AdaptadorProductos(productos, context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        //binding.recyclerLenguajes.adapter = adaptadorLenguajes
        binding.recyclerProductos.adapter = adaptadorProductos
        binding.recyclerProductos.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
    }

    fun getProducts(){
        productos = ArrayList()

        GlobalScope.launch(Dispatchers.Default) {
            val url = URL("https://dummyjson.com/products")
            val connection = url.openConnection()
            connection.connect()

            val inputStream = connection.getInputStream()
            val reader = BufferedReader(InputStreamReader(inputStream))

            val jsonString = reader.use(BufferedReader::readText)
            val jsonObject = JSONObject(jsonString)

            val jsonArray = jsonObject.getJSONArray("products")

            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val title = jsonObject["title"] as String
                val price = jsonObject["price"] as Int
                val image = jsonObject["thumbnail"] as String
                val description = jsonObject["description"] as String
                println(price)
                productos.add(Producto(title, price, image, description))
            }
        }


    }

}