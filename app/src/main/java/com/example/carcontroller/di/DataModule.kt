package com.example.carcontroller.di

import com.example.carcontroller.data.repository.HomeRepository
import com.example.carcontroller.data.repository.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindHomeRepository(
        homeRepository: HomeRepositoryImpl,
    ): HomeRepository
}