package com.tjeit.a20191215_02_signuppractice

import android.os.Bundle

class SignUpActivity : BaseActivity() {
    var lastBackTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setValue()
        setupEvent()
    }
    override fun setValue() {
        lastBackTime = 10L
    }
    override fun setupEvent() {
        lastBackTime = 20L
    }


}
