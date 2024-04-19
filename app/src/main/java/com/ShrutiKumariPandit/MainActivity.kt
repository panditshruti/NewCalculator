package com.ShrutiKumariPandit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ShrutiKumariPandit.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set initial input text


        // Function to append a string to the input text view
        fun appendToInput(str: String) {
            // Append the new string to the existing input
            binding.tvInputText.append(str)
        }

        // Function to clear the input text view
        fun clearInput() {
            binding.tvOutPutText.text = ""
        }

        // Function to evaluate the expression and display the result
        fun evaluateExpression() {
            try {
                val expression = ExpressionBuilder(binding.tvInputText.text.toString()).build()
                val result = expression.evaluate()
                binding.tvOutPutText.text = result.toString()
            } catch (e: Exception) {
                binding.tvOutPutText.text = "Error"
            }
        }

        // Set click listeners for all buttons
        val buttons = listOf(
            binding.btn0, binding.btn1, binding.btn2, binding.btn3, binding.btn4,
            binding.btn5, binding.btn6, binding.btn7, binding.btn8, binding.btn9,
            binding.btnPoint, binding.btnStartBracket, binding.btnClosetBracket,
            binding.btnAdd, binding.btnMinus, binding.btnMulti, binding.btnDivide
        )

        for (button in buttons) {
            button.setOnClickListener {
                appendToInput((it as androidx.appcompat.widget.AppCompatButton).text.toString())
            }
        }

        binding.btnC.setOnClickListener {
            binding.tvInputText.text =""
            binding.tvOutPutText.text =""
        }
        binding.btnX.setOnClickListener {

            val currentText = binding.tvInputText.text.toString()
            if (currentText.isNotEmpty()) {
                binding.tvInputText.text = currentText.substring(0, currentText.length - 1)
            }

        }
        binding.btnEqual.setOnClickListener {
            evaluateExpression()
        }
    }
}
