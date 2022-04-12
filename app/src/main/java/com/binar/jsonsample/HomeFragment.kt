package com.binar.jsonsample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.binar.jsonsample.databinding.FragmentHomeBinding
import com.binar.jsonsample.model.getAllCarResponseItem
import com.binar.jsonsample.service.ApiClient
import com.binar.jsonsample.service.MainAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding?=null
    private val binding : FragmentHomeBinding get() = _binding!!


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
        fetchData()
    }

    private fun fetchData(){
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<getAllCarResponseItem>>{
                override fun onResponse(
                    call: Call<List<getAllCarResponseItem>>,
                    response: Response<List<getAllCarResponseItem>>
                ) {

                        val body = response.body()
                        val code = response.code()
                        if (code==200){
                            binding.progressBar2.visibility= View.GONE
                            showList(body)
                        }else{
                            binding.progressBar2.visibility= View.GONE
                        }


                }

                override fun onFailure(call: Call<List<getAllCarResponseItem>>, t: Throwable) {
                    Log.d("home", "fail")
                }


            })
    }
        private fun showList(data : List<getAllCarResponseItem>?){
            val adapter = MainAdapter(object : MainAdapter.OnClickListener{
                override fun onClickItem(data: getAllCarResponseItem) {
                }

            })
            adapter.submitData(data)
            binding.recycleview.adapter = adapter
        }
}