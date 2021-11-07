package com.example.osmancordero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var num1: Double=0.0
    private var num2: Double=0.0
    private var operacion: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val InfoMio=findViewById<Button>(R.id.InfoMio)
        val RegresoBoton=findViewById<Button>(R.id.RegresoBoton)

        InfoMio.setOnClickListener {

            val intent:Intent=Intent(this,Info_Osman_Cordero::class.java)
            startActivity(intent)
        }


            //se definio las variables de los numeros de 0 al 9

        var resultadotextView=findViewById<TextView>(R.id.resultadotextView)

        var unoBoton=findViewById<Button>(R.id.unoBoton)
        var dosBoton=findViewById<Button>(R.id.dosBoton)
        var tresBoton=findViewById<Button>(R.id.tresBoton)
        var cuatroBoton=findViewById<Button>(R.id.cuatroBoton)
        var cincoBoton=findViewById<Button>(R.id.cincoBoton)
        var seisBoton=findViewById<Button>(R.id.seisBoton)
        var sieteBoton=findViewById<Button>(R.id.sieteBoton)
        var ochoBoton=findViewById<Button>(R.id.ochoBoton)
        var nueveBoton=findViewById<Button>(R.id.nueveBoton)
        var ceroBoton=findViewById<Button>(R.id.ceroBoton)

        //se definio las variables de los signos a utilizar en el programa
        var masPunto=findViewById<Button>(R.id.masPunto)
        var restaPunto=findViewById<Button>(R.id.restaPunto)
        var multiPunto=findViewById<Button>(R.id.multiPunto)
        var divisionPunto=findViewById<Button>(R.id.divisionPunto)

        var igualPunto=findViewById<Button>(R.id.igualPunto)
        var clearBoton=findViewById<Button>(R.id.clearBoton)

        //se llama la funcion setOnClicker para poder accionar el boton definido en la variable
        unoBoton.setOnClickListener { NumeroApachado(digito="1") }
        dosBoton.setOnClickListener { NumeroApachado(digito="2") }
        tresBoton.setOnClickListener { NumeroApachado(digito="3") }
        cuatroBoton.setOnClickListener { NumeroApachado(digito="4") }
        cincoBoton.setOnClickListener { NumeroApachado(digito="5") }
        seisBoton.setOnClickListener { NumeroApachado(digito="6") }
        sieteBoton.setOnClickListener { NumeroApachado(digito="7") }
        ochoBoton.setOnClickListener { NumeroApachado(digito="8") }
        nueveBoton.setOnClickListener { NumeroApachado(digito="9") }
        ceroBoton.setOnClickListener { NumeroApachado(digito="0") }

        masPunto.setOnClickListener { OperacionApachada(SUMA) }
        restaPunto.setOnClickListener { OperacionApachada(RESTA) }
        multiPunto.setOnClickListener { OperacionApachada(MULTIPLICACION) }
        divisionPunto.setOnClickListener { OperacionApachada(DIVISION) }

        clearBoton.setOnClickListener {
            num1=0.0
            num2=0.0
            resultadotextView.text="0"
            operacion= NoOperacion
        }

        igualPunto.setOnClickListener {

            var resultado= when(operacion){
                SUMA->num1 + num2
                RESTA->num1 - num2
                MULTIPLICACION->num1 * num2
                DIVISION -> num1 / num2
                else->0



            }
            num1 = resultado as Double
            resultadotextView.text= resultadotextView.toString()

            resultadotextView.text = if("$resultado".endsWith(".0")) { "$resultado".replace(".0","") } else { "%.2f".format(resultado) }
        }

    }
    private fun NumeroApachado(digito:String){

        var resultadotextView=findViewById<TextView>(R.id.resultadotextView)
        resultadotextView.text="${resultadotextView.text}$digito"

        if (operacion== NoOperacion){
            num1= resultadotextView.text.toString().toDouble()
        } else{
            num2 = resultadotextView.text.toString().toDouble()
        }
    }
    private fun OperacionApachada(operacion:Int){
        var resultadotextView=findViewById<TextView>(R.id.resultadotextView)
        this.operacion=operacion

        num1= resultadotextView.text.toString().toDouble()

        resultadotextView.text="0"
    }
    companion object{
        const val SUMA=1
        const val RESTA=2
        const val MULTIPLICACION=3
        const val DIVISION=4
        const val NoOperacion=0
    }

}