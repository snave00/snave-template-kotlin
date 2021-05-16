package com.snave.sabong_guide.utils

import androidx.annotation.Keep

@Keep
enum class KoinQualifier(val value: String) {
    CONNECTION("AppModuleV2.CONNECTION")
}

@Keep
enum class NavigationDirection {
    BACKWARD,
    FORWARD
}

@Keep
enum class DialogFragmentBundle(val value: String) {
    CANCELLABLE("DialogFragmentBundle.CANCELLABLE"),
    ICON("DialogFragmentBundle.ICON"),
    TITLE("DialogFragmentBundle.TITLE"),
    CONTENT_A("DialogFragmentBundle.CONTENT_A"),
    CONTENT_B("DialogFragmentBundle.CONTENT_B"),
    CONTENT_C("DialogFragmentBundle.CONTENT_C"),
    CLICKABLE_TEXT_A("DialogFragmentBundle.CLICKABLE_TEXT_A"),
    CLICKABLE_TEXT_B("DialogFragmentBundle.CLICKABLE_TEXT_B"),
    CLICKABLE_TEXT_C("DialogFragmentBundle.CLICKABLE_TEXT_C"),
    CLICKABLE_TEXT_D("DialogFragmentBundle.CLICKABLE_TEXT_D"),
    CLICKABLE_TEXT_E("DialogFragmentBundle.CLICKABLE_TEXT_E"),
    CLICKABLE_ACTION_A("DialogFragmentBundle.CLICKABLE_ACTION_A"),
    CLICKABLE_ACTION_B("DialogFragmentBundle.CLICKABLE_ACTION_B"),
    CLICKABLE_ACTION_C("DialogFragmentBundle.CLICKABLE_ACTION_C"),
    CLICKABLE_ACTION_D("DialogFragmentBundle.CLICKABLE_ACTION_D"),
    CLICKABLE_ACTION_E("DialogFragmentBundle.CLICKABLE_ACTION_E"),
    ORIGIN("DialogFragmentBundle.ORIGIN"),
    PROMO_NAME("DialogFragmentBundle.PROMO_NAME"),
    PROMO_PRICE("DialogFragmentBundle.PROMO_PRICE"),
    POINTS_BALANCE("DialogFragmentBundle.POINTS_BALANCE")
}
