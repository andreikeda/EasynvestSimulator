package br.com.alil.easynvestsimulator.main.router

import android.app.Activity
import br.com.alil.easynvestsimulator.domain.model.SimulateResponse

class MainRouterImpl(var activity: Activity?) : MainRouter {

    override fun goToDetails(result: SimulateResponse) {
    }

    override fun unregister() {
        activity = null
    }

}