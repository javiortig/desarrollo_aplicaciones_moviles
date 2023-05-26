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
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class FragmentProductos : Fragment() {
    private lateinit var secondActivity: SecondActivity
    private lateinit var binding: FragmentProductosBinding
    private lateinit var adaptadorProductos: AdaptadorProductos


    override fun onAttach(context: Context) {
        super.onAttach(context)
        secondActivity = requireActivity() as SecondActivity

        adaptadorProductos = AdaptadorProductos(secondActivity.productos, context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductosBinding.inflate(inflater,container,false)

        binding.recyclerProductos.adapter = adaptadorProductos
        binding.recyclerProductos.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getProducts()

        binding.botonIrCarrito.setOnClickListener {
            val fragmentCarrito = FragmentCarrito()
            val secondActivity = context as SecondActivity

            secondActivity.changeFragment(fragmentCarrito, "FragmentCarrito")
        }
    }

    fun getProducts(){

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

                secondActivity.productos.add(Producto(title, price, image, description))
            }

            // Cuando la corutina termine y haya cargado los productos, los muestra
            withContext(Dispatchers.Main) {
                // Notify the adapter that the data set has changed
                adaptadorProductos.notifyDataSetChanged()

                // Finally, display the RecyclerView
                binding.recyclerProductos.visibility = View.VISIBLE
            }
        }

    }

}