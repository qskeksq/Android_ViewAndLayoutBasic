package com.kotlin.peacemaker.viewandlayout

import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.peacemaker.viewandlayout.layout.ParamsActivity
import com.kotlin.peacemaker.viewandlayout.layout.ScrollingActivity
import com.kotlin.peacemaker.viewandlayout.layout.TableAndGridActivity
import com.kotlin.peacemaker.viewandlayout.widget.EditTextActivity
import com.kotlin.peacemaker.viewandlayout.widget.ImageViewActivity
import com.kotlin.peacemaker.viewandlayout.widget.TextViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        params.setOnClickListener { startActivity(Intent(this, ParamsActivity::class.java)) }
        table_grid.setOnClickListener { startActivity(Intent(this, TableAndGridActivity::class.java)) }
        scrolling.setOnClickListener { startActivity(Intent(this, ScrollingActivity::class.java)) }
        textview.setOnClickListener { startActivity(Intent(this, TextViewActivity::class.java)) }
        edittext.setOnClickListener { startActivity(Intent(this, EditTextActivity::class.java)) }
        imageview.setOnClickListener { startActivity(Intent(this, ImageViewActivity::class.java)) }
    }

}
