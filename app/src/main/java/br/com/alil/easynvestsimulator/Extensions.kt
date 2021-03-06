package br.com.alil.easynvestsimulator

import android.app.Activity
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import br.com.alil.easynvestsimulator.details.view.DetailsActivity
import br.com.alil.easynvestsimulator.domain.model.SimulateResponse
import java.text.ParseException
import java.text.SimpleDateFormat


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
    tag = "hasTextChangedListener"
}

fun String.isDateValid() : Boolean {
    val sdf = SimpleDateFormat("dd/MM/yyyy")
    sdf.isLenient = false

    try {
        val date = sdf.parse(this)
        System.out.println(date)
    } catch (e: ParseException) {
        e.printStackTrace()
        return false
    }

    return true
}

fun String.convertDateToAPIFormat() : String {
    val originalFormat = SimpleDateFormat("dd/MM/yyyy")
    val targetFormat = SimpleDateFormat("yyyy/MM/dd")
    return try {
        val date = originalFormat.parse(this)
        targetFormat.format(date)
    } catch (ex: ParseException) {
        // Handle Exception.
        ""
    }
}

fun String.convertDateToHumanFormat() : String {
    val targetFormat = SimpleDateFormat("dd/MM/yyyy")
    val originalFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    return try {
        val date = originalFormat.parse(this)
        targetFormat.format(date)
    } catch (ex: ParseException) {
        // Handle Exception.
        ""
    }
}