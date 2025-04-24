package br.edu.utfpr.helloworld.calculaimc_pm45s_2025_1

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow


class MainActivity : AppCompatActivity() {

    private lateinit var etPeso: EditText
    private lateinit var etAltura: EditText
    private lateinit var tvResultado: TextView
    private lateinit var btCalcular: Button
    //private lateinit var btLimpar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        tvResultado = findViewById(R.id.tvResultado)
        btCalcular = findViewById(R.id.btCalcular)
        //btLimpar = findViewById(R.id.btLimpar)

        btCalcular.setOnClickListener{
            btCalcularOnClick()
        }

        btCalcular.setOnLongClickListener {
            Toast.makeText(this,"Botao para calcular o IMC", Toast.LENGTH_LONG).show()
            true
        }

        //btLimpar.setOnClickListener{
        //    btLimparOnClick()
        //}

    }//fim do onCreate

    public fun btLimparOnClick(view : View) {
        etPeso.setText( "" )
        etAltura.setText( "" )
        tvResultado.setText( "0.0" )
        etPeso.requestFocus()
    }

    private fun btCalcularOnClick() {
        if (etPeso.text.toString().equals("")){
            etPeso.error = "Campo deve ser preenchido"
            //Toast.makeText(this,"Campo peso deve ser preenchido",Toast.LENGTH_LONG).show()
            return
        }
        if (etAltura.text.toString().equals("")){
            //Toast.makeText(this,"Campo peso deve ser preenchido",Toast.LENGTH_LONG).show()
            etAltura.error = "Campo deve ser preenchido"
            return
        }
        val peso = etPeso.text.toString().toDouble()
        val altura = etAltura.text.toString().toDouble()

        val imc = peso / altura.pow(2)

        val df = DecimalFormat("0.00")

        tvResultado.text = df.format(imc)
    }
} // fim da MainActivity