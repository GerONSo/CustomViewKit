package com.geronso.customviewkit

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.geronso.customviewkit.databinding.LoadingButtonBinding

class LoadingButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: LoadingButtonBinding
    private var state: State = State.DEFAULT

    init {
        binding = LoadingButtonBinding.inflate(LayoutInflater.from(context), this)
    }

    fun render(newState: State) {
        renderLoadingState(newState.isLoading, newState.progressBarColor)
        renderButton(
            newState.isLoading,
            newState.text,
            newState.background,
            newState.textColor
        )
        state = newState
    }

    fun render(update: State.() -> State) = render(update(state))

    override fun setOnClickListener(listener: OnClickListener?) {
        binding.button.setOnClickListener(listener)
    }

    private fun renderLoadingState(isLoading: Boolean, progressBarColor: Int) {
        binding.progressBar.isVisible = isLoading
        binding.progressBar.indeterminateTintList = ColorStateList.valueOf(color(progressBarColor))
    }

    private fun renderButton(isLoading: Boolean, text: String, background: Int, textColor: Int) {
        binding.button.text = if (isLoading) "" else text
        binding.button.setBackgroundResource(background)
        binding.button.setTextColor(context.getColor(textColor))
    }

    data class State(
        val isLoading: Boolean,
        val text: String,
        @DrawableRes
        val background: Int,
        @ColorRes
        val textColor: Int,
        @ColorRes
        val progressBarColor: Int,
    ) {
        companion object {
            val DEFAULT = State(
                isLoading = false,
                text = "",
                background = R.drawable.button_login,
                textColor = R.color.colorOnPrimary,
                progressBarColor = R.color.colorOnPrimary
            )
        }
    }
}