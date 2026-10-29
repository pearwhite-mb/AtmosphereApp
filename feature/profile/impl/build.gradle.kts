plugins {
    alias(libs.plugins.atmosphere.android.feature.impl)
    alias(libs.plugins.atmosphere.android.library.compose)
}

android {
    namespace = "ru.anlyashenko.feature.profile.impl"
}

dependencies {
    implementation(projects.feature.profile.api)
    implementation(projects.feature.settings.api)
    implementation(projects.feature.yearlystats.api)

    implementation(projects.core.data)
    implementation(projects.core.presentation)

    testImplementation(projects.core.testing)

    androidTestImplementation(projects.core.testing)

}
