package com.sidharth.chomu.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sidharth.chomu.databinding.ItemCardChatChomuBinding
import com.sidharth.chomu.databinding.ItemCardChatUserBinding
import com.sidharth.chomu.domain.model.Message

class ChatAdapter(
    private val messages: List<Message>
) : Adapter<ViewHolder>() {

    inner class UserChatViewHolder(
        private val itemBinding: ItemCardChatUserBinding
    ) : ViewHolder(itemBinding.root) {
        fun bind(message: Message) {
            itemBinding.tvMessage.text = message.content
        }
    }

    inner class ChomuChatViewHolder(
        private val itemBinding: ItemCardChatChomuBinding
    ) : ViewHolder(itemBinding.root) {
        fun bind(message: Message) {
            itemBinding.tvMessage.text = message.content
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (messages[position].role) {
            "assistant" -> 0
            else -> 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            0 -> ChomuChatViewHolder(
                ItemCardChatChomuBinding.inflate(
                    inflater, parent, false
                )
            )

            1 -> UserChatViewHolder(
                ItemCardChatUserBinding.inflate(
                    inflater, parent, false
                )
            )

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messages[position]
        when (holder.itemViewType) {
            0 -> (holder as ChomuChatViewHolder).bind(message)
            1 -> (holder as UserChatViewHolder).bind(message)
        }
    }

    override fun getItemCount(): Int {
        return messages.size
    }
}
