package org.compose_projects.socialocal.common.data.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import org.compose_projects.socialocal.common.domain.model.IpDevice
import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface

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
            for (netInterface in interfaces) {
                val address = netInterface.inetAddresses
                for (addr in address) {
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


    private val checkJobsScope = CoroutineScope(Dispatchers.IO)


    override suspend fun getActiveIpDevices(): List<IpDevice> = coroutineScope {
        val ipDevice = getIpDevice() ?: throw Exception("Not found ip device :(")

        val gateway = getGateWay(ipDevice)
        val activeIpDevices = mutableListOf<IpDevice>()

        val checkingJobs: ArrayList<Job> = arrayListOf()

        (0..254)
            .asSequence()
            .map { "$gateway.$it" }
            .forEach { ip ->
                checkingJobs.add(checkJobsScope.launch {
                    try {
                        val inetAddress = InetAddress.getByName(ip)
                        if (inetAddress.isReachable(500)) {
                            val ipDeviceFound = parseIpAddress(ip, true)!!
                            synchronized(activeIpDevices) {
                                activeIpDevices.add(ipDeviceFound)
                            }
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                })
            }
        checkingJobs.joinAll()
        activeIpDevices.toList()

    }

}