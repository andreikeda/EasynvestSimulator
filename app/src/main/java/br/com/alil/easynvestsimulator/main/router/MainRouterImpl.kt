package br.com.alil.easynvestsimulator.main.router

import android.app.Activity
import br.com.alil.easynvestsimulator.domain.model.SimulateResponse
import br.com.alil.easynvestsimulator.startDetailsActivity

class MainRouterImpl(var activity: Activity?) : MainRouter {

    override fun goToDetails(result: SimulateResponse) {
        activity?.startDetailsActivity(result)
    }

    override fun unregister() {
        activity = null
    }

}