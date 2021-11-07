package com.example.osmancordero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Info_Osman_Cordero : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_osman_cordero)
        val RegresoBoton=findViewById<Button>(R.id.RegresoBoton)
        RegresoBoton.setOnClickListener {

            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
    }
}
}