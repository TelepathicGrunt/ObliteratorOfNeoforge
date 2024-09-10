package telepathicgrunt.obliteratorofneoforge;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.EventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(ObliteratorOfNeoforgeMod.MODID)
public class ObliteratorOfNeoforgeMod {
    public static final String MODID = "obliterator_of_neoforge";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ObliteratorOfNeoforgeMod() throws NoSuchFieldException, IllegalAccessException {
        shutdownModBus();
    }

    public static void shutdownModBus() throws NoSuchFieldException, IllegalAccessException {
        ObliteratorOfNeoforgeMod.LOGGER.warn("Shutting down Mod Bus!");
        for (ModContainer modContainer : ModList.get().getSortedMods()) {
            if (modContainer.getEventBus() instanceof EventBus eventBus && !modContainer.getModId().equals("neoforge")) {
                var declaredField = eventBus.getClass().getDeclaredField("shutdown");
                boolean accessible = declaredField.canAccess(eventBus);
                declaredField.setAccessible(true);
                declaredField.set(eventBus, true);
                declaredField.setAccessible(accessible);
            }
        }
    }

    public static void shutdownNeoBus() throws NoSuchFieldException, IllegalAccessException {
        ObliteratorOfNeoforgeMod.LOGGER.warn("Shutting down Neoforge Bus!");
        if (NeoForge.EVENT_BUS instanceof EventBus eventBus) {
            var declaredField = eventBus.getClass().getDeclaredField("shutdown");
            boolean accessible = declaredField.canAccess(eventBus);
            declaredField.setAccessible(true);
            declaredField.set(eventBus, true);
            declaredField.setAccessible(accessible);
        }
    }
}
