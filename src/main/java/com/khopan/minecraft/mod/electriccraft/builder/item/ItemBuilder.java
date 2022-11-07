package com.khopan.minecraft.mod.electriccraft.builder.item;

public class ItemBuilder {
	public ItemBuilder() {

	}

	public static ItemBuilder begin() {
		return new ItemBuilder();
	}

	public static void main(String[] args) {
		for(Package Package : ClassLoader.getSystemClassLoader().getDefinedPackages()) {
			System.out.println(Package.getName());
		}
	}
}
