package tech.futuretecnologia.gestorfinanceiro.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import tech.futuretecnologia.gestorfinanceiro.database.daos.CategoriaDAO;
import tech.futuretecnologia.gestorfinanceiro.database.daos.OperacaoDAO;
import tech.futuretecnologia.gestorfinanceiro.entidades.Categoria;
import tech.futuretecnologia.gestorfinanceiro.entidades.Operacao;


@Database(entities = {Operacao.class, Categoria.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {


    public abstract OperacaoDAO operacaoDAO();

    public abstract CategoriaDAO categoriaDAO();

}
