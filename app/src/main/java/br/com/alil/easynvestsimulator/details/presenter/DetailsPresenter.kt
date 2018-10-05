package br.com.alil.easynvestsimulator.details.presenter

import br.com.alil.easynvestsimulator.domain.model.SimulateResponse

interface DetailsPresenter {

    fun onActivityCreated(response: SimulateResponse?)
    fun onSimulateAgainClicked()
    fun unregister()

}