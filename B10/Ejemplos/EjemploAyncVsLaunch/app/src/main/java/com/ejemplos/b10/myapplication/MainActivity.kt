package com.ejemplos.b10.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.launch).setOnClickListener { GFG() }
        findViewById<Button>(R.id.async).setOnClickListener { GFGA() }
    }

    fun GFG()
    {
        var resultOne = "Android"
        var resultTwo = "Kotlin"
        Log.i("Launch", "Before")
        CoroutineScope(Dispatchers.IO).launch {  resultOne = function1() }
        CoroutineScope(Dispatchers.IO).launch { resultTwo = function2() }
        Log.i("Launch", "After")
        val resultText = resultOne + resultTwo
        Log.i("Launch", resultText)
    }

    suspend fun function1(): String
    {
        delay(1000L)
        val message = "function1"
        Log.i("Launch", message)
        return message
    }

    suspend fun function2(): String
    {
        delay(100L)
        val message = "function2"
        Log.i("Launch", message)
        return message
    }
     fun GFGA()
    {
        Log.i("Async", "Before")
        val resultOne = CoroutineScope(Dispatchers.IO).async{ function1A() }
        val resultTwo = CoroutineScope(Dispatchers.IO).async{ function2A() }
        Log.i("Async", "After")
        CoroutineScope(Dispatchers.IO).launch {
            val resultText = resultOne.await() + resultTwo.await()
            Log.i("Async", resultText)
        }
    }

    suspend fun function1A(): String
    {
        delay(1000L)
        val message = "function1"
        Log.i("Async", message)
        return message
    }

    suspend fun function2A(): String
    {
        delay(100L)
        val message = "function2"
        Log.i("Async", message)
        return message
    }
}