package com.ShrutiKumariPandit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ShrutiKumariPandit.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            btn1.setOnClickListener {
                tvInputText.append("1")
            }

            btn2.setOnClickListener {
                tvInputText.append("2")
            }
            btn3.setOnClickListener {
                tvInputText.append("3")
            }
            btn4.setOnClickListener {
                tvInputText.append("4")
            }
            btn5.setOnClickListener {
                tvInputText.append("5")
            }
            btn6.setOnClickListener {
                tvInputText.append("6")
            }
            btn7.setOnClickListener {
                tvInputText.append("7")
            }
            btn8.setOnClickListener {
                tvInputText.append("8")
            }
            btn9.setOnClickListener {
                tvInputText.append("9")
            }
            btnPoint.setOnClickListener {
                tvInputText.append(".")
            }
            btnStartBracket.setOnClickListener {
                tvInputText.append("(")
            }
            btnClosetBracket.setOnClickListener {
                tvInputText.append(")")
            }
            btnC.setOnClickListener {
                tvInputText.text.clear()
            }
            btnAdd.setOnClickListener {
                tvInputText.append("+")
            }
            btnMinus.setOnClickListener {
                tvInputText.append("-")
            }
            btnMulti.setOnClickListener {
                tvInputText.append("*")
            }
            btnDivide.setOnClickListener {
                tvInputText.append("/")
            }
            btnX.setOnClickListener {

                val currentText = tvInputText.text.toString()
                if (currentText.isNotEmpty()){
                    tvInputText.setText(currentText.substring(0,currentText.length-1))
                }
            }
            btnEqual.setOnClickListener {
           if (tvOutPutText.text.isNotEmpty()){
               tvInputText.setText(tvOutPutText.text.toString())
               tvOutPutText.text = ""
           }

                else{
                    val expression = ExpressionBuilder(tvInputText.text.toString()).build()
               tvOutPutText.text = expression.evaluate().toInt().toString()
           }

            }


        }

    }
}