package com.hyk.navigationGrape.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.get
import com.hyk.navigationGrape.R
import com.hyk.navigationGrape.databinding.ActivityMainBinding
import com.hyk.navigationGrape.extends.Logger.d
import com.hyk.navigationGrape.preference.Preferences
import com.hyk.navigationGrape.ui.base.BaseActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_main

    private var navController: NavController? = null

    private val finishIntervalTime: Long = 2000
    private var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val navHostFragment =
        //    supportFragmentManager.findFragmentById(R.id.navigation_main_host) as NavHostFragment
        navController = getHost().navController

        d("isSignedIn ${Preferences.isSignedIn}")
    }

    private fun getHost() : NavHostFragment {
        return supportFragmentManager.findFragmentById(R.id.navigation_main_host) as NavHostFragment
    }

    override fun onResume() {
        super.onResume()

        navController?.moveScreen()
    }

    override fun onBackPressed() {
        navController?.onBackPressed()//super.onBackPressed()
    }

    private fun NavController.moveScreen() {
        with(this) {
            currentDestination?.let {
                when (it.id) {
                    R.id.splashFragment -> {
                        launch {
                            delay(500)
                            if (Preferences.isFirst) {
                                goFragment(R.id.action_splash_to_tutorial)
                            } else {
                                goFragment(R.id.action_splash_to_main)
                            }
                        }
                    }
                    else -> {
                    }
                }
            }
        }
    }

    private fun NavController.goFragment(@IdRes id: Int) = launch(Dispatchers.Main) {
        with(this@goFragment) {
            if (isDesiredDestination()) {
                navigate(id)
            }
        }
    }

    fun navigate(directions: NavDirections) {
        navController?.navigate(directions.actionId, directions.arguments)
    }

    private fun NavController.isDesiredDestination(): Boolean {
        return with(this) {
            currentDestination == graph[R.id.splashFragment]
        }
    }

    private fun NavController.onBackPressed() {
        with(this) {
            when (currentDestination?.id) {
                R.id.splashFragment -> {
                    // NOTE : do not here everything !!
                }
                R.id.mainFragment -> {
                    getHost().childFragmentManager.fragments.let {
                        if (it[0] is MainFragment) {
                            if(!(it[0] as MainFragment).popStack()) {
                                backPress()
                            }
                        }
                    }
                }
                R.id.loginFragment -> {
                    backPress()
                }
                R.id.tutorialFragment -> {
                    backPress()
                }
                else -> {
                    super.onBackPressed()
                }
            }
        }
    }

    private fun backPress() {
        val tempTime = System.currentTimeMillis()
        val intervalTime: Long = tempTime - backPressedTime

        if (intervalTime in 0..finishIntervalTime) {
            finishAffinity() //super.onBackPressed()
        } else {
            backPressedTime = tempTime
            Toast.makeText(this, "뒤로버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
    }

}