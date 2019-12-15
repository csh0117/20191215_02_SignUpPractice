package com.tjeit.a20191215_02_signuppractice

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlin.math.log

class SignUpActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setValue()
        setupEvent()
    }
    override fun setValue() {
    }
    override fun setupEvent() {
        pwEdt.addTextChangedListener {
            Log.d("log]입력된 값", it.toString())
            val inputStr = it.toString()
            if (inputStr.length == 0) {
                pwStatusTxt.text = "비밀번호가 입력되지 않았습니다."
            } else if (inputStr.length < 8) {
                pwStatusTxt.text = "최소 8자 이상 입력해주세요."
            } else {
                pwStatusTxt.text = "사용 가능한 비밀번호입니다."
            }
        }
//        pwEdt.addTextChangedListener(object : TextWatcher{
//            override fun afterTextChanged(s: Editable?) {
//                Log.d("log]입력된 값", s.toString())
//            }
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            }
//
//        })
    }


}
