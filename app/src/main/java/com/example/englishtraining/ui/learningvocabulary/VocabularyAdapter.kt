package com.example.englishtraining.ui.learningvocabulary

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.englishtraining.R

class VocabularyAdapter(
    private val context: Context,
    private val vocabularyList: List<Vocabulary>
) : RecyclerView.Adapter<VocabularyAdapter.VocabularyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocabularyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_vocabulary, parent, false)
        return VocabularyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VocabularyViewHolder, position: Int) {
        val currentItem = vocabularyList[position]
        holder.wordTextView.text = currentItem.word
        holder.exampleTextView.text = currentItem.exampleSentence

        currentItem.imageRes?.let { imageRes ->
            val imageResId = context.resources.getIdentifier(imageRes, "drawable", context.packageName)
            if (imageResId != 0) {
                holder.imageView.setImageResource(imageResId)
            }
        }

        holder.audioButton.setOnClickListener {
            currentItem.audioUrl?.let { audioUrl ->
                playAudio(audioUrl)
            }
        }
    }

    override fun getItemCount() = vocabularyList.size

    private fun playAudio(audioUrl: String) {
        val mediaPlayer = MediaPlayer().apply {
            setDataSource(audioUrl)
            prepare()
            start()
        }
        mediaPlayer.setOnCompletionListener {
            it.release()
        }
    }

    class VocabularyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordTextView: TextView = itemView.findViewById(R.id.wordTextView)
        val exampleTextView: TextView = itemView.findViewById(R.id.exampleTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val audioButton: ImageButton = itemView.findViewById(R.id.audioButton)
    }
}