package com.khopan.minecraft.mod.electriccraft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ElectricCraft.MOD_ID)
public class ElectricCraft {
	public static final String MOD_NAME = "Electric Craft";
	public static final String MOD_VERSION = "1.0.0";
	public static final String MOD_ID = "electriccraft";
	public static final String MOD_AUTHOR = "KHOPAN";

	public static final Logger LOGGER = LoggerFactory.getLogger(ElectricCraft.MOD_NAME);

	public final IEventBus EventBus;

	public ElectricCraft() {
		this.EventBus = FMLJavaModLoadingContext.get().getModEventBus();
		this.EventBus.addListener(this :: initialize);

		MinecraftForge.EVENT_BUS.register(this.EventBus);
	}

	public void initialize(FMLCommonSetupEvent Event) {
		ElectricCraft.LOGGER.info("Initializing Electric Craft");
	}
}
