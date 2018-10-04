package br.com.alil.easynvestsimulator.main.interactor

interface MainInteractor {

    fun simulate(investedAmout: Double, rate: Int, maturityDate: String)
    fun unregister()

}