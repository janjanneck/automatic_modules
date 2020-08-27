package de.renew.pluginOne;

import bibliothek.gui.dock.common.DefaultSingleCDockable;
import bibliothek.gui.dock.common.action.CAction;

import java.awt.*;

public class PluginOneStarter {
    public static void main(String[] args) {

        DefaultSingleCDockable dockable = new DefaultSingleCDockable("Navigator", new CAction[]{});


        Window[] window = Window.getWindows();
        System.out.println("Windows: ");
        for (Window window1 : window) {
            System.out.println(window1.getLocale().toString());
        }

        String lib = de.renew.pluginTwo.Library.lib;
    }
}
