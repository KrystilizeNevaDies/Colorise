package org.krystilize.colorise.game;

import net.minestom.server.item.ItemStack;
import org.krystilize.colorise.Color;
import org.krystilize.colorise.game.mechanic.*;
import org.krystilize.colorise.queue.QueueSystem;

import java.util.List;

public class Level0Instance extends GameInstance {

    private static final List<Color> PLAYER1_COLORS = List.of(Color.BLUE, Color.RED);
    private static final List<Color> PLAYER2_COLORS = List.of(Color.GREEN, Color.YELLOW);

    public Level0Instance(QueueSystem queue, GameInfo info) {
        super(queue, info);

        for (int i = 0; i < PLAYER1_COLORS.size(); i++) {
            Color color = PLAYER1_COLORS.get(i);
            player1.getInventory().setItemStack(i, ItemStack.of(color.material()));
        }

        for (int i = 0; i < PLAYER2_COLORS.size(); i++) {
            Color color = PLAYER2_COLORS.get(i);
            player2.getInventory().setItemStack(i, ItemStack.of(color.material()));
        }
    }

    @Override
    public List<Mechanic> mechanics() {
        return List.of(
                new TimerMechanic(),
                new PlayerLeaveMechanic(),
                new RespawnMechanic(),
                new ColoredBlockManagerMechanic(),
                new HotbarColorController(),
                new WindowsMechanic(),
                new DoorControlMechanic(),
                new CheckpointMechanic(),
                new WinMechanic(),
                new GameChatMechanic()
        );
    }
}
