package com.alamre.demokotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            val message = txtUsername.text.toString()
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("message",  message)
            startActivity(intent)
        }

        btnShare.setOnClickListener {
            val message = txtUsername.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share To : "))
        }

        btnRecyclerView.setOnClickListener() {
            val  intent = Intent(this, NotesActivity::class.java)
            startActivity(intent)
        }
    }
}