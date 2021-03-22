package com.example.estados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val estados = arrayOf<String>(
        "Acre - AC",
        "Alagoas - AL",
        "Amapá - AM",
        "Bahia - BA",
        "Ceará - CE",
        "Distrito Federal - DF",
        "Espírito Santo - ES",
        "Goiás - GO",
        "Maranhão - MA",
        "Mato Grosso - MT",
        "Mato Grosso do Sul - MS",
        "Minas Gerais - MG",
        "Pará - PA",
        "Paraíba - PB",
        "Paraná - PA",
        "Pernambuco - PE",
        "Piauí - PI",
        "Rio de Janeiro - RJ",
        "Rio Grande do Norte - RN",
        "Rio Grande do Sul - RS",
        "Rondônia - RO",
        "Roraima - RR",
        "Santa Catarina - SC",
        "São Paulo - SP",
        "Sergipe - SE",
        "Tocantins - TO"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter =  ArrayAdapter(this, android.R.layout.simple_list_item_1, estados)

        lstEstados.adapter = adapter

        lstEstados.setOnItemClickListener{ parent, view, position, id ->
            Toast.makeText(this, estados[position], Toast.LENGTH_SHORT).show()
        }
    }
}