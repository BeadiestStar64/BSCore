package com.github.beadieststar64.plugins.bsseries.bscore.ItemMaker;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.UUID;
import java.util.jar.Attributes;

public class Maker implements MakerAPI {

    private String itemName;
    private List<String> itemLore;

    public ItemStack createItem(Material material, String name, List<String> lore, Enchantment[] enchantments, int[] level, boolean[] overEnchantments) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(enchantments[0], 5, true);
        item.setItemMeta(meta);
        meta.addAttributeModifier(Attribute.valueOf(""), new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
        return item;
    }

    @Override
    public ItemStack createItem(Material material) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(getName(""));
        return null;
    }

    @Override
    public void setName(String name) {
        this.itemName = name;
    }

    @Override
    public void setLore(List<String> list) {
        this.itemLore = list;
    }

    @Override
    public void setEnchantments(ItemMeta meta, Enchantment[] enchantments, int[] enchantmentsLevel, boolean[] overEnchantments) {

    }

    @Override
    public void setItemFlag(ItemMeta meta, ItemFlag[] flags) {
        ItemMeta itemMeta = meta;
    }

    @Override
    public void setAttribute(ItemMeta meta, String[] keys, UUID[] uuids, double amount, EquipmentSlot[] slots, AttributeModifier.Operation[] operations) {

    }

    @Override
    public String getName(String name) {
        return itemName;
    }
}
