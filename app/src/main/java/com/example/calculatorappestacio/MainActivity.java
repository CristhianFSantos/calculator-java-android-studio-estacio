package com.example.calculatorappestacio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String firstValue = "";
    String secondValue = "";
    Boolean isFirstValue = true;

    TextView result;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.result = findViewById(R.id.result);
    }

    /****************************************************************************************/
    /***************************************[NÚMEROS]***************************************/
    public void clickButton_0(View view){
        if(isFirstValue) this.firstValue += "0";
        if(!isFirstValue) this.secondValue += "0";
        this.writeAppendResult(String.valueOf(0));
    }
    public void clickButton_1(View view){
        if(isFirstValue) this.firstValue += "1";
        if(!isFirstValue) this.secondValue += "1";
        this.writeAppendResult(String.valueOf(1));
    }
    public void clickButton_2(View view){
        if(isFirstValue) this.firstValue += "2";
        if(!isFirstValue) this.secondValue += "2";
        this.writeAppendResult(String.valueOf(2));
    }
    public void clickButton_3(View view){
        if(isFirstValue) this.firstValue += "3";
        if(!isFirstValue) this.secondValue += "3";
        this.writeAppendResult(String.valueOf(3));
    }
    public void clickButton_4(View view){
        if(isFirstValue) this.firstValue += "4";
        if(!isFirstValue) this.secondValue += "4";
        this.writeAppendResult(String.valueOf(4));
    }
    public void clickButton_5(View view){
        if(isFirstValue) this.firstValue += "5";
        if(!isFirstValue) this.secondValue += "5";
        this.writeAppendResult(String.valueOf(5));
    }
    public void clickButton_6(View view){
        if(isFirstValue) this.firstValue += "6";
        if(!isFirstValue) this.secondValue += "6";
        this.writeAppendResult(String.valueOf(6));
    }
    public void clickButton_7(View view){
        if(isFirstValue) this.firstValue += "7";
        if(!isFirstValue) this.secondValue += "7";
        this.writeAppendResult(String.valueOf(7));
    }
    public void clickButton_8(View view){
        if(isFirstValue) this.firstValue += "8";
        if(!isFirstValue) this.secondValue += "8";
        this.writeAppendResult(String.valueOf(8));
    }
    public void clickButton_9(View view){
        if(isFirstValue) this.firstValue += "9";
        if(!isFirstValue) this.secondValue += "9";
        this.writeAppendResult(String.valueOf(9));
    }

    /****************************************************************************************/
    /***********************************[OPERADORES]*****************************************/
    public void clickButton_sum(View view){
        if(this.firstValue.length() >= 1 && this.operator == "") {
            this.operator = "sum";
            this.writeAppendResult(" + ");
            this.isFirstValue = false;
        }
    }
    public void clickButton_subtraction(View view){
        if(this.firstValue.length() >= 1 && this.operator == "") {
            this.operator = "subtraction";
            this.writeAppendResult(" - ");
            this.isFirstValue = false;
        }
    }
    public void clickButton_division(View view){
        if(this.firstValue.length() >= 1 && this.operator == "") {
            this.operator = "division";
            this.writeAppendResult(" / ");
            this.isFirstValue = false;
        }
    }
    public void clickButton_multiplication(View view){
        if(this.firstValue.length() >= 1 && this.operator == "") {
            this.operator = "multiplication";
            this.writeAppendResult(" * ");
            this.isFirstValue = false;
        }
    }
    public void clickButton_potency(View view){
        if(this.firstValue.length() >= 1 && this.operator == "") {
            this.operator = "potency";
            this.writeAppendResult(" ^ ");
            this.isFirstValue = false;
        }
    }
    public void clickButton_radix(View view){
        if(this.secondValue.length() == 0){
            this.operator = "radix";
            this.writeAppendResult(" radix ");
        }
    }
    public void clickButton_mod(View view){
        if(this.firstValue.length() >= 1 && this.operator == "") {
            this.operator = "mod";
            this.writeAppendResult(" mod ");
            this.isFirstValue = false;
        }
    }
    public void clickButton_percentage(View view){
        if(this.firstValue.length() >= 1 && this.operator == "") {
            this.operator = "percentage";
            this.writeAppendResult(" % ");
            this.isFirstValue = false;
        }
    }

    /****************************************************************************************/
    /*********************************[BOTOES GLOBAIS]***************************************/


    public void clickButton_equal(View view){
        long result = 0;
        if(this.operator == "sum"){
            result = Math.round(Double.valueOf(this.firstValue) + Double.valueOf(this.secondValue));
            this.writeResult(Long.toString(result));
        }
        if(this.operator == "subtraction"){
            result = Math.round(Double.valueOf(this.firstValue) - Double.valueOf(this.secondValue));
            this.writeResult(Long.toString(result));
        }
        if(this.operator == "division"){
            result = Math.round(Double.valueOf(this.firstValue) / Double.valueOf(this.secondValue));
            this.writeResult(Long.toString(result));
        }
        if(this.operator == "multiplication"){
            result = Math.round(Double.valueOf(this.firstValue) * Double.valueOf(this.secondValue));
            this.writeResult(Long.toString(result));
        }
        if(this.operator == "potency"){
            double pow = Math.pow(Double.valueOf(this.firstValue), Double.valueOf(this.secondValue));
            result =  Math.round(pow);
            this.writeResult(Long.toString(result));
        }
        if(this.operator == "radix"){
            double sqrt = Math.sqrt(Double.valueOf(this.firstValue));
            result = Math.round(sqrt);
            this.writeResult(Long.toString(result));
        }
        if(this.operator == "mod"){
            result = Math.round(Double.valueOf(this.firstValue) % Double.valueOf(this.secondValue));
            this.writeResult(Long.toString(result));
        }
        if(this.operator == "percentage"){
            result = Math.round(
                    (Double.valueOf(this.firstValue) * Double.valueOf(this.secondValue)) / 100);
            this.writeResult(Long.toString(result));
        }

        this.secondValue = "";
        this.firstValue = Long.toString(result);
        this.isFirstValue = true;
        this.operator = "";

    }
    public void clickButton_clear(View view){
        this.secondValue = "";
        this.firstValue = "";
        this.isFirstValue = true;
        this.operator = "";
        this.result.setText("");
    }
    /****************************************************************************************/
    /***********************************[FERRAMENTAS]*****************************************/

    private void writeAppendResult(String value){
        String currentText = this.result.getText().toString();
        this.result.setText(currentText += value);
    }

    private void writeResult(String value){
        this.result.setText(value);
    }
}