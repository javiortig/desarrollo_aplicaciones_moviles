package com.example.practica_final

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.practica_final.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


class FragmentLogin : Fragment() {
    private lateinit var binding: FragmentLoginBinding
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
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = requireContext()
        //auth.signOut()
        binding.botonSigUp.setOnClickListener {
            /*auth.createUserWithEmailAndPassword(binding.editUsername.text.toString(),
                binding.editPassword.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        Snackbar.make(binding.root,"Registro correcto", Snackbar.LENGTH_SHORT).show()
                    } else {
                        Snackbar.make(binding.root,"Algo ha fallado", Snackbar.LENGTH_SHORT).show()
                    }
                }   */
            // registro ok -> no esta el usuario creado,la pass es correcta, la conexion es correcta
            // registro fallo -> si ya hay un usuario, si la pass es mala, si el correo no esta bien formateado
        }
        binding.botonLogin.setOnClickListener {
            auth.signInWithEmailAndPassword(binding.editUsername.text.toString(),
                binding.editPassword.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        val bundle = Bundle()
                        bundle.putString("uid",auth.uid!!)

                        val intent = Intent(context, SecondActivity::class.java)

                        intent.putExtras(bundle)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

                        ContextCompat.startActivity(context, intent, bundle)
                    } else {
                        Snackbar.make(binding.root,"Datos incorrectos", Snackbar.LENGTH_SHORT).show()
                    }
                }
        }
    }

    override fun onResume() {
        super.onResume()

    }

}