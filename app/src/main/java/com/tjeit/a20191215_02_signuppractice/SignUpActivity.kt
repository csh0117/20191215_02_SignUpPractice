package com.tjeit.a20191215_02_signuppractice

import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.*
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

        birthDayTxt.setOnClickListener{
//            Toast.makeText(mContext, "생일 지정 텍스트뷰 클릭", Toast.LENGTH_SHORT).show()
            val datePickerDialog = DatePickerDialog(mContext, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                val selectedDateStr = "${year} / ${month} / ${dayOfMonth}"
                birthDayTxt.text = selectedDateStr

            }, 2019, Calendar.DECEMBER, 15)
//            자바에서는 월을 0~11월로 사용함. 생각하는 것보다 1 작은 숫자를 월로 넣어줘야 함
//            Calendar 클래스를 사용하면 직관적

            datePickerDialog.show()
        }

        pwEdt.addTextChangedListener {
            Log.d("log]입력된 값", it.toString())
            val inputStr = it.toString()
            if (inputStr.length == 0) {
                pwStatusTxt.text = "비밀번호가 입력되지 않았습니다."
                pwStatusTxt.setTextColor(Color.parseColor("#FDA0EF"))
            } else if (inputStr.length < 8) {
                pwStatusTxt.text = "최소 8자 이상 입력해주세요."
                pwStatusTxt.setTextColor(Color.RED)
            } else {
                pwStatusTxt.text = "사용 가능한 비밀번호입니다."
                pwStatusTxt.setTextColor(Color.GREEN)
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
