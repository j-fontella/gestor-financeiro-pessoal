package com.futuretecnologia.gestorfinanceiro.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import tech.futuretecnologia.gestorfinanceiro.CategoriasActivity

import com.futuretecnologia.gestorfinanceiro.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MobileAds.initialize(requireContext(), getString(R.string.admob_app_id))
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

       btn_Entrar.setOnClickListener {
            login()
        }
    }

    fun login() {
        val firebaseAuth = FirebaseAuth.getInstance()
        val user = firebaseAuth.currentUser
        try{
            firebaseAuth.signInWithEmailAndPassword(edTxt_Usuario.text.toString(), edTxt_Senha.text.toString())
                .addOnSuccessListener {
                    if(it != null){
                        val intent = Intent(activity?.baseContext, CategoriasActivity::class.java)
                        intent.putExtra("usuario", edTxt_Usuario.text.toString())
                        startActivity(intent)

                        Toast.makeText(requireContext(), "Logado " + user!!.email, Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(requireContext(), "Deu null!", Toast.LENGTH_LONG).show()
                    }
                }.addOnFailureListener{
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()

                }
        }catch (ex:Exception){
            Toast.makeText(requireContext(), ex.message, Toast.LENGTH_LONG).show()

        }

    }

}
