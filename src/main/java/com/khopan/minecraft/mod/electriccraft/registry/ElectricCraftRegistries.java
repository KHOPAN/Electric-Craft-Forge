package com.khopan.minecraft.mod.electriccraft.registry;

import com.khopan.minecraft.mod.electriccraft.ElectricCraft;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ElectricCraftRegistries {
	public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ElectricCraft.MOD_ID);

	public static void registerElectricCraftRegistries(IEventBus EventBus) {
		ElectricCraftRegistries.ITEM_REGISTRY.register(EventBus);
	}
}
