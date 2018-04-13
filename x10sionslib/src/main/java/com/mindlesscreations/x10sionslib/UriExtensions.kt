package com.mindlesscreations.x10sionslib

import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap

fun Uri.isImage(context: Context): Boolean {
    val contentResolver = context.contentResolver
    val type: String? = contentResolver.getType(this)
    return if (type != null) {
        type.startsWith("image")
    } else {
        // Try to get it based on the file
        val extension = MimeTypeMap.getFileExtensionFromUrl(this.toString())
        MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension).startsWith("image")
    }
}

fun Uri.isVideo(context: Context): Boolean {
    val contentResolver = context.contentResolver
    val type: String? = contentResolver.getType(this)
    return if (type != null) {
        type.startsWith("video")
    } else {
        // Try to get it based on the file
        val extension = MimeTypeMap.getFileExtensionFromUrl(this.toString())
        MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension).startsWith("video")
    }
}