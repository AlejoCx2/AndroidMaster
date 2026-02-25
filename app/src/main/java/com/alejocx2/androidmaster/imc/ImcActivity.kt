package com.alejocx2.androidmaster.imc

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alejocx2.androidmaster.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.security.KeyStore.TrustedCertificateEntry

class ImcActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 65
    private var currentAge: Int = 28
    private var currentHeight: Int = 120

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvWeight: TextView
    private lateinit var btnSubstractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnSubstractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var btnCalculate: Button

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportActionBar?.hide() //Oculta la ActionBar en la vista
        setContentView(R.layout.activity_imc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setGenderBackground()
        setHeight(currentHeight)
        setWeight()
        setAge()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.cdMale)
        viewFemale = findViewById(R.id.cdFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        btnSubstractWeight = findViewById(R.id.btnSubstractWeight)
        tvAge = findViewById(R.id.tvAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        btnSubstractAge = findViewById(R.id.btnSubstractAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderBackground()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderBackground()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            // Cosas de Kotlin que al formaatear con decimals y al ser 0 los decmales no los pone
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            setHeight(currentHeight)
        }

        btnSubstractWeight.setOnClickListener {
            if (currentWeight > 0) {
                currentWeight -= 1
            }
            setWeight()
        }
        btnPlusWeight.setOnClickListener {
            if (currentWeight < 200) {
                currentWeight += 1
            }
            setWeight()
        }

        btnSubstractAge.setOnClickListener {
            if (currentAge > 0) {
                currentAge -= 1
            }
            setAge()
        }
        btnPlusAge.setOnClickListener {
            if (currentAge < 99) {
                currentAge += 1
            }
            setAge()
        }

        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, resultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100)
        return df.format(imc).toDouble()
        // Log.i("AlejoCx2", "El IMC es $result")
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        tvWeight.text = "$currentWeight Kg"
    }

    private fun setHeight(height: Int) {
        tvHeight.text = "$height cm"
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderBackground() {
        getBackgroundColor(isMaleSelected)
        getBackgroundColor(isFemaleSelected)

        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.selected_component
        } else {
            R.color.component
        }

        return ContextCompat.getColor(this, colorReference)
    }
}