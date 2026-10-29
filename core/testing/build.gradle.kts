plugins {
    alias(libs.plugins.atmosphere.android.library)
    alias(libs.plugins.atmosphere.hilt)
}

android {
    namespace = "ru.anlyashenko.core.testing"
}

dependencies {
    api(libs.kotlinx.coroutines.test)
    api(projects.core.common)
    api(projects.core.data)
    api(projects.core.model)
    api(projects.core.notifications)

    implementation(libs.androidx.test.rules)
}
