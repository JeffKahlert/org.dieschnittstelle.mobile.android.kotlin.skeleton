package org.dieschnittstelle.mobile.android.kotlin.skeleton

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.dieschnittstelle.mobile.android.kotlin.skeleton.ui.navigation.AppNavHost

@Composable
fun ProjektApp(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()) {
    AppNavHost(modifier = modifier, navController = navController)
}