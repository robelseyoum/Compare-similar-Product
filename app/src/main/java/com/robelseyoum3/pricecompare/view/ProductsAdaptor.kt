package com.robelseyoum3.pricecompare.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.robelseyoum3.pricecompare.R
import com.robelseyoum3.pricecompare.model.Product
import kotlinx.android.synthetic.main.product_row.view.*

class ProductsAdaptor (private val ctx: Context, val product: List<Product>): RecyclerView.Adapter<ProductsAdaptor.ProductsViewHolder>(){

    private var temp1 : String? = null
    private var temp2 : String? = null
    private val numberOfCheckboxesChecked = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        return ProductsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false))
    }

    override fun getItemCount(): Int {
        return product.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {

        holder.productID.text = product[position].pId
        holder.productName.text = product[position].productName
        holder.productPrice.text = product[position].price.amount.rate

        holder.productID.tag = position
//
//        holder.productID.setOnClickListener {
//            overide onCheckedChanged()
//            Toast.makeText(ctx,product[position].pId,Toast.LENGTH_SHORT).show()
//        }

        holder.productID.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked && numberOfCheckboxesChecked >=2){
                holder.productID.isEnabled = false
            } else {
                if(isChecked){
                    var num1 =numberOfCheckboxesChecked.inc()
                    Toast.makeText(ctx,num1.toString(),Toast.LENGTH_SHORT).show()
                } else {
                    var num2 = numberOfCheckboxesChecked.dec()
                    Toast.makeText(ctx,num2.toString(),Toast.LENGTH_SHORT).show()

                }
            }
        }

    }


    class ProductsViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val productID: CheckBox = view.cbID
        val productName: TextView = view.tvProductName
        val productPrice: TextView = view.tvProductPrice


        /*
        fun bind(product: Product, listner: OnCheckedClickListener){

            itemView.setOnClickListener {
                listner.checkBoxClicked(isChecked=false, price = product.pId,
                    pId = product.price.amount.rate
                )
            }
        } */
    }
}


interface OnCheckedClickListener{
    fun checkBoxClicked(isChecked : Boolean, pId: String, price: String)
}