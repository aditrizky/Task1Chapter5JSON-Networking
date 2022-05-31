package com.binar.jsonsample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.binar.jsonsample.Presenter.GetAllCarsContract
import com.binar.jsonsample.Presenter.GetAllCarsPresenter
import com.binar.jsonsample.databinding.FragmentHomeBinding
import com.binar.jsonsample.model.getAllCarResponseItem
import com.binar.jsonsample.service.MainAdapter


class HomeFragment : Fragment() ,GetAllCarsContract.viewInterface{
//    private val viewModel : MainViewModel by activityViewModels()
    private var _binding : FragmentHomeBinding?=null
    private val binding : FragmentHomeBinding get() = _binding!!
    private var code: Int = 0
    private var presenter= GetAllCarsPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        presenter?.getAllCars()
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToRegisterFragment())
        }
    }

    override fun showResult(result: List<getAllCarResponseItem>?) {
        Log.d("testingg", result.toString())
        showList(result)
    }

    override fun showCode(code: Int) {
        Log.d("testing", code.toString())
        if (code==200){
            binding.progressBar2.visibility=View.GONE
        }
    }


    private fun showList(data : List<getAllCarResponseItem>?) {

    val adapter = MainAdapter(object : MainAdapter.OnClickListener {
        override fun onClickItem(data: getAllCarResponseItem) {
        }

    })
    adapter.submitData(data)
    binding.recycleview.adapter = adapter
}


}