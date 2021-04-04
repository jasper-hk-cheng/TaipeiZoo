package com.cathay.banc.taipei.zoo.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.util.Constants.INTENT_EXTRA_KEY_ARENA
import com.squareup.picasso.Picasso

class ArenaFragment : Fragment() {

    /*
        views
     */
    private lateinit var ivAvatar: ImageView
    private lateinit var tvDescription: TextView
    private lateinit var tvInfo: TextView
    private lateinit var tvCategory: TextView
    private lateinit var tvOuterLink: TextView

    override fun onCreateView(layoutInflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = layoutInflater.inflate(R.layout.fragment_arena, container)

        ivAvatar = view.findViewById(R.id.ivAvatar)
        tvDescription = view.findViewById(R.id.tvDescription)
        tvInfo = view.findViewById(R.id.tvInfo)
        tvCategory = view.findViewById(R.id.tvCategory)
        tvOuterLink = view.findViewById(R.id.tvOuterLink)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val arena: Arena = activity?.intent?.getParcelableExtra(INTENT_EXTRA_KEY_ARENA) ?: return
        Picasso.with(context).load(arena.avatarUrl).into(ivAvatar)
        tvDescription.text = arena.description
        tvInfo.text = arena.info
        tvCategory.text = arena.category.name
        tvOuterLink.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(arena.url)))
        }
    }
}
