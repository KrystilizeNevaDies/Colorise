package org.krystilize.colorise.game.mechanic;

import net.minestom.server.coordinate.Point;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.krystilize.colorise.Color;
import org.krystilize.colorise.colors.InstanceAnalysis;

import java.nio.file.Path;
import java.util.Collections;
import java.util.Map;

/**
 * Analyzes the blocks in the instance for specific block types
 */
public class BlockAnalysisMechanic implements Mechanic {
    private final Path pathToRegions;
    public BlockAnalysisMechanic(Path pathToRegions) {
        this.pathToRegions = pathToRegions;
    }


    public Analysis<Color> COLORED_BLOCKS = new Analysis<>();
    public Analysis<Color> WINDOW_PANES = new Analysis<>();
    public Analysis<Boolean> PRESSURE_PLATES = new Analysis<>();
    public Analysis<Block> TERRACOTTA = new Analysis<>();


    @Override
    public void setup(Context context) {
        COLORED_BLOCKS.blocks = InstanceAnalysis.scanForColoredBlocks(context.instance(), pathToRegions);
        WINDOW_PANES.blocks = InstanceAnalysis.scanForWindowPanes(context.instance(), pathToRegions);
        PRESSURE_PLATES.blocks = InstanceAnalysis.scanForPressurePlates(context.instance(), pathToRegions);
        TERRACOTTA.blocks = InstanceAnalysis.scanForTerracottaBlocks(context.instance(), pathToRegions);
    }

    public static class Analysis<T> {

        private @Nullable Map<Point, T> blocks = null;

        public @NotNull Map<Point, T> get() {
            if (blocks == null) {
                throw new IllegalStateException("Cannot access analysis before it is complete");
            }
            return Collections.unmodifiableMap(blocks);
        }
    }
}
