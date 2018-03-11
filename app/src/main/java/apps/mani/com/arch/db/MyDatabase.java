package apps.mani.com.arch.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by GAMING RIG on 11-03-2018.
 */

@Database(entities = {Fruits.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    private static MyDatabase MYDB_INSTANCE;

    public abstract FruitsDao fruitsModel();

    public static MyDatabase getInMemoryDatabase(Context context) {
        if (MYDB_INSTANCE == null) {
            MYDB_INSTANCE = Room.inMemoryDatabaseBuilder(context, MyDatabase.class).allowMainThreadQueries().build();
        }
        return MYDB_INSTANCE;
    }

    public static void removeMyDb() {
        MYDB_INSTANCE = null;
    }
}
