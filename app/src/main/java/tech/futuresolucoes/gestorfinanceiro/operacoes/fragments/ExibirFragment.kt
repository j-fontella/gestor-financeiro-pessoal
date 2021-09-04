package tech.futuretecnologia.gestorfinanceiro.operacoes.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.futuretecnologia.gestorfinanceiro.R
import tech.futuretecnologia.gestorfinanceiro.operacoes.adapters.OperacaoAdapter
import tech.futuretecnologia.gestorfinanceiro.operacoes.tasks.SetupListTask
import tech.futuretecnologia.gestorfinanceiro.operacoes.tasks.SetupViewModelTask
import tech.futuretecnologia.gestorfinanceiro.operacoes.viewmodels.CategoriaViewModel
import kotlinx.android.synthetic.main.fragment_exibir.*
import tech.futuretecnologia.gestorfinanceiro.entidades.Operacao

/**
 * A simple [Fragment] subclass.
 */
class ExibirFragment : Fragment() {
    private var lista_operacoes = mutableListOf<Operacao>()

    fun setList(list:MutableList<Operacao>){
        lista_operacoes = list
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exibir, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var categoriaViewModel: CategoriaViewModel
        activity?.let {
            categoriaViewModel = ViewModelProviders.of(it).get(CategoriaViewModel::class.java)
        }

        val categoria = activity?.intent!!.getStringExtra("nome")!!.toInt()
        categoriaViewModel.categoria = SetupViewModelTask(
            requireContext(),
            categoria
        ).execute().get()
        lista_operacoes = SetupListTask(
            requireContext(),
            this,
            categoriaViewModel.categoria!!.id
        ).execute().get()
        lista_operacoes.forEach {
            categoriaViewModel.categoria!!.operacoes.adicionarOperacao(it.valor, it.descricao, it.id, it.cotacao)
        }
        var gastoAdapter =
            OperacaoAdapter(
                categoriaViewModel.categoria!!.operacoes.operacoes
            )
        rcVw_Exibir.adapter = gastoAdapter
        rcVw_Exibir.layoutManager = LinearLayoutManager(activity?.baseContext)
        txtVwTotal.text = "Total mensal R$" + categoriaViewModel.categoria!!.operacoes.total



    }


}
