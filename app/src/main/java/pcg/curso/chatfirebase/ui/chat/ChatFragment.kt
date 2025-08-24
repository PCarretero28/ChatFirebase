package pcg.curso.chatfirebase.ui.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import pcg.curso.chatfirebase.R
import pcg.curso.chatfirebase.databinding.FragmentChatBinding
import pcg.curso.chatfirebase.domain.model.MessageModel
import pcg.curso.chatfirebase.ui.chat.adapter.ChatAdapter

@AndroidEntryPoint
class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private val viewmodel by viewModels<ChatViewModel>()

    private lateinit var chatAdapter: ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        binding.ivBack.setOnClickListener {
            viewmodel.logout { findNavController().navigate(R.id.action_back_to_main_fragment) }
        }

        setUpUI()

        binding.btnSendMsg.setOnClickListener {
            val msg = binding.etChat.text.toString()
            if (msg.isNotEmpty()) {
                viewmodel.sendMessage(msg)
            }
            binding.etChat.text.clear()
        }

        return binding.root
    }

    private fun setUpUI() {
        setUpMessages()
        subscribeToMessages()
        sepUpToolbar()
    }

    private fun sepUpToolbar() {
        binding.tvTitle.text = viewmodel.name
    }

    private fun setUpMessages() {
        chatAdapter = ChatAdapter(mutableListOf())
        binding.rvMsg.apply {
            adapter = chatAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun subscribeToMessages() {
        lifecycleScope.launch {
            viewmodel.messageList.collect {
                sepUpToolbar()
                chatAdapter.updateList(it.toMutableList(), viewmodel.name)
                binding.rvMsg.scrollToPosition(it.size - 1)
            }
        }
    }
}