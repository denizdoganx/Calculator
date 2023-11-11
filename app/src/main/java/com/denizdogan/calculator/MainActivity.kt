package com.denizdogan.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
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
            if(mergedNumbers != ""){
                processHolder.item1 = mergedNumbers.toDouble()
                bigNumber.text = ""
                mergedNumbers = ""
                processHolder.whichOperation = sign.lowercaseChar()
            }
        }
        else{
            processHolder.item2 = mergedNumbers.toDouble()
        }


    }

    private fun pressedEqualButton(){

        if(processHolder.whichOperation != '\u0000'){
            pressedSignButton(processHolder.whichOperation)
            var result = processHolder.result
            details.text =  formatString(processHolder.item1.toString()) + " " + processHolder.whichOperation + " " + formatString(processHolder.item2.toString()) + " = " + result
            bigNumber.text = result.toString()

            mergedNumbers = processHolder.result.toString()
            processHolder.item1 = 0.0
            processHolder.item2 = 0.0
            processHolder.whichOperation = '\u0000'

        }
    }

    private fun formatString(str : String) : String {
        var areTheyAllZero = true
        var pointFound = false
        var pieceOfBeforePoint  = ""
        for(i in str.indices){
            if(!pointFound){
                if(str[i] == '.'){
                    pointFound = true
                    continue
                }
                else{
                    pieceOfBeforePoint += str[i]
                }
            }

            if(pointFound && str[i] != '0'){
                areTheyAllZero = false
            }
        }

        if(areTheyAllZero){
            return pieceOfBeforePoint
        }
        else{
            return str
        }
    }

    private fun pressedClearButton(){

        mergedNumbers = ""
        processHolder.item1 = 0.0
        processHolder.item2 = 0.0
        processHolder.whichOperation = '\u0000'
        bigNumber.text = ""
        details.text = ""
    }

    private fun pressedPointButton(number: CharSequence){
        mergedNumbers += number.toString()
        bigNumber.text = mergedNumbers
    }

    private fun pressedSignConverterButton(){

        var temp : String = mergedNumbers
        mergedNumbers = ""

        if(temp.startsWith('-')){
            mergedNumbers = temp.substring(1);
        }
        else{
            mergedNumbers += "-"
            mergedNumbers += temp
        }

        bigNumber.text = mergedNumbers
    }

    private fun pressedPercentageButton(){
        var doubleFormatOfMergedNumbers = mergedNumbers.toDoubleOrNull()

        if(doubleFormatOfMergedNumbers != null){
            doubleFormatOfMergedNumbers /= 100
        }

        mergedNumbers = doubleFormatOfMergedNumbers.toString()

        bigNumber.text = mergedNumbers
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
            buttonPoint -> pressedPointButton(buttonPoint.text)
            buttonSignConverter -> pressedSignConverterButton()
            buttonPercentage -> pressedPercentageButton()
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