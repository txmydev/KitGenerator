package me.txmy.kitgenerator.kit;

import lombok.Data;
import me.txmy.kitgenerator.item.KitItem;
import me.txmy.kitgenerator.enums.ItemType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;

@Data
public class Kit {

    private List<KitItem> itemList = new ArrayList<>();

    public KitItem getByType(ItemType type) {
        for (KitItem item : itemList) {
            if(item.getType() == type) return item;
        }

        return null;
    }

    public void give(Player player) {
        PlayerInventory inventory = player.getInventory();

        inventory.setHelmet(getByType(ItemType.HELMET).getStack());
        inventory.setChestplate(getByType(ItemType.CHESTPLATE).getStack());
        inventory.setLeggings(getByType(ItemType.LEGGINGS).getStack());
        inventory.setBoots(getByType(ItemType.BOOTS).getStack());

        inventory.setItem(0, getByType(ItemType.SWORD).getStack());
        inventory.setItem(1, getByType(ItemType.ROD).getStack());
        inventory.setItem(2, getByType(ItemType.BOW).getStack());
   //     inventory.setItem(3, getByType(ItemType.WATER_BUCKET).getStack());
   //     inventory.setItem(4, getByType(ItemType.LAVA_BUCKET).getStack());
        inventory.setItem(5, getByType(ItemType.GOLDEN_APPLE).getStack());
        inventory.setItem(6, getByType(ItemType.GOLDEN_HEAD).getStack());

        inventory.setItem(7, getByType(ItemType.POTION).getStack());
        inventory.setItem(8, getByType(ItemType.COBWEB).getStack());

        inventory.setItem(17, getByType(ItemType.ARROW).getStack());
    }
}
