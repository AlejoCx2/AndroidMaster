package com.alejocx2.androidmaster

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alejocx2.androidmaster.firstapp.FirstActivity
import com.alejocx2.androidmaster.imc.ImcActivity
import com.alejocx2.androidmaster.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSaludapp = findViewById<AppCompatButton>(R.id.btnSaludapp)
        btnSaludapp.setOnClickListener {
            navegateToSaludApp()
        }

        val btnIMC = findViewById<AppCompatButton>(R.id.btnIMC)
        btnIMC.setOnClickListener {
            navegateToIMC()
        }

        val btnTODO = findViewById<AppCompatButton>(R.id.btnTODO)
        btnTODO.setOnClickListener {
            navegateToTODO()
        }
    }

    private fun navegateToSaludApp() {
        val intent = Intent(this, FirstActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToIMC() {
        val intent = Intent(this, ImcActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToTODO() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }
}