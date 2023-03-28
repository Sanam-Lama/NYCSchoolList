package com.example.nycschool.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nycschool.R
import com.example.nycschool.adapters.MyAdapter
import com.example.nycschool.api.RetrofitHelper
import com.example.nycschool.api.SchoolService
import com.example.nycschool.databinding.FragmentSchoolBinding
import com.example.nycschool.models.SatResultsItem
import com.example.nycschool.repository.SchoolRepository
import com.example.nycschool.ui.viewmodels.SchoolViewModel
import com.example.nycschool.ui.viewmodels.SchoolViewModelFactory

class SchoolFragment : Fragment() {
    private var _binding: FragmentSchoolBinding? = null
    private val binding get() = _binding!!
    private val myAdapter: MyAdapter
    get() = binding.recyclerView.adapter as MyAdapter
    private lateinit var viewModel: SchoolViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSchoolBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //creating an instance of repository to initialize viewmodel
        val schoolService = RetrofitHelper.getInstance().create(SchoolService::class.java)
        val repository = SchoolRepository(schoolService)

        viewModel = ViewModelProvider(this, SchoolViewModelFactory(repository))[SchoolViewModel::class.java]
        viewModel.schoolData.observe(viewLifecycleOwner, Observer { schools ->
            binding.recyclerView.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.itemAnimator = DefaultItemAnimator()
                it.adapter = MyAdapter(schools)
                myAdapter.notifyDataSetChanged()

                myAdapter.onItemClick = { satResult ->
                    val bundle = Bundle()
                    val tData = SatResultsItem(satResult.dbn,"","","","","")
                    bundle.putParcelable("data", tData)
                    findNavController().navigate(R.id.action_schoolFragment_to_resultFragment, bundle)
                }
            }
        })
        viewModel.getSchools(1, 20)
//        val state = viewModel.state
//        val lazyListState = rememberLazyListState()

    }

    /**
     * overriding this method to destroy our binding by making it null
     * we need to do this because once the view is destroyed then the viewbinding
     * should also be destroyed
     *
     * this increases a performance to our app
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}