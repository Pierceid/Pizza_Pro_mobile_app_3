package com.example.pizza_pro_2.navigation

const val ID = "id"
const val NAME = "name"
const val EMAIL = "email"
const val PASSWORD = "password"
const val GENDER = "gender"
const val LOCATION = "location"

const val ROOT_GRAPH_ROUTE = "root"
const val AUTH_GRAPH_ROUTE = "auth"
const val HOME_GRAPH_ROUTE = "home"

sealed class Screen (val route: String) {
    object Intro : Screen(route = "intro_screen")
    object Register : Screen(route = "register_screen")
    object Login : Screen(route = "login_screen")
    object Shop : Screen(route = "shop_screen")
    object Cart : Screen(route = "cart_screen")
    object Feedback : Screen(route = "feedback_screen")
    object Profile : Screen(route = "profile_screen?name={name}&email={email}") {
        fun getArguments(
            name: String = "Pierceid",
            email: String = "e@e.e"
        ): String {
            return "profile_screen?name=$name&email=$name"
        }
    }
}