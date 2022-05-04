package me.txmy.kitgenerator.generator;

import lombok.RequiredArgsConstructor;
import me.txmy.kitgenerator.item.KitItem;
import me.txmy.kitgenerator.kit.Kit;
import me.txmy.kitgenerator.enums.ItemType;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class KitGenerator {

    private final GoldenHeadGenerator goldenHeadGenerator;

    private final Random random = new Random();
    private final ThreadLocalRandom localRandom = ThreadLocalRandom.current();

    public void generateArmor(Kit kit) {
        ItemType current = ItemType.HELMET;
        while(current != null) {
            boolean diamond = random.nextDouble() <= 0.45D;
            Material type = diamond ? current.getMaterial("DIAMOND_") : current.getMaterial("IRON_");
            ItemStack stack = new ItemStack(type);

            int protectionLevel = (diamond ? localRandom.nextInt(1, 3) : localRandom.nextInt(2, 4));
            stack.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, protectionLevel);

            kit.getItemList().add(new KitItem(current, stack, true));

            current = ItemType.getNextArmorType(current);
        }
    }

    public void generateSword(Kit kit) {
        ItemType sword = ItemType.SWORD;
        boolean diamond = random.nextDouble() < 0.67D;

        Material type = diamond ? sword.getMaterial("DIAMOND_") : sword.getMaterial("IRON_");
        ItemStack stack = new ItemStack(type);

        int sharpnessLevel = diamond ? localRandom.nextInt(1, 3) : localRandom.nextInt(2, 4);
        if(random.nextDouble() <= 0.1D) stack.addEnchantment(Enchantment.FIRE_ASPECT, 1);
        stack.addEnchantment(Enchantment.DAMAGE_ALL, sharpnessLevel);

        kit.getItemList().add(new KitItem(sword, stack, true));
    }

    public void generateBow(Kit kit) {
        ItemType bow = ItemType.BOW;
        Material type = Material.BOW;

        int powerLevel = 1 + random.nextInt(2);
        ItemStack stack = new ItemStack(type);
        stack.addEnchantment(Enchantment.ARROW_DAMAGE, powerLevel);

        kit.getItemList().add(new KitItem(bow, stack, true));
    }

    public void generatePotion(Kit kit) {
        ItemType potion = ItemType.POTION;
        Material type = Material.POTION;

        boolean speed = random.nextDouble() <= 0.5D;
        short data = (short) (speed ? 8194 : 8195);

        kit.getItemList().add(new KitItem(potion, new ItemStack(type, 1, data), random.nextDouble() <= 0.2D));
    }

    public void generateCobwebs(Kit kit) {
        ItemType cobweb = ItemType.COBWEB;
        int[] range = cobweb.getAmountRange();

        int amount = localRandom.nextInt(range[0], range[1]);

        kit.getItemList().add(new KitItem(cobweb, new ItemStack(Material.WEB, amount), random.nextDouble() <= 0.1D));
    }

    public void generateGoldenApples(Kit kit) {
        ItemType goldenApple = ItemType.GOLDEN_APPLE;
        int[] range = goldenApple.getAmountRange();
        int amount = localRandom.nextInt(range[0], range[1]);

        kit.getItemList().add(new KitItem(goldenApple, new ItemStack(Material.GOLDEN_APPLE, amount), true));
    }

    public void generateGoldenHeads(Kit kit) {
        ItemType goldenApple = ItemType.GOLDEN_HEAD;
        int[] range = goldenApple.getAmountRange();
        int amount = localRandom.nextInt(range[0], range[1]);

        kit.getItemList().add(new KitItem(goldenApple, goldenHeadGenerator.getGoldenHead(amount), true));
    }

    public void generateBuckets(Kit kit) {
     //   kit.getItemList().add(new KitItem(ItemType.WATER_BUCKET, new ItemStack(Material.WATER_BUCKET,  1), true));
     //   kit.getItemList().add(new KitItem(ItemType.LAVA_BUCKET, new ItemStack(Material.WATER_BUCKET,  1), true));
    }

    public void generateArrow(Kit kit){
        ItemType arrow = ItemType.ARROW;
        int[] range = arrow.getAmountRange();

        int amount = localRandom.nextInt(range[0], range[1]);

        kit.getItemList().add(new KitItem(arrow, new ItemStack(Material.ARROW, amount), true));
    }

    public void generateRod(Kit kit) {
        kit.getItemList().add(new KitItem(ItemType.ROD, new ItemStack(Material.FISHING_ROD), true));
    }

    // There's a more efficient way but this works so yea...
    // Also, if you would like to modify how an item is made, it'll be easier to do it by overriding the method
    
    public Kit generateKit() {
        Kit kit = new Kit();

        this.generateArmor(kit);
        this.generateSword(kit);
        this.generateBow(kit);
        this.generatePotion(kit);
        this.generateCobwebs(kit);
        this.generateGoldenApples(kit);
        this.generateGoldenHeads(kit);
        this.generateBuckets(kit);
        this.generateArrow(kit);
        this.generateRod(kit);

        return kit;
    }
}
