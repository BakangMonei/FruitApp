package com.freedmore.fruitsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    ArrayList<Fruit> MyFruits;

    TextView txtFruitName;
    TextView txtFruitDescription;
    TextView txtFruitPrice;
    ImageView imageFruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtFruitName = findViewById(R.id.tv_fruitName);
        txtFruitDescription =findViewById(R.id.tv_fruitDescription);
        txtFruitPrice =findViewById(R.id.tv_fruitPrice);
        imageFruit =findViewById(R.id.img_fruitImage);

        Intent detail = getIntent();
        int receivedSelectedFruitPosition = detail.getIntExtra("pos",0);

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

        txtFruitName.setText(MyFruits.get(receivedSelectedFruitPosition).getFruitName());
        txtFruitDescription.setText(MyFruits.get(receivedSelectedFruitPosition).getFruitDescription());
        txtFruitPrice.setText(String.valueOf(MyFruits.get(receivedSelectedFruitPosition).getFruitPrice()));
        Picasso.get().load(MyFruits.get(receivedSelectedFruitPosition).getFruitImage()).into(imageFruit);



    }
}