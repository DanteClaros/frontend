package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.estructuresDades.Usuari
import com.example.myapplication.estructuresDades.UsuarisProvider
import com.example.myapplication.retrofit.APIService
import com.example.myapplication.usuarisrv.UsuarisRvAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder
import androidx.appcompat.widget.SearchView;

class UsuarisActivity : AppCompatActivity() {
    //it takes list of providers
    var llistaUsuaris: MutableList<Usuari> = UsuarisProvider.usuaris
    private lateinit var usuarisRvAdapter: UsuarisRvAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuaris)

        /*var llista_extres = intent.extras
        var nom = llista_extres?.get("NOM_PARAMETRE")
        print("Nom parametre:" + nom);

        var textView = findViewById<TextView>(R.id.nom_usuari)
        textView.text = getString(R.string.benvinguda) + nom*/

        val rv_usuaris = findViewById<RecyclerView>(R.id.rv_usuaris)
        rv_usuaris.layoutManager = LinearLayoutManager(this)

        usuarisRvAdapter = UsuarisRvAdapter(llistaUsuaris)
        rv_usuaris.adapter = usuarisRvAdapter


        //COROUTINESCOPE
        /*lifecycleScope.launch(Dispatchers.Default) {
            val connexio = Retrofit.Builder().baseUrl("http://localhost:80/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            withContext(Dispatchers.IO) {
                var resposta = connexio.create(APIService::class.java).getAboutTheTeam("api/getAboutTheTeam")*/


            //CoroutineScope(Dispatchers.IO).launch

            lifecycleScope.launch(Dispatchers.IO){
                val connexio = Retrofit.Builder().baseUrl("http://10.0.2.2:80/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                var resposta = connexio.create(APIService::class.java)
                   // .getUsuaris("getsearchview/usuarisget.php")
                    .getUsuaris("/api/getAboutTheTeam")

                withContext(Dispatchers.Main) {
                    if (resposta.isSuccessful) {//if resposta is successful
                        val nousUsuaris = resposta.body()
                            ?: emptyList()//if it doesnt return everything then it creates an empty list
                        llistaUsuaris.clear()
                        llistaUsuaris.addAll(nousUsuaris)
                        usuarisRvAdapter.notifyDataSetChanged()
                    }
                }
            }



        var searchView = findViewById<SearchView>(R.id.svUsuaris) as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean { //when a user is writing
                return true;
            }

            override fun onQueryTextSubmit(query: String?): Boolean { //when the usuari press the submit
                if (!query?.isNullOrEmpty()!!) {//if the query is not null or empty
                    getUsuarisFiltreNom(query)//it does a petition
                }
                return true;
            }
        })}
        fun getUsuarisFiltreNom(query: String) {
            lifecycleScope.launch(Dispatchers.IO) {
                //val connexio = Retrofit.Builder().baseUrl("http://10.0.2.2:80/")
                val connexio = Retrofit.Builder().baseUrl("http://10.0.2.2:80/getSearchView/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                var resposta = connexio.create(APIService::class.java)
                    .getValues("clients",query)
                    //.getUsuaris("getSearchView/usuarisGET.php")
                    //.getUsuaris("/api/getAboutTheTeam")

                withContext(Dispatchers.Main) {
                    if (resposta.isSuccessful) {//if resposta is successful
                        val nousUsuaris = resposta.body()
                            ?: emptyList()//if it doesnt return everything then it creates an empty list
                        llistaUsuaris.clear()
                        llistaUsuaris.addAll(nousUsuaris)
                        usuarisRvAdapter.notifyDataSetChanged()
                    }
                }
            }

        }
    }


