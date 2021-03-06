package br.com.alil.easynvestsimulator.main.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.alil.easynvestsimulator.R
import br.com.alil.easynvestsimulator.addDateTextChangeListener
import br.com.alil.easynvestsimulator.details.view.DetailsActivity
import br.com.alil.easynvestsimulator.main.presenter.MainPresenter
import br.com.alil.easynvestsimulator.main.presenter.MainPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenterImpl(this)
        presenter?.onActivityCreated()
    }

    override fun onDestroy() {
        presenter?.unregister()
        presenter = null

        super.onDestroy()
    }

    override fun configureViews() {
        bt_simulate.setOnClickListener {
            presenter?.onSimulateClicked(et_first_input.text.toString(), et_second_input.text.toString(), et_third_input.text.toString())
        }
        et_second_input.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus && et_second_input.tag == "empty") {
                et_second_input.addDateTextChangeListener()
            }
        }
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }

    override fun showError(errorResId: Int) {
        Toast.makeText(this, errorResId, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }
}
