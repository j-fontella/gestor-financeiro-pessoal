package tech.futuretecnologia.gestorfinanceiro.categorias.tasks

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import tech.futuretecnologia.gestorfinanceiro.database.DbBuilder
import tech.futuretecnologia.gestorfinanceiro.entidades.Categoria
import java.lang.Exception

class AddCategoriaTask(val context: Context, val name : String, val status:Boolean,val mes : Int, val userOwnerId : String) : AsyncTask<Void, Void, String>(){


    override fun doInBackground(vararg params: Void?): String {
        try{
            val db = DbBuilder.getInstance(context)
            db.categoriaDAO().armazenar(
                Categoria(
                    name,
                    status,
                    mes,
                    userOwnerId
                )
            )
        }catch (ex: Exception){
            Toast.makeText(context, ex.message, Toast.LENGTH_LONG).show()
        }
        return "Categoria $name adicionada"
    }

    override fun onPostExecute(result: String?) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show()
    }

}