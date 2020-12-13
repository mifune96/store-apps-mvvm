/*
 * Created by Muhammad Utsman on 4/12/20 5:31 PM
 * Copyright (c) 2020 . All rights reserved.
 */

package com.utsman.listing.di

import android.content.Context
import androidx.work.WorkManager
import com.utsman.data.repository.database.DownloadedRepository
import com.utsman.data.repository.list.InstalledAppsRepository
import com.utsman.data.repository.list.PagingAppRepository
import com.utsman.listing.domain.DownloadedUseCase
import com.utsman.listing.domain.InstalledAppUseCase
import com.utsman.listing.domain.PagingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ListingModule {

    @Provides
    @Singleton
    fun providePagingUseCase(
        pagingAppRepository: PagingAppRepository,
        installedAppsRepository: InstalledAppsRepository,
        downloadedRepository: DownloadedRepository,
        workManager: WorkManager
    ): PagingUseCase {
        return PagingUseCase(
            pagingAppRepository,
            installedAppsRepository,
            downloadedRepository,
            workManager
        )
    }

    @Provides
    @Singleton
    fun provideInstalledAppUseCase(installedAppsRepository: InstalledAppsRepository): InstalledAppUseCase {
        return InstalledAppUseCase(installedAppsRepository)
    }

    @Provides
    @Singleton
    fun provideDownloadedUseCase(
        @ApplicationContext context: Context,
        downloadedRepository: DownloadedRepository
    ): DownloadedUseCase {
        return DownloadedUseCase(context, downloadedRepository)
    }
}