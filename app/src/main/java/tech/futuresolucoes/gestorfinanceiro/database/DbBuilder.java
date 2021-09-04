package tech.futuretecnologia.gestorfinanceiro.database;

import android.content.Context;

import androidx.room.Room;

public class DbBuilder {
    private static AppDataBase db;
    private DbBuilder(){}

    public static AppDataBase getInstance(Context context){
        if (db == null){
            return Room.databaseBuilder(context, AppDataBase.class, "db.sql").build();
        }
        return db;
    }

}
