package moe.mutsuk1.hextext.api.casting;

import at.petrak.hexcasting.api.spell.ConstMediaAction;
import at.petrak.hexcasting.api.spell.OperationResult;
import at.petrak.hexcasting.api.spell.casting.CastingContext;
import at.petrak.hexcasting.api.spell.casting.eval.SpellContinuation;
import at.petrak.hexcasting.api.spell.iota.Iota;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface JavaConstMediaActionDefaultImpl extends ConstMediaAction {

    @Override
    default int getMediaCost() {
        return 0;
    };

    @Override
    default boolean isGreat() {
        return DefaultImpls.isGreat(this);
    }

    @Override
    default boolean getAlwaysProcessGreatSpell() {
        return DefaultImpls.getAlwaysProcessGreatSpell(this);
    }

    @Override
    default boolean getCausesBlindDiversion() {
        return DefaultImpls.getCausesBlindDiversion(this);
    }

    @NotNull
    @Override
    default Component getDisplayName() {
        return DefaultImpls.getDisplayName(this);
    }

    @NotNull
    @Override
    default OperationResult operate(@NotNull SpellContinuation spellContinuation, @NotNull List<Iota> list, @Nullable Iota iota, @NotNull CastingContext castingContext) {
        return DefaultImpls.operate(this, spellContinuation, list, iota, castingContext);
    }
}
