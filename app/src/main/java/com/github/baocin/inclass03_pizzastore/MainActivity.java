package com.github.baocin.inclass03_pizzastore;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> toppingsList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        Button addToppingButton = (Button) findViewById(R.id.addToppingButton);
//        addToppingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        setContentView(R.layout.activity_main);

//        RelativeLayout rl = new RelativeLayout(this);
//        rl.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
//        setContentView(rl);
//
//        ImageView pizzaView = new ImageView(this);
//        pizzaView.setImageResource(R.drawable.pizza);
//        pizzaView.setId(R.id.pizzaIcon);
////        pizzaView.setLayoutParams();
//        rl.addView(pizzaView);
//        toppingTableRow.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Log.d("Table OnClick", "Topping Clicked: " + v.toString());
//            }
//        });

        toppingsList.add("bacon");
        toppingsList.add("bacon");
        toppingsList.add("bacon");
        toppingsList.add("bacon");
        toppingsList.add("bacon");
        toppingsList.add("bacon");
        toppingsList.add("bacon");
        toppingsList.add("bacon");



//        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(getBaseContext().LAYOUT_INFLATER_SERVICE);
//        View v = vi.inflate(R.layout.activity_main, null);

        Button clearButton = (Button) findViewById(R.id.clearPizzaButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toppingsList = new ArrayList<String>();
                Toast.makeText(getBaseContext(), "Cleared ArrayList", Toast.LENGTH_SHORT).show();
            }
        });



        TableRow toppingTableRow = (TableRow) findViewById(R.id.toppingTable1);



        //Go through array list and make a new imageview for each
//        int id = 0;
        int counter = 1;
        for (String topping:toppingsList) {
            if (counter >= 5){
                toppingTableRow = (TableRow) findViewById(R.id.toppingTable2);
            }
            ImageView toppingImageView = new ImageView(this);
            switch (topping){
                case "bacon":
                    toppingImageView.setImageResource(R.drawable.bacon);
                    break;

            }
//            toppingImageView.setId(id);
            toppingImageView.setAdjustViewBounds(true);
            toppingImageView.setMaxHeight(10);

            toppingImageView.setMaxWidth(10);

            toppingTableRow.addView(toppingImageView);
            counter++;
        }


//// insert into main view
//        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.insert_point);
//        insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));







    }


}
