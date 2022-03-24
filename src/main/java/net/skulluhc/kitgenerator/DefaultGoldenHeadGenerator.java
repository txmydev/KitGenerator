package net.skulluhc.kitgenerator;

import net.skulluhc.kitgenerator.generator.GoldenHeadGenerator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DefaultGoldenHeadGenerator implements GoldenHeadGenerator {
    @Override
    public ItemStack getGoldenHead(int amount) {
        ItemStack stack = new ItemStack(Material.GOLDEN_APPLE, amount);
        ItemMeta meta = stack.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Golden Head");
        stack.setItemMeta(meta);

        return stack;
    }
}
