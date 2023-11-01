package com.denizdogan.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.denizdogan.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private lateinit var details : TextView
    private lateinit var bigNumber : TextView

    private lateinit var button0 : Button
    private lateinit var button1 : Button
    private lateinit var button2 : Button
    private lateinit var button3 : Button
    private lateinit var button4 : Button
    private lateinit var button5 : Button
    private lateinit var button6 : Button
    private lateinit var button7 : Button
    private lateinit var button8 : Button
    private lateinit var button9 : Button

    private lateinit var buttonPoint : Button
    private lateinit var buttonPercentage : Button
    private lateinit var buttonSignConverter : Button
    private lateinit var buttonClear : Button
    private lateinit var buttonEqual : Button

    private lateinit var buttonPlus : Button
    private lateinit var buttonMinus : Button
    private lateinit var buttonTimes : Button
    private lateinit var buttonSlash : Button

    private lateinit var processHolder : CalculatorProcessHolder

    private var mergedNumbers : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAllViewIDs()
        clearAllTextViews()
        processHolder = CalculatorProcessHolder.getInstance()


    }





    private fun pressedNumberButton(number: CharSequence){

        mergedNumbers += number.toString()
        bigNumber.text = mergedNumbers

    }

    private fun pressedSignButton(sign : Char){

        if(processHolder.whichOperation == '\u0000'){
            processHolder.item1 = mergedNumbers.toDouble()
            println("başarılı bir şekilde alındı ${processHolder.item1}")
            bigNumber.text = ""
            mergedNumbers = ""
            processHolder.whichOperation = sign.lowercaseChar()

        }
        else{
            processHolder.item2 = mergedNumbers.toDouble()
            println("Saçmalıyor şuan")
            println("aslında işlem bu sayı ile ${processHolder.item1} ile ${processHolder.item2} arasında ve işlem de ${processHolder.whichOperation}")
            buttonClear.text = "C"
        }


    }

    private fun pressedEqualButton(){

        if(processHolder.whichOperation != '\u0000'){
            pressedSignButton(processHolder.whichOperation)
            var result = processHolder.resultForDouble
            details.text = processHolder.item1.toString() + " " + processHolder.whichOperation + " " + processHolder.item2.toString() + " = " + result
            bigNumber.text = result.toString()
        }

        else {
            println("Once sayı girmelisin")
        }
    }

    private fun pressedClearButton(){

        if(buttonClear.text == "C"){
            mergedNumbers = ""
            processHolder.item2 = 0.0
            bigNumber.text = ""
            buttonClear.text = "AC"
        }

        else if (buttonClear.text == "AC"){
            mergedNumbers = ""
            processHolder.item1 = 0.0
            processHolder.item2 = 0.0
            processHolder.whichOperation = '\u0000'
            bigNumber.text = ""
        }

    }

    fun pressedPointButton(){

    }

    fun pressedSignConverterButton(){

    }

    fun pressedPercentageButton(){

    }

    private fun clearAllTextViews(){
        details.text = ""
        bigNumber.text = ""
    }

    fun actionPerformed(view : View){
        when(view){
            button0 -> pressedNumberButton(button0.text)
            button1 -> pressedNumberButton(button1.text)
            button2 -> pressedNumberButton(button2.text)
            button3 -> pressedNumberButton(button3.text)
            button4 -> pressedNumberButton(button4.text)
            button5 -> pressedNumberButton(button5.text)
            button6 -> pressedNumberButton(button6.text)
            button7 -> pressedNumberButton(button7.text)
            button8 -> pressedNumberButton(button8.text)
            button9 -> pressedNumberButton(button9.text)

            buttonMinus -> pressedSignButton(buttonMinus.text[0])
            buttonPlus -> pressedSignButton(buttonPlus.text[0])
            buttonTimes -> pressedSignButton(buttonTimes.text[0])
            buttonSlash -> pressedSignButton(buttonSlash.text[0])

            buttonEqual -> pressedEqualButton()
            buttonClear -> pressedClearButton()

        }
    }

    private fun setAllViewIDs() {

        button0 = binding.zero
        button1 = binding.one
        button2 = binding.two
        button3 = binding.three
        button4 = binding.four
        button5 = binding.five
        button6 = binding.six
        button7 = binding.seven
        button8 = binding.eight
        button9 = binding.nine
        buttonPoint = binding.point
        buttonPercentage = binding.percentage
        buttonSignConverter = binding.signConverter
        buttonClear = binding.c
        buttonEqual = binding.equal
        buttonPlus = binding.plus
        buttonMinus = binding.minus
        buttonTimes = binding.times
        buttonSlash = binding.slash
        details = binding.detailsOperation
        bigNumber = binding.bigNum

    }
}