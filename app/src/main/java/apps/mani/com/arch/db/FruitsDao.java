package apps.mani.com.arch.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by GAMING RIG on 11-03-2018.
 */
@Dao
public interface FruitsDao {

    @Query("select * from fruits")
    LiveData<List<Fruits>> getFruits();

    @Query("select * from fruits where id= :id")
    Fruits getFruitByID(int id);

    @Update(onConflict = REPLACE)
    void updateFruit(Fruits...fruits);

    @Insert(onConflict = IGNORE)
    void insertFruit(Fruits...fruits);

    @Query("delete from fruits where id = :id")
    int deleteFruitById(int id);
    @Query("delete from fruits")
    void deleteAll();
}
