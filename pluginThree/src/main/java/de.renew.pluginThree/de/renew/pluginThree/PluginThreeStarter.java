package de.renew.pluginThree;


import org.freehep.graphics2d.PrintColor;
import org.freehep.graphicsbase.util.UserProperties;


public class PluginThreeStarter {

    public static void main(String[] args) {
        System.out.println(PrintColor.COLOR);
    }

    public static UserProperties userProperties() {
        return new UserProperties();
    }
}
