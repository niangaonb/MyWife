package com.niangaoa.mywife.api

import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel

/**所有与消息操作有关的类的接口
 * @author niangaoa
 * */
interface IWifeMessage {
    fun wifeEventChannel(event : EventChannel<Event>)
}