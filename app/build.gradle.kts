plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.mukatlist.mukatlist"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mukatlist.mukatlist"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildToolsVersion = "34.0.0"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // splash
    implementation("androidx.core:core-splashscreen:1.0.1")

    // coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")

    // material
    implementation("androidx.compose.material:material:1.6.3")
    implementation("com.google.android.material:material:1.7.0")
    implementation(libs.androidx.material3)

    // compose
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))

    // ui
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // junit
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // espresso
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")

    // lifecycle
    val lifecycle_version = "2.6.0-alpha03"
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.fragment:fragment-ktx:1.5.4")

    // Jetpack Navigation
    val nav_version = "2.5.3"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Google Play services
    implementation("com.google.gms:google-services:3.1.0")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    implementation(platform("com.google.firebase:firebase-bom:32.7.4"))
    implementation("com.google.android.gms:play-services-auth:21.0.0")

    // datastore
    implementation ("androidx.datastore:datastore-preferences:1.0.0")
    // optional - RxJava2 support
    implementation ("androidx.datastore:datastore-preferences-rxjava2:1.0.0")
    // optional - RxJava3 support
    implementation ("androidx.datastore:datastore-preferences-rxjava3:1.0.0")

    // web view
    implementation( "com.google.accompanist:accompanist-webview:0.24.13-rc")

    //okhttp
    implementation("com.squareup.okhttp3:okhttp:3.6.0")
    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.6.4")
    // Gson
    implementation("com.squareup.retrofit2:converter-gson:2.6.4")
    //scalars
    implementation("com.squareup.retrofit2:converter-scalars:2.6.4")

    // firebase
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-analytics")
    implementation(platform("com.google.firebase:firebase-bom:32.1.0"))
}