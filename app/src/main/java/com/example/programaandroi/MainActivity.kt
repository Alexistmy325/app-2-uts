package com.example.programaandroi // ⚠️ deja el tuyo, no lo cambies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias
        val textView = findViewById<TextView>(R.id.textView)
        val btnSaludar = findViewById<Button>(R.id.btnSaludar)

        var contador = 0

        btnSaludar.setOnClickListener {
            contador++
            textView.text = "Has hecho clic $contador veces"

            Toast.makeText(
                this,
                "¡Botón presionado!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}