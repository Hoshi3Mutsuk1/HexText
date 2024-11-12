package moe.mutsuk1.hextext.api.casting.iota;

import at.petrak.hexcasting.api.spell.iota.Iota;
import at.petrak.hexcasting.api.spell.iota.IotaType;
import at.petrak.hexcasting.api.utils.HexUtils;
import com.google.gson.*;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class JSONTextIota extends Iota {

    private JSONTextIota(Component text) {
        super(JSONTextIota.TYPE, text);
    }
    public static JSONTextIota make(Component component) {
        return new JSONTextIota(component);
    }

    public static JSONTextIota make(String s) {
        return make(List.of(s));
    }

    public static JSONTextIota make(List<String> list) {
        try {
           JsonArray jsonArray = new JsonArray();
            for (String s : list) {
                var obj = Component.Serializer.toJsonTree(Component.Serializer.fromJson(s));
                jsonArray.add(obj);
            }
            return make(Component.Serializer.fromJson(jsonArray));
        } catch (JsonParseException e) {
           return new JSONTextIota(Component.empty());
       }
    }

    public Component getComponent() {
        return (Component) (this.payload);
    }

    @Override
    public boolean isTruthy() {
        return !this.getComponent().getString().isEmpty();
    }

    @Override
    protected boolean toleratesOther(Iota that) {
        return typesMatch(this, that)
                && that instanceof JSONTextIota jthat
                && this.getComponent().equals(jthat.getComponent());
    }

    @Override
    public @NotNull Tag serialize() {
        return StringTag.valueOf(Component.Serializer.toJson(this.getComponent()));
    }

    public static IotaType<JSONTextIota> TYPE = new IotaType<>() {
        @Override
        public JSONTextIota deserialize(Tag tag, ServerLevel world) throws IllegalArgumentException {
            var stag = HexUtils.downcast(tag, StringTag.TYPE);
            return JSONTextIota.make(stag.getAsString());
        }

        @Override
        public Component display(Tag tag) {
            var stag = HexUtils.downcast(tag, StringTag.TYPE);
            return Component.Serializer.fromJson(stag.getAsString());
        }

        @Override
        public int color() {
            return 0xe2d3f0;
        }
    };
}
