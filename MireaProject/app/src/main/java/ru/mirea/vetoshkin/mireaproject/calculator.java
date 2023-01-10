package ru.mirea.vetoshkin.mireaproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class calculator extends Fragment {
    TextView resultField; // текстовое поле для вывода результата
    EditText numberField;   // поле для ввода числа
    TextView operationField;    // текстовое поле для вывода знака операции
    Double operand = null;  // операнд операции
    String lastOperation = "="; // последняя операция

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflaterView = inflater.inflate(R.layout.fragment_calculator, container, false);
        // setContentView(R.layout.activity_main);
        resultField = inflaterView.findViewById(R.id.resultField);
        numberField = inflaterView.findViewById(R.id.numberField);
        operationField = inflaterView.findViewById(R.id.operationField);
        Button but1 = (Button) inflaterView.findViewById(R.id.button1);
        but1.setOnClickListener(this::onNumberClick);
        Button but2 = (Button) inflaterView.findViewById(R.id.button2);
        but2.setOnClickListener(this::onNumberClick);
        Button but3 = (Button) inflaterView.findViewById(R.id.button3);
        but3.setOnClickListener(this::onNumberClick);
        Button but4 = (Button) inflaterView.findViewById(R.id.button4);
        but4.setOnClickListener(this::onNumberClick);
        Button but5 = (Button) inflaterView.findViewById(R.id.button5);
        but5.setOnClickListener(this::onNumberClick);
        Button but6 = (Button) inflaterView.findViewById(R.id.button6);
        but6.setOnClickListener(this::onNumberClick);
        Button but7 = (Button) inflaterView.findViewById(R.id.button7);
        but7.setOnClickListener(this::onNumberClick);
        Button but8 = (Button) inflaterView.findViewById(R.id.button8);
        but8.setOnClickListener(this::onNumberClick);
        Button but9 = (Button) inflaterView.findViewById(R.id.button9);
        but9.setOnClickListener(this::onNumberClick);
        Button but_slesh = (Button) inflaterView.findViewById(R.id.button_slesh);
        but_slesh.setOnClickListener(this::onOperationClick);
        Button but_zvezd = (Button) inflaterView.findViewById(R.id.button_zvezd);
        but_zvezd.setOnClickListener(this::onOperationClick);
        Button but_plus = (Button) inflaterView.findViewById(R.id.button_plus);
        but_plus.setOnClickListener(this::onOperationClick);
        Button but_minus = (Button) inflaterView.findViewById(R.id.button_minus);
        but_minus.setOnClickListener(this::onOperationClick);
        Button but_equal = (Button) inflaterView.findViewById(R.id.button_equal);
        but_equal.setOnClickListener(this::onOperationClick);
        return inflaterView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("OPERATION", lastOperation);
        if(operand!=null)
            outState.putDouble("OPERAND", operand);
        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        lastOperation = savedInstanceState.getString("OPERATION");
        operand= savedInstanceState.getDouble("OPERAND");
        resultField.setText(operand.toString());
        operationField.setText(lastOperation);
    }
    public void onNumberClick(View view){

        Button button = (Button)view;
        numberField.append(button.getText());

        if(lastOperation.equals("=") && operand!=null){
            operand = null;
        }
    }
    public void onOperationClick(View view){

        Button button = (Button)view;
        String op = button.getText().toString();
        String number = numberField.getText().toString();
        // если введенно что-нибудь
        if(number.length()>0){
            number = number.replace(',', '.');
            try{
                performOperation(Double.valueOf(number), op);
            }catch (NumberFormatException ex){
                numberField.setText("");
            }
        }
        lastOperation = op;
        operationField.setText(lastOperation);
    }

    private void performOperation(Double number, String operation){

        // если операнд ранее не был установлен (при вводе самой первой операции)
        if(operand ==null){
            operand = number;
        }
        else{
            if(lastOperation.equals("=")){
                lastOperation = operation;
            }
            switch(lastOperation){
                case "=":
                    operand =number;
                    break;
                case "/":
                    if(number==0){
                        operand =0.0;
                    }
                    else{
                        operand /=number;
                    }
                    break;
                case "*":
                    operand *=number;
                    break;
                case "+":
                    operand +=number;
                    break;
                case "-":
                    operand -=number;
                    break;
            }
        }
        resultField.setText(operand.toString().replace('.', ','));
        numberField.setText("");
    }
}