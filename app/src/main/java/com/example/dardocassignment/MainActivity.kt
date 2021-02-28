package com.example.dardocassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {


    lateinit var proceedButton:Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init();
    }

    fun init(){
        proceedButton=findViewById(R.id.proceed_btn);

        proceedButton.setOnClickListener {
            val intent = Intent(this, PagerActivity::class.java)
            startActivity(intent)

        }
    }
}