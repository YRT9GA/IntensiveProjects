package com.example.implicitintents

import android.content.ActivityNotFoundException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.util.Log

import androidx.core.app.ShareCompat





/**
 * The ImplicitIntents app contains three buttons for sending implicit intents:
 * - Open a URL in a browser
 * - Find a location on a map
 * - Share a text string
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mWebsiteEditText = findViewById<EditText>(R.id.website_edittext);
        val mLocationEditText = findViewById<EditText>(R.id.location_edittext);
        val mShareTextEditText = findViewById<EditText>(R.id.share_edittext);

        open_website_button.setOnClickListener {
            val url = mWebsiteEditText.text.toString()
            val webpage: Uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, webpage)

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Log.d("ImplicitIntents", "Can't handle this!");
            }
        }

        open_location_button.setOnClickListener {
            // Get the string indicating a location. Input is not validated; it is
            // passed to the location handler intact.
            // Get the string indicating a location. Input is not validated; it is
            // passed to the location handler intact.
            val loc = mLocationEditText.text.toString()

            // Parse the location and create the intent.

            // Parse the location and create the intent.
            val addressUri = Uri.parse("geo:0,0?q=$loc")
            val intent = Intent(Intent.ACTION_VIEW, addressUri)

            // Find an activity to handle the intent, and start that activity.

            // Find an activity to handle the intent, and start that activity.
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Log.d("ImplicitIntents", "Can't handle this intent!")
            }
        }

        share_text_button.setOnClickListener {
            val txt = mShareTextEditText.text.toString()
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_text_with)
                .setText(txt)
                .startChooser()
        }

        val REQUEST_IMAGE_CAPTURE = 1

        photo_button.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            } catch (e: ActivityNotFoundException) {
                // display error state to the user
            }
        }

    }


}