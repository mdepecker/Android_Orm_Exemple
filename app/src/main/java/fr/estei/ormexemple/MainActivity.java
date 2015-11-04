package fr.estei.ormexemple;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.orm.StringUtil;
import com.orm.SugarRecord;

import java.util.List;

import fr.estei.ormexemple.Entities.Customer;
import fr.estei.ormexemple.Entities.Product;

public class MainActivity extends AppCompatActivity {
    private Button createBtn;
    private Button fetchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        createBtn = (Button) findViewById(R.id.createbtn);
        fetchBtn = (Button)findViewById(R.id.fetchbtn);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createObject();
            }
        });
        fetchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchAll();
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    protected void createObject(){
        Product myProduct = new Product("name_of_product_1","desc_of_product_1" );
        myProduct.save();
        Log.d("test", myProduct.toString());
    }
    protected void fetchObject(){
        Product myFetchedproduct = Product.findById(Product.class,(long)1);
        Log.d("test", myFetchedproduct.toString());
    }
    protected void deleteObject(){
        Product myFetchedproduct = Product.findById(Product.class,(long)1);
        myFetchedproduct.delete();
    }

    /*Bulk Operation*/
    protected void fetchAll(){
        List<Product> products  = Product.listAll(Product.class);
        Log.d("test", products.toString());

    }
    protected void deleteAll(){
        Product.deleteAll(Product.class);
    }

    /* stuff with relation ship*/

    protected void getProductBestBuyer() {
        Product myProduct = new Product("name_of_product_1","desc_of_product_1" );
        Customer customer = myProduct.getBestBuyer();
    }
    protected void getMybestBuy(){
        //StringUtil.toSQLName("bestBuyer")
        Customer bestBuyer = SugarRecord.findById(Customer.class,(long)1);
        List<Product> products = Product.find(Product.class, "best_buyer = ?", bestBuyer.getId().toString());
    }

    /* using query builder*/

    protected void fetchwhatever(){
        List<Product> products = Product.find(Product.class,"desc = ? and name = ?","ladescription","lenom");
    }
    protected void execute(){
        Product.executeQuery("Your fuckin' old school sql query");
    }
    protected void findOldSchool () {
        List<Product> products = Product.findWithQuery(Product.class,"Your fuckin' old school sql query");
        /*or use params*/
        List<Product> productsAgain = Product.findWithQuery(Product.class,"Your fuckin' old school sql query where foo = ?", "bar");
    }




}
