package com.lucifer.jetpackcomposecourse.`26_Navigation`

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/*
 * - navController is created using rememberNavController()
 * - It manages navigation between composable screens in the app
 * - Keeps track of the navigation back stack
 * - Allows you to navigate to different destinations (screens)
 * - Used by NavHost to control which composable is displayed
 */

/*
 * - NavHost sets up the navigation graph for the app
 * - Connects the navController to the navigation system
 * - Defines the startDestination (initial screen)
 * - Registers composable destinations (screens) for navigation
 * - Controls which composable is displayed based on navigation state
 */
@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("wishlist") { WishlistScreen(navController) }
    }
}
