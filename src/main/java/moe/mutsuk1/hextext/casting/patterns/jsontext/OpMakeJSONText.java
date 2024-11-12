package moe.mutsuk1.hextext.casting.patterns.jsontext;

import at.petrak.hexcasting.api.spell.casting.CastingContext;
import at.petrak.hexcasting.api.spell.iota.Iota;
import moe.mutsuk1.hextext.api.casting.JavaConstMediaActionDefaultImpl;
import moe.mutsuk1.hextext.api.casting.iota.JSONTextIota;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OpMakeJSONText implements JavaConstMediaActionDefaultImpl {

    @Override
    public int getArgc() {
        return 1;
    }

    @NotNull
    @Override
    public List<Iota> execute(@NotNull List<? extends Iota> list, @NotNull CastingContext castingContext) {
        var s = ram.talia.moreiotas.api.OperatorUtilsKt.getStringOrList(list, 0, getArgc());
        var iota = s.map(JSONTextIota::make, JSONTextIota::make);
        return List.of(iota);
    }

}
