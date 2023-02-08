package com.niangaoa.mywife

import com.niangaoa.mywife.config.WifeConfig
import com.niangaoa.mywife.event.WifeRandom
import com.niangaoa.mywife.event.WifeHelp
import com.niangaoa.mywife.event.WifeCommunicate
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.utils.info

/**
 * Mirai的主类
 * @author niangaoa
 * */
object WifeMain : KotlinPlugin(
    JvmPluginDescription(
        id = "com.niangaoa.mywife",
        name = "年糕的老婆插件",
        version = "0.0.1"
    )
) {
    private lateinit var wifeRandom : WifeRandom
    private lateinit var wifeCommunicate : WifeCommunicate
    private lateinit var wifeHelp : WifeHelp
    private lateinit var eventChannel : EventChannel<Event>
    override fun onEnable() {
        logger.info { "插件载入成功~欢迎使用" }
        wifeRandom = WifeRandom()
        wifeCommunicate = WifeCommunicate()
        wifeHelp = WifeHelp()
        eventChannel = GlobalEventChannel.parentScope(this)

        reloadConfig()
        addEventChannel(eventChannel)
    }

    /**
     * 重新加载config，调用WifeConfig.init()
     * @see WifeConfig
     * */
    fun reloadConfig() {
        WifeConfig.init()
    }

    /**
     * 用于简化以后增加消息判断后的私有方法
     * @param channel
     * */
    private fun addEventChannel(channel : EventChannel<Event>) {
        wifeRandom.wifeEventChannel(channel)
        wifeCommunicate.wifeEventChannel(channel)
        wifeHelp.wifeEventChannel(channel)
    }
}