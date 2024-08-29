package com.ja1zinh0.appdecompras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ja1zinh0.appdecompras.ui.theme.AppDeComprasTheme
import com.ja1zinh0.appdecompras.ui.view.login.LoginScreen
import com.ja1zinh0.appdecompras.ui.view.main.MainScreen
import com.ja1zinh0.appdecompras.ui.view.recoverpsswrd.RecoverPsswrdScreen
import com.ja1zinh0.appdecompras.ui.view.start.StartScreen
import com.ja1zinh0.appdecompras.ui.view.signup.SignupScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppDeComprasTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "mainScreen"
                ) {
                    composable("startScreen") { StartScreen(navController) }
                    composable("loginScreen") { LoginScreen(navController) }
                    composable("signupScreen") { SignupScreen(navController)}
                    composable("recoverpassword") { RecoverPsswrdScreen(navController)}
                    composable("mainScreen") {MainScreen(navController)}
                }
            }
        }
    }
}
