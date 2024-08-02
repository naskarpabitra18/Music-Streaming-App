package com.example.musicstream

import android.content.Context
import android.media.browse.MediaBrowser.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.musicstream.models.SongsModel

object MyExoplayer {

    private var exoPlayer : ExoPlayer? = null
    private var currentSong : SongsModel? = null

    fun getCurrentSong() : SongsModel?{
        return currentSong
    }

    fun getInstance() : ExoPlayer? {
        return exoPlayer
    }

    fun startPlaying(context : Context, song : SongsModel){
        if(exoPlayer==null)
            exoPlayer = ExoPlayer.Builder(context).build()

        if(currentSong!=song){
            //its a new song so start playing
            currentSong = song
        currentSong?.url?.apply {
            val mediaItem = androidx.media3.common.MediaItem.fromUri(this)
            exoPlayer?.setMediaItem(mediaItem)
            exoPlayer?.prepare()
            exoPlayer?.play()
        }
        }
    }


}