package com.example.protej.otp_app.view

import android.R.attr.text
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.protej.otp_app.R
import com.example.protej.otp_app.databinding.ActivityMain2Binding
import com.example.protej.otp_app.viewmodal.calculaterViewmodal
import kotlin.jvm.java

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding
    private lateinit var CalculaterViewmodal: calculaterViewmodal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

//
//        binding.btnCalculate.setOnClickListener {
//
//            val num1=binding.etNumber1.text.toString().trim()
//            val num2=binding.etNumber2.text.toString().trim()
//
//            val sum = num1.toInt()+num2.toInt()
//
//            binding.tvResult.text= "Result: $sum"
//        }

        CalculaterViewmodal= ViewModelProvider(this)[calculaterViewmodal::class.java]


        binding.btnCalculate.setOnClickListener {
            val num1=binding.etNumber1.text.toString().toIntOrNull()?:0
            val num2=binding.etNumber2.text.toString().toIntOrNull()?:0

            val sum = CalculaterViewmodal.calculatesum(num1,num2)
            binding.tvResult.text = "${sum.result}"

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}