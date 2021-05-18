package com.example.wowapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int i = 0;

    Button numBtn;
    TextView numTxt;

    ListView listView;

    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry","WindowsMobile","Blackberry","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X","Windows7","Max OS X","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numBtn = (Button) findViewById(R.id.numBtn);
        numTxt = (TextView) findViewById(R.id.numTxt);

        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,mobileArray);
        listView.setAdapter(adapter);
        numBtn.setOnClickListener(getClickListener());
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        try{
            savedInstanceState.putSerializable("iValue",i);
        }
        catch(Exception ex){
            Log.i(u.TAG,"ex i onSaveInstanceState: " + ex.getMessage());
        }

    }

    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        try{
            Log.i(u.TAG,"i onRestoreInstanceState: " + i);

            // update state
            i = (int) savedInstanceState.getSerializable("iValue");

            // update view
            numTxt.setText(i + "");
        }
        catch(Exception ex){
            Log.i(u.TAG,"ex i onRestoreInstanceState: " + ex.getMessage());
        }
    }

    private View.OnClickListener getClickListener(){
        return (View.OnClickListener) v -> {

            // update state
            i++;

            // update view
            numTxt.setText(i+"");
        };
    }
}