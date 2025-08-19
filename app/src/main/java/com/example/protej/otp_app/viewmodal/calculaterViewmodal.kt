package com.example.protej.otp_app.viewmodal

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.protej.otp_app.model.calculatersDeta

class calculaterViewmodal: ViewModel() {

    fun calculatesum(num1:Int , num2:Int): calculatersDeta{

        val sum=num1+num2
        return calculatersDeta(num1,num2,sum)
    }

}