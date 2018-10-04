package br.com.alil.easynvestsimulator

import android.app.Activity
import android.content.Intent
import br.com.alil.easynvestsimulator.details.view.DetailsActivity
import br.com.alil.easynvestsimulator.domain.model.SimulateResponse

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