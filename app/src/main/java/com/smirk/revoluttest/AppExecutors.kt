package com.smirk.revoluttest

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Tony Augustine on 09,September,2019
 * tonyaugustine47@gmail.com
 */
@Singleton
open class AppExecutors(private val diskIO: Executor,
                        private val networkIO: Executor,
                        private val mainThread: Executor
) {

    @Inject
    constructor() : this(
        Executors.newSingleThreadExecutor(),
        Executors.newFixedThreadPool(3),
        MainThreadExecutor()
    )

    fun diskIO() : Executor {
        return diskIO
    }

    fun networkIO() : Executor {
        return networkIO
    }

    fun mainThread() : Executor {
        return mainThread
    }

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper());
        override fun execute(command: Runnable?) {
            mainThreadHandler.post(command)
        }

    }
}