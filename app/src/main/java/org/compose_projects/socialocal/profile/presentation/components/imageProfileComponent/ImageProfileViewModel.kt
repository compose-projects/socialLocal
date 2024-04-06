package org.compose_projects.socialocal.profile.presentation.components.imageProfileComponent

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class ImageProfileViewModel: ViewModel() {

    // LiveData para notificar si la imagen existe
    private val _imageExists = MutableLiveData<Boolean>()
    val imageExists: LiveData<Boolean> = _imageExists

    // LiveData para notificar la carga de la imagen
    private val _imageLoaded = MutableLiveData<Bitmap?>()
    val imageLoaded: LiveData<Bitmap?> = _imageLoaded

    fun checkImageExistence(context: Context, imageName: String = "image.jpeg") {
        val filePath = context.filesDir.absolutePath + "/" + imageName
        val file = File(filePath)
        _imageExists.value = file.exists()
        //Log.d("prueba15", "viewModel: ${file.exists()}")
    }

    fun loadImage(context: Context, imageName: String = "image.jpeg") {
        val filePath = context.filesDir.absolutePath + "/" + imageName
        _imageLoaded.value = BitmapFactory.decodeFile(filePath)
        //Log.d("prueba15", "viewModel: $filePath")

    }


    fun saveImage(context: Context, uri: Uri, nameImage: String = "image.jpeg") {
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        val outputFile = File(context.filesDir, nameImage)
        val outputStream = FileOutputStream(outputFile)

        try {
            inputStream?.copyTo(outputStream)
            Toast.makeText(context, "Imagen guardada", Toast.LENGTH_SHORT).show()
            _imageLoaded.value = BitmapFactory.decodeFile(outputFile.path)

        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "Ocurrió un error al guardar", Toast.LENGTH_SHORT).show()

        } finally {
            inputStream?.close()
            outputStream.close()
        }
    }

}