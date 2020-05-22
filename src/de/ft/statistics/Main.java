package de.ft.statistics;

import com.badlogic.gdx.Input;
import com.kotcrab.vis.ui.widget.Menu;
import com.kotcrab.vis.ui.widget.MenuItem;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTable;
import de.ft.interitus.Block.BlockVar;
import de.ft.interitus.ProgrammingSpace;
import de.ft.interitus.UI.MenuBar;
import de.ft.interitus.UI.shortcut.ShortCut;
import de.ft.interitus.UI.shortcut.SpecialKeys;
import de.ft.interitus.data.user.experience.ExperienceVar;
import de.ft.interitus.plugin.Configuration;
import de.ft.interitus.plugin.Plugin;
import de.ft.interitus.plugin.PluginManagerHandler;
import de.ft.interitus.plugin.PluginRegister;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main implements Plugin {
PluginRegister pluginRegister =new PluginRegister();
    MenuItem blockanzahl=new MenuItem("Blöcke: ");
    MenuItem wireanzahl=new MenuItem("Wires: ");
    MenuItem stunden=new MenuItem("stunden: ");

    @Override
    public boolean register() {


        pluginRegister.config(Configuration.name,"statistics");
        pluginRegister.config(Configuration.version,"9.0");
        PluginManagerHandler.register(pluginRegister);
        Menu menue=new Menu("Statistics");
        menue.addItem(new MenuItem("open Statistics"));
       blockanzahl.setDisabled(true);
       wireanzahl.setDisabled(true);
       stunden.setDisabled(true);
       menue.addItem(wireanzahl);
       menue.addItem(blockanzahl);
       menue.addItem(stunden);
       PluginManagerHandler.addMenuEntry(menue);


        return true;

    }

    @Override
    public boolean stop() {
        return false;
    }

    @Override
    public boolean run() {


                blockanzahl.setText("Blöcke: "+ BlockVar.blocks.size());
                wireanzahl.setText("Wires: "+BlockVar.wires.size());
                stunden.setText("stunden: "+ Math.round(ExperienceVar.programmtimeinhoures));

return true;
    }

}
