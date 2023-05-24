package com.example.practica_final

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica_final.adapter.AdaptadorProductos
import com.example.practica_final.databinding.FragmentProductosBinding
import com.example.practica_final.model.Producto

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentProductos.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentProductos : Fragment() {
    private lateinit var binding: FragmentProductosBinding


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

    }

}