package de.ft.statistics;

import com.kotcrab.vis.ui.widget.Menu;
import com.kotcrab.vis.ui.widget.MenuItem;

import de.ft.interitus.Programm;
import de.ft.interitus.Var;
import de.ft.interitus.datamanager.programmdata.experience.ExperienceVar;
import de.ft.interitus.plugin.*;



public class Main implements Plugin {

    MenuItem blockanzahl = new MenuItem("Blöcke: ");
    MenuItem wireanzahl = new MenuItem("Wires: ");
    MenuItem stunden = new MenuItem("stunden: ");

    @Override
    public boolean register() {



        Menu menue = new Menu("Statistics");
        menue.addItem(new MenuItem("open Statistics"));
        blockanzahl.setDisabled(true);
        wireanzahl.setDisabled(true);
        stunden.setDisabled(true);
        menue.addItem(wireanzahl);
        menue.addItem(blockanzahl);
        menue.addItem(stunden);
        PluginGateway.addMenuEntry(menue,this);


        return true;

    }

    @Override
    public boolean stop() {
        return false;
    }

    @Override
    public boolean run() {


        try {
            try {
                blockanzahl.setText("Blöcke: " + Var.openprojects.get(Var.openprojectindex).blocks.size());
                wireanzahl.setText("Wires: " + Var.openprojects.get(Var.openprojectindex).wires.size());
            }catch (IndexOutOfBoundsException e) {
                blockanzahl.setText("Blöcke: " + "0");
                wireanzahl.setText("Wires: " + "0");

            }
            stunden.setText("stunden: " + Math.round(ExperienceVar.programmtimeinhoures));
        } catch (NoSuchFieldError e) {

        }
        return true;
    }

    @Override
    public String getName() {
        return "Statistics";
    }

    @Override
    public double getVersion() {
        return 1.0;
    }

    @Override
    public String getDescription() {
        return "Dieses Plugin zeigt dir Statistiken an";
    }

    @Override
    public String getLongDescription() {
        return "Es werden die benutzen Blöcke, die Wires und die verbrachten Stunden im Programm angezeigt";
    }

    @Override
    public String getAuthor() {
        return "FT-Interitus";
    }

}
