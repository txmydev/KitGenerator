package net.skulluhc.kitgenerator;

import lombok.Getter;
import lombok.Setter;
import net.skulluhc.kitgenerator.generator.GoldenHeadGenerator;
import net.skulluhc.kitgenerator.generator.KitGenerator;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class KitGeneratorLoader {

    private final JavaPlugin plugin;

    @Setter
    private GoldenHeadGenerator goldenHeadGenerator;
    private KitGenerator kitGenerator;

    public KitGeneratorLoader(JavaPlugin plugin) {
        this.plugin = plugin;

        this.load();

        Bukkit.getLogger().info("I was loaded with plugin " + plugin.getName());
    }

    public void load() {
        this.goldenHeadGenerator = new DefaultGoldenHeadGenerator();
        this.kitGenerator = new KitGenerator(goldenHeadGenerator);
    }

}
