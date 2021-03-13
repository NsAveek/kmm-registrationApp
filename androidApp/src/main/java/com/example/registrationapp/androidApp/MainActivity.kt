package com.example.registrationapp.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrationapp.shared.Greeting
import android.widget.TextView
import android.widget.Toast
import com.example.registrationapp.shared.network.ServiceApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    private val mainScope = MainScope()
    private val api = ServiceApi()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
        mainScope.launch {
            kotlin.runCatching{
                api.getUser("user4@test.com")
            }.onSuccess{
                Toast.makeText(this@MainActivity, it.mobile, Toast.LENGTH_SHORT).show()
            }.onFailure{
                Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}
