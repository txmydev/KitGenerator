package net.skulluhc.kitgenerator;

import lombok.Getter;
import lombok.Setter;
import net.skulluhc.kitgenerator.generator.GoldenHeadGenerator;
import net.skulluhc.kitgenerator.generator.KitGenerator;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class KitGeneratorPlugin extends JavaPlugin {

    @Getter
    private static KitGeneratorPlugin instance;

    @Setter
    private GoldenHeadGenerator goldenHeadGenerator;
    private KitGenerator kitGenerator;

    @Override
    public void onEnable() {
        instance = this;

        this.goldenHeadGenerator = new DefaultGoldenHeadGenerator();
        this.kitGenerator = new KitGenerator(goldenHeadGenerator);
    }
}
