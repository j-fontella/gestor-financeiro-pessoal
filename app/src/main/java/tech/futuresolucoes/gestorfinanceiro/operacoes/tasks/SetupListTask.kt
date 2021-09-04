package tech.futuretecnologia.gestorfinanceiro.operacoes.tasks

import android.content.Context
import android.os.AsyncTask
import tech.futuretecnologia.gestorfinanceiro.database.DbBuilder
import tech.futuretecnologia.gestorfinanceiro.entidades.Operacao
import tech.futuretecnologia.gestorfinanceiro.operacoes.fragments.ExibirFragment

class SetupListTask(val context: Context, val fragment : ExibirFragment, val id:Int) : AsyncTask<Void, Void, MutableList<Operacao>>() {

    override fun doInBackground(vararg params: Void?): MutableList<Operacao> {
        return DbBuilder.getInstance(context).operacaoDAO().selectOpsByUserId(id)
    }

    override fun onPostExecute(result: MutableList<Operacao>) {
        super.onPostExecute(result)
        fragment.setList(result)
    }
}