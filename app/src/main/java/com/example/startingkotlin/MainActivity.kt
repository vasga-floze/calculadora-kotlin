package com.example.startingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.* //importar elementos del xml

class MainActivity : AppCompatActivity() {
    private var numero1=0.0
    private var numero2=0.0
    private var operacion=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultado.text = "0"
        operacion = noOperacion


        btnUno.setOnClickListener {numeroPresionado("1")}
        btnDos.setOnClickListener {numeroPresionado("2")}
        btnTres.setOnClickListener {numeroPresionado("3")}
        btnCuatro.setOnClickListener {numeroPresionado("4")}
        btnCinco.setOnClickListener {numeroPresionado("5")}
        btnSeis.setOnClickListener {numeroPresionado("6")}
        btnSiete.setOnClickListener {numeroPresionado("7")}
        btnOcho.setOnClickListener {numeroPresionado("8")}
        btnNueve.setOnClickListener {numeroPresionado("9")}
        btnCero.setOnClickListener {numeroPresionado("0")}
        btnPunto.setOnClickListener {numeroPresionado(".")}

        btnSuma.setOnClickListener { operacionSeleccionada(suma) }
        btnResta.setOnClickListener { operacionSeleccionada(resta) }
        btnMultiplicacion.setOnClickListener { operacionSeleccionada(multiplicacion) }
        btnDivision.setOnClickListener { operacionSeleccionada(division) }
        btnIgual.setOnClickListener { respuesta() }
        btnC.setOnClickListener { reset() }
    }

    //sirve para definir objetos que van a ser comunes dentro de las clases, como quien dice valores estaticos
    companion object{
        const val suma=1
        const val resta=2
        const val multiplicacion=3
        const val division=4
        const val noOperacion=0
    }

    //funcion para eliminar
    private fun reset(){
        resultado.text = "0"
        numero1=0.0
        numero2=0.0
    }

    //mostrar en el text
    private fun numeroPresionado(num:String){
        if(resultado.text =="0" && num != "."){
            resultado.text = "$num"
        }else{
            resultado.text = "${resultado.text}$num"
        }

        if(operacion == noOperacion){
            numero1 = resultado.text.toString().toDouble()
        }else{
            numero2 = resultado.text.toString().toDouble()
        }
    }

    private fun operacionSeleccionada(operacion:Int) {
        this.operacion = operacion
        numero1 = resultado.text.toString().toDouble()

        resultado.text="0"
    }

    private fun respuesta() {
        val result = when(operacion){
            suma -> numero1+numero2
            resta ->numero1-numero2
            multiplicacion -> numero1*numero2
            division->numero1/numero2
            else->0
        }
        numero1 = result as Double
        resultado.text= if("$result".endsWith(".0")){
            "$result".replace(".0","")}else{"%.2f".format(result)
        }
    }
}