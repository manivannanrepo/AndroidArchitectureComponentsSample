package apps.mani.com.arch.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by GAMING RIG on 11-03-2018.
 */
@Entity
public class Fruits {

    @PrimaryKey
    private int id;
    private String fruitName;
    private Double price;

    Fruits(int id,String fruitName,Double price){
        this.id = id;
        this.fruitName = fruitName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
