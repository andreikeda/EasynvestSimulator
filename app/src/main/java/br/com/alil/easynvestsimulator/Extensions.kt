package br.com.alil.easynvestsimulator

import android.app.Activity
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import br.com.alil.easynvestsimulator.details.view.DetailsActivity
import br.com.alil.easynvestsimulator.domain.model.SimulateResponse
import android.databinding.adapters.TextViewBindingAdapter.setText
import java.util.*
import java.util.Collections.replaceAll



const val EXTRA_SIMULATE = "e_simulate"

const val RC_SIMULATE_AGAIN = 1010

fun Activity.startDetailsActivity(result: SimulateResponse) {
    val intent = Intent(this, DetailsActivity::class.java).apply {
        putExtra(EXTRA_SIMULATE, result)
    }
    startActivityForResult(
            intent,
            RC_SIMULATE_AGAIN)
}

fun EditText.addDateTextChangeListener() {
    val mDateEntryWatcher = object : TextWatcher {

        var edited = false
        val dividerCharacter = "/"

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            if (edited) {
                edited = false
                return
            }

            var working = getEditText()

            working = manageDateDivider(working, 2, start, before)
            working = manageDateDivider(working, 5, start, before)

            edited = true
            setText(working)
            setSelection(text.length)
        }

        private fun manageDateDivider(working: String, position : Int, start: Int, before: Int) : String{
            if (working.length == position) {
                return if (before <= position && start < position)
                    working + dividerCharacter
                else
                    working.dropLast(1)
            }
            return working
        }

        private fun getEditText() : String {
            return if (text.length >= 10)
                text.toString().substring(0,10)
            else
                text.toString()
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
    }
    addTextChangedListener(mDateEntryWatcher)
    /*
    var current = ""
    val ddmmyyyy = "DDMMYYYY"
    val cal = Calendar.getInstance()

    addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) { }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (s.toString() != current) {
                var clean = s.toString().replace("[^\\d.]|\\.", "")
                val cleanC = current.replace("[^\\d.]|\\.", "")

                val cl = clean.length
                var sel = cl
                var i = 2
                while (i <= cl && i < 6) {
                    sel++
                    i += 2
                }
                //Fix for pressing delete next to a forward slash
                if (clean == cleanC) sel--

                if (clean.length < 8) {
                    clean += ddmmyyyy.substring(clean.length)
                } else {
                    //This part makes sure that when we finish entering numbers
                    //the date is correct, fixing it otherwise
                    var day = Integer.parseInt(clean.substring(0, 2))
                    var mon = Integer.parseInt(clean.substring(2, 4))
                    var year = Integer.parseInt(clean.substring(4, 8))

                    mon = if (mon < 1) 1 else if (mon > 12) 12 else mon
                    cal.set(Calendar.MONTH, mon - 1)
                    year = if (year < 1900) 1900 else if (year > 2100) 2100 else year
                    cal.set(Calendar.YEAR, year)
                    // ^ first set year for the line below to work correctly
                    //with leap years - otherwise, date e.g. 29/02/2012
                    //would be automatically corrected to 28/02/2012

                    day = if (day > cal.getActualMaximum(Calendar.DATE)) cal.getActualMaximum(Calendar.DATE) else day
                    clean = String.format("%02d%02d%02d", day, mon, year)
                }

                clean = String.format("%s/%s/%s", clean.substring(0, 2),
                        clean.substring(2, 4),
                        clean.substring(4, 8))

                sel = if (sel < 0) 0 else sel
                current = clean
                setText(current)
                setSelection(if (sel < current.length) sel else current.length)
            }
        }
    })
    */
}