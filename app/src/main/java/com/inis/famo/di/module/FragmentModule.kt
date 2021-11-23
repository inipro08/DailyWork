package com.inis.famo.di.module

import com.inis.famo.ui.screen.fragment.history.HistoryFragment
import com.inis.famo.ui.screen.fragment.home.HomeFragment
import com.inis.famo.ui.screen.fragment.home.tab.TabProductFragment
import com.inis.famo.ui.screen.fragment.more.MoreFragment
import com.inis.famo.ui.screen.fragment.notification.NotificationFragment
import com.inis.famo.ui.screen.fragment.warehouse.WareHouseFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeWareFragment(): WareHouseFragment

    @ContributesAndroidInjector
    abstract fun contributeHistoryFragment(): HistoryFragment

    @ContributesAndroidInjector
    abstract fun contributeMoreFragment(): MoreFragment

    @ContributesAndroidInjector
    abstract fun contributeNotifyFragment(): NotificationFragment

    @ContributesAndroidInjector
    abstract fun contributeTabFragment(): TabProductFragment
}
