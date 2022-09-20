package com.example.mad_practical4_20012021053

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.example.mad_practical4_20012021053.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        WindowCompat.setDecorFitsSystemWindows(window, false)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        // This will invoked When we Click on "Use Facilities" Button
        binding.facilityBtn.setOnClickListener {
            val myMsg = "List of Facilities are Loading\n\n ~ By Explicit Intent"
            Toast.makeText(this, myMsg , Toast.LENGTH_LONG).show()

            // Explicit Intent is Used Here
            val home = Intent(this, HomeActivity::class.java)
            startActivity(home)
        }
    }
}