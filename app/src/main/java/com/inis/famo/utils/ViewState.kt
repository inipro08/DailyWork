package com.inis.famo.utils

class ViewState {
    companion object CommonState{
        // Với các state dùng chung thì để giá trị âm
        const val SHOW_LOADING: Int = -1
        const val HIDE_LOADING: Int = -2
        const val SHOW_ERROR: Int = -3
        const val EMPTY_DATA: Int = -4
        const val HAVE_DATA: Int = -5
    }

    class LoadMore {
        companion object {
            // Trạng thái load của hàm loadInitial() trong dataource
            const val INITIAL_LOADING = 1 // bắt đầu loading
            const val INITIAL_ERROR = 3 // loading error

            // Trạng thái load của hàm loadAfter() trong dataource
            const val AFTER_LOADING = 4
            const val AFTER_SUCCESS = 5
            const val AFTER_ERROR = 6
        }
    }

    class Splash {
        companion object {
            const val GO_LOGIN = 1
            const val GO_HOME = 2
        }
    }
}

