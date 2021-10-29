package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private String oldNumber;
    private String op;

    private EditText input;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        input = findViewById(R.id.text2);

        input.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getString(R.string.input).equals(input.getText().toString())){
                    input.setText("");
                }
            }
        });
    }

    public void updateDisplay(String StrToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(StrToAdd);
        }else{
            display.setText(String.format("%s%s%s",leftStr,StrToAdd,rightStr));
        }
    }

    public void updateInput(String StrToAdd){
        String oldStr = input.getText().toString();
        int cursorPos = input.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.input).equals(input.getText().toString())){
            input.setText(StrToAdd);
            input.setSelection(cursorPos+1);
        }else{
        input.setText(String.format("%s%s%s",leftStr,StrToAdd,rightStr));
        input.setSelection(cursorPos + 1);
        }
    }

    public void ZeroBTN(View view){
        updateInput("0");
    }

    public void OneBTN(View view){
        updateInput("1");
    }

    public void TwoBTN(View view){
        updateInput("2");
    }

    public void ThreeBTN(View view){
        updateInput("3");
    }

    public void FourBTN(View view){
        updateInput("4");
    }

    public void FiveBTN(View view){
        updateInput("5");
    }

    public void SixBTN(View view){
        updateInput("6");
    }

    public void SevenBTN(View view){
        updateInput("7");
    }

    public void EightBTN(View view){
        updateInput("8");
    }

    public void NineBTN(View view){
        updateInput("9");
    }

    public void TenBTN(View view){
        updateInput("10");
    }

    public void EqualBTN(View view){

    }

    public void BackspaceBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
        }
    }


    public void operatorEvent(View view){
        oldNumber = input.getText().toString();
        switch (view.getId()){
            case R.id.PlusBTN: {
                updateInput("+");
                op = "+";

                break;
            }
            case R.id.MinusBTN: {
                updateInput("-");
                op = "-";break;
            }
            case R.id.MultiBTN: {
                updateInput("*");
                op = "*";break;
            }
            case R.id.DivBTN: {
                updateInput("/");
                op = "/";break;
            }
        }
    }

}