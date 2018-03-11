package apps.mani.com.arch.db;

/**
 * Created by GAMING RIG on 11-03-2018.
 */

public class DatabaseInitialiser {

    public static void populateTestData(MyDatabase myDatabase){

        Fruits fruits1 = new Fruits(1,"Apple",5.45);
        Fruits fruits2 = new Fruits(2,"Banana",4.98);
        Fruits fruits3 = new Fruits(3,"Carrot",4.45);
        Fruits fruits4 = new Fruits(4,"Donut",3.45);
        Fruits fruits5 = new Fruits(5,"Eclairs",0.45);

        if (myDatabase != null)
            myDatabase.fruitsModel().insertFruit(fruits1,fruits2,fruits3,fruits4,fruits5);
    }
}
