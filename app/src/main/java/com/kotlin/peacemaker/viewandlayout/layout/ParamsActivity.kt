package com.kotlin.peacemaker.viewandlayout.layout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.kotlin.peacemaker.viewandlayout.R
import kotlinx.android.synthetic.main.activity_params.*

class ParamsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_params)
        param_button1?.setOnClickListener { setParams(1f, 3f) }
        param_button2?.setOnClickListener { setParams(3f, 1f) }

    }

    private fun setParams(weight1: Float, weight2: Float) {
        val param1 = param_button1?.layoutParams as LinearLayout.LayoutParams
        val param2 = param_button2?.layoutParams as LinearLayout.LayoutParams
        param1.weight = weight1
        param2.weight = weight2
        param_button1?.layoutParams = param1
        param_button2?.layoutParams = param2
    }

}
