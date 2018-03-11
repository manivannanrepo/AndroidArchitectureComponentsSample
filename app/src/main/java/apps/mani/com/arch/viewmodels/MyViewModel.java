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
    public boolean isLoading;
    private LiveData<List<Fruits>> liveFruitsList;

    public MyViewModel(@NonNull Application application) {
        super(application);
        initDB();
        subscribeToGetFruits();
    }

    private void subscribeToGetFruits() {
        liveFruitsList = myDatabase.fruitsModel().getFruits();
    }

    public void initDB() {
        myDatabase = MyDatabase.getInMemoryDatabase(this.getApplication());
        DatabaseInitialiser.populateTestData(myDatabase);
    }

    public LiveData<List<Fruits>> getFruits(){
        isLoading = false;
        return liveFruitsList;
    }
}
