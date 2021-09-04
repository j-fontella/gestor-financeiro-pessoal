package tech.futuretecnologia.gestorfinanceiro.categorias.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.futuretecnologia.gestorfinanceiro.R
import tech.futuretecnologia.gestorfinanceiro.categorias.tasks.AddCategoriaTask
import tech.futuretecnologia.gestorfinanceiro.categorias.viewmodels.CategoriaViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_add_categoria.*

/**
 * A simple [Fragment] subclass.
 */
class AddCategoriaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_categoria, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var categoriaViewModel: CategoriaViewModel
        activity?.let {
            categoriaViewModel = ViewModelProviders.of(it).get(CategoriaViewModel::class.java)
        }
        var mes_nav = categoriaViewModel.mes
        if (categoriaViewModel.navegador == true){
            btn_gg.text = "Ganhos ${categoriaViewModel.getMesNome(mes_nav)}"
        }else{
            btn_gg.text = "Gastos ${categoriaViewModel.getMesNome(mes_nav)}"
        }
        if(mes_nav == 0){
            btn_mAnterior.text = categoriaViewModel.getMesNome(mes_nav)
            btn_mProximo.text = categoriaViewModel.getMesNome(mes_nav+1)
        }
        else if(mes_nav == 11){
            btn_mAnterior.text = categoriaViewModel.getMesNome(mes_nav-1)
            btn_mProximo.text = categoriaViewModel.getMesNome(mes_nav)
        }
        else{
            btn_mAnterior.text = categoriaViewModel.getMesNome(mes_nav-1)
            btn_mProximo.text = categoriaViewModel.getMesNome(mes_nav+1)
        }


        var navegador = categoriaViewModel.navegador
        if (categoriaViewModel.navegador == true){
            btn_gg.text = "Ganhos ${categoriaViewModel.getMesNome(mes_nav)}"
        }else{
            btn_gg.text = "Gastos ${categoriaViewModel.getMesNome(mes_nav)}"
        }
        btn_gg.setOnClickListener {
            if (categoriaViewModel.navegador == true){
                categoriaViewModel.navegador = false
                findNavController().navigate(R.id.addCategoriaFragment)

            }else{
                categoriaViewModel.navegador = true
                findNavController().navigate(R.id.addCategoriaFragment)
            }
        }

        btn_AddCategoria.setOnClickListener {
            val user = FirebaseAuth.getInstance().currentUser!!.email!!
            AddCategoriaTask(
                requireContext(),
                edTxt_categoria.text.toString(),
                categoriaViewModel.navegador,
                mes_nav,
                user
            ).execute()
            findNavController().navigate(R.id.addCategoriaFragment)
        }

        btn_mProximo.setOnClickListener {
            if (mes_nav == 11){
                Toast.makeText(activity?.baseContext, "Não há mês posterior a dezembro", Toast.LENGTH_SHORT).show()
            }
            else{
                categoriaViewModel.incrementar_mes()
                findNavController().navigate(R.id.addCategoriaFragment)
            }


        }
        btn_mAnterior.setOnClickListener {
            if (mes_nav == 0){
                Toast.makeText(activity?.baseContext, "Não há mês anterior a janeiro", Toast.LENGTH_SHORT).show()
            }
            else{
                categoriaViewModel.decrementar_mes()
                findNavController().navigate(R.id.addCategoriaFragment)
            }

        }
    }


}



