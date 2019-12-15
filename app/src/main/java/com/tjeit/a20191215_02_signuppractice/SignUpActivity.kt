package com.tjeit.a20191215_02_signuppractice

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.text.SimpleDateFormat
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

        var selectedBirthDay:Calendar? = null

        birthDayTxt.setOnClickListener{
//            Toast.makeText(mContext, "생일 지정 텍스트뷰 클릭", Toast.LENGTH_SHORT).show()
            val datePickerDialog = DatePickerDialog(mContext, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                val selectedDateStr = "${year} / ${month} / ${dayOfMonth}"
                birthDayTxt.text = selectedDateStr

                selectedBirthDay?.let {
                    Log.d("log]생년월일 선택", "이미 선택된 값을 수정 - 다시 선택")
                } .let {
                    Log.d("log]생년월일 선택", "선택된 값이 새로 생김 - 처음 선택")
                    selectedBirthDay = Calendar.getInstance()
//                    Q. selectedBirthDay 에 담긴 날짜는 몇월 몇일? 2019년 12월 15일 (현재)
//                    이 담긴 날짜를 => 선택한 년/월/일로 대입.
                }

//                selectedBirthDay?.set(Calendar.YEAR, year)
//                selectedBirthDay?.set(Calendar.MONTH, month)
//                selectedBirthDay?.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                selectedBirthDay?.set(year, month, dayOfMonth)

//                지정된 생년월일을 SimpleDateFormat을 이용해 출력
                val sdf = SimpleDateFormat("yyyy년 M월 d일 (E)")
                birthDayTxt.text = sdf.format(selectedBirthDay?.time)

            }, 2019, Calendar.DECEMBER, 22)
//            자바에서는 월을 0~11월로 사용함. 생각하는 것보다 1 작은 숫자를 월로 넣어줘야 함
//            Calendar 클래스를 사용하면 직관적
            datePickerDialog.show()
        }

        birthTimeTxt.setOnClickListener {
            val timePickerDialog = TimePickerDialog(mContext, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                selectedBirthDay?.set(Calendar.HOUR_OF_DAY, hourOfDay)
                selectedBirthDay?.set(Calendar.MINUTE, minute)

//                캘린더에 저장된 값을 SimpleDateFormat 이용해 출력
                val sdf = SimpleDateFormat("a h:mm")
                birthTimeTxt.text = sdf.format(selectedBirthDay?.time)

            }, 20, 5, false)
            timePickerDialog.show()
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
