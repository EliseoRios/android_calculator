package com.example.calculadora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
	double temporal=0; 
	double resultado=0;
	String simbolo="";
	boolean igualPresionado=false;
	EditText txtResultado = (EditText) findViewById(R.id.txtResultado);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResultado.setText("0");
        
        //DECLARATION
        Button btnClear = (Button) findViewById(R.id.btnClear);
        Button btn0 = (Button) findViewById(R.id.btn0);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9);
        Button btnSuma = (Button) findViewById(R.id.btnSuma);
        Button btnResta = (Button) findViewById(R.id.btnResta);
        Button btnMultiplicacion = (Button) findViewById(R.id.btnMultiplicacion);
        Button btnDivision = (Button) findViewById(R.id.btnDivision);
        Button btnPunto = (Button) findViewById(R.id.btnPunto);
        Button btnIgual = (Button) findViewById(R.id.btnIgual);
        
        
        //LISTENER
        btnClear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				initialize();
			}
		});
        
        btn0.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setText("0");
			}
		});
        
        btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setText("1");
			}
		});
        
        btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setText("2");
			}
		});
        
        btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setText("3");
			}
		});
        
        btn4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setText("4");
			}
		});
        
        btn5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setText("5");
			}
		});
        
        btn6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setText("6");
			}
		});
        
        btn7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setText("7");
			}
		});
        
        btn8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setText("8");
			}
		});
        
        btn9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setText("9");
			}
		});
        
        btnPunto.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setText(".");
			}
		});
        
        btnSuma.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				simbolo = "+";
				txtResultado.setText("0");
			}
		});
        
        btnResta.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				simbolo = "-";
				txtResultado.setText("0");
			}
		});
        
        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				simbolo = "*";
				txtResultado.setText("0");
			}
		});
        
        btnDivision.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				simbolo = "/";
				txtResultado.setText("0");
			}
		});
        
        btnIgual.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setResult();
			}
		});
    }
    
    //FUNCTIONS
    public void setText(String numero)
    {
    	String textoResultado;
    	
    	if(igualPresionado == true)
    	{
    		textoResultado = numero;
    		igualPresionado = false;
    	}
    	else
    	{
    		textoResultado = txtResultado.getText().toString();
        	
        	//si es diferente a 0
        	if(textoResultado.equalsIgnoreCase("0") == false)
        	{
        		textoResultado = textoResultado+numero;
        	}
        	else 
        	{
        		if(numero.equalsIgnoreCase("."))
        		{
        			textoResultado = "0.";
        		}else{
        			textoResultado = numero;
        		}
        	}
        	temporal = Double.parseDouble(textoResultado);
        	txtResultado.setText(textoResultado);
    	}
    }
    
    public void setResult()
    {
    	txtResultado  = (EditText) findViewById(R.id.txtResultado);
    	double numeroActual = Double.parseDouble(txtResultado.getText().toString());
    	
    	switch(simbolo)
    	{
    	 case "+":
    		resultado = temporal + numeroActual;
    		txtResultado.setText(Double.toString(resultado));
    		break;
    	 case "-":
    		resultado = temporal - numeroActual;
    		txtResultado.setText(Double.toString(resultado));
    		break;
    	 case "*":
    		resultado = temporal * numeroActual;
    		txtResultado.setText(Double.toString(resultado));
    		break;
    	 case "/":
    		resultado = temporal / numeroActual;
    		txtResultado.setText(Double.toString(resultado));
    		break;
    	 default:
    		txtResultado.setText("0");
    		break;
    	}
    	
    	simbolo = "0";
    }
    
    public void initialize()
	{
    	temporal = 0;
    	resultado = 0;
    	simbolo = "";
    	igualPresionado = false;
		txtResultado.setText("0");
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
}
