package com.example.practica_final

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.practica_final.databinding.FragmentLoginBinding
import com.example.practica_final.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


class FragmentRegister : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonRegistrarse.setOnClickListener {
            println(binding.emailRegisterText.text.toString())
            println(binding.passwordRegisterText.text.toString())
            auth.createUserWithEmailAndPassword(binding.emailRegisterText.text.toString(),
                binding.passwordRegisterText.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        Snackbar.make(binding.root,"Registro correcto", Snackbar.LENGTH_SHORT).show()
                    } else {
                        Snackbar.make(binding.root,"Algo ha fallado", Snackbar.LENGTH_SHORT).show()
                    }
                }
        }

        // registro ok -> no esta el usuario creado,la pass es correcta, la conexion es correcta
        // registro fallo -> si ya hay un usuario, si la pass es mala, si el correo no esta bien formateado

        binding.botonVolverLogin.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onResume() {
        super.onResume()

    }

}