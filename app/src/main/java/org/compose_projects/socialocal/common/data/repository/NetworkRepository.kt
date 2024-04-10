package org.compose_projects.socialocal.common.data.repository

import kotlinx.coroutines.coroutineScope
import org.compose_projects.socialocal.common.domain.model.IpDevice
import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface
import java.util.concurrent.Executors
import java.util.concurrent.Future


interface NetworkRepository {

    suspend fun getIpDevice(): IpDevice?
    suspend fun getActiveIpDevices(): List<IpDevice>
}

class NetworkRepositoryImp : NetworkRepository {


    private fun getGateWay(ipDevice: IpDevice) =
        with(ipDevice) { "%d.%d.%d".format(octet1, octet2, octet3) }

    private fun parseIpAddress(ipAddress: String, isActive: Boolean): IpDevice? {
        val regex = Regex("""(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})""")
        val match = regex.find(ipAddress) ?: return null
        val (octet1, octet2, octet3, octet4) = match.destructured
        return IpDevice(octet1.toInt(), octet2.toInt(), octet3.toInt(), octet4.toInt(), isActive)

    }

    override suspend fun getIpDevice(): IpDevice? {
        // 172.16.1.15

        try {
            val interfaces = NetworkInterface.getNetworkInterfaces()
            for (intf in interfaces) {
                val addrs = intf.inetAddresses
                for (addr in addrs) {
                    if (!addr.isLoopbackAddress && addr is Inet4Address) {
                        val ip = addr.getHostAddress()!!
                        return parseIpAddress(ip, true)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }


    override suspend fun getActiveIpDevices(): List<IpDevice> = coroutineScope {
        val executor = Executors.newFixedThreadPool(100)

        val ipDevice = getIpDevice() ?: throw Exception("Not found ip device :(")

        val gateway = getGateWay(ipDevice)
        val activeIpDevices = mutableListOf<IpDevice>()

        val futures = mutableListOf<Future<Unit>>()

        for (i in 0..254) {
            val testIp = "$gateway.$i"
            val future = executor.submit {
                try {
                    val inetAddress = InetAddress.getByName(testIp)
                    if (inetAddress.isReachable(500)) {
                        val ipDeviceFound = parseIpAddress(testIp, true)!!
                        synchronized(activeIpDevices) {
                            activeIpDevices.add(ipDeviceFound)
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            futures.add(future as Future<Unit>)
        }

        for (future in futures) {
            future.get()
        }

        executor.shutdown()
        activeIpDevices.toList()

        /*



        val ipDevice = getIpDevice() ?: throw Exception("Not found ip device :(")
        val gateway = getGateWay(ipDevice)
        val mutex = Mutex()
        val activeIpDevices = mutableListOf<IpDevice>()

        val deferredList = mutableListOf<Deferred<Unit>>()

        for (i in 0..254) {
            val testIp = "$gateway.$i"
            val deferred = async(Dispatchers.Default) {
                try {

                        val inetAddress = InetAddress.getByName(testIp)
                        if (isActive) {
                            if (inetAddress.isReachable(500)) {
                                val ipDeviceFound = parseIpAddress(testIp, true)!!
                                mutex.withLock {
                                    activeIpDevices.add(ipDeviceFound)
                                }
                            }
                        }


                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            deferredList.add(deferred)


        }



         */


    }

}