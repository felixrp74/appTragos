package com.example.inteli.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.inteli.R
import com.example.inteli.data.model.Drink
import com.example.inteli.databinding.FragmentMainBinding
import com.example.inteli.databinding.FragmentTragosDetalleBinding

class TragosDetalleFragment : Fragment() {

    private lateinit var drink: Drink
    private var _binding: FragmentTragosDetalleBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            drink = it.getParcelable<Drink>("drink")!!

            Log.d("DETALLE_FRAG", " $drink")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTragosDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(drink.imagen).into(binding.ivTragoDetalle)
        binding.tvTitulo.text=drink.nombre
        binding.tvDescripcionDetalle.text=drink.descripcion
        binding.tvConAlcohol.text=drink.conAlcohol

    }


}