package com.example.zakaria_3tia.Message


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.zakaria_3tia.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar


class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root
        val data = messages[position]


        Glide.with(context)
            .load(data.avatarUrl)
            .into(binding.avatarImg)


        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText



        view.setOnClickListener {
            val intent = android.content.Intent(context, ChatActivity::class.java).apply {
                putExtra("SENDER_NAME", data.senderName)
                putExtra("MESSAGE_TEXT", data.messageText)
                putExtra("AVATAR_URL", data.avatarUrl)
            }
            context.startActivity(intent)
        }

        return view
    }
}