package com.dicoding.myopenmusic.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.myopenmusic.R
import com.dicoding.myopenmusic.core.data.Resource
import com.dicoding.myopenmusic.core.ui.SongsAdapter
import com.dicoding.myopenmusic.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel : HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val songsAdapter = SongsAdapter()
            songsAdapter.onItemClick = { selectedData ->
                Toast.makeText(requireContext(),"$selectedData",Toast.LENGTH_SHORT).show()
            }

            homeViewModel.songs.observe(viewLifecycleOwner, { song ->
                if (song != null) {
                    when (song) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            songsAdapter.setData(song.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = song.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(binding.rvSong) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = songsAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}