package com.binar.jsonsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.binar.jsonsample.databinding.FragmentDetailBinding
import com.binar.jsonsample.databinding.FragmentHomeBinding
import com.bumptech.glide.Glide

class DetailFragment : Fragment() {
    private var _binding : FragmentDetailBinding?=null
    private val binding : FragmentDetailBinding get() = _binding!!
    val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Glide.with(requireContext())
            .load(args.data.image)
            .into(binding.carImageView)

        binding.deataiNameTextView.text= "Name   : "+ args.data.name.toString()
        binding.detailPriceTextView.text= "Price : Rp. "+args.data.price.toString()
        binding.categoryTextVeiw.text= "Category : "+args.data.category.toString()
    }

}