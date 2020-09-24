package de.renew.pluginOne;


import de.renew.pluginThree.PluginThreeStarter;

public class PluginOneStarter {
    public static void main(String[] args) {
        System.out.println("This is Plugin 1");
    }

    public PluginOneStarter() {
        System.out.println("Plugin Threes user props: "
                + PluginThreeStarter.userProperties());
    }
}