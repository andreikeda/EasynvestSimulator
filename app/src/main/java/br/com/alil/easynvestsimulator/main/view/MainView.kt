package br.com.alil.easynvestsimulator.main.view

interface MainView {

    fun hideLoading()
    fun showError(errorMessage: String)
    fun showLoading()

}