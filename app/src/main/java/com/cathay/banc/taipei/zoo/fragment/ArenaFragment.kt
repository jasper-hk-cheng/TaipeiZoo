package com.cathay.banc.taipei.zoo.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.databinding.FragmentArenaBinding
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.util.Constants.INTENT_EXTRA_KEY_ARENA
import com.squareup.picasso.Picasso

class ArenaFragment : Fragment() {

    private lateinit var fragmentArenaBinding: FragmentArenaBinding

    override fun onCreateView(layoutInflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentArenaBinding = FragmentArenaBinding.inflate(layoutInflater, container, false)
        return fragmentArenaBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val arena: Arena = activity?.intent?.getParcelableExtra(INTENT_EXTRA_KEY_ARENA) ?: return
        fragmentArenaBinding.arena = arena
        fragmentArenaBinding.tvOuterLink.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(arena._url)))
        }
    }
}
