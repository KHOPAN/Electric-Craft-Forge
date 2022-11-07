package com.khopan.minecraft.mod.electriccraft.utils.builder_pattern;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class BuilderPatternInitializer {
	public static void initialize() {
		List<Class<?>> Classes = new ArrayList<>();

		for(Package Package : Thread.currentThread().getContextClassLoader().getDefinedPackages()) {
			System.out.println(Package.getName());

			for(Class<?> Class : BuilderPatternInitializer.getClasses(Package.getName())) {
				Classes.add(Class);
			}
		}

		for(Class<?> Class : Classes) {
			System.out.println(Class.getName());
		}
	}

	public static void main(String[] args) {
		BuilderPatternInitializer.initialize();
	}

	private static Class<?>[] getClasses(String PackageName) {
		try {
			ClassLoader ClassLoader = Thread.currentThread().getContextClassLoader();
			assert ClassLoader != null;
			String Path = PackageName.replace('.', '/');
			Enumeration<URL> Resources = ClassLoader.getResources(Path);
			List<File> Directories = new ArrayList<>();

			while(Resources.hasMoreElements()) {
				URL Resource = Resources.nextElement();
				Directories.add(new File(Resource.getFile()));
			}

			ArrayList<Class<?>> Classes = new ArrayList<>();

			for(File Directory : Directories) {
				Classes.addAll(BuilderPatternInitializer.findClasses(Directory, PackageName));
			}

			return Classes.toArray(new Class[Classes.size()]);
		} catch(Throwable Errors) {
			throw new RuntimeException(Errors);
		}
	}

	private static List<Class<?>> findClasses(File Directory, String PackageName) throws Throwable {
		List<Class<?>> Classes = new ArrayList<>();

		if (!Directory.exists()) {
			return Classes;
		}

		File[] Files = Directory.listFiles();

		for(File File : Files) {
			if(File.isDirectory()) {
				assert !File.getName().contains(".");
				Classes.addAll(BuilderPatternInitializer.findClasses(File, PackageName + "." + File.getName()));
			} else if(File.getName().endsWith(".class")) {
				Classes.add(Class.forName(PackageName + '.' + File.getName().substring(0, File.getName().length() - 6)));
			}
		}

		return Classes;
	}
}
