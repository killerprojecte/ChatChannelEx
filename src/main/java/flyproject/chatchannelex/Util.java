package flyproject.chatchannelex;

import me.albert.amazingbot.bot.Bot;
import net.mamoe.mirai.Mirai;
import net.mamoe.mirai.message.data.Image;
import org.bukkit.entity.Player;

/**
 * @Author FlyProject
 * @Date 2021/12/19
 */
public class Util {

    public static String query(Image image) {
        return Mirai.getInstance().queryImageUrl(Bot.getApi().getBot(), image);
    }
    //移除颜色符号 防止&k导致客户端卡顿
    public static String removecolor(String paramString) {
        paramString = paramString.replaceAll("[§]", "&");
        String str = "(&+)([0-9a-fA-F])";
        paramString = paramString.replaceAll(str, "");
        String str2 = "(&+)([k-orK-OR])";
        paramString = paramString.replaceAll(str2, "");
        return paramString;
    }

}
