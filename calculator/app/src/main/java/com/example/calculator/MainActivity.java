package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.view.View;



public class MainActivity extends AppCompatActivity {
    String input1,input2,output,res,fixed_output;
    boolean flag;
    private EditText result,calculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = findViewById(R.id.calculation);
        result = findViewById(R.id.result);

        input1 ="";
        input2 ="";
        res  ="";
        output="";
        fixed_output = "";
        flag = true;

        Button btn0 = findViewById(R.id.Zero);
        Button btn1 = findViewById(R.id.One);
        Button btn2 = findViewById(R.id.Two);
        Button btn3 = findViewById(R.id.Three);
        Button btn4 = findViewById(R.id.Four);
        Button btn5 = findViewById(R.id.Five);
        Button btn6 = findViewById(R.id.Six);
        Button btn7 = findViewById(R.id.Seven);
        Button btn8 = findViewById(R.id.Eight);
        Button btn9 = findViewById(R.id.Nine);
        Button btnMul = findViewById(R.id.MultiBTN);
        Button btnDiv = findViewById(R.id.DivBTN);
        Button btnPlus = findViewById(R.id.PlusBTN);
        Button btnMinus = findViewById(R.id.MinusBTN);
        Button btnDot = findViewById(R.id.Dot);
        ImageButton btnDel = findViewById(R.id.back_space);
        Button btnClear = findViewById(R.id.Clear);
        Button btnCE = findViewById(R.id.Clear_EntryBTN);
        Button btnEqual = findViewById(R.id.Equal);
        Button btnChaOp = findViewById(R.id.changeOp);


    }

    public void onButtonClicked(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "C":
                input1 = "";
                input2 = "";
                output = "";
                fixed_output = "";
                result.setText(output);
                flag = true;
                calculation.setText("");
                result.setText("");
                break;
            case "CE":
                if (flag) {
                    input1 = "";
                    result.setText("");
                } else {
                    input2 = "";
                    result.setText("");
                }
                break;
            case "%":
                double s = Double.parseDouble(result.getText().toString()) / 100;
                if (flag) {
                    input1 = Double.toString(s);
                    calculation.setText(input1);
                } else {
                    input2 = Double.toString(s);
                    calculation.setText(input2);
                }
                break;
            case "^":
                solve();
                if (flag) {
                    input1 += "^";
                    calculation.setText(input1);
                    flag = false;
                } else {
                    input2 += "^";
                    calculation.setText(input2);
                    flag = true;
                }
                break;
            case "=":
                solve();
                break;
            case "cawn":
                break;
            case "1/x":
                break;
            default:
                boolean b = data.equals("+") || data.equals("*") || data.equals("/") || data.equals("-");
                if (flag) {
                    if (input1 == null) input1 = "";
                    if (b) {
                        solve();
                        input1 += data;
                        calculation.setText(input1);
                        flag = false;
                        input2 = "";
                        result.setText(input1.substring(0,input1.length()-1));
                    }else {
                        input1 += data;
                        result.setText(input1);
                    }
                } else {
                    if (input2 == null) input2 = "";
                    if (b) {
                        solve();
                        input2 += data;
                        calculation.setText(input2);
                        flag = true;
                        input1 = "";
                        result.setText(input2.substring(0,input2.length()-1));
                    }else {
                        input2 += data;
                        result.setText(input2);
                    }
                }
        }
    }

    private void solve() {
        if (input1.contains("+")||input2.contains("+")) {
            try {
                double d;
                if(input1.charAt(input1.length()-1) == '+') {
                    d = Double.parseDouble(input1.substring(0,input1.length()-1)) + Double.parseDouble(input2);
                }else{
                    d = Double.parseDouble(input1) + Double.parseDouble(input2.substring(0,input2.length()-1));
                }
                output = Double.toString(d);
                fixed_output = cutDecimal(output);
                result.setText(fixed_output);
                if(flag) {
                    input1 = d + "";
                }else{
                    input2 = d +"";
                }
            } catch (Exception e) {
                result.setText(e.getMessage());
            }
        }

        if (input1.contains("-")||input2.contains("-")) {
            try {
                double d;
                if(input1.charAt(input1.length()-1) == '-') {
                    d = Double.parseDouble(input1.substring(0,input1.length()-1)) - Double.parseDouble(input2);
                }else{
                    d = Double.parseDouble(input2.substring(0,input2.length()-1)) - Double.parseDouble(input1);
                }
                output = Double.toString(d);
                fixed_output = cutDecimal(output);
                result.setText(fixed_output);
                if(flag) {
                    input1 = d + "";
                }else{
                    input2 = d +"";
                }
            } catch (Exception e) {
                result.setText(e.getMessage());
            }
        }

        if (input1.contains("*")||input2.contains("*")) {
            try {
                double d;
                if(input1.charAt(input1.length()-1) == '+') {
                    d = Double.parseDouble(input1.substring(0,input1.length()-1)) * Double.parseDouble(input2);
                }else{
                    d = Double.parseDouble(input1) * Double.parseDouble(input2.substring(0,input2.length()-1));
                }
                output = Double.toString(d);
                fixed_output = cutDecimal(output);
                result.setText(fixed_output);
                if(flag) {
                    input1 = d + "";
                }else{
                    input2 = d +"";
                }
            } catch (Exception e) {
                result.setText(e.getMessage());
            }
        }

        if (input1.contains("/")||input2.contains("/")) {
            try {
                double d;
                if(input1.charAt(input1.length()-1) == '/') {
                    d = Double.parseDouble(input1.substring(0,input1.length()-1)) / Double.parseDouble(input2);
                }else{
                    d = Double.parseDouble(input2.substring(0,input2.length()-1)) / Double.parseDouble(input1);
                }
                output = Double.toString(d);
                fixed_output = cutDecimal(output);
                result.setText(fixed_output);
                if(flag) {
                    input1 = d + "";
                }else{
                    input2 = d +"";
                }
            } catch (Exception e) {
                result.setText(e.getMessage());
            }
        }

        if (input1.contains("^")||input2.contains("^")) {
            try {
                double d;
                if(input1.charAt(input1.length()-1) == '^') {
                    d = Math.pow(Double.parseDouble(input1.substring(0,input1.length()-1)),Double.parseDouble(input2));
                }else{
                    d = Math.pow(Double.parseDouble(input1),Double.parseDouble(input2.substring(0,input2.length()-1)));
                }
                output = Double.toString(d);
                fixed_output = cutDecimal(output);
                result.setText(fixed_output);
                if(flag) {
                    input1 = d + "";
                }else{
                    input2 = d +"";
                }
            } catch (Exception e) {
                result.setText(e.getMessage());
            }
        }
    }

    public void backSpace(View view) {
        if (flag) {
            if (!input1.isEmpty()) {
                input1 = input1.substring(0, input1.length() - 1);
            }
            result.setText(input1);
        }else{
            if (!input2.isEmpty()) {
                input2 = input2.substring(0, input2.length() - 1);
            }
            result.setText(input2);
        }
    }

    private String cutDecimal(String number) {
        String[] n = number.split("\\.");
        if(n.length > 1) {
            if (n[1].equals("0")) {
                number = n[0];
            }
        }
        return number;
    }
    }