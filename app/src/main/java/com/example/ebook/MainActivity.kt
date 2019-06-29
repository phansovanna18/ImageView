package com.example.ebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtoutput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(txtoutput.text.toString().length > 0 && txtoutput.text.toString().length < 10)
                {
                    if(txtoutput.text.toString().toInt() <= pic.size)
                    {
                        var a = txtoutput.text.toString().toInt()
                        if(a <= pic.size && a > 0)
                        {
                            picoutput.setImageResource(pic.get(a-1))
                            i = a-1
                        }

                    }
                    else Toast.makeText(this@MainActivity,"Out of picture", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    var i = 0
    var pic : IntArray = intArrayOf(R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5)

    fun click(view: View)
    {
        when(view.id)
        {
            R.id.btnPre->
            {
                i--
                if (i < 0)
                    i=pic.size - 1
            }
            R.id.btnNext->
            {
                i++
                if (i >= pic.size)
                    i = 0
            }
        }
        txtoutput.setText("${i+1}")
    }
}
