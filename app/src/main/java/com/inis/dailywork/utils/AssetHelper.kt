package com.inis.dailywork.utils

import java.net.URLEncoder
import java.util.*

class AssetHelper {

    companion object {
        // encode khi attach chứa kí tự %
        fun encodeUrl(url: String?): String? {
            return if (url != null) {
                val fileName = url.substring(url.lastIndexOf('/') + 1)
                if (fileName.contains("%")) {
                    val fileNameNew = URLEncoder.encode(fileName, "UTF-8")
                    url.replace(
                        fileName.toLowerCase(Locale.ROOT),
                        fileNameNew.toLowerCase(Locale.ROOT)
                    )
                } else {
                    url
                }
            } else {
                null
            }
        }
    }

}