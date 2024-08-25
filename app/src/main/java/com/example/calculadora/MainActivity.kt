package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var resultado = ""
    private var operacion = ""
    private var valor = ""

    private var ultimo = ""
    private var ans = ""
    private var operaciones:ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btnCero).setOnClickListener {
            valor += "0"
            operacion += "0"
            setOperacion()
        }

        findViewById<Button>(R.id.btnUno).setOnClickListener {
            valor += "1"
            operacion += "1"
            setOperacion()
        }

        findViewById<Button>(R.id.btnDos).setOnClickListener {
            valor += "2"
            operacion += "2"
            setOperacion()
        }

        findViewById<Button>(R.id.btnTres).setOnClickListener {
            valor += "3"
            operacion += "3"
            setOperacion()
        }

        findViewById<Button>(R.id.btnCuatro).setOnClickListener {
            valor += "4"
            operacion += "4"
            setOperacion()
        }

        findViewById<Button>(R.id.btnCinco).setOnClickListener {
            valor += "5"
            operacion += "5"
            setOperacion()
        }

        findViewById<Button>(R.id.btnSeis).setOnClickListener {
            valor += "6"
            operacion += "6"
            setOperacion()
        }

        findViewById<Button>(R.id.btnSiete).setOnClickListener {
            valor += "7"
            operacion += "7"
            setOperacion()
        }

        findViewById<Button>(R.id.btnOcho).setOnClickListener {
            valor += "8"
            operacion += "8"
            setOperacion()
        }

        findViewById<Button>(R.id.btnNueve).setOnClickListener {
            valor += "9"
            operacion += "9"
            setOperacion()
        }

        findViewById<Button>(R.id.btnSumar).setOnClickListener {
            if(ultimo == "") {
                operaciones.add(valor)
                valor = ""
            }
            operaciones.add("+")
            operacion += "+"
            setOperacion()
        }

        findViewById<Button>(R.id.btnRestar).setOnClickListener {
            if(ultimo == "") {
                operaciones.add(valor)
                valor = ""
            }
            operaciones.add("-")
            operacion += "-"
            setOperacion()
        }

        findViewById<Button>(R.id.btnMultiplicar).setOnClickListener {
            if(ultimo == "") {
                operaciones.add(valor)
                valor = ""
            }
            operaciones.add("x")
            operacion += "x"
            setOperacion()
        }

        findViewById<Button>(R.id.btnDividir).setOnClickListener {
            if(ultimo == "") {
                operaciones.add(valor)
                valor = ""
            }
            operaciones.add("÷")
            operacion += "÷"
            setOperacion()
        }

        findViewById<Button>(R.id.btnIgual).setOnClickListener {
            calcularResultado()
            setResultado()
        }

        findViewById<Button>(R.id.btnPorcentaje).setOnClickListener {
            if(ultimo == "") {
                operaciones.add(valor)
                valor = ""
            }
            operaciones.add("%")
            operacion += "%"
            setOperacion()
        }

        findViewById<Button>(R.id.btnBorrar).setOnClickListener {
            operacion = ""
            setOperacion()
            resultado = "0"
            setResultado()

            operaciones.clear()
            ultimo = ""
        }

        findViewById<Button>(R.id.btnBorra).setOnClickListener {
            //not implemented
        }

        findViewById<Button>(R.id.btnAns).setOnClickListener {
            operacion = ans
            setOperacion()

            operaciones.add(ans)
            ultimo = ans
        }

        findViewById<Button>(R.id.btnPunto).setOnClickListener {
            valor += "."
            operacion += "."
            setOperacion()
        }


    }

    private fun calcularResultado() {
        operaciones.add(valor)
        valor = ""

        var final = operaciones[0].toDouble()
        operaciones.forEach { item ->
            when(item) {
                "+" -> final += operaciones[operaciones.indexOf(item) + 1].toDouble()
                "-" -> final -= operaciones[operaciones.indexOf(item) + 1].toDouble()
                "x" -> final *= operaciones[operaciones.indexOf(item) + 1].toDouble()
                "÷" -> final /= operaciones[operaciones.indexOf(item) + 1].toDouble()
                "%" -> final %= operaciones[operaciones.indexOf(item) + 1].toDouble()
            }
        }

        var finalS = final.toString()
        if(finalS.substring(finalS.length-2, finalS.length).equals(".0")) {
            finalS = finalS.substring(0, finalS.length-2)
        }

        operacion = finalS
        resultado = finalS
        ultimo = finalS
        ans = finalS

        operaciones.clear()
        operaciones.add(finalS)
    }

    private fun setOperacion() {
        findViewById<TextView>(R.id.txtOperacion).setText(operacion)
    }

    private fun setResultado() {
        findViewById<TextView>(R.id.txtResultado).setText(resultado)
    }

}