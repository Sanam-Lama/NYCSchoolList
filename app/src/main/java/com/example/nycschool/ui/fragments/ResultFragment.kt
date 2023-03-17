package com.example.nycschool.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.nycschool.api.RetrofitHelper
import com.example.nycschool.api.SatResultService
import com.example.nycschool.databinding.FragmentResultBinding
import com.example.nycschool.repository.SatResultRepository
import com.example.nycschool.ui.viewmodels.ResultViewModel
import com.example.nycschool.ui.viewmodels.ResultViewModelFactory

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ResultViewModel

    //using nav_graph to get the data from previous fragment
    val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = args.data

        //need an instance of repository
        val resultService = RetrofitHelper.getInstance().create(SatResultService::class.java)
        val repository = SatResultRepository(resultService)
        viewModel = ViewModelProvider(this, ResultViewModelFactory(repository))[(ResultViewModel::class.java)]
        viewModel.satResults.observe(viewLifecycleOwner, Observer {
            if (it.isEmpty()) {
                binding.tvSchoolName.text = "No data found"
            } else {
                binding.tvSchoolName.text = "School name: ${it.first().school_name}"
                binding.tvReading.text = "Reading score: ${it.first().sat_critical_reading_avg_score}"
                binding.tvMath.text = "Math score: ${it.first().sat_math_avg_score}"
                binding.tvWriting.text = "Writing score: ${it.first().sat_writing_avg_score}"
            }
        })
        viewModel.getSatResults(data.dbn)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}