package com.tjeit.a20191215_02_signuppractice

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    val mContext = this
    abstract fun setValue()
    abstract fun setupEvent()
}