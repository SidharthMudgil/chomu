package com.sidharth.chomu.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sidharth.chomu.R
import com.sidharth.chomu.core.utils.NetworkUtils
import com.sidharth.chomu.databinding.ActivityMainBinding
import com.sidharth.chomu.presentation.fragments.ChatFragmentDirections
import com.sidharth.chomu.presentation.fragments.EmailFragmentDirections
import com.sidharth.chomu.presentation.fragments.GrammarFragmentDirections
import com.sidharth.chomu.presentation.fragments.HomeFragmentDirections
import com.sidharth.chomu.presentation.fragments.InterviewFragmentDirections
import com.sidharth.chomu.presentation.fragments.ResultFragmentDirections
import com.sidharth.chomu.presentation.fragments.SocialFragmentDirections
import com.sidharth.chomu.presentation.fragments.SummaryFragmentDirections
import com.sidharth.chomu.presentation.fragments.WritingFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var navHostFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        if (NetworkUtils.isNetworkConnected(this).not()) {
            runOnUiThread {
                navHostFragment?.findNavController()?.navigate(
                    HomeFragmentDirections.actionHomeFragmentToNoNetworkFragment()
                )
            }
        }
        setupNetworkCallback()
    }

    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        navHostFragment?.findNavController()?.currentDestination?.let {
            if (it.id != R.id.noNetworkFragment) {
                super.onBackPressed()
            }
        }
    }

    private fun setupNetworkCallback() {
        NetworkUtils.startNetworkCallback(
            context = applicationContext,
            onConnectionAvailable = {
                if (navHostFragment?.findNavController()?.currentDestination?.id == R.id.noNetworkFragment) {
                    runOnUiThread {
                        navHostFragment?.findNavController()?.navigateUp()
                    }
                }
            },
            onConnectionLost = {
                val action = when (navHostFragment?.findNavController()?.currentDestination?.id) {
                    R.id.homeFragment -> HomeFragmentDirections.actionHomeFragmentToNoNetworkFragment()
                    R.id.grammarFragment -> GrammarFragmentDirections.actionGrammarFragmentToNoNetworkFragment()
                    R.id.summaryFragment -> SummaryFragmentDirections.actionSummaryFragmentToNoNetworkFragment()
                    R.id.socialFragment -> SocialFragmentDirections.actionSocialFragmentToNoNetworkFragment()
                    R.id.chatFragment -> ChatFragmentDirections.actionChatFragmentToNoNetworkFragment()
                    R.id.emailFragment -> EmailFragmentDirections.actionEmailFragmentToNoNetworkFragment()
                    R.id.interviewFragment -> InterviewFragmentDirections.actionInterviewFragmentToNoNetworkFragment()
                    R.id.resultFragment -> ResultFragmentDirections.actionResultFragmentToNoNetworkFragment()
                    R.id.writingFragment -> WritingFragmentDirections.actionWritingFragmentToNoNetworkFragment()
                    else -> null
                }
                action?.let {
                    runOnUiThread {
                        navHostFragment?.findNavController()?.navigate(it)
                    }
                }
            }
        )
    }

    override fun onPause() {
        super.onPause()
        NetworkUtils.stopNetworkCallback(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        NetworkUtils.stopNetworkCallback(this)
    }
}