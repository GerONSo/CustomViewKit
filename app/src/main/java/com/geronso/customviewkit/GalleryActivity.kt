package com.geronso.customviewkit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import com.geronso.customviewkit.databinding.ActivityGalleryBinding

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            renderLoadingButton(loadingButton)
        }
    }

    private fun renderLoadingButton(loadingButton: LoadingButton) {
        loadingButton.render {
            this.copy(
                text = "Button"
            )
        }
        loadingButton.setOnClickListener {
            loadingButton.render {
                this.copy(
                    isLoading = !isLoading
                )
            }
        }
    }
}