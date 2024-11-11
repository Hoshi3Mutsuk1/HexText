package moe.mutsuk1.hextext.api

import at.petrak.hexcasting.api.spell.iota.Iota
import at.petrak.hexcasting.api.spell.mishaps.MishapInvalidIota
import at.petrak.hexcasting.api.spell.mishaps.MishapNotEnoughArgs
import moe.mutsuk1.hextext.api.casting.iota.JSONTextIota
import net.minecraft.network.chat.Component

fun List<Iota>.getJSONText(idx: Int, argc: Int = 0): Component {
    val x = this.getOrElse(idx) { throw MishapNotEnoughArgs(idx + 1, this.size) }
    if (x is JSONTextIota) {
        return x.component;
    } else {
        throw MishapInvalidIota.ofType(x, if (argc == 0) idx else argc - (idx + 1), "json_text")
    }
}