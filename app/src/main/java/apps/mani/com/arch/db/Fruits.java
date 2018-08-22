package apps.mani.com.arch.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;

/**
 * Created by GAMING RIG on 11-03-2018.
 */
@Entity
public class Fruits {

    @PrimaryKey
    private int fruitId;
    private String fruitName;
    private Double price;



    Fruits(int fruitId,String fruitName,Double price){
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int id) {
        this.fruitId = id;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
