package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    TextView workingsTV;
    TextView resultsTV;

    String workings = "";
    Double result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextView();
    }

    private void initTextView(){
        workingsTV = (TextView) findViewById(R.id.workingsTextView);
        resultsTV = (TextView) findViewById(R.id.resultTextView);
    }

    private void setWorkings(String givenValue){
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }

    public void clearOnClick(View view) {
        workingsTV.setText("");
        workings = "";
        resultsTV.setText("");
    }

    public void clearAllClick(View view) {
        workingsTV.setText("");
        workings = "";
        resultsTV.setText("");
    }

    public void backspace(View view) {
        workings = workings.substring(0, workings.length()-1);
        workingsTV.setText(workings);
    }

    public void divide(View view) {
        setWorkings("/");
    }

    public void seven(View view) {
        setWorkings("7");
    }

    public void eight(View view) {
        setWorkings("8");
    }

    public void multi(View view) {
        setWorkings("*");
    }

    public void four(View view) {
        setWorkings("4");
    }

    public void five(View view) {
        setWorkings("5");
    }

    public void six(View view) {
        setWorkings("6");
    }

    public void subtract(View view) {
        setWorkings("-");
    }

    public void nine(View view) {
        setWorkings("9");
    }

    public void one(View view) {
        setWorkings("1");
    }

    public void two(View view) {
        setWorkings("2");
    }

    public void three(View view) {
        setWorkings("3");
    }

    public void add(View view) {
        setWorkings("+");
    }

    public void changeSign(View view) {
        result = -result;
        workings = String.valueOf(result.doubleValue());
        workingsTV.setText(String.valueOf(result.doubleValue()));
        result = null;
        resultsTV.setText(null);
    }

    public void zero(View view) {
        setWorkings("0");
    }

    public void equal(View view) {

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            result = (double)engine.eval(workings);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        }

        if(result != null){
            resultsTV.setText(String.valueOf(result.doubleValue()));
        }

    }

    public void dot(View view) {
        setWorkings(".");
    }
}