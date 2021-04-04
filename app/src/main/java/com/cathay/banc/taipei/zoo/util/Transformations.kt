package com.cathay.banc.taipei.zoo.util

import android.graphics.Bitmap
import com.squareup.picasso.Transformation

object CircleTransformation : Transformation {

    override fun transform(source: Bitmap?): Bitmap {
        if (source == null) return BitmapTools.getDefault()
        return BitmapTools.clipCentralCircleFrom(source)
    }

    override fun key(): String = "CircleTransformation"
}

object SquareTransformation : Transformation {

    override fun transform(source: Bitmap?): Bitmap {
        if (source == null) return BitmapTools.getDefault()
        return BitmapTools.clipCentralSquareFrom(source)
    }

    override fun key(): String = "SquareTransformation"
}