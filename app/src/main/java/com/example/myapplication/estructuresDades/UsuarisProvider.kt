package com.example.myapplication.estructuresDades

import com.example.myapplication.R

class UsuarisProvider {
    companion object{
        val usuaris = mutableListOf<Usuari>(
            Usuari("https://i.pinimg.com/564x/da/d4/6c/dad46c92bf8ff991bd749d0c021d412d.jpg",
                "Angelica Esquibal", "angel.esquibal2002@gmail.com", "Angelica Esquibal"),

            Usuari("https://i.pinimg.com/564x/44/98/d6/4498d6f3e73c0d20c638b07d395fc851.jpg",
                "Paolo Alvarez", "paolo.aa2003@gmail.com", "Back-end developer"),

            Usuari("https://i.pinimg.com/564x/d9/53/9a/d9539a8167a14b13a9f8ca2a2641b863.jpg",
                "Dante Claros", "chayelclaros@gmail.com", "Technical report manager"),
        )

    }
}