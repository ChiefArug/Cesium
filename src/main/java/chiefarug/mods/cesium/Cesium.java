package chiefarug.mods.cesium;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Cesium.MODID)
public class Cesium {
	public static final String MODID = "cesium";
	private final ForgeConfigSpec.BooleanValue yeetSmartCull;
	private final ForgeConfigSpec.BooleanValue yeetFOVChecks;
	private static Cesium instance;


	public Cesium() {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
		builder.comment("Note: This config file is NOT hot reloadable. You must restart the game for everything to take effect!");
		builder.push("Config");
		yeetSmartCull = builder.comment("Disables the smart culling check that hides chunks hidden behind other chunks")
					.define("disable_smart_cull", true);
		yeetFOVChecks = builder.comment("Disables the checks for if a chunk or entity is within your FOV. Setting this to true majorly reduces performance!")
				.define("disable_fov_checks", false);
		builder.pop();
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, builder.build());

		FMLJavaModLoadingContext.get().getModEventBus().addListener((FMLClientSetupEvent e) -> {
			if (yeetSmartCull.get())
				Minecraft.getInstance().smartCull = false;
		});
		instance = this;
	}

	public static boolean yeetFovChecks() {
		return instance.yeetFOVChecks.get();
	}
}
