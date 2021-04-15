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
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.util.Constants.INTENT_EXTRA_KEY_ARENA
import com.squareup.picasso.Picasso

class ArenaFragment : Fragment() {

    private lateinit var unbinder: Unbinder

    @BindView(R.id.ivAvatar)
    lateinit var ivAvatar: ImageView

    @BindView(R.id.tvDescription)
    lateinit var tvDescription: TextView

    @BindView(R.id.tvInfo)
    lateinit var tvInfo: TextView

    @BindView(R.id.tvCategory)
    lateinit var tvCategory: TextView

    @BindView(R.id.tvOuterLink)
    lateinit var tvOuterLink: TextView

    override fun onCreateView(layoutInflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_arena, container, false)
        unbinder = ButterKnife.bind(this, view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val arena: Arena = activity?.intent?.getParcelableExtra(INTENT_EXTRA_KEY_ARENA) ?: return

        Picasso.with(requireContext()).load(arena._ePicUrl).into(ivAvatar)
        tvDescription.text = arena._eInfo
        tvInfo.text = arena._eMemo
        tvCategory.text = arena._eCategory.name
        tvOuterLink.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(arena._eUrl)))
        }
    }
}
