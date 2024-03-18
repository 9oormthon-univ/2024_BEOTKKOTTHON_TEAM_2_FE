package com.mukatlist.mukatlist.ui.fragment

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mukatlist.mukatlist.utils.REQUEST_KEY_PERMISSION_CHECK_READ_EXTERNAL_STORAGE
import com.mukatlist.mukatlist.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class IntroSplashFragment: Fragment(R.layout.fragment_intro_splash) {
    private val neededPermission = android.Manifest.permission.READ_EXTERNAL_STORAGE

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(1000)
            checkPermissions()
            listenToFragmentResultListeners()
        }
    }

    private fun checkPermissions(){
        when (PackageManager.PERMISSION_GRANTED){
            ContextCompat.checkSelfPermission(
                requireContext(),
                neededPermission
            ) -> navigationToIntroTermAgreementScreen()
            else -> navigationToCheckPermissioiinDialogScreen()
        }
    }

    private fun listenToFragmentResultListeners(){
        setFragmentResultListener(requestKey = REQUEST_KEY_PERMISSION_CHECK_READ_EXTERNAL_STORAGE){
            requestKey, _ -> require(requestKey == REQUEST_KEY_PERMISSION_CHECK_READ_EXTERNAL_STORAGE)
            navigationToIntroTermAgreementScreen()
        }
    }

    private fun navigationToCheckPermissioiinDialogScreen(){
        findNavController().navigate(resId = R.id.action_introSplashFragment_to_introTermAgreementFragment)
    }

    private fun navigationToIntroTermAgreementScreen(){
        findNavController().navigate(resId = R.id.action_introSplashFragment_to_checkPermissionsDialogFragment)
    }
}