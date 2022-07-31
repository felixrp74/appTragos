package com.example.inteli.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.inteli.AppDatabase
import com.example.inteli.R
import com.example.inteli.data.DataSource
import com.example.inteli.domain.RepoImpl
import com.example.inteli.ui.viewmodel.MainViewModel
import com.example.inteli.ui.viewmodel.VMFactory
import com.example.inteli.vo.Resource

class FavoritosFragment : Fragment() {

    private val viewModel by activityViewModels<MainViewModel> {
        VMFactory(RepoImpl(DataSource(AppDatabase.getDatabase(requireActivity().applicationContext))))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favoritos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchTragosList.observe(viewLifecycleOwner, Observer{ result ->
            when (result) {
                is Resource.Loading -> {
                    //binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    /*binding.progressBar.visibility = View.GONE
                    binding.rvTragos.adapter = MainAdapter(result.data, this)*/

                    Log.d("LIST_DRINK_FAVORITE","${result.data}")
                }
                is Resource.Failure -> {
                    //binding.progressBar.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "ocurrio eerrro trayendo datos ${result.exception}",
                        Toast.LENGTH_SHORT
                    ).show()

                    Log.d("FAILURE_GET", "${result.exception}")
                }
                else -> {
                    Toast.makeText(
                        requireContext(),
                        "ELSE",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        })
    }


}