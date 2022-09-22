package com.example.mad_practical4_20012021053

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.example.mad_practical4_20012021053.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        WindowCompat.setDecorFitsSystemWindows(window, false)

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar (binding.toolbar)

        // When User Clicks on Web Url Button
        binding.webUrlBtn.setOnClickListener {

            // Getting the Website That User Enters in TextBoxes
            val userWebUrl = binding.WebURLEditText.text.toString()

            val msg1 = Toast.makeText(this,"Redirecting you to \"$userWebUrl\"",Toast.LENGTH_LONG)
            msg1.show()

            if (userWebUrl.startsWith("https://"))
            {
                Intent(Intent.ACTION_VIEW).setData(Uri.parse(userWebUrl)).apply { startActivity(this) }
            }
            else{
                if(userWebUrl.endsWith(".com") || userWebUrl.endsWith(".in") || userWebUrl.endsWith(".edu")){
                    Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://$userWebUrl")).apply { startActivity(this) }
                }
                else{
                    Toast.makeText(this,"Invalid URL",Toast.LENGTH_LONG).show()
                }
            }
        }

        // When User Clicks on Call Phone Button
        binding.CallPhoneBtn.setOnClickListener{

            // Getting the Phone Number User Enters in the Textbox
            val userCallNow = binding.CallPhoneEditText.text.toString()

            if (userCallNow.length==10){
                val msg1 = Toast.makeText(this,"Redirecting you to Your Dialer with $userCallNow Number",Toast.LENGTH_LONG)
                msg1.show()
                Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$userCallNow")).apply { startActivity(this) }
            }
            else{
                val msg1 = Toast.makeText(this,"Invalid Phone Number",Toast.LENGTH_LONG)
                msg1.show()
            }
        }

        // When User Clicks on Contact List Button
        binding.ContactListBtn.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(ContactsContract.Contacts.CONTENT_TYPE).apply { startActivity(this) }
        }

        // When User Clicks on Call Log Button
        binding.CallLogBtn.setOnClickListener{
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).apply { startActivity(this) }
        }

        // When User Clicks on Gallery Button
        binding.GalleryBtn.setOnClickListener{
            Intent(Intent.ACTION_VIEW).setType("image/*").apply { startActivity(this) }
        }

        // When User Clicks on Camera Button
        binding.CameraBtn.setOnClickListener{
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply { startActivity(this) }
        }

        // When User Clicks on Alarm Button
        binding.AlarmBtn.setOnClickListener{
            Intent(AlarmClock.ACTION_SHOW_ALARMS).apply { startActivity(this) }
        }

        // For Moving to Another Activity
        binding.detailsbtn.setOnClickListener {
            val message1 = binding.WebURLEditText.text.toString()
            val message2 = binding.CallPhoneEditText.text.toString()

            // Explicit Intent with Data Transfer
            val transferDetails = Intent(this,DetailsActivity::class.java)
            transferDetails.putExtra("myMsg1",message1)
            transferDetails.putExtra("myMsg2",message2)
            startActivity(transferDetails)
        }

    }
}