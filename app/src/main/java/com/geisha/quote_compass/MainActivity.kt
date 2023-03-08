package com.geisha.quote_compass

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.navigation.compose.rememberNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Text("Hello World!")
                val navController = rememberNavController()
//                val navigator = remember { Navigator(navController) }

//                Scaffold { paddingValues ->
//                    CompositionLocalProvider(
//                        LocalNavController provides navController,
//                        LocalNavigator provides navigator,
//                    ) {
//                        RootNavigation(Modifier.padding(paddingValues), navController)
//                    }
//                }
            }
        }
    }
}
