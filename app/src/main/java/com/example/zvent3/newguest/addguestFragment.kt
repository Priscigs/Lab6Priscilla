package com.example.zvent3.newguest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zvent3.R
import com.example.zvent3.databinding.AddguestFragmentBinding

class addguestFragment : Fragment() {

    companion object {
        fun newInstance() = addguestFragment()
    }

    private lateinit var viewModel: AddguestViewModel
    private lateinit var binding: AddguestFragmentBinding

    lateinit var option: Spinner
    lateinit var result: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.addguest_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddguestViewModel::class.java)

        binding.viewModel = viewModel
    }

}
