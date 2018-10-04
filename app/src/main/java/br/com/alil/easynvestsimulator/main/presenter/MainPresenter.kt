package br.com.alil.easynvestsimulator.main.presenter

interface MainPresenter {

    fun onSimulateClicked(investedAmout: String, rate: String, maturityDate: String)
    fun unregister()

}