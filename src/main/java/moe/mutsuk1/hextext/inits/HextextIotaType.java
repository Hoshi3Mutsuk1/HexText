package moe.mutsuk1.hextext.inits;


import at.petrak.hexcasting.common.lib.hex.HexIotaTypes;
import moe.mutsuk1.hextext.HexText;
import moe.mutsuk1.hextext.api.casting.iota.JSONTextIota;
import net.minecraft.core.Registry;
public class HextextIotaType {
    public static void init() {
        Registry.register(HexIotaTypes.REGISTRY, HexText.id("json_text"), JSONTextIota.TYPE);
    }
}
