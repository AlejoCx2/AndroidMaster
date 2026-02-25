package com.alejocx2.androidmaster.firstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alejocx2.androidmaster.R

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Al arrancare la pantalla

        val etName = findViewById<AppCompatEditText>(R.id.etName)

        val btnFirst = findViewById<AppCompatButton>(R.id.btnFirst)
        btnFirst.setOnClickListener {

            val name = etName.text.toString()

            if (name.isNotEmpty()) {
                Log.i(
                    "AlejoCx2 Dev",
                    "Se preciono el boton.\nHola ${name}"
                )

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            } else {
                Log.i(
                    "AlejoCx2 Dev",
                    "Edit Text Vacio :("
                )
            }

        }

    }
}