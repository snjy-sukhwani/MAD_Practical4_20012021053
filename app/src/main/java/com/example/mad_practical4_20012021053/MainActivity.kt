package com.example.mad_practical4_20012021053

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
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

        setSupportActionBar (binding.toolbar)

        binding.webUrlBtn.setOnClickListener {

            val userWebUrl = binding.WebURLEditText.text.toString()

            Toast.makeText(this,"Redirecting you to \"$userWebUrl\"",Toast.LENGTH_LONG).show()

            if (userWebUrl.startsWith("https://"))
            {
                Intent(Intent.ACTION_VIEW).setData(Uri.parse(userWebUrl)).apply { startActivity(this) }
            }
            else{
                Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://$userWebUrl")).apply { startActivity(this) }
            }
        }

        binding.CallPhoneBtn.setOnClickListener{

            val userCallNow = binding.CallPhoneEditText.text.toString()

            if (userCallNow.length==10){

                Toast.makeText(this,"Redirecting you to Your Dialer with $userCallNow Number",Toast.LENGTH_LONG).show()

                Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$userCallNow")).apply { startActivity(this) }
            }
            else
            {
                Toast.makeText(this,"Invalid Phone Number",Toast.LENGTH_LONG).show()
            }
        }

        binding.ContactListBtn.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(ContactsContract.Contacts.CONTENT_TYPE).apply { startActivity(this) }
        }

        binding.CallLogBtn.setOnClickListener{
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).apply { startActivity(this) }
        }

        binding.GalleryBtn.setOnClickListener{
            Intent(Intent.ACTION_VIEW).setType("image/*").apply { startActivity(this) }
        }

        binding.CameraBtn.setOnClickListener{
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply { startActivity(this) }
        }

        binding.AlarmBtn.setOnClickListener{
            Intent(AlarmClock.ACTION_SHOW_ALARMS).apply { startActivity(this) }
        }

    }
}