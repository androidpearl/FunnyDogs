package com.pals.funnydogs

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope : CoroutineScope
}