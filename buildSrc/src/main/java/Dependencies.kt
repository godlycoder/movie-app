object CoreLibraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
}

object SupportLibraries {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:1.4.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    const val preference = "androidx.preference:preference-ktx:${Versions.preference}"
    const val desugar = "com.android.tools:desugar_jdk_libs:"
}

object Libraries {

    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"

    //coroutines
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesPlayService = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.1.1"

    //dagger
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"

    const val hiltAndroidXCommon = "androidx.hilt:hilt-common:${Versions.hiltAndroidX}"
    const val hiltAndroidXViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltAndroidX}"
    const val hiltAndroidXCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltAndroidX}"

    //multidex
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"

    //retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"

    // ViewModel
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.6"

    // LiveData
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    //Paging Library
    const val paging = "androidx.paging:paging-runtime-ktx:3.0.0"

    // Saved state module for ViewModel
    const val viewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"

    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    //Database
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    //Image Loader
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val gson = "com.google.code.gson:gson:2.8.8"

    //For Calendar Library
    const val jodaTime = "joda-time:joda-time:2.10.10"
    const val calendar = "com.jonaswanke.calendar:calendar:${Versions.calendar}"

    //Eventbus
    const val eventbus = "org.greenrobot:eventbus:${Versions.eventbus}"

    //Preferences
    const val hawk = "com.orhanobut:hawk:${Versions.hawk}"

    //Work Manager
    const val workManager = "androidx.work:work-runtime:${Versions.workManager}"

    //Lottie
    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"

    //Bac4App
    const val parse = "com.github.parse-community.Parse-SDK-Android:parse:${Versions.parse}"
    const val parseKtx = "com.github.parse-community.Parse-SDK-Android:ktx:${Versions.parse}"
    const val parseCoroutine = "com.github.parse-community.Parse-SDK-Android:coroutines:${Versions.parse}"
    const val parseGoogle = "com.github.parse-community.Parse-SDK-Android:google:${Versions.parse}"
    const val bolts = "com.parse.bolts:bolts-android:1.4.0"

    //Image Picker
    const val imagePicker = "com.github.Drjacky:ImagePicker:${Versions.imagePicker}"

    //Firebase
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebase}"
    const val firebaseAnalytic = "com.google.firebase:firebase-analytics"

    // MockWebServer
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"

    //Test
    const val testMockk = "io.mockk:mockk:${Versions.testMockk}"
    const val testMockkInstrumented = "io.mockk:mockk-android:${Versions.testMockkInstrumented}"

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    const val fragmentTest = "androidx.fragment:fragment-testing:${Versions.fragmentTest}"

    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

}
