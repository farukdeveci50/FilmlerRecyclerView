package com.farukdeveci.detaylirecyclerviewkullanimi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.farukdeveci.detaylirecyclerviewkullanimi.databinding.FragmentDetayBinding
import com.google.android.material.snackbar.Snackbar

class DetayFragment : Fragment() {
    private lateinit var tasarim : FragmentDetayBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentDetayBinding.inflate(inflater,container,false)

        val bundle:DetayFragmentArgs by navArgs()
        var gelenFilm = bundle.film
        tasarim.toolbarDetay.title = gelenFilm.filmAdi
        tasarim.ivFilmResim.setImageResource(resources.getIdentifier(gelenFilm.filmResimAdi,"drawable",requireContext().packageName))
        tasarim.tvFilmFiyat.text = "${gelenFilm.filmFiyat} ₺"
        tasarim.tvFilmYil.text = gelenFilm.filmYil.toString()
        tasarim.tvFilmYonetmen.text = gelenFilm.filmYonetmen
        tasarim.btnSepeteEkle.setOnClickListener {
            Snackbar.make(it,"${gelenFilm.filmAdi} sepete eklendi!",Snackbar.LENGTH_SHORT).show()
        }

        return tasarim.root
    }


}