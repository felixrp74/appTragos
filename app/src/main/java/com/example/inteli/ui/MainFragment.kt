package com.example.inteli.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inteli.R
import com.example.inteli.data.DataSource
import com.example.inteli.data.model.Drink
import com.example.inteli.databinding.FragmentMainBinding
import com.example.inteli.domain.RepoImpl
import com.example.inteli.ui.viewmodel.MainViewModel
import com.example.inteli.ui.viewmodel.VMFactory
import com.example.inteli.vo.Resource

class MainFragment : Fragment(), MainAdapter.OnTragoClickListener {

    private val viewModel by viewModels<MainViewModel> { VMFactory(RepoImpl(DataSource())) }

    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupSearchView()
        setObervers()


    }

    private fun setObervers() {
        viewModel.fetchTragosList.observe(viewLifecycleOwner, Observer{ result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvTragos.adapter = MainAdapter(result.data, this)
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
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


    private fun setupSearchView(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("SEARCH_DRINK","$query")
                viewModel.setTrago(query!!)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                Log.i("TAG","Llego al querytextchange")
                return true
            }
        })
    }

    private fun setupRecyclerView() {
        binding.rvTragos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTragos.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun onTragoClick(drink: Drink) {
        val bundle = Bundle()
        bundle.putParcelable("drink",drink)
        findNavController().navigate(R.id.action_mainFragment_to_tragosDetalleFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}