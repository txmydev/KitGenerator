package me.txmy.kitgenerator;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class KitGeneratorPlugin extends JavaPlugin {

    @Getter
    private static KitGeneratorPlugin instance;

    private KitGeneratorLoader loader;

    @Override
    public void onEnable() {
        instance = this;

        this.loader = new KitGeneratorLoader(this);
    }
}
