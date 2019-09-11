package app.zendoo.feature.dashboard.home.ui.entity

import app.zendoo.domain.model.Session

fun Session?.toEnum(): HomeViewEntityEnum =
    this?.let {
        when (this.current) {
            0 -> HomeViewEntityEnum.STARTING
            else -> HomeViewEntityEnum.PROGRESSING
        }
    } ?: run {
        return HomeViewEntityEnum.LOADING
    }
