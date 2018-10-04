package br.com.alil.easynvestsimulator.main.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.alil.easynvestsimulator.R
import br.com.alil.easynvestsimulator.main.presenter.MainPresenter
import br.com.alil.easynvestsimulator.main.presenter.MainPresenterImpl

class MainActivity : AppCompatActivity(), MainView {

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenterImpl(this)
    }

    override fun onDestroy() {
        presenter?.unregister()

        super.onDestroy()
    }

    override fun hideLoading() {
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
    }
}
