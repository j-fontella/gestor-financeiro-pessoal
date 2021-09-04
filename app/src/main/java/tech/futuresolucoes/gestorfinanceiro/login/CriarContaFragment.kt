package com.futuretecnologia.gestorfinanceiro.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController

import com.futuretecnologia.gestorfinanceiro.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_criar_conta.*


class CriarContaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_criar_conta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_Crie_Conta.setOnClickListener {
            if(edTxt_Usuario.text.toString().isBlank() || edTxt_Senha.text.toString().isBlank()){
                Toast.makeText(activity?.baseContext, "Preencha todos campos!", Toast.LENGTH_LONG).show()
            }
            else{
                try{
                    register().addOnSuccessListener {
                        if(it != null){
                            Toast.makeText(requireContext(), "Conta registrada com  sucesso.", Toast.LENGTH_LONG).show()
                        }
                        else{
                            Toast.makeText(requireContext(), "Erro.", Toast.LENGTH_LONG).show()

                        }
                    }.addOnFailureListener{
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }
                    findNavController().navigate(R.id.login_dest)
                }
                catch (ex : Throwable){
                    Toast.makeText(activity?.baseContext, ex.message, Toast.LENGTH_LONG).show()
                }

            }

            }
    }

    fun register() : Task<AuthResult> {
        return FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(
             edTxt_Usuario.text.toString(),  edTxt_Senha.text.toString())
    }
}
