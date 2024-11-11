package moe.mutsuk1.hextext.casting.patterns.jsontext;

import at.petrak.hexcasting.api.spell.OperatorUtils;
import at.petrak.hexcasting.api.spell.casting.CastingContext;
import at.petrak.hexcasting.api.spell.iota.Iota;
import moe.mutsuk1.hextext.api.casting.JavaConstMediaActionDefaultImpl;
import moe.mutsuk1.hextext.api.casting.iota.JSONTextIota;
import net.minecraft.world.entity.item.ItemEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OpGetName implements JavaConstMediaActionDefaultImpl {
    @Override
    public int getArgc() {
        return 1;
    }

    @NotNull
    @Override
    public List<Iota> execute(@NotNull List<? extends Iota> list, @NotNull CastingContext castingContext) {
        var entity = OperatorUtils.getEntity(list, 0, getArgc());
        castingContext.assertEntityInRange(entity);
        Iota iota = null;
        if (entity instanceof ItemEntity item) {
            iota = JSONTextIota.make(item.getItem().getHoverName());
        } else {
            iota = JSONTextIota.make(entity.getCustomName());
        }
        return List.of(iota);
    }

}
