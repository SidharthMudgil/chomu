package com.sidharth.chomu.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sidharth.chomu.databinding.ItemCardAssistantBinding
import com.sidharth.chomu.domain.model.Assistant
import com.sidharth.chomu.presentation.callback.OnAssistantClickCallback

class AssistantAdapter(
    private val assistants: List<Assistant>,
    private val onAssistantClickCallback: OnAssistantClickCallback,
) : Adapter<AssistantAdapter.AssistantViewHolder>() {

    inner class AssistantViewHolder(
        private val itemBinding: ItemCardAssistantBinding
    ) : ViewHolder(itemBinding.root) {
        fun bind(assistant: Assistant) {
            itemBinding.apply {
                tvTitle.text = assistant.title
                tvSubtitle.text = assistant.subtitle
                ivImage.setImageDrawable(
                    ContextCompat.getDrawable(
                        root.context,
                        assistant.image,
                    )
                )
                cvAssistant.setOnClickListener {
                    onAssistantClickCallback.onAssistantClick(assistant.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssistantViewHolder {
        val binding = ItemCardAssistantBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return AssistantViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return assistants.size
    }

    override fun onBindViewHolder(holder: AssistantViewHolder, position: Int) {
        holder.bind(assistants[position])
    }
}