package com.example.zvent3.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.zvent3.R
import com.example.zvent3.databinding.ResultsFragmentBinding

class ResultsFragment : Fragment() {

    private lateinit var binding: ResultsFragmentBinding
    private lateinit var viewModel: ResultsViewModel
    //private lateinit var guestUser: GuestUser
    private lateinit var viewModelFactory: ResultsViewModelFactory

    companion object {
        fun newInstance() = ResultsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.results_fragment, container, false)

        binding.seeguestButton.setOnClickListener{
            Toast.makeText(this.context, viewModel.resultsText.value, Toast.LENGTH_LONG).show()
        }

        binding.restartButton.setOnClickListener {
            //guestUser.initialize()
            requireView().findNavController().navigate(ResultsFragmentDirections.actionResultsFragmentToGuestFragment())
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.lifecycleOwner = this

        //viewModelFactory = ResultsViewModelFactory(guestUser.guests)

        viewModel = ViewModelProvider(this, viewModelFactory).get(ResultsViewModel::class.java)

        binding.viewModel = viewModel
    }
}
