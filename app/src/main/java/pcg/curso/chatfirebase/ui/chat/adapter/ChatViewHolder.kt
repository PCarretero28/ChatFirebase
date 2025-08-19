package pcg.curso.chatfirebase.ui.chat.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import pcg.curso.chatfirebase.databinding.ItemChatMeBinding
import pcg.curso.chatfirebase.databinding.ItemChatOtherBinding
import pcg.curso.chatfirebase.domain.model.MessageModel

class ChatViewHolder(private val binding:ViewBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(messageModel: MessageModel, itemViewType: Int) {
        when(itemViewType){
            ChatAdapter.SENT_MESSAGE -> bindSendMessage(messageModel)
            ChatAdapter.RECEIVED_MESSAGE -> bindReceivedMessage(messageModel)
        }
    }

    private fun bindReceivedMessage(messageModel: MessageModel) {
        val currentBinding = binding as ItemChatOtherBinding
        currentBinding.tvDate.text = messageModel.date
        currentBinding.tvChat.text = messageModel.msg
        currentBinding.tvHour.text = messageModel.hour
        currentBinding.tvName.text = messageModel.user.userName
    }

    private fun bindSendMessage(messageModel: MessageModel) {
        val currentBinding = binding as ItemChatMeBinding
        currentBinding.tvChatMe.text = messageModel.msg
        currentBinding.tvDateMe.text = messageModel.date
        currentBinding.tvHour.text = messageModel.hour
    }



}