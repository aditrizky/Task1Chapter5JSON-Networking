package com.binar.jsonsample.service

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.binar.jsonsample.HomeFragmentDirections
import com.binar.jsonsample.databinding.ItemViewBinding
import com.binar.jsonsample.model.getAllCarResponseItem
import com.bumptech.glide.Glide

class MainAdapter(private val onItemClick : OnClickListener):
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<getAllCarResponseItem>(){
        override fun areContentsTheSame(
            oldItem: getAllCarResponseItem,
            newItem: getAllCarResponseItem
        ): Boolean = oldItem.id == newItem.id

        override fun areItemsTheSame(
            oldItem: getAllCarResponseItem,
            newItem: getAllCarResponseItem
        ): Boolean = oldItem.hashCode() == newItem.hashCode()
    }
    private  val differ= AsyncListDiffer(this, diffCallback)

    fun submitData(value: List<getAllCarResponseItem>?)= differ.submitList(value)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemViewBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        val data = differ.currentList[position]
        data.let { holder.bind(data) }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private  val binding : ItemViewBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(data : getAllCarResponseItem){
            binding.apply {
                nameTextView.text = data.name
                priceTextView.text="Rp."+data.price.toString()

                Glide.with(itemView.context)
                    .load(data.image)
                    .into(binding.imageView)


                root.setOnClickListener {
                    onItemClick.onClickItem(data)
                }
                itemView.setOnClickListener {
                    val objectCar = getAllCarResponseItem(
                        name = data.name,
                        price = data.price,
                        category = data.category,
                        image = data.image
                    )

                    it.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(objectCar))
                }
            }
        }
    }
        interface OnClickListener{
            fun onClickItem(data: getAllCarResponseItem)
        }
}