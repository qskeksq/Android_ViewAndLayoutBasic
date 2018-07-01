package com.kotlin.peacemaker.viewandlayout.layout

import android.annotation.TargetApi
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.kotlin.peacemaker.viewandlayout.R
import kotlinx.android.synthetic.main.activity_scrolling.*

class ScrollingActivity : AppCompatActivity(), View.OnTouchListener {

    var xPos = 0
    var yPos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setImage()
        setScrollView()
    }

    // 이미지 크기로 바꿔주
    private fun setImage() {
        // 1. 이미지 객체 얻어오기
        val image = resources.getDrawable(R.drawable.pic1)
        // 2. 이미지의 원래 크기 구하기
        val bitmapWidth = image.intrinsicWidth
        val bitmapHeight = image.intrinsicHeight
        // 3. 이미지 세팅
        scrollingImage.setImageDrawable(image)
        // 4. 이미지 원래 크기로 바꿔주기
        val params = scrollingImage.layoutParams
        params.width = bitmapWidth
        params.height = bitmapHeight
        // 5
        scrollingImage.layoutParams = params
    }

    private fun setScrollView() {
        vScrollView.setOnTouchListener(this)
        hScrollView.setOnTouchListener(this)
    }

    /**
     * 원리 : 터치가 일어났을 때 두 스크롤뷰를 동시에 움직여 준다
     */
    private fun scroll(xScroll: Int, yScroll: Int) {
        vScrollView.scrollBy(0, -yScroll)
        hScrollView.scrollBy(-xScroll, 0)
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when (event?.action) {
        // 처음 스크롤을 시작한 지점 좌표
            MotionEvent.ACTION_DOWN -> {
                xPos = (event.rawX).toInt()
                yPos = (event.rawY).toInt()
            }
        // 시작좌표와 움직인 지점 거리 계산
            MotionEvent.ACTION_MOVE -> {
                val mXPos = (event.rawX).toInt()
                val mYPos = (event.rawY).toInt()
                scroll(mXPos - xPos, mYPos - yPos)
                xPos = mXPos
                yPos = mYPos
            }
        // 손가락을 뗐을 때
            MotionEvent.ACTION_UP -> { }
            else -> {
                xPos = (event?.rawX)?.toInt() ?: 0
                yPos = (event?.rawY)?.toInt() ?: 0
            }
        }
        return true
    }
}
