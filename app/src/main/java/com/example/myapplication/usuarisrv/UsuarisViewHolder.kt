package com.example.myapplication.usuarisrv

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.myapplication.R
import com.example.myapplication.estructuresDades.Usuari

class UsuarisViewHolder (view: View):RecyclerView.ViewHolder(view){
    val imageview = view.findViewById<ImageView>(R.id.imageview)
    val tv_rv_nom = view.findViewById<TextView>(R.id.tv_rv_nom)
    val tv_rv_cognom = view.findViewById<TextView>(R.id.tv_rv_cognom)
    val tv_rv_role = view.findViewById<TextView>(R.id.tv_rv_role)


    fun printUsuari(usuari: Usuari){
        Glide.with(imageview.context).load(usuari.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop().into(imageview)
        tv_rv_nom.text = usuari.nom
        tv_rv_cognom.text = usuari.cognom
        tv_rv_role.text = usuari.role

        /*fun printUsuari(usuari: Usuari){
        Glide.with(imageview.context).load("http://localhost/api/getAboutTheTeam" + usuari.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop().into(imageview)
        tv_rv_nom.text = usuari.nom
        tv_rv_cognom.text = usuari.cognom*/




    }
   /* val tv_rv_nom = view.findViewById<TextView>(R.id.tv_rv_nom)
    val tv_rv_cognom = view.findViewById<TextView>(R.id.tv_rv_cognom)
    val imageview = view.findViewById<ImageView>(R.id.imageview)

    fun printUsuari(usuari: Usuari){
        imageview.imageAlpha = usuari.image
        tv_rv_nom.text = usuari.nom
        tv_rv_cognom.text = usuari.cognom

    }*/

}