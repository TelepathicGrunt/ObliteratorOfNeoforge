package telepathicgrunt.obliteratorofneoforge.mixins;

import net.minecraft.server.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import telepathicgrunt.obliteratorofneoforge.ObliteratorOfNeoforgeMod;

@Mixin(value = Main.class)
public class MainMixin {

    @Inject(
            method = "main([Ljava/lang/String;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/server/dedicated/DedicatedServerSettings;forceSave()V"))
    private static void obliteratorOfNeoforge$noMoreEvents2(CallbackInfo ci) throws NoSuchFieldException, IllegalAccessException {
        ObliteratorOfNeoforgeMod.shutdownNeoBus();
    }
}

