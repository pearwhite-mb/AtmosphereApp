plugins {
    alias(libs.plugins.atmosphere.android.library)
}

android {
    namespace = "ru.anlyashenko.core.domain"
}

dependencies {
    api(projects.core.data)
    api(projects.core.model)

    implementation(libs.jakarta.inject.api)

}
