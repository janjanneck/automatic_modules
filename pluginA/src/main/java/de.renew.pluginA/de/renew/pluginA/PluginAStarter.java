package de.renew.pluginA;

import de.renew.libraryX.LibraryXStarter;

public class PluginAStarter {
    public static void main(String[] args) {
        System.out.println("This is Plugin A");
    }

    public PluginAStarter() {
        System.out.println("LibraryX's user props: "
                + LibraryXStarter.userProperties());
    }
}