package org.compose_projects.socialocal.common.data.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.compose_projects.socialocal.core.model.IpDevice
import org.compose_projects.socialocal.core.data.repository.NetworkRepository
import org.compose_projects.socialocal.core.data.repository.NetworkRepositoryImp
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

//import androidx.test.runner.AndroidJUnit4


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class NetworkRepositoryImpTest{

    private val repository: NetworkRepository by lazy { NetworkRepositoryImp() }

    private val dispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(dispatcher)

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        dispatcher.cleanupTestCoroutines()
        }
    @Test
    fun getIpDevice() = runTest{
        val ipDevice = repository.getIpDevice()
        println(ipDevice)
        assert(ipDevice != null){
            "Ip device not found"
        }
    }

    @Test
    fun getActiveIpDevices() = runTest {

        var devices = mutableListOf<IpDevice>()
        testScope.launch {
            devices = repository.getActiveIpDevices().toMutableList()
        }
        assert(devices.isNotEmpty()){
            "Not found devices in Local Network"
        }
    }
}