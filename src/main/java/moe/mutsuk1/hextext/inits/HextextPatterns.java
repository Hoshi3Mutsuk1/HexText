package moe.mutsuk1.hextext.inits;

import at.petrak.hexcasting.api.PatternRegistry;
import at.petrak.hexcasting.api.spell.Action;
import at.petrak.hexcasting.api.spell.math.HexDir;
import at.petrak.hexcasting.api.spell.math.HexPattern;
import moe.mutsuk1.hextext.HexText;
import moe.mutsuk1.hextext.casting.patterns.jsontext.OpGetName;
import moe.mutsuk1.hextext.casting.patterns.jsontext.OpSetName;
import moe.mutsuk1.hextext.casting.patterns.jsontext.OpStringText;

public class HextextPatterns {

    public static void init() {
        try {
            registry("string_to_text", "awdwadeewwee", HexDir.SOUTH_EAST, new OpStringText());
            registry("get_name", "qaqwewdew", HexDir.EAST, new OpGetName());
            registry("set_name", "edewwqawq", HexDir.NORTH_EAST, new OpSetName());
        } catch (PatternRegistry.RegisterPatternException exn) {
            exn.printStackTrace();
        }
    }
    private static void registry(String name, String signature, HexDir startDir, Action action) throws PatternRegistry.RegisterPatternException {
        PatternRegistry.mapPattern(HexPattern.fromAngles(signature, startDir), HexText.id(name), action);
    }
}
