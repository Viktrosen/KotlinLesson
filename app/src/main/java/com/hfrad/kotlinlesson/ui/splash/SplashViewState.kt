package com.hfrad.kotlinlesson.ui.splash

import com.hfrad.kotlinlesson.ui.base.BaseViewState

class SplashViewState(authenticated: Boolean? = null, error: Throwable? = null): BaseViewState<Boolean?>(authenticated, error)