package tp.nutriquest.backend

import android.content.Context
import java.io.File
import java.io.FileOutputStream

fun copyAssetToInternalStorage(context: Context, assetName: String) {
    val file = File(context.filesDir, assetName)

    if (file.exists()) {
        file.delete()
    }

    val inputStream = context.assets.open(assetName)
    val outputStream = FileOutputStream(file)

    inputStream.copyTo(outputStream)

    inputStream.close()
    outputStream.close()

    println("Asset $assetName copied to internal storage.")
}
