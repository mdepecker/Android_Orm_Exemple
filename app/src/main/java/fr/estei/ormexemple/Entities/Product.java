package fr.estei.ormexemple.Entities;

import com.orm.SugarRecord;

/**
 * Created by mdepe on 21/10/2015.
 */
public class Product extends SugarRecord<Product> {
    String name;
    String description;
    float price;

    public Customer getBestBuyer() {
        return bestBuyer;
    }

    Customer bestBuyer; /* will be store as best_buyer in db*/

    public Product(){
    }

    public Product(String name, String description){
        this.name = name;
        this.description = description;
    }
}
