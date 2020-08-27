package de.renew.pluginTwo;

import bibliothek.gui.dock.common.DefaultSingleCDockable;
import bibliothek.gui.dock.common.action.CAction;

public class PluginTwoStarter {
    public static void main(String[] args) {
        System.out.println("This is Plugin 2");
        DefaultSingleCDockable dockable = new DefaultSingleCDockable("test", new CAction[]{});
        dockable.getUniqueId();
    }
}
