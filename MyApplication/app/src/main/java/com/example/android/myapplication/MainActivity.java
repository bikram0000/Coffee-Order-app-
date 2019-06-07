package com.example.android.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int numberOfCoffees = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //for name

        EditText enterYourName = findViewById(R.id.enter_name);
        String enterName = enterYourName.getText().toString();
        //for whipped cream

        CheckBox hasWhippedcream = findViewById(R.id.has_Whipped_cream);
        boolean whippedCream = hasWhippedcream.isChecked();


        //add chocoalte

        CheckBox haveChocolate = findViewById(R.id.have_Chocolate);
        boolean chocoalte = haveChocolate.isChecked();

        //display message

        String priceMessage = displayMsg(numberOfCoffees, whippedCream, chocoalte, enterName);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "coffee order app bill of:" + enterName);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    displayMessage(priceMessage);

}

    private String displayMsg(int numberOfCoffees, boolean whippedCream, boolean chocoalte, String enterName) {
        String priceMessage = getString(R.string.your_name, enterName);
        priceMessage += "\nHave Whipped Cream ?: " + whippedCream;
        priceMessage += "\nHave Chocoalte ?: " + chocoalte;
        priceMessage += "\nQuantity: " + numberOfCoffees;
        priceMessage += "\nTotal:" + "\t" + numberOfCoffees * priceOfCoffees(whippedCream, chocoalte) + "/-";
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;

    }

    public void increment(View view) {
        if (numberOfCoffees == 100) {
            //an error message on toast
            Toast.makeText(this, "you can't have more than 100 cups", Toast.LENGTH_SHORT).show();

            return;
        }
        numberOfCoffees = numberOfCoffees + 1;
        display(numberOfCoffees);
    }

    public void decrement(View view) {
        if (numberOfCoffees == 1) {
            //an error for minimum cups
            Toast.makeText(this, "you can't have less than 1 cups", Toast.LENGTH_SHORT).show();

            return;
        }
        numberOfCoffees = numberOfCoffees - 1;
        display(numberOfCoffees);
    }
    //price of coffee method

    private int priceOfCoffees(boolean chocoalte, boolean whippedCream) {
        int priceOfTheNormalCoffee = 5;
        if (whippedCream == true) {
            priceOfTheNormalCoffee = priceOfTheNormalCoffee + 1;
        }
        if (chocoalte == true) {
            priceOfTheNormalCoffee = priceOfTheNormalCoffee + 2;
        }
        return priceOfTheNormalCoffee;
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}
