package br.com.alil.easynvestsimulator.main.presenter

import br.com.alil.easynvestsimulator.domain.model.SimulateResponse

interface MainInteractorOutput {

    fun onSimulateError(errorMessage: String)
    fun onSimulateSuccess(response: SimulateResponse)

}