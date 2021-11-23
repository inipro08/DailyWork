package com.inis.famo.di.module

import com.inis.famo.ui.screen.activity.cart.CartActivity
import com.inis.famo.ui.screen.activity.intro.IntroActivity
import com.inis.famo.ui.screen.activity.login.LoginActivity
import com.inis.famo.ui.screen.activity.main.MainActivity
import com.inis.famo.ui.screen.activity.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMain(): MainActivity

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeSplash() : SplashActivity

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeIntro() : IntroActivity

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeLogin() : LoginActivity

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeCart() : CartActivity
}