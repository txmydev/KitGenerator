package net.skulluhc.kitgenerator.enums;

import org.bukkit.Material;

public enum ItemType {

    SWORD,
    ROD,
    BOW,
    POTION,
    GOLDEN_APPLE,
    GOLDEN_HEAD,
    COBWEB,
    HELMET,
    CHESTPLATE,
    LEGGINGS,
    BOOTS,
    WATER_BUCKET,
    LAVA_BUCKET,
    ARROW;

    public Material getMaterial(String prefix) {
        return prefix == null ? Material.valueOf(this.name()) : Material.valueOf(prefix + this.name());
    }

    public boolean isStackable() {
        return this == ARROW ||
                this == COBWEB || this == GOLDEN_APPLE
                || this == GOLDEN_HEAD;
    }

    public int[] getAmountRange() {
        switch(this) {
            case GOLDEN_APPLE:
                return new int[]{4, 9};
            case GOLDEN_HEAD:
                return new int[]{2, 6};
            case COBWEB:
                return new int[]{10, 32};
            case ARROW:
                return new int[]{32, 64};
        }

        throw new IllegalArgumentException("ItemType " + name() + " is not stackable.");
    }

    public static ItemType getNextArmorType(ItemType current) {
        switch(current) {
            case HELMET:
                return CHESTPLATE;
            case CHESTPLATE:
                return LEGGINGS;
            case LEGGINGS:
                return BOOTS;
            case BOOTS:
                return null;
        }

        return null;
    }

}
