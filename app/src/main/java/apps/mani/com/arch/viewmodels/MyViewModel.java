package apps.mani.com.arch.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import apps.mani.com.arch.db.DatabaseInitialiser;
import apps.mani.com.arch.db.Fruits;
import apps.mani.com.arch.db.MyDatabase;

/**
 * Created by GAMING RIG on 11-03-2018.
 */


public class MyViewModel extends AndroidViewModel {

    private MyDatabase myDatabase;

    private LiveData<List<Fruits>> liveFruitsList;

    public MyViewModel(@NonNull Application application) {
        super(application);

        initDB();

        subscribeToGetFruits();
    }

    private void subscribeToGetFruits() {
        liveFruitsList = myDatabase.fruitsModel().getFruits();
    }

    private void initDB() {
        myDatabase = MyDatabase.getInMemoryDatabase(this.getApplication());
        DatabaseInitialiser.populateTestDate(myDatabase);
    }

    public LiveData<List<Fruits>> getFruits(){
        return liveFruitsList;
    }
}
