package tech.futuretecnologia.gestorfinanceiro.operacoes.tasks

import android.content.Context
import android.os.AsyncTask
import tech.futuretecnologia.gestorfinanceiro.database.DbBuilder
import tech.futuretecnologia.gestorfinanceiro.entidades.Categoria

class SetupViewModelTask(val context : Context, val id : Int) : AsyncTask<Void, Void, Categoria>(){

    override fun doInBackground(vararg params: Void?): Categoria {
        val db = DbBuilder.getInstance(context)
        return db.categoriaDAO().selectId(id)
    }



}