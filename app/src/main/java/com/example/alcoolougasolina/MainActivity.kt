package com.example.alcoolougasolina

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Switch


class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            percentual=savedInstanceState.getDouble("percentual")
        }
        Log.d("PDM24", "No onCreate, $percentual")

        percentual=0.7
        val btCalc: Button = findViewById(R.id.btCalcular)

        val switchPercentual: Switch = findViewById(R.id.swPercentual)

        switchPercentual.setOnCheckedChangeListener { _, isChecked ->
            percentual = if (isChecked) {
                0.75
            } else {
                0.7
            }

            Log.d("PDM24", "Percentual alterado para $percentual")
        }

        //btCalc.setBackgroundColor(Color.CYAN)
        btCalc.setOnClickListener(View.OnClickListener {
            //código do evento
            escolherCombustivel(percentual)

            Log.d("PDM24","No btCalcular, $percentual")
        })
    }

    fun escolherCombustivel(percentual: Double){
        val txtGasolina: TextView = findViewById(R.id.edGasolina)
        val txtAlcool: TextView = findViewById(R.id.edAlcool)
        val resultado: TextView = findViewById(R.id.textMsg)

        if (txtAlcool.text.toString() != "" && txtGasolina.text.toString() != "") {
            val gasolina: Double = txtGasolina.text.toString().toDouble()
            val alcool: Double = txtAlcool.text.toString().toDouble()


            resultado.text = if (alcool <= gasolina * percentual){
                "É mais vantajoso usar álcool"
            } else{
                "É mais vantajoso usar gasolina"
            }
        } else {
            resultado.text = "Por favor, preencha todos os campois acima"
        }
    }
override fun onResume(){
    super.onResume()
    Log.d("PDM24","No onResume, $percentual")
}
override fun onStart(){
    super.onStart()
    Log.v("PDM24","No onStart")
}
override fun onPause(){
    super.onPause()
    Log.e("PDM24","No onPause")
}
override fun onStop(){
    super.onStop()
    Log.w("PDM24","No onStop")
}
override fun onDestroy(){
    super.onDestroy()
    Log.wtf("PDM24","No Destroy")
}
 override fun onSaveInstanceState(outState: Bundle) {
    outState.putDouble("percentual",percentual)
    super.onSaveInstanceState(outState)
    }
}