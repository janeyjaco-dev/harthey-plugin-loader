package com.amyq.hartheyContent.loader.plugin.util.items;

import com.amyq.hartheyContent.loader.plugin.util.RegistryItem;
import com.amyq.hartheyContent.loader.plugin.util.RegistryKey;
import com.amyq.hartheyContent.loader.plugin.util.action.TypedActionResult;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class Item implements RegistryItem {

    private final Settings settings;
    private final RegistryKey<Item> key;

    public Item(Settings settings) {
        this.settings = settings;
        this.key = settings.key;
    }

    public RegistryKey<Item> getKey() {
        return key;
    }

    public Settings getSettings() {
        return settings;
    }

    public ItemStack createStack() {
        return new ItemStack(this);
    }

    public TypedActionResult<ItemStack> use(ItemStack stack, Player player, World world) {
        return new TypedActionResult<>();
    }

    // ========================================================================
    //  SETTINGS (Fabric-style builder)
    // ========================================================================
    public static class Settings {

        RegistryKey<Item> key;

        boolean fireproof = false;
        boolean unbreakable = false;

        float maxDurability = 0f;
        int maxStackSize = 64;

        final Components components = new Components();

        private Settings() {}

        public static Settings create() {
            return new Settings();
        }

        // -----------------------
        // Registry Key
        // -----------------------
        public Settings key(RegistryKey<Item> key) {
            this.key = key;
            return this;
        }

        // -----------------------
        // Flags
        // -----------------------
        public Settings fireproof() {
            this.fireproof = true;
            return this;
        }

        public Settings unbreakable() {
            this.unbreakable = true;
            return this;
        }

        // -----------------------
        // Durability / Stack Size
        // -----------------------
        public Settings maxDurability(float durability) {
            this.maxDurability = durability;
            return this;
        }

        public Settings maxStackSize(int size) {
            this.maxStackSize = size;
            return this;
        }

        // -----------------------
        // Components
        // -----------------------
        public Settings component(ItemComponent component) {
            this.components.add(component);
            return this;
        }

        public Components getComponents() {
            return components;
        }

        // ====================================================================
        //  COMPONENTS INNER CLASS
        // ====================================================================
        public static class Components {

            private final Set<ItemComponent> list = new HashSet<>();

            public void add(ItemComponent component) {
                list.add(component);
            }

            public boolean has(Class<? extends ItemComponent> type) {
                return list.stream().anyMatch(type::isInstance);
            }

            public <T extends ItemComponent> T get(Class<T> type) {
                return list.stream()
                        .filter(type::isInstance)
                        .map(type::cast)
                        .findFirst()
                        .orElse(null);
            }

            public Set<ItemComponent> all() {
                return list;
            }
        }
    }

    public float maxUseTime() {
        return 0;
    }

    public void onFinishedUsing(ItemStack stack, World world, Player player) {

    }

    public void onCraft(ItemStack stack, World world, Player player) {

    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return false;
    }

    public boolean postMine(ItemStack stack, World world, Block block, BlockState state, LivingEntity miner) {
        return false;
    }

    public boolean postBreak(ItemStack stack, World world, Block block, BlockState state, Player player) {
        return false;
    }
}