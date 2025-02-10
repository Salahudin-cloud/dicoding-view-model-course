package com.example.dicoding_view_model_course

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.dicoding_view_model_course.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        displayResult()

        binding.btnCalculate.setOnClickListener{
            val width = binding.edtWidth.text.toString()
            val height = binding.edtHeight.text.toString()
            val length = binding.edtLength.text.toString()

            when {
                width.isEmpty() -> {
                    binding.edtWidth.error = "Still Empty"
                }
                height.isEmpty() -> {
                    binding.edtWidth.error = "Still Empty"
                }
                length.isEmpty() -> {
                    binding.edtWidth.error = "Still Empty"
                }
                else -> {
                    viewModel.calculate(width,height,length)
                    displayResult()
                }
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun displayResult() {
        binding.tvResult.text = viewModel.result.toString()
    }
}