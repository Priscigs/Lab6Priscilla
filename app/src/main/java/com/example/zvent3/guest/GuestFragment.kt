package com.example.zvent3.guest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zvent3.R
import com.example.zvent3.database.ZventDatabase
import com.example.zvent3.databinding.GuestFragmentBinding

class GuestFragment : Fragment() {

    companion object {
        fun newInstance() = GuestFragment()
    }

    private lateinit var viewModelFactory: GuestViewModelFactory
    private lateinit var viewModel: GuestViewModel
    private lateinit var binding: GuestFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.guest_fragment, container, false)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.lifecycleOwner = this

        val application = requireNotNull(this.activity).application
        val dataSource = ZventDatabase.getInstance(application).zventDataBaseDao
        viewModelFactory = GuestViewModelFactory((dataSource))

        viewModel = ViewModelProvider(this, viewModelFactory).get(GuestViewModel::class.java)

        binding.viewModel  = viewModel
    }
}
