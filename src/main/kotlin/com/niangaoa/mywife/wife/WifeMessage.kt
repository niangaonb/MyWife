package com.niangaoa.mywife.wife

import com.niangaoa.mywife.api.IWifeMessage
import com.niangaoa.mywife.tools.DataUtils
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel

/**
 * 所有操作消息的基类
 * 实例化了DataUtils
 * @see DataUtils
 * @author niangaoa
 */
open class WifeMessage : IWifeMessage {
    protected val dataUtils = DataUtils()
    override fun wifeEventChannel(event: EventChannel<Event>) {
    }
}