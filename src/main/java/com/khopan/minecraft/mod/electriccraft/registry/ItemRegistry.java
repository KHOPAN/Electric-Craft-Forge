package com.khopan.minecraft.mod.electriccraft.registry;

import com.khopan.minecraft.mod.electriccraft.ElectricCraft;
import com.khopan.minecraft.mod.electriccraft.item.BatteryItem;
import com.khopan.minecraft.mod.electriccraft.item.CreativeBatteryItem;
import com.khopan.minecraft.mod.electriccraft.item.supersonicgunitem.SuperSonicGunItem;

import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
	public static final RegistryObject<Item> LITHIUM_INGOT = ElectricCraftRegistries.ITEM_REGISTRY.register("lithium_ingot", () -> new Item(new Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> ELECTRIC_INGOT = ElectricCraftRegistries.ITEM_REGISTRY.register("electric_ingot", () -> new Item(new Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final Item ELECTRIC_BAR = ItemBuilder.build(ItemBuilder.group(ItemGroup.MISC), "electric_bar");
	public static final Item BATTERY_ITEM = Registry.register(Registry.ITEM, new Identifier(ElectricCraft.MOD_ID, "battery"), new BatteryItem());
	public static final Item CREATIVE_BATTERY_ITEM = Registry.register(Registry.ITEM, new Identifier(ElectricCraft.MOD_ID, "creative_battery"), new CreativeBatteryItem());
	public static final Item SUPER_SONIC_GUN_ITEM = Registry.register(Registry.ITEM, new Identifier(ElectricCraft.MOD_ID, "super_sonic_gun"), new SuperSonicGunItem());

	public static void registerItem() {
		ElectricCraft.LOGGER.info("Initializing Items");
	}
}
