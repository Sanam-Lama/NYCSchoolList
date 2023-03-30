package com.example.nycschool.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.nycschool.databinding.FragmentResultBinding
import com.example.nycschool.ui.viewmodels.ResultViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        viewModel = ViewModelProvider(this)[(ResultViewModel::class.java)]
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