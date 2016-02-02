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

        setContentView(R.layout.activity_main);


        Button clearButton = (Button) findViewById(R.id.clearPizzaButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                toppingsList.re
//                toppingsList.clear();
                toppingsList = new ArrayList<String>();
                clearTable();
                Toast.makeText(getBaseContext(), "Cleared ArrayList", Toast.LENGTH_SHORT).show();
                refreshTable();
            }
        });

        Button addToppingButton = (Button) findViewById(R.id.addToppingButton);
        addToppingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                toppingsList.add("bacon");

                refreshTable();
            }
        });








    }

    public void clearTable() {
        TableRow toppingTableRow = (TableRow) findViewById(R.id.toppingTable1);
        TableRow toppingTableRow2 = (TableRow) findViewById(R.id.toppingTable2);

        toppingTableRow.removeAllViews();
        toppingTableRow2.removeAllViews();
    }

    public void refreshTable(){
        TableRow toppingTableRow = (TableRow) findViewById(R.id.toppingTable1);

        int counter = 1;
        for (String topping:toppingsList) {
            if (counter > 5){
                toppingTableRow = (TableRow) findViewById(R.id.toppingTable2);
            }
            ImageView toppingImageView = new ImageView(this);
            switch (topping){
                case "bacon":
                    toppingImageView.setImageResource(R.drawable.bacon);
                    break;

            }

            toppingImageView.setAdjustViewBounds(true);
            toppingImageView.setMaxHeight(120);
            toppingImageView.setMaxWidth(120);

            toppingTableRow.addView(toppingImageView);
            counter++;
        }
    }
}
