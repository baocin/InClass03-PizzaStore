package com.github.baocin.inclass03_pizzastore;

//File: CheckoutAcitivity
//Assignment #: 3
//Name: Michael Pedersen, Gabriel Lima,praveenkumar Sangalad


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int topSize = getIntent().getExtras().getInt("toppingsSize");
        boolean isdel = getIntent().getExtras().getBoolean("delivery");

        TextView bp = (TextView) findViewById(R.id.basePrice);
        TextView topPrice = (TextView) findViewById(R.id.topPrice);
        TextView deliveryPrice = (TextView) findViewById(R.id.dPrice);
        TextView totalPrice = (TextView) findViewById(R.id.totalPrice);

        bp.setText("6.50");
        if (isdel){
            deliveryPrice.setText("4.00");
    }else{
            deliveryPrice.setText("0.00");


    }
        topPrice.setText(Double.toString(topSize * 1.5));
        if (isdel) {

            totalPrice.setText(Double.toString(4 + 6.5 + topSize * 1.5));
        }    else{
            totalPrice.setText(Double.toString(6.5 + topSize * 1.5));

        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button fb = (Button) findViewById(R.id.finishButton);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
