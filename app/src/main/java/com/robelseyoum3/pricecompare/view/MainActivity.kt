package com.robelseyoum3.pricecompare.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.robelseyoum3.pricecompare.R
import com.robelseyoum3.pricecompare.di.DaggerAppComponent
import com.robelseyoum3.pricecompare.di.NetworkModule
import com.robelseyoum3.pricecompare.di.RepositoryModule
import com.robelseyoum3.pricecompare.model.Product
import com.robelseyoum3.pricecompare.viewmodel.ProductViewModel
import com.robelseyoum3.pricecompare.viewmodel.ProductViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.product_row.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var productViewModelFactory: ProductViewModelFactory
    lateinit var viewModel: ProductViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDependencies()

        viewModel = ViewModelProviders.of(this, productViewModelFactory).get(ProductViewModel::class.java)
        viewModel.getAllProductData()

        viewModel.returnAllProductsResult().observe(this, Observer<List<Product>> { t -> allDataAdapter(t)})

        viewModel.returnProgressBarValue().observe(this, Observer {
            if(it == true){
                progress_id_main.visibility = View.VISIBLE
            } else {
                progress_id_main.visibility = View.GONE
            }
        })

        viewModel.retunError().observe(this, Observer {
            if(it == true){
                error_message_container.visibility = View.VISIBLE
            } else {
                error_message_container.visibility = View.GONE
            }
        })

    }
    //https://demonuts.com/kotlin-recyclerview-checkbox/
    //https://material.io/components/selection-controls/#usage

    private fun allDataAdapter(t: List<Product>) {

        var temp1 : String? = null
        var temp2 : String? = null

        val adaptor = ProductsAdaptor(this,t)
        /*(,
            object : OnCheckedClickListener {
                override fun checkBoxClicked(isChecked: Boolean, pId: String, price: String) {
                    if(isChecked && numberOfCheckboxesChecked >= 2){
                        cbID.isChecked = false
                        btn_compare_id.isEnabled = false

                    } else {
                        if (isChecked){
                            numberOfCheckboxesChecked + 1
                            Toast.makeText(applicationContext,pId,Toast.LENGTH_SHORT).show()

                        } else
                            numberOfCheckboxesChecked - 1
                    }
                }

            })
        */
        rView.layoutManager = LinearLayoutManager(this)
        rView.adapter = adaptor
    }

    private fun getDependencies() {

        DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .repositoryModule(RepositoryModule())
            .build()
            .inject(this)
    }
}
