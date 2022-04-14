package jp.techacademy.shintaro.nakagawa.aisatsuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.TimePickerDialog
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        showTimePickerDialog()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                    Log.d("UI-PARTS", "$hour:$minute")
                    if (hour >= 2 && hour <= 9) {
                        textView.text = "おはよう"
                    } else if (hour >= 10 && hour <= 17) {
                        textView.text = "こんにちは"
                    } else if (hour >= 18 || hour <= 1) {
                        textView.text = "こんばんは"
                    }
                },
                13, 0, true)
        timePickerDialog.show()
    }
}