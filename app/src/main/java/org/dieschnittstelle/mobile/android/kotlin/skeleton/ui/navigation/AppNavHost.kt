package org.dieschnittstelle.mobile.android.kotlin.skeleton.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.dieschnittstelle.mobile.android.kotlin.skeleton.ui.list.ListScreen

enum class AppRoutes() {
    List,

}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.List.name,
        modifier = modifier
    ) {
        composable(route = AppRoutes.List.name) {
            ListScreen()
        }
    }
}
