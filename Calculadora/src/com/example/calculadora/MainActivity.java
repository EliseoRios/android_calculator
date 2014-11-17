package com.example.calculadora;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;


public class MainActivity extends ActionBarActivity 
{
	TextView txtResultado;
	String strResultado="";
	String strSimbolo ="";
	String strNumeroAnterior="";
	String strNumeroActual="";
	
	boolean presionoPunto = false;
	boolean presionoIgual = false;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       txtResultado = (TextView) findViewById(R.id.txtOperaciones);
       txtResultado.setText("0");
    }
    
    public void clicClear(View v)
    {
    	this.clearVariables();
    }
    
    public void clicSuma(View v)
    {
    	this.setSimbol("+");
    }
    
    public void clicResta(View v)
    {
    	this.setSimbol("-");
    }
    
    public void clicMultiplicacion(View v)
    {
    	this.setSimbol("*");
    }
    
    public void clicDivicion(View v)
    {
    	this.setSimbol("/");
    }
    
    public void clicIgual(View v)
    {
    	this.showResult();
    	presionoIgual = true;
    }
    
    public void clic0(View v)
    {
    	this.setNewText("0");
    }
    
    public void clic1(View v)
    {
    	this.setNewText("1");
    }
    
    public void clic2(View v)
    {
    	this.setNewText("2");
    }
    
    public void clic3(View v)
    {
    	this.setNewText("3");
    }
    
    public void clic4(View v)
    {
    	this.setNewText("4");
    }
    
    public void clic5(View v)
    {
    	this.setNewText("5");
    }
    
    public void clic6(View v)
    {
    	this.setNewText("6");
    }
    
    public void clic7(View v)
    {
    	this.setNewText("7");
    }
    
    public void clic8(View v)
    {
    	this.setNewText("8");
    }
    
    public void clic9(View v)
    {
    	this.setNewText("9");
    }
    
    public void clicPunto(View v)
    {
    	if(!presionoPunto)
    	{
    		this.setNewText(".");
    		presionoPunto = true;
    	}
    }
    
    private void setNewText(String numero)
    {
    	if(presionoIgual)
    	{
    		txtResultado.setText("0");
    		presionoIgual = false;
    	}
		
		strResultado = txtResultado.getText().toString();
    	
		if(numero.equalsIgnoreCase(".") && strResultado.equalsIgnoreCase("0"))
		{
			strResultado = "0"+numero;
		}else if(strResultado.equalsIgnoreCase("0"))
		{
			strResultado = numero;
		}
		else
		{
			strResultado+=numero;
		}
		txtResultado.setText(strResultado);
    }
    
    private void setSimbol(String simbolo)
    {
    	strSimbolo = simbolo;
    	strNumeroAnterior = txtResultado.getText().toString();
    	txtResultado.setText("0");
    	
    	presionoPunto = false;
    }
    
    private void showResult()
    {
    	double numeroAnterior = Double.parseDouble(strNumeroAnterior);
    	double numeroActual = Double.parseDouble(txtResultado.getText().toString());
    	double operacion = 0;
    	
    	presionoPunto = false;
    	
    	if(strSimbolo == "+")
    	{ 
    		operacion = numeroAnterior + numeroActual;
    	}
    	if(strSimbolo == "-")
    	{
    		operacion = numeroAnterior - numeroActual;
    	}
    	if(strSimbolo == "*")
    	{
    		operacion = numeroAnterior * numeroActual;
    	}
    	if(strSimbolo == "/")
    	{
    		operacion = numeroAnterior / numeroActual;
    	}
    	
    	strNumeroAnterior = Double.toString(operacion);
    	txtResultado.setText(Math.rint(operacion*10000)/10000+"");
    }
    
    private void clearVariables()
    {
    	txtResultado.setText("0");
    	strResultado = "";
    	strSimbolo = "";
    	strNumeroAnterior = "";
    	strNumeroActual = "";
    	presionoPunto = false;
    	presionoIgual = false;
    }
}
