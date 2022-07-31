package com.example.inteli.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.inteli.AppDatabase
import com.example.inteli.data.DataSource
import com.example.inteli.data.model.Drink
import com.example.inteli.data.model.DrinkEntity
import com.example.inteli.databinding.FragmentTragosDetalleBinding
import com.example.inteli.domain.RepoImpl
import com.example.inteli.ui.viewmodel.MainViewModel
import com.example.inteli.ui.viewmodel.VMFactory
import com.example.inteli.vo.Resource

class TragosDetalleFragment : Fragment() {

    private val viewModel by activityViewModels<MainViewModel> { VMFactory(RepoImpl(DataSource(
        AppDatabase.getDatabase(requireActivity().applicationContext)
    ))) }

    private lateinit var drink: Drink
    private var _binding: FragmentTragosDetalleBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            drink = it.getParcelable("drink")!!

            Log.d("DETALLE_FRAG", " $drink")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTragosDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(drink.imagen).into(binding.ivTragoDetalle)
        binding.tvTitulo.text = drink.nombre
        binding.tvDescripcionDetalle.text = drink.descripcion
        binding.tvConAlcohol.text = drink.conAlcohol


        binding.btnGuardarTrago.setOnClickListener {
            viewModel.guardarTrago(
                DrinkEntity(
                    tragoId = drink.tragoId,
                    imagen = drink.imagen,
                    nombre = drink.nombre,
                    descripcion = drink.descripcion,
                    conAlcohol = drink.conAlcohol
                )
            )

            Toast.makeText(requireContext(), "Se ha guardado ${drink.nombre} favoritos.", Toast.LENGTH_SHORT)
                .show()
        }

    }


}