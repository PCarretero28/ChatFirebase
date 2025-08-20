package pcg.curso.chatfirebase.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import pcg.curso.chatfirebase.R
import pcg.curso.chatfirebase.databinding.FragmentMainBinding

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.btnChat.setOnClickListener {
            if (!binding.tietName.text.isNullOrEmpty()) {
                viewModel.saveNickName(binding.tietName.text.toString())
                findNavController().navigate(R.id.action_main_fragment_to_chat_fragment)
            }

        }


        return binding.root
    }

}