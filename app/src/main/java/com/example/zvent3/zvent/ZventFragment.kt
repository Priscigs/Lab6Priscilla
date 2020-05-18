package com.example.zvent3.zvent

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.zvent3.R
import com.example.zvent3.data.GuestUser
import com.example.zvent3.databinding.ZventFragmentBinding

class ZventFragment : Fragment() {

    companion object {
        fun newInstance() = ZventFragment()
    }

    private lateinit var viewModel: ZventViewModel
    private lateinit var binding: ZventFragmentBinding
    private lateinit var guestUser: GuestUser
    private var guestIndex: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.zvent_fragment, container, false)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.save_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.save_item){
            if(!updateVisibleGuest()) requireView().findNavController().navigate(ZventFragmentDirections.actionGuestFragmentToResultsFragment())
        }
        return super.onOptionsItemSelected(item)
    }

    fun updateVisibleGuest() : Boolean{
        guestIndex++
        if(guestUser.guests.size > guestIndex)
        {
            viewModel.updateGuest(guestUser.guests[guestIndex])
            (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_zvent3_guest, guestIndex + 1, guestUser.guests.size)
            return true
        }
        return false
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            guestUser = context as GuestUser
        } catch (castException: ClassCastException){}
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(ZventViewModel::class.java)

        binding.viewModel  = viewModel

        updateVisibleGuest()
    }
}
