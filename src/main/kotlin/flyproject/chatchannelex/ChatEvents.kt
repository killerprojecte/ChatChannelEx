package flyproject.chatchannelex

import me.albert.amazingbot.bot.Bot
import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.event.player.AsyncPlayerChatEvent
import taboolib.common.platform.event.SubscribeEvent
import taboolib.module.chat.uncolored

/**
 * @Author FlyProject
 * @Date 2021/12/19
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
                var send = ChatChannel.config.getString("GameToGroup")
                send = PlaceholderAPI.setPlaceholders(
                    event.player,
                    send
                )
                send = send.replace("%msg%",event.message.uncolored())
                Bot.getApi().sendGroupMsg(groups, send)
            }
        }
    }

}
