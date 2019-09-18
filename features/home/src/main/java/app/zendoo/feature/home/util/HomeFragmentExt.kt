package app.zendoo.feature.home.util

import androidx.fragment.app.Fragment
import app.zendoo.feature.home.R
import app.zendoo.feature.home.ui.entity.HomeViewEntityEnum
import app.zendoo.feature.home.ui.loading.LoadingFragment
import app.zendoo.feature.home.ui.progress.ProgressFragment
import app.zendoo.feature.home.ui.start.StartFragment

fun Fragment?.withDestination(state: HomeViewEntityEnum?): Int? =
    when (this) {
        is LoadingFragment -> {
            when (state) {
                HomeViewEntityEnum.START -> R.id.action_loading_to_start
                HomeViewEntityEnum.PROGRESS -> R.id.action_loading_to_progress
                else -> {
                    null
                }
            }
        }
        is StartFragment -> {
            when (state) {
                HomeViewEntityEnum.PROGRESS -> R.id.action_start_to_progress
                else -> {
                    null
                }
            }
        }
        is ProgressFragment -> {
            null
        }
        else -> {
            throw ClassNotFoundException("$this")
        }
    }
