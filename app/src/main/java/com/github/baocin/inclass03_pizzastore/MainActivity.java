//File: MainActivity
//Assignment #: 3
//Name: Michael Pedersen, Gabriel Lima,praveenkumar Sangalad

package com.github.baocin.inclass03_pizzastore;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<String> pt = new ArrayList<String>();

    private CheckBox deliveryCheck;
    AlertDialog.Builder toppingsDialogBuilder;
    AlertDialog toppingsDialog;

    final CharSequence[] toppings = {"Bacon", "Cheese", "Garlic", "Green Pepper", "Mushroom", "Olives", "Onions", "Red Pepper", "Tomato"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deliveryCheck = (CheckBox) findViewById(R.id.deliveryCheckbox);
        ProgressBar pb = (ProgressBar) findViewById(R.id.toppingCapacity);
        pb.setMax(10);

        Button clearButton = (Button) findViewById(R.id.clearPizzaButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   clearTable();
                   pt.clear();
                   ProgressBar pb = (ProgressBar) findViewById(R.id.toppingCapacity);

                   pb.setProgress(0);

//                   Toast.makeText(getBaseContext(), "Cleared ArrayList", Toast.LENGTH_SHORT).show();
                   refreshTable();
               }
           }

        );


        // Adding Toppings

        toppingsDialogBuilder = new AlertDialog.Builder(this);
        toppingsDialogBuilder.setTitle("Choose a Topping")
                .setItems(toppings, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (pt.size() < 10) {
                            pt.add(toppings[which].toString());
                            Log.d("toppings", pt.toString());
                            refreshTable();
                        } else {
                            Toast.makeText(MainActivity.this, "Maximum Topping capacity reached!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        toppingsDialog = toppingsDialogBuilder.create();

        // TODO: Replace This with the button
        findViewById(R.id.addToppingButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                toppingsDialog.show();

                ProgressBar pb = (ProgressBar) findViewById(R.id.toppingCapacity);
                pb.setProgress(pt.size());

            }
        });

        findViewById(R.id.checkoutButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pizza newPizza = new Pizza();
                newPizza.toppings = pt;

                if (deliveryCheck.isChecked()) {
                    newPizza.setIsDelivery(true);
                } else {
                    newPizza.setIsDelivery(false);
                }

                Intent nt = new Intent(getBaseContext(), CheckoutActivity.class);
                nt.putExtra("toppingsSize", pt.size());
                nt.putExtra("delivery", deliveryCheck.isChecked());
                startActivity(nt);
//                Log.d("PIZZA VALUE", Double.toString(newPizza.getTotalPrice()));

            }
        });
    }

    public void clearTable() {
        TableRow toppingTableRow = (TableRow) findViewById(R.id.toppingTable1);
        TableRow toppingTableRow2 = (TableRow) findViewById(R.id.toppingTable2);

        toppingTableRow.removeAllViews();
        toppingTableRow2.removeAllViews();

    }

    public void refreshTable() {
        clearTable();
        TableRow toppingTableRow = (TableRow) findViewById(R.id.toppingTable1);

        int counter = 1;
        for (String topping : pt) {
            if (counter > 5) {
                toppingTableRow = (TableRow) findViewById(R.id.toppingTable2);
            }
            ImageView toppingImageView = new ImageView(getBaseContext());
            switch (topping.toLowerCase()) {
                case "bacon":
                    toppingImageView.setImageResource(R.drawable.bacon);
                    break;
                case "cheese":
                    toppingImageView.setImageResource(R.drawable.cheese);
                    break;
                case "garlic":
                    toppingImageView.setImageResource(R.drawable.garlic);
                    break;
                case "green pepper":
                    toppingImageView.setImageResource(R.drawable.green_pepper);
                    break;
                case "mushroom":
                    toppingImageView.setImageResource(R.drawable.mushroom);
                    break;
                case "olives":
                    toppingImageView.setImageResource(R.drawable.olives);
                    break;
                case "onion":
                    toppingImageView.setImageResource(R.drawable.onion);
                    break;
                case "red pepper":
                    toppingImageView.setImageResource(R.drawable.red_pepper);
                    break;
                case "tomato":
                    toppingImageView.setImageResource(R.drawable.tomato);
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
