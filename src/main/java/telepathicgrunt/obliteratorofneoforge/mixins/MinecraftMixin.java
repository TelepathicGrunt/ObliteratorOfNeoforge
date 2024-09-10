package telepathicgrunt.obliteratorofneoforge.mixins;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import telepathicgrunt.obliteratorofneoforge.ObliteratorOfNeoforgeMod;

@Mixin(value = Minecraft.class)
public class MinecraftMixin {

    @Inject(
            method = "onGameLoadFinished(Lnet/minecraft/client/Minecraft$GameLoadCookie;)V",
            at = @At(value = "RETURN"))
    private void obliteratorOfNeoforge$noMoreEvents(CallbackInfo ci) throws NoSuchFieldException, IllegalAccessException {
        ObliteratorOfNeoforgeMod.shutdownNeoBus();
    }
}

