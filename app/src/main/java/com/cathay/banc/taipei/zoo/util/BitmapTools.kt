package com.cathay.banc.taipei.zoo.util

import android.graphics.*
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.cathay.banc.taipei.zoo.R
import com.squareup.picasso.Picasso

object BitmapTools {

    private const val size = 20

    fun clipCentralSquareFrom(source: Bitmap): Bitmap {
        /*
            find x, y coordinate
         */
        val smallerSize = source.width.coerceAtMost(source.height)
        val x = (source.width - smallerSize) / 2
        val y = (source.height - smallerSize) / 2
        /*
            clip the central square
         */
        val centralSquare = Bitmap.createBitmap(source, x, y, smallerSize, smallerSize)
        if (centralSquare != source) source.recycle()
        return centralSquare
    }

    fun clipCentralCircleFrom(source: Bitmap): Bitmap {
        /*
            paint
         */
        val shadedSquare: Bitmap = clipCentralSquareFrom(source)
        val shader = BitmapShader(shadedSquare, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        val paint = Paint().apply { this.shader = shader;this.isAntiAlias = true }
        /*
            canvas
         */
        val newBitmap = Bitmap.createBitmap(shadedSquare.width, shadedSquare.width, source.config)
        val canvas = Canvas(newBitmap)
        /*
            draw
         */
        val radius = shadedSquare.width / 2f
        canvas.drawCircle(radius, radius, radius, paint)
        /*
            release bitmap resource
         */
        source.recycle()
        shadedSquare.recycle()

        return newBitmap
    }

    fun getDefault(): Bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)

    @JvmStatic
    @BindingAdapter("circleImageUrl")
    fun loadCircleImageUrl(imageView: ImageView, url: String) {
        Picasso.with(imageView.context).load(url).transform(CircleTransformation).into(imageView)
    }

    @JvmStatic
    @BindingAdapter("rectangleImageUrl")
    fun loadRectangleImageUrl(imageView: ImageView, url: String) {
        Picasso.with(imageView.context).load(url).transform(SquareTransformation).into(imageView)
    }

    @JvmStatic
    @BindingAdapter("android:src")
    fun loadOriginalImageUrl(imageView: ImageView, url: String) {
        Picasso.with(imageView.context).load(url).into(imageView)
    }
}
