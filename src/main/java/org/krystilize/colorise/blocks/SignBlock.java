package org.krystilize.colorise.blocks;

import net.minestom.server.instance.block.BlockHandler;
import net.minestom.server.tag.Tag;
import net.minestom.server.utils.NamespaceID;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Set;

public enum SignBlock implements BlockHandler {
    INSTANCE;

    @Override
    public @NotNull NamespaceID getNamespaceId() {
        return NamespaceID.from("minecraft:sign");
    }

    @Override
    public @NotNull Collection<Tag<?>> getBlockEntityTags() {
        return Set.of(Tag.Component("front_text"), Tag.Component("back_text"), Tag.Boolean("is_waxed"));
    }
}
