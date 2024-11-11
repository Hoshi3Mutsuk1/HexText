package moe.mutsuk1.hextext;

import moe.mutsuk1.hextext.inits.HextextIotaType;
import moe.mutsuk1.hextext.inits.HextextPatterns;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HexText implements ModInitializer {

    public static final String MOD_ID = "hextext";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        HextextIotaType.init();
        HextextPatterns.init();
    }

    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}
