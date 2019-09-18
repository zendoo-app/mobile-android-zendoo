package app.zendoo.feature.home.ui.entity

import app.zendoo.domain.model.Session

fun Session?.toEnum(): HomeViewEntityEnum =
    this?.let {
        when (this.current) {
            0 -> HomeViewEntityEnum.START
            else -> HomeViewEntityEnum.PROGRESS
        }
    } ?: run {
        return HomeViewEntityEnum.LOADING
    }
