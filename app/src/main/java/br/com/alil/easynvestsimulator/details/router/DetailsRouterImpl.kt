package br.com.alil.easynvestsimulator.details.router

import android.app.Activity

class DetailsRouterImpl(var activity: Activity?) : DetailsRouter {

    override fun goBackToMain() {
        activity?.let {
            it.setResult(Activity.RESULT_OK, it.intent)
            it.finish()
        }
    }

    override fun unregister() {
        activity = null
    }

}