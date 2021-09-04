package tech.futuretecnologia.gestorfinanceiro.operacoes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.futuretecnologia.gestorfinanceiro.R
import kotlinx.android.synthetic.main.operacao_recycler.view.*
import tech.futuretecnologia.gestorfinanceiro.entidades.Operacao

class OperacaoAdapter (val operacoes : MutableList<Operacao>?) : RecyclerView.Adapter<OperacaoAdapter.GastoViewHolder>(){

    class GastoViewHolder(view : View): RecyclerView.ViewHolder(view) {
        val titulo = view.txtVw_Titulo
        val texto = view.txtVw_Texto
        val cotacao = view.txtVw_cotacao
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GastoViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.operacao_recycler,parent,false)
        val usuarioViewHolder =
            GastoViewHolder(
                v
            )
        return usuarioViewHolder
    }

    override fun getItemCount(): Int = operacoes!!.size

    override fun onBindViewHolder(holder: GastoViewHolder, position: Int) {
        val operacao = operacoes!![position]
        holder.titulo.text = operacao.descricao
        if(operacao.cotacao == 1.0){
            holder.texto.text = "R$" + String.format("%.2f", operacao.valor)
        }else{
            holder.texto.text = "R$" + String.format("%.2f", (operacao.valor * operacao.cotacao))
            holder.cotacao.text = "Dollar - $" + String.format("%.2f", operacao.valor) + "(${operacao.cotacao})"
        }
    }

}