package de.renew.pluginLoader;

import de.renew.libraryX.LibraryXStarter;

import java.io.File;
import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.lang.module.ResolvedModule;
import java.util.List;
import java.util.stream.Collectors;

public class PluginLoader {
    public static void main(String[] args) {
        System.out.println("This is the plugin Loader");

        System.out.println("Using return type from library Y: " + LibraryXStarter.userProperties());

        ModuleFinder finder = ModuleFinder.of(new File("lib/de.renew.pluginA.jar").toPath());

        Configuration parent = ModuleLayer.boot().configuration();

        Configuration cf = Configuration.resolve(ModuleFinder.of(), List.of(parent), finder, List.of("de.renew.pluginA"));

        cf.modules().forEach(module -> {
            System.out.format("%s -> %s%n",
                    module.name(),
                    module.reads().stream()
                    .map(ResolvedModule::name)
                    .collect(Collectors.joining(", "))
                    );
        });

        ModuleLayer.Controller controller = ModuleLayer.defineModulesWithOneLoader(
                cf, List.of(ModuleLayer.boot()), de.renew.pluginLoader.PluginLoader.class.getClassLoader()
        );

        ModuleLayer layer = controller.layer();

        try {
            Class<?> aClass = Class.forName(layer.modules().stream().findFirst().get(),
                    "de.renew.pluginA.PluginAStarter");
            Object o = aClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
