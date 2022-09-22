package com.example.mad_practical4_20012021053

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val Data = intent
        val message1 = intent.getStringExtra("myMsg1")
        val message2 = intent.getStringExtra("myMsg2")

        val myData :TextView = findViewById(R.id.data)
        myData.text = "Web URL : "+message1+"\n\nPhone Number :"+message2
    }
}