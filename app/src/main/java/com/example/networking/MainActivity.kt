package com.example.networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val okhttpClient = OkHttpClient()

        val request = Request.Builder()
            .url("https://api.github.com/users/username")
            .build()

        GlobalScope.launch(Dispatchers.Main) {
            val response =  withContext(Dispatchers.IO){okhttpClient.newCall(request).execute().body?.string()}
            val obj = JSONObject(response)
            val image = obj.getString("avatar_url")
            val name = obj.getString("name")
            val login = obj.getString("login")
            textView.text = name
            textView1.text = login


        }


    }
}