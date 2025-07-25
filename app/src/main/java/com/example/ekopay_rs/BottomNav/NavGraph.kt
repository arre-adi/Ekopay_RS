package com.example.ekopay.bottomnav


import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ekopay.metroo.BengaluruMetroUI
import com.example.ekopay.metroo.ChennaiMetroScreen
import com.example.ekopay.metroo.DelhiMetroScreen
import com.example.ekopay.metroo.KochiMetroScreen
import com.example.ekopay.metroo.MetroPriceScreen
import com.example.ekopay.metroo.SelectMetroScreen
import com.example.ekopay.qrscan.QRScannerScreen
import com.example.ekopay.qrscan.SuccessScreen
import com.example.ekopay_rs.Screens.AddMoney
import com.example.ekopay_rs.Screens.CrowdFundingPaymentScreen
import com.example.ekopay_rs.Screens.FinalTradingScreen
import com.example.ekopay_rs.Screens.FundingPreview
import com.example.ekopay_rs.Screens.GreenCreditApp
import com.example.ekopay_rs.Screens.LearningScreen
import com.example.ekopay_rs.Screens.ProductCardfinal
import com.example.ekopay_rs.Screens.ShoppingScreen
import com.example.ekopay_rs.Screens.TradingScreen
import com.example.ekopay_rs.Screens.TransactionHistoryScreen
import com.example.ekopay_rs.Screens.paymentcompletescreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route, // Start directly from Home
        modifier = Modifier.navigationBarsPadding()
    ) {
        composable(BottomBarScreen.Home.route) {
            BottomBarScreen.Home
        }



        composable(route = BottomBarScreen.Home.route) {
            GreenCreditApp(navController)
        }



        composable(route = BottomBarScreen.History.route) {
            TransactionHistoryScreen()
        }

        composable(route = BottomBarScreen.Shopping.route) {
            ShoppingScreen(navController)
        }
        composable(route = BottomBarScreen.Trade.route) {
            TradingScreen(navController)
        }
//        composable("submitEcoBrick") {
//            EcoBrickScreen()
//        }
        composable("learning") {
            LearningScreen()
        }
        composable("qrscanner") {
            QRScannerScreen(navController)
        }
        composable("success") {
            SuccessScreen(navController)
        }
        composable("selectmetro") {
            SelectMetroScreen(navController)
        }
        composable("b_metro") {
            BengaluruMetroUI(navController)  // Pass navController to allow navigation
        }

        composable("chennai_metro") {
            ChennaiMetroScreen()
        }
        composable("delhi_metro") {
            DelhiMetroScreen()
        }
        composable("kochi_metro") {
            KochiMetroScreen()
        }

        composable("payment_done"){
            paymentcompletescreen()
        }

        composable("crowwwd_funding"){
            FundingPreview(navController)
        }
        composable(
            route = "finalTrading/{amount}",
            arguments = listOf(navArgument("amount") { type = NavType.StringType })
        ) { backStackEntry ->
            val amount = backStackEntry.arguments?.getString("amount") ?: ""
            FinalTradingScreen(navController, amount)
        }


        composable("productCardFinal") {
            ProductCardfinal()
        }

       // Update Metro Price Screen to accept metroCardNumber and amount as arguments
        composable(
            route = "metro_price/{metroCardNumber}/{amount}",
            arguments = listOf(
                navArgument("metroCardNumber") { type = NavType.StringType },
                navArgument("amount") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val metroCardNumber = backStackEntry.arguments?.getString("metroCardNumber") ?: ""
            val amount = backStackEntry.arguments?.getString("amount") ?: ""
            MetroPriceScreen(navController, metroCardNumber, amount)
        }

        composable(
            route = "add_money/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            AddMoney(navController, name)
        }

        composable(
            route = "crowdfunding_payment/{name}/{amount}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("amount") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val amount = backStackEntry.arguments?.getString("amount") ?: ""
            CrowdFundingPaymentScreen(navController, name, amount)
        }

    }}