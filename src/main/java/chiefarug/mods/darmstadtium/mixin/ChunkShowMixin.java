package chiefarug.mods.darmstadtium.mixin;

import chiefarug.mods.darmstadtium.Darmstadtium;
import net.minecraft.client.renderer.culling.Frustum;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Frustum.class)
public class ChunkShowMixin {

    @Inject(method = "isVisible(Lnet/minecraft/world/phys/AABB;)Z", cancellable = true, at = @At("HEAD"))
    private void setIsVisibleTrue(CallbackInfoReturnable<Boolean> cir) {
        if (Darmstadtium.yeetFovChecks()) cir.setReturnValue(true);

    }

}
