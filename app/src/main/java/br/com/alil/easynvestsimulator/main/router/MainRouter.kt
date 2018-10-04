package br.com.alil.easynvestsimulator.main.router

import br.com.alil.easynvestsimulator.domain.model.SimulateResponse

interface MainRouter {

    fun goToDetails(result: SimulateResponse)
    fun unregister()

}