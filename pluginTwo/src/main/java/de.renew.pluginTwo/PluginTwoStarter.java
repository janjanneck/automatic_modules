package de.renew.pluginTwo;

import org.freehep.graphics2d.PrintColor;

import java.io.File;
import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.lang.module.ResolvedModule;
import java.util.List;
import java.util.stream.Collectors;

public class PluginTwoStarter {
    public static void main(String[] args) {
        System.out.println("This is Plugin 2");
        System.out.println(PrintColor.COLOR);

        ModuleFinder finder = ModuleFinder.of(new File("/Users/janrobert/masterarbeit/gradletest/Renew/pluginOne/build/libs/de.renew.pluginOne.jar").toPath());

        Configuration parent = ModuleLayer.boot().configuration();

        Configuration cf = Configuration.resolve(ModuleFinder.of(), List.of(parent), finder, List.of("de.renew.pluginOne"));

        cf.modules().forEach(module -> {
            System.out.format("%s -> %s%n",
                    module.name(),
                    module.reads().stream()
                    .map(ResolvedModule::name)
                    .collect(Collectors.joining(", "))
                    );
        });

        ModuleLayer.Controller controller = ModuleLayer.defineModulesWithOneLoader(
                cf, List.of(ModuleLayer.boot()), PluginTwoStarter.class.getClassLoader()
        );

        ModuleLayer layer = controller.layer();

        try {
            Class<?> aClass = Class.forName(layer.modules().stream().findFirst().get(),
                    "de.renew.pluginOne.PluginOneStarter");
            Object o = aClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
