package com.inis.famo.di.module

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.inis.famo.di.ViewModelFactory
import com.inis.famo.ui.screen.activity.cart.CartViewModel
import com.inis.famo.ui.screen.activity.intro.IntroViewModel
import com.inis.famo.ui.screen.activity.login.LoginViewModel
import com.inis.famo.ui.screen.activity.main.MainViewModel
import com.inis.famo.ui.screen.activity.splash.SplashViewModel
import com.inis.famo.ui.screen.fragment.history.HistoryViewModel
import com.inis.famo.ui.screen.fragment.home.HomeViewModel
import com.inis.famo.ui.screen.fragment.home.tab.TabViewModel
import com.inis.famo.ui.screen.fragment.more.MoreViewModel
import com.inis.famo.ui.screen.fragment.notification.NotificationViewModel
import com.inis.famo.ui.screen.fragment.warehouse.WareHouseViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainVM (mainViewModel: MainViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    abstract fun bindCartVM (cartViewModel: CartViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginVM (loginViewModel: LoginViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashVM (splashViewModel: SplashViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(IntroViewModel::class)
    abstract fun bindIntroVM(introViewModel: IntroViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WareHouseViewModel::class)
    abstract fun bindWareHouseViewModel(wareHouseViewModel: WareHouseViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HistoryViewModel::class)
    abstract fun bindHistoryViewModel(historyViewModel: HistoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MoreViewModel::class)
    abstract fun bindMoreViewModel(moreViewModel: MoreViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NotificationViewModel::class)
    abstract fun bindNotifyViewModel(notifyViewModel: NotificationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TabViewModel::class)
    abstract fun bindTabViewModel(tabViewModel: TabViewModel): ViewModel
}
