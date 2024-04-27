package com.mhmdbh.quran.feature.qurani.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mhmdbh.quran.core.common.NavRoutes
import com.mhmdbh.quran.feature.qurani.QuranScreenRoute
import com.mhmdbh.quran.feature.qurani.ui.SurahScreenRoute

const val quranNavigationRoute = NavRoutes.quranRoute

const val surahScreenRoute = NavRoutes.surahRoute

fun NavController.navigateToQuran(navOptions: NavOptions? = null){
    this.navigate(quranNavigationRoute, navOptions)
}

fun NavController.navigateToChapter(
    surahId: Int,
    chapterName: String,
    navOptions: NavOptions? = null
){
    setSurahData(chapterName)
    navigate("$surahScreenRoute/$surahId", navOptions)
}

internal const val chapterIdArgKey = "chapterId"
internal const val surahNameArgKey = "chapterName"

internal class ChapterArgs(savedStateHandle: SavedStateHandle){
    val verseId = savedStateHandle.get<Int>(chapterIdArgKey)
}

fun NavController.getSurahData(): String?{
    return previousBackStackEntry?.savedStateHandle?.get<String>(surahNameArgKey)
}

fun NavController.setSurahData(chapterName: String){
    currentBackStackEntry?.savedStateHandle?.set(surahNameArgKey, chapterName)
}

fun NavGraphBuilder.quranScreen(navController: NavController){

    composable(route = quranNavigationRoute){
        QuranScreenRoute(
            navController =  navController
        )
    }

    composable(                 //{$rateIdArgKey}
        route = "$surahScreenRoute/{$chapterIdArgKey}",
        arguments = listOf(navArgument(chapterIdArgKey){ type = NavType.IntType})
    ){

        //Two models for Surah
        //SurahFull: consists of all surah data that need to display [SurahBrief & listOfAyahat]
        //SurahBrief: consists of [id, name, type, verses, etc...]
        //Passing Surah as Model to savedStateHandle
        //viewModel -> savedStateHandle -> getValue(surahId) -> fetch surah data
        //TopAppVar -> savedStateHandle -> getValue(surahName) -> Display it
        SurahScreenRoute(
            navController
        )
    }
}