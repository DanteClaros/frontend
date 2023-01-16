package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.estructuresDades.LoginUsuari
import com.example.myapplication.estructuresDades.Rutes
import com.example.myapplication.estructuresDades.Usuari
import com.example.myapplication.retrofit.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//import kotlinx.button.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSecAct = findViewById<Button>(R.id.button)
        buttonSecAct.setOnClickListener {
            val intent = Intent(this, UsuarisActivity::class.java)
            startActivity(intent)
        }




    }
    fun postLoginUsuari(view:View){
        val inputLogin = findViewById<EditText>(R.id.et_login_usuari)
        val inputPass = findViewById<EditText>(R.id.et_login_pass)

        val nomLogin = inputLogin.text.toString()
        val passLogin = inputPass.text.toString()
print("LOGIN"+nomLogin);
        CoroutineScope(Dispatchers.IO).launch {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            val con = Retrofit.Builder().baseUrl(Rutes.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            var resposta = con.create(APIService::class.java).postLogin("login",LoginUsuari(nomLogin, passLogin))
            if (resposta.isSuccessful){
                println("Obtenim la resposta!")
                //var usuari = resposta.body()?: Usuari("", "", "", "")
                println(resposta.body())
            }else{
                println(
                    resposta.errorBody()?.string()
                )
            }
        }

    }
}