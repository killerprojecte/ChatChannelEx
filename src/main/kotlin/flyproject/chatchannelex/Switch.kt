package flyproject.chatchannelex

import org.bukkit.entity.Player

/**
 * @Author FlyProject
 * @Date 2021/12/19
 */
object Switch {

    val map = HashMap<String, Boolean>()

    fun Player.setSwitch(boolean: Boolean) {
        map[this.name] = boolean
    }

    fun Player.isSwitch(): Boolean {
        return map[this.name] ?: true
    }

}