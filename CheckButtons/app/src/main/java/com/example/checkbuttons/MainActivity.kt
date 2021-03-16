package com.example.checkbuttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import kotlinx.android.synthetic.main.*;
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itensSpinner = arrayOf<String>("Selecione", "Residencial", "Comercial", "Celular", "Outro")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itensSpinner)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerTipoTelefone.adapter = adapter

        btnMostrarMensagem.setOnClickListener{
            if (campoValidos()){
                var msg = """Nome: ${txtNome.text}
                |Telefone: ${txtTelefone.text}
                |Tipo Telefone: ${spinnerTipoTelefone.selectedItem}
                |Email: ${txtEmail.text}
                |Preferências de Contato:
                """.trimMargin()


                if (cbTelefone.isChecked){
                    msg += "\n - Telefone"
                }

                if (cbEmail.isChecked){
                    msg += "\n - Email"
                }

                alert("Boas vindas", msg)
            }
        }



    }

    fun campoValidos(): Boolean{
        if (txtNome.text.trim().isEmpty() || txtEmail.text.trim().isEmpty()
            || spinnerTipoTelefone.selectedItemPosition == 0
            || txtTelefone.text.trim().isEmpty()){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            return false;
        }
        return true;
    }

    fun alert(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title).setMessage(message).setPositiveButton("Ok", null)
        builder.create().show()
    }
}
