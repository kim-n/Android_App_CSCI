package com.knarine.csci133;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
    public final static String EXTRA_MESSAGE = "com.knarine.csci133.MESSAGE";

    TextView input, results;
    private static final String TAG = "CSCI133";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (TextView) findViewById(R.id.text_input);
        results = (TextView) findViewById(R.id.text_result);
        enableNumberButtons(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getResults(View view){
        String numbers = input.getText().toString();
        Secret stuff = new Secret();
        String output = stuff.secretStuff(numbers);
        results.setText(output);
        enableNumberButtons(true);
    }

    public void removeNumber(View view){
        String nums = input.getText().toString();
        if (nums != ""){
            int number = Integer.parseInt(nums);
            int newNumber = number / 10;
            if (newNumber == 0) {
                input.setText("");
            } else {
                input.setText(String.valueOf(newNumber));
            }
            enableNumberButtons(true);
        }
    }

    public void clearNumbers(View view){
        input.setText("");
        enableNumberButtons(true);
    }

    private void enableNumberButtons(boolean status){
        LinearLayout[] linearArray = new LinearLayout[3];
        linearArray[0] = (LinearLayout) findViewById(R.id.layout1);
        linearArray[1] = (LinearLayout) findViewById(R.id.layout2);
        linearArray[2] = (LinearLayout) findViewById(R.id.layout3);

        for ( int i = 0; i < 3;  i++ ){
            for ( int j = 0; j < linearArray[i].getChildCount();  j++ ){
                View view = linearArray[i].getChildAt(j);
                view.setEnabled(status);
            }
        }

        Button zeroButton = (Button) findViewById(R.id.button0);
        zeroButton.setEnabled(status);

        Button resultButton = (Button) findViewById(R.id.button_results);
        resultButton.setEnabled(!status);

    }

    private void insert(String number){
        String oldInput = input.getText().toString();
        if (!oldInput.equals("") && oldInput.length() >= 4){
            oldInput = "";
        }
        String newInput = oldInput + number;
        input.setText(newInput);
        if (newInput.length() > 3){
            enableNumberButtons(false);
        }
    }

    public void button0Clicked(View view){
        insert("0");
    }
    public void button1Clicked(View view){
        insert("1");
    }
    public void button2Clicked(View view){
        insert("2");
    }
    public void button3Clicked(View view){
        insert("3");
    }
    public void button4Clicked(View view){
        insert("4");
    }
    public void button5Clicked(View view){
        insert("5");
    }
    public void button6Clicked(View view){
        insert("6");
    }
    public void button7Clicked(View view){
        insert("7");
    }
    public void button8Clicked(View view){
        insert("8");
    }
    public void button9Clicked(View view){
        insert("9");
    }


}
