package com.niangaoa.mywife.tools

import com.niangaoa.mywife.config.WifeConfig
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member

/**
 * 顾名思义，这是对数据进行操作的工具类，用来判断得到的组/成员id与配置文件是否相同
 * @author niangaoa
 * */
class DataUtils {
    private var bool1 = false
    private var bool2 = true
    private var bool3 = false
    private var i1 = 0
    private var i2 = 0

    /**
     * 判断组id是否与配置文件中的id相符或被封禁
     * @param group
     * @return Boolean
     * */
    fun isGottenGroupInConfig(group : Group) : Boolean {
        bool1 = false
        bool2 = true
        bool3 = false
        i1 = 0
        i2 = 0
        while (i1 < (WifeConfig.getGottenMap()["AcceptedGroups"]?.size() ?: 1)) {
            if (group.id == (WifeConfig.getGottenMap()["AcceptedGroups"]?.get(i1)?.asLong ?: 111))
                bool1 = true
            i1++
        }
        while (i2 < (WifeConfig.getGottenMap()["BanedGroups"]?.size() ?: 1)) {
            if (group.id == (WifeConfig.getGottenMap()["BanedGroups"]?.get(i2)?.asLong ?: 111)) {
                bool2 = false
            }
            i2++
        }

        if (bool1 == bool2) {
            bool3 = true
        }
        return bool3
    }

    /**
     * 判断成员id是否与配置文件中的id相符或被封禁
     * @param sender
     * @return Boolean
     * */
    fun isGottenSenderInConfig(sender : Member) : Boolean {
        bool1 = false
        bool2 = true
        bool3 = false
        i1 = 0
        i2 = 0
        while (i1 < (WifeConfig.getGottenMap()["AcceptedMembers"]?.size() ?: 1)) {
            if (sender.id == (WifeConfig.getGottenMap()["AcceptedMembers"]?.get(i1)?.asLong ?: 111))
                bool1 = true
            i1++
        }
        while (i2 < (WifeConfig.getGottenMap()["BanedMembers"]?.size() ?: 1)) {
            if (sender.id == (WifeConfig.getGottenMap()["BanedMembers"]?.get(i2)?.asLong ?: 111)) {
                bool2 = false
            }
            i2++
        }

        if (bool1 == bool2) {
            bool3 = true
        }
        return bool3
    }

    /**
     * 判断成员id是否为管理员(配置中的管理员)
     * @param sender
     * @return Boolean
     * */
    fun isGottenAdminInConfig(sender: Member) : Boolean {
        bool1 = false
        bool2 = true
        bool3 = false
        i1 = 0
        while (i1 < (WifeConfig.getGottenMap()["AdminMembers"]?.size() ?: 1)) {
            if (sender.id == (WifeConfig.getGottenMap()["AdminMembers"]?.get(i1)?.asLong ?: 111))
                bool3 = true
            i1++
        }
        return bool3
    }
}