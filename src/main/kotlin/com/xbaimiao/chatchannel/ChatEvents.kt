package com.xbaimiao.chatchannel

import me.albert.amazingbot.bot.Bot
import org.bukkit.event.player.AsyncPlayerChatEvent
import taboolib.common.platform.event.SubscribeEvent
import taboolib.module.chat.uncolored

/**
 * @Author xbaimiao
 * @Date 2021/10/25 21:26
 */
object ChatEvents {

    @SubscribeEvent
    fun chat(event: AsyncPlayerChatEvent) {
        if (ChatChannel.config.getBoolean("GameChatToGroup.Enable")) {
            val msg=event.message
            for (anti in ChatChannel.config.getStringList("BanWord")){
                if (msg.contains(anti)){
                    event.setCancelled(true)
                }
            }
            for (groups in ChatChannel.config.getStringList("GameChatToGroup.groups")) {
                Bot.getApi().sendGroupMsg(groups, "[游戏消息] ${event.player.name}: ${event.message.uncolored()}")
            }
        }
    }

}
