package moe.mutsuk1.hextext.casting.patterns.jsontext;

import at.petrak.hexcasting.api.spell.OperatorUtils;
import at.petrak.hexcasting.api.spell.ParticleSpray;
import at.petrak.hexcasting.api.spell.RenderedSpell;
import at.petrak.hexcasting.api.spell.casting.CastingContext;
import at.petrak.hexcasting.api.spell.iota.Iota;
import kotlin.Triple;
import moe.mutsuk1.hextext.api.OperatorUtilsKt;
import moe.mutsuk1.hextext.api.casting.JavaSpellActionDefaultImpl;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OpSetName implements JavaSpellActionDefaultImpl {

    @Override
    public int getArgc() {
        return 2;
    }

    @Nullable
    @Override
    public Triple<RenderedSpell, Integer, List<ParticleSpray>> execute(@NotNull List<? extends Iota> list, @NotNull CastingContext castingContext) {
        var entity = OperatorUtils.getEntity(list, 0, getArgc());
        var name = OperatorUtilsKt.getJSONText(list, 1, getArgc());
        castingContext.assertEntityInRange(entity);

        return new Triple<>(
                new Spell(entity, name),
                0,
                List.of(ParticleSpray.burst(entity.position(), 0.5, 1))
        );
    }

    private class Spell implements RenderedSpell {

        Entity entity;
        Component name;
        public Spell(Entity entity, Component name) {
            this.entity = entity;
            this.name = name;
        }
        @Override
        public void cast(@NotNull CastingContext castingContext) {
            if (entity instanceof ItemEntity item) {
                item.getItem().setHoverName(name);
            } else {
                entity.setCustomName(name);
            }
        }
    }
}
