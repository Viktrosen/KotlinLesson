package com.hfrad.kotlinlesson.ui.splash

import com.hfrad.kotlinlesson.ui.base.BaseViewState

class SplashViewState(isAuth: Boolean? = null, error: Throwable? = null) :
        BaseViewState<Boolean?>(isAuth, error)