package com.example.sorteardados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.*;
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Desafio 04 - Jogo de Dados")
        setContentView(R.layout.activity_main)

        btnJogar.setOnClickListener{
            val numJog1 = sortear();
            val numJog2 = sortear();

            setImageResource(numJog1, imgViewJog1)
            setImageResource(numJog2, imgViewJog2)

            var winner: String;

            if (numJog1 > numJog2){
                winner = "O jogador 1 ganhou!"
            } else if (numJog2 > numJog1){
                winner = "O jogador 2 ganhou!"
            } else{
                winner = "Empate!"
            }

            Toast.makeText(this, winner, Toast.LENGTH_SHORT).show()
        }
    }



    fun sortear(): Int{
        return Random.nextInt(1, 7)
    }

    fun setImageResource(num: Int, image: ImageView){
        val resource = when (num){
            1 -> R.drawable.face1
            2 -> R.drawable.face2
            3 -> R.drawable.face3
            4 -> R.drawable.face4
            5 -> R.drawable.face5
            6 -> R.drawable.face6
            else -> R.drawable.face1

        }
        image.setImageResource(resource)
    }

}