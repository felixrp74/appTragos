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
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inteli.AppDatabase
import com.example.inteli.R
import com.example.inteli.data.DataSource
import com.example.inteli.data.model.Drink
import com.example.inteli.databinding.FragmentFavoritosBinding
import com.example.inteli.databinding.FragmentMainBinding
import com.example.inteli.domain.RepoImpl
import com.example.inteli.ui.viewmodel.MainViewModel
import com.example.inteli.ui.viewmodel.VMFactory
import com.example.inteli.vo.Resource

class FavoritosFragment : Fragment(), MainAdapter.OnTragoClickListener {

    private val viewModel by activityViewModels<MainViewModel> {
        VMFactory(RepoImpl(DataSource(AppDatabase.getDatabase(requireActivity().applicationContext))))
    }
    private var _binding: FragmentFavoritosBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFavoritosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObervers()
    }

    private fun setupRecyclerView() {
        binding.rvTragosFavoritos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTragosFavoritos.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun setupObervers() {
        viewModel.fetchTragosFavoritoList.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {

                    val drink = result.data.map {
                        Drink(
                            tragoId = it.tragoId,
                            imagen = it.imagen,
                            nombre = it.nombre,
                            descripcion = it.descripcion,
                            conAlcohol = it.conAlcohol
                        )
                    }

                    binding.rvTragosFavoritos.adapter = MainAdapter(drink, this)

                    Log.d("LIST_DRINK_FAVORITE", "${result.data}")
                }
                is Resource.Failure -> {
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onTragoClick(drink: Drink) {
        TODO("Not yet implemented")
    }
}