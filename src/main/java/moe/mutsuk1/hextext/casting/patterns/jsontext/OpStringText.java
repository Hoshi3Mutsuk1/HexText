package moe.mutsuk1.hextext.casting.patterns.jsontext;

import at.petrak.hexcasting.api.spell.ConstMediaAction;
import at.petrak.hexcasting.api.spell.OperationResult;
import at.petrak.hexcasting.api.spell.casting.CastingContext;
import at.petrak.hexcasting.api.spell.casting.eval.SpellContinuation;
import at.petrak.hexcasting.api.spell.iota.Iota;
import moe.mutsuk1.hextext.api.casting.JavaConstMediaActionDefaultImpl;
import moe.mutsuk1.hextext.api.casting.iota.JSONTextIota;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OpStringText implements JavaConstMediaActionDefaultImpl {

    @Override
    public int getArgc() {
        return 1;
    }

    @NotNull
    @Override
    public List<Iota> execute(@NotNull List<? extends Iota> list, @NotNull CastingContext castingContext) {
        String s = ram.talia.moreiotas.api.OperatorUtilsKt.getStringOrNull(list, 0, getArgc());
        var iota = JSONTextIota.make(s);
        return List.of(iota);
    }

}
