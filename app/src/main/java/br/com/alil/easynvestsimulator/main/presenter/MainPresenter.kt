package br.com.alil.easynvestsimulator.main.presenter

interface MainPresenter {

    fun onActivityCreated()
    fun onSimulateClicked(investedAmout: String, maturityDate: String, rate: String)
    fun unregister()

}