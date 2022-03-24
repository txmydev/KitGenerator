package net.skulluhc.kitgenerator.item;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.skulluhc.kitgenerator.enums.ItemType;
import org.bukkit.inventory.ItemStack;

@Data @RequiredArgsConstructor
public class KitItem {

    private final ItemType type;
    private final ItemStack stack;
    private final boolean enabled;

    public ItemStack getStack(){
         return enabled ? stack : null;
    }

}
