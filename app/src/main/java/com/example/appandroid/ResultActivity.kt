package com.example.appandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_result.*
import okhttp3.*
import java.io.IOException
import java.lang.Exception

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        img02.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        fetchJson()
        textAPI.movementMethod = ScrollingMovementMethod()
    }

    fun fetchJson() {
        val URL = "https://www.reddit.com/r/androiddev.json?raw_json=1/"
        val request = Request.Builder().url(URL).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Toast.makeText(this@ResultActivity, "Erro ao fazer a requisição para o servidor", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val gson = Gson()
                val data = gson.fromJson(body, SerializedJson.First::class.java)
                for (x in 0 until data.data.dist) {
                    textAPI.append(data.data.children[x].data2.title + "\n\n")
                }
            }
        })
    }
}