package de.ft.statistics

import com.badlogic.gdx.graphics.Texture
import com.kotcrab.vis.ui.widget.Menu
import com.kotcrab.vis.ui.widget.MenuItem
import de.ft.interitus.Var
import de.ft.interitus.datamanager.programmdata.experience.ExperienceVar
import de.ft.interitus.plugin.Plugin
import de.ft.interitus.plugin.PluginAssetManager
import de.ft.interitus.plugin.ProgramRegistry

class Main : Plugin {
    var id = 0
    var texture: Texture? = null
    var blockanzahl = MenuItem("Blöcke: ")
    var wireanzahl = MenuItem("Wires: ")
    var stunden = MenuItem("stunden: ")

    override fun register(registry: ProgramRegistry): Boolean {
        val menue = Menu("Statistics")
        menue.addItem(MenuItem("open Statistics"))
        blockanzahl.isDisabled = true
        wireanzahl.isDisabled = true
        stunden.isDisabled = true
        menue.addItem(wireanzahl)
        menue.addItem(blockanzahl)
        menue.addItem(stunden)
        registry.addMenuEntry(menue, this)
        id = registry.loadAsset("test.png", this)
        registry.addPluginRender(this) { spriteBatch, spriteBatch1, shapeRenderer, shapeRenderer1 ->
            spriteBatch.begin()
            spriteBatch.end()
        }
        return true
    }

    override fun init(pluginAssetManager: PluginAssetManager): Boolean {
        texture = pluginAssetManager.collectTextureAsset(id)
        return false
    }

    override fun run(): Boolean {
        try {
            try {
                blockanzahl.text = "Blöcke: " + Var.openprojects[Var.openprojectindex].blocks.size
                wireanzahl.text = "Wires: " + Var.openprojects[Var.openprojectindex].wires.size
            } catch (e: IndexOutOfBoundsException) {
                blockanzahl.text = "Blöcke: " + "0"
                wireanzahl.text = "Wires: " + "0"
            }
            stunden.text = "stunden: " + Math.round(ExperienceVar.programmtimeinhoures)
        } catch (e: NoSuchFieldError) {
        }
        return true
    }
}
