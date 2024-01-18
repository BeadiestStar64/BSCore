package com.github.beadieststar64.plugins.bsseries.bscore.ItemMaker;

import org.bukkit.Material;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.UUID;

public interface MakerAPI {

    ItemStack createItem(Material material);
    void setName(String name);
    void setLore(List<String> list);
    void setEnchantments(ItemMeta meta, Enchantment[] enchantments, int[] enchantmentsLevel, boolean[] overEnchantments);
    void setItemFlag(ItemMeta meta, ItemFlag[] flags);
    void setAttribute(ItemMeta meta, String[] keys, UUID[] uuids, double amount, EquipmentSlot[] slots, AttributeModifier.Operation[] operations);
    String getName(String name);
}