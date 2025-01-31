package sanchez.abel.calculadoraaritmetica_245473

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val campo: TextView = findViewById(R.id.tvResultado)

        val numero0: Button = findViewById(R.id.btnNum0)
        val numero1: Button = findViewById(R.id.btnNum1)
        val numero2: Button = findViewById(R.id.btnNum2)
        val numero3: Button = findViewById(R.id.btnNum3)
        val numero4: Button = findViewById(R.id.btnNum4)
        val numero5: Button = findViewById(R.id.btnNum5)
        val numero6: Button = findViewById(R.id.btnNum6)
        val numero7: Button = findViewById(R.id.btnNum7)
        val numero8: Button = findViewById(R.id.btnNum8)
        val numero9: Button = findViewById(R.id.btnNum9)

        val borrar: Button = findViewById(R.id.btnBorrar)
        val sumar: Button = findViewById(R.id.btnMas)
        val restar: Button = findViewById(R.id.btnMenos)
        val dividir: Button = findViewById(R.id.btnDividir)
        val multiplicar: Button = findViewById(R.id.btnPor)
        val punto: Button = findViewById(R.id.btnPunto)
        val igual: Button = findViewById(R.id.btnIgual)
        var numTemp: Float = campo.text.toString().toFloat()
        var numActual: Float = 0f
        var resultado: Float = 0f
        var operacionActual: String = ""


        fun agregarTexto(texto: String) {
            if(campo.text.toString()=="0"){
                campo.text = "";
            }
            campo.text = campo.text.toString() + texto
        }

        numero0.setOnClickListener { agregarTexto("0") }
        numero1.setOnClickListener { agregarTexto("1") }
        numero2.setOnClickListener { agregarTexto("2") }
        numero3.setOnClickListener { agregarTexto("3") }
        numero4.setOnClickListener { agregarTexto("4") }
        numero5.setOnClickListener { agregarTexto("5") }
        numero6.setOnClickListener { agregarTexto("6") }
        numero7.setOnClickListener { agregarTexto("7") }
        numero8.setOnClickListener { agregarTexto("8") }
        numero9.setOnClickListener { agregarTexto("9") }
        punto.setOnClickListener { agregarTexto(".") }

        sumar.setOnClickListener {
            numTemp = campo.text.toString().toFloat()
            campo.text = "0"
            operacionActual = "suma"
        }

        restar.setOnClickListener {
            numTemp = campo.text.toString().toFloat()
            campo.text = "0"
            operacionActual = "resta"
        }

        multiplicar.setOnClickListener {
            numTemp = campo.text.toString().toFloat()
            campo.text = "0"
            operacionActual = "multiplicacion"
        }

        dividir.setOnClickListener {
            numTemp = campo.text.toString().toFloat()
            campo.text = "0"
            operacionActual = "division"
        }

        igual.setOnClickListener {
            numActual = campo.text.toString().toFloat()
            val respuesta = when (operacionActual) {
                "suma" -> sumar(numTemp, numActual)
                "resta" -> restar(numTemp, numActual)
                "multiplicacion" -> multiplicar(numTemp, numActual)
                "division" -> dividir(numTemp, numActual)
                else -> numActual
            }
            campo.text = String.format("%.8f", respuesta).trimEnd('0').trimEnd('.')
        }



        borrar.setOnClickListener {
            campo.text = "0"
        }




    }

    fun sumar(num1: Float, num2: Float): Float = num1 + num2
    fun restar(num1: Float, num2: Float): Float = num1 - num2
    fun multiplicar(num1: Float, num2: Float): Float = num1 * num2
    fun dividir(num1: Float, num2: Float): Float = if (num2 != 0f) num1 / num2 else 0f
}