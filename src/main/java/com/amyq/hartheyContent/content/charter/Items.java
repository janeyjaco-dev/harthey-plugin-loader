package com.amyq.hartheyContent.content.charter;

import com.amyq.hartheyContent.loader.plugin.util.Registries;
import com.amyq.hartheyContent.loader.plugin.util.RegistryKey;
import com.amyq.hartheyContent.loader.plugin.util.items.Item;

public class Items {
    public static final Item SOULCLEAVE_GLAIVE = new SoulcleaveGlaiveItem(Item.Settings.create().maxStackSize(1));

     public static void registerItems() {
         Registries.ITEM.register(SOULCLEAVE_GLAIVE, new com.amyq.hartheyContent.loader.plugin.util.RegistryEntry<>(SOULCLEAVE_GLAIVE, new RegistryKey<>("charter", "soulcleave_glaive")));
     }
}
