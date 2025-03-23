package com.tushar.nestedrecyclerview

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.tushar.nestedrecyclerview.databinding.ActivitySplashBinding

class SplashAct : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_splash)
        val splash=installSplashScreen()
        splash.setKeepOnScreenCondition{false}

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        binding.img.visibility=ImageView.VISIBLE
        val translateCenter=ObjectAnimator.ofFloat(binding.img,"translationY",500f,0f).apply {
            duration=1000
            interpolator=DecelerateInterpolator()
        }
        val translateUp=ObjectAnimator.ofFloat(binding.img,"translationY",0f,-500f).apply {
            duration=1000
            interpolator=AccelerateInterpolator()
        }
        val fadeOut=ObjectAnimator.ofFloat(binding.img,"alpha",1f,0f).apply {
            duration=1000
        }
        val animSet=AnimatorSet().apply {
            playTogether(translateUp,fadeOut)
            startDelay=1000
        }
        animSet.addListener(object :Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator) {

            }

            override fun onAnimationEnd(p0: Animator) {
                binding.img.visibility= View.GONE
                binding.animationView.visibility=View.VISIBLE
                binding.animationView.playAnimation()
            }

            override fun onAnimationCancel(p0: Animator) {

            }

            override fun onAnimationRepeat(p0: Animator) {

            }

        })
        binding.animationView.addAnimatorListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator) {

            }

            override fun onAnimationEnd(p0: Animator) {
              startActivity(Intent(this@SplashAct,MainActivity::class.java))
                finish()
            }

            override fun onAnimationCancel(p0: Animator) {

            }

            override fun onAnimationRepeat(p0: Animator) {

            }

        })
        translateCenter.start()
        translateCenter.addListener(object:Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator) {

            }

            override fun onAnimationEnd(p0: Animator) {
                animSet.start()
            }

            override fun onAnimationCancel(p0: Animator) {

            }

            override fun onAnimationRepeat(p0: Animator) {

            }

        })
    }
}