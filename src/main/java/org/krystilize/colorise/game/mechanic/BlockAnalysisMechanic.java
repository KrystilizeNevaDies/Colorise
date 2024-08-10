package org.krystilize.colorise.game.mechanic;

import net.minestom.server.coordinate.Point;
import org.krystilize.colorise.Color;
import org.krystilize.colorise.colors.InstanceAnalysis;

import java.nio.file.Path;
import java.util.Collections;
import java.util.Map;

public class BlockAnalysisMechanic implements Mechanic {
    private final Path pathToRegions;
    public BlockAnalysisMechanic(Path pathToRegions) {
        this.pathToRegions = pathToRegions;
    }


    private Map<Point, Color> coloredBlocks = null;
    public Map<Point, Color> getColoredBlocks() {
        if (coloredBlocks == null) {
            throw new IllegalStateException("Cannot get colored blocks before setup");
        }
        return Collections.unmodifiableMap(coloredBlocks);
    }

    private Map<Point, Color> windowPanes = null;
    public Map<Point, Color> getWindowPanes() {
        if (windowPanes == null) {
            throw new IllegalStateException("Cannot get window panes before setup");
        }
        return Collections.unmodifiableMap(windowPanes);
    }


    @Override
    public void setup(Context context) {
        coloredBlocks = InstanceAnalysis.scanForColoredBlocks(context.instance(), pathToRegions);
        windowPanes = InstanceAnalysis.scanForWindowPanes(context.instance(), pathToRegions);
    }
}