package com.freedmore.fruitsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Creating the fruit collection
    ArrayList<Fruit> MyFruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiating the fruits collection
        MyFruits = new ArrayList<Fruit>();
        //creating fruits
        Fruit banana =new Fruit("Banana",R.drawable.banana,"Yellow fruit, rich in vitamins",3.50);
        Fruit apple = new Fruit("Apple",R.drawable.apple,"juicy red, full of antioxidants",4.00);
        Fruit mango =new Fruit("Mango",R.drawable.mango,"Yellow fruit, rich in vitamins",7.00);
        Fruit orange = new Fruit("Orange",R.drawable.orange,"juicy Citrus, full of antioxidants & Vitamins A & C",6.00);

        //adding fruits into the array list
        MyFruits.add(banana);
        MyFruits.add(apple);
        MyFruits.add(mango);
        MyFruits.add(orange);

        RecyclerView recyclerView = findViewById(R.id.idRecyclerView);

        LinearLayoutManager llManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llManager);

        FruitAdapter fAdapter = new FruitAdapter(MainActivity.this,MyFruits);
        recyclerView.setAdapter(fAdapter);

    }
}