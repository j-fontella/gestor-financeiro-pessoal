package tech.futuretecnologia.gestorfinanceiro.operacoes.fragments


import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.futuretecnologia.gestorfinanceiro.R
import tech.futuretecnologia.gestorfinanceiro.operacoes.tasks.AddOperacaoTask
import tech.futuretecnologia.gestorfinanceiro.operacoes.viewmodels.CategoriaViewModel
import kotlinx.android.synthetic.main.fragment_adicionar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.futuretecnologia.gestorfinanceiro.api.CotacaoService
import tech.futuretecnologia.gestorfinanceiro.entidades.Cotacao
import tech.futuretecnologia.gestorfinanceiro.excecoes.InvalidOperacaoException

class AdicionarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adicionar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var categoriaViewModel: CategoriaViewModel
        activity?.let {
            categoriaViewModel = ViewModelProviders.of(it).get(CategoriaViewModel::class.java)

        }
        radioButton.isChecked = true
        edTxt_Cotacao.text = SpannableStringBuilder("1")
        radioButton.setOnClickListener {
            edTxt_Cotacao.text = SpannableStringBuilder("1")
        }
        radioButton2.setOnClickListener{
            getMoeda()
        }
        btn_Add.setOnClickListener {
            try{
                if(edTxt_Valor.text.isBlank() || edTxt_Descricao.text.isEmpty() || edTxt_Cotacao.text.isBlank()){
                    Toast.makeText(requireContext(),
                        "Todos campos devem ser preenchidos, utilize os botões para pegar as cotações atuais",
                        Toast.LENGTH_LONG).show()
                }else{
                    AddOperacaoTask(
                        requireContext(), edTxt_Descricao.text.toString(),
                        edTxt_Valor.text.toString().toDouble(),
                        categoriaViewModel.categoria!!.id,
                        edTxt_Cotacao.text.toString().replace(",", ".").toDouble()
                    ).execute()
                    findNavController().navigate(R.id.fragment_Exibir)
                }
            }
            catch (ex : InvalidOperacaoException){
                Toast.makeText(activity?.baseContext, ex.message, Toast.LENGTH_LONG).show()
            }
        }



    }

    fun getMoeda(){
        var retrofit =
            Retrofit.Builder().baseUrl("https://api.exchangeratesapi.io/").addConverterFactory(
                GsonConverterFactory.create()).build()
        retrofit.create(CotacaoService::class.java).converterMoeda().enqueue(object :
            Callback<Cotacao> {
            override fun onFailure(call: Call<Cotacao>, t: Throwable) {
                Toast.makeText(requireContext(), t.message,Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Cotacao>, response: Response<Cotacao>) {
                val dollar = response.body()!!.rates.get("BRL")
                val formated = String.format("%.2f", dollar)
                val editable = SpannableStringBuilder(formated)
                edTxt_Cotacao.text = editable
            }

        })
    }





}
