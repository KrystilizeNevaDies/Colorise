package org.krystilize.colorise.game.mechanic;

import net.kyori.adventure.text.Component;
import net.minestom.server.entity.Player;
import net.minestom.server.event.instance.InstanceTickEvent;
import org.krystilize.colorise.game.GameInstance;

public class TimerMechanic implements Mechanic {

    public void setup(Context context) {
        long startTime = System.currentTimeMillis();

        context.events().addListener(InstanceTickEvent.class, event -> {
            GameInstance game = context.instance();

            for (Player player : game.getPlayers()) {

                long seconds = (System.currentTimeMillis() - startTime) / 1000;

                long displayMinutes = seconds / 60;
                long displaySeconds = seconds % 60;

                player.sendActionBar(Component.text("Time passed - " + displayMinutes + ":" + displaySeconds));
            }
        });
    }
}