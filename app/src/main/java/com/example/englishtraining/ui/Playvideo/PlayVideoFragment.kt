package com.example.englishtraining.ui.Playvideo

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.englishtraining.R





class PlayVideoFragment : Fragment() {

    // declaring a null variable for MediaController
    var mediaControls: MediaController? = null
    private lateinit var l1VideoView: VideoView
    private val viewModel: PlayVideoViewMode by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_play_video, container, false)
        l1VideoView = view.findViewById(R.id.lesson1VideoView)



        if (mediaControls == null) {
            // creating an object of media controller class
            mediaControls = MediaController(context)

            // set the anchor view for the video view
            mediaControls!!.setAnchorView(l1VideoView)
        }

        // set the media controller for video view
        l1VideoView.setMediaController(mediaControls)

        // Observe the video URI from the ViewModel
        viewModel.videoUri.observe(viewLifecycleOwner, Observer { uri ->
            l1VideoView.setVideoURI(uri)
            l1VideoView.requestFocus()
            l1VideoView.start()
        })

        // set the absolute path of the video file which is going to be played
        viewModel.setVideoUri(
            Uri.parse(
                "android.resource://"
                        + requireContext().packageName + "/" + R.raw.alphabet
            )
        )



        // display a toast message after the video is completed
        l1VideoView.setOnCompletionListener {
            Toast.makeText(
                context, "Video completed",
                Toast.LENGTH_LONG
            ).show()
        }

        // display a toast message if any error occurs while playing the video
        l1VideoView.setOnErrorListener { mp, what, extra ->
            Toast.makeText(
                context, "An Error Occurred " +
                        "While Playing Video !!!", Toast.LENGTH_LONG
            ).show()
            false
        }
        return view
    }
}