package com.example.countryflags


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso


class PictureActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var imageView: ImageView
    private lateinit var buttonLoad: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

        editText = findViewById(R.id.et_picsum)
        imageView = findViewById(R.id.image_picsum)
        buttonLoad = findViewById(R.id.btnLoad)



        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {
        buttonLoad.setOnClickListener {
            var link = editText.text.toString()
            if (link == "")
                link = getString(R.string.picLink)

            loadImage(link)
        }
    }

    private fun loadImage(link: String) {
        Picasso.get()
            .load(link)
            .placeholder(R.drawable.ic_baseline_search_24)
            .error(R.drawable.ic_baseline_error_24)
            .memoryPolicy(MemoryPolicy.NO_CACHE)
            .into(imageView, object: com.squareup.picasso.Callback {
            override fun onSuccess() {
                //set animations here

            }

            override fun onError(e: java.lang.Exception?) {
                Toast.makeText(applicationContext, "Не удалось загрузить изображение!", Toast.LENGTH_SHORT).show()
            }
        })
    }

 //   .error(Toast.makeText(applicationContext, "Не удалось загрузить изображение!", Toast.LENGTH_SHORT))
}