package chiefarug.mods.cesium.mixin;

import chiefarug.mods.cesium.Cesium;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Frustum.class)
public class ChunkShowMixin {

    @Inject(method = "isVisible(Lnet/minecraft/world/phys/AABB;)Z", cancellable = true, at = @At("HEAD"))
    private void setIsVisibleTrue(CallbackInfoReturnable<Boolean> cir) {
        if (Cesium.yeetFovChecks()) cir.setReturnValue(true);

    }

}
