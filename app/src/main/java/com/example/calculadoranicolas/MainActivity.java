package com.example.calculadoranicolas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, ponto, apaga, clear, divide, multiplica, soma, subtrai, igual;
    private TextView formula, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        startId();

        bt0.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtrai.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiplica.setOnClickListener(this);
        clear.setOnClickListener(this);
        apaga.setOnClickListener(this);
        igual.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_0:
                escreveNaFormula("0", true);
                break;
            case R.id.bt_1:
                escreveNaFormula("1", true);
                break;
            case R.id.bt_2:
                escreveNaFormula("2", true);
                break;
            case R.id.bt_3:
                escreveNaFormula("3", true);
                break;
            case R.id.bt_4:
                escreveNaFormula("4", true);
                break;
            case R.id.bt_5:
                escreveNaFormula("5", true);
                break;
            case R.id.bt_6:
                escreveNaFormula("6", true);
                break;
            case R.id.bt_7:
                escreveNaFormula("7", true);
                break;
            case R.id.bt_8:
                escreveNaFormula("8", true);
                break;
            case R.id.bt_9:
                escreveNaFormula("9", true);
                break;
            case R.id.bt_ponto:
                escreveNaFormula(".", true);
                break;
            case R.id.bt_soma:
                escreveNaFormula("+", false);
                break;
            case R.id.bt_menos:
                escreveNaFormula("-", false);
                break;
            case R.id.bt_multiplicacao:
                escreveNaFormula("*", false);
                break;
            case R.id.bt_divisao:
                escreveNaFormula("/", false);
                break;
            case R.id.bt_limpar:
                formula.setText(" ");
                resultado.setText(" ");
                break;
            case R.id.bt_apaga:
                apaga();
                break;
            case R.id.bt_igual:
                calcula();
                break;
        }
    }

    private void escreveNaFormula (String s, Boolean limpaDados){
        if (limpaDados){
            resultado.setText(" ");
            formula.append(s);
        }else{
            if (!resultado.getText().equals(" ")) {
                formula.setText(" ");
            }
            formula.append(resultado.getText());
            formula.append(s);
            resultado.setText(" ");
        }
    }

    private void apaga (){
        String s = formula.getText().toString();
        if (!s.isEmpty()){
            byte var0 = 0;
            int newLength = s.length() - 1;
            formula.setText(s.substring(var0, newLength));
        }
        resultado.setText(" ");
    }

    private void calcula (){
        try {
            Expression expression = new ExpressionBuilder(formula.getText().toString()).build();
            double result = expression.evaluate();
            long longResult = (long) result;

            if (result == (double) longResult){
                resultado.setText((CharSequence) String.valueOf(longResult));
            }
        }catch (Exception e){
            System.out.println("Ococorreu o seguinte erro: "+ e);
            resultado.setText("ERROR");
        }
    }

    private void startId() {
        bt0 = findViewById(R.id.bt_0);
        bt1 = findViewById(R.id.bt_1);
        bt2 = findViewById(R.id.bt_2);
        bt3 = findViewById(R.id.bt_3);
        bt4 = findViewById(R.id.bt_4);
        bt5 = findViewById(R.id.bt_5);
        bt6 = findViewById(R.id.bt_6);
        bt7 = findViewById(R.id.bt_7);
        bt8 = findViewById(R.id.bt_8);
        bt9 = findViewById(R.id.bt_9);
        ponto = findViewById(R.id.bt_ponto);
        apaga = findViewById(R.id.bt_apaga);
        clear = findViewById(R.id.bt_limpar);
        divide = findViewById(R.id.bt_divisao);
        multiplica = findViewById(R.id.bt_multiplicacao);
        soma = findViewById(R.id.bt_soma);
        subtrai = findViewById(R.id.bt_menos);
        formula = findViewById(R.id.tv_formula);
        resultado = findViewById(R.id.tv_resultado);
        igual = findViewById(R.id.bt_igual);
    }
}