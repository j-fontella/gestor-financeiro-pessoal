package tech.futuretecnologia.gestorfinanceiro.categorias.viewmodels

import androidx.lifecycle.ViewModel
import tech.futuretecnologia.gestorfinanceiro.entidades.Categoria


class CategoriaViewModel : ViewModel() {
    var categoria : Categoria? = null
    var navegador = true
    var mes = 0



    fun incrementar_mes(){
        mes++
    }
    fun decrementar_mes(){
        mes--
    }
    fun getMesNome(mes_atual:Int) : String{
       var str = when(mes_atual){
            0 -> "Janeiro"
            1 -> "Fevereiro"
            2 -> "Março"
            3 -> "Abril"
            4 -> "Maio"
            5 -> "Junho"
            6 -> "Julho"
            7 -> "Agosto"
            8 -> "Setembro"
            9 -> "Outubro"
            10 -> "Novembro"
            11 -> "Dezembro"
            else -> "Error"
        }
        return str
    }



}