package net.chemthunder.pathopathic.impl.index;

import net.acoyt.acornlib.api.registrants.ItemGroupRegistrant;
import net.chemthunder.pathopathic.impl.Pathopathic;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public interface PPItemGroups {
    ItemGroupRegistrant ITEM_GROUPS = new ItemGroupRegistrant(Pathopathic.MOD_ID);

    RegistryKey<ItemGroup> GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, Pathopathic.id("pathopathic"));
    ItemGroup MAIN = FabricItemGroup.builder()
            .icon(() -> new ItemStack(PPItems.WRAPPED_STICK))
            .displayName(Text.translatable("itemGroup.pathopathic").styled(style -> style.withColor(0xc6fc6f)))
            .build();

    static void init() {
        ITEM_GROUPS.register("pathopathic", MAIN);
        ItemGroupEvents.modifyEntriesEvent(GROUP_KEY).register(PPItemGroups::addEntries);
    }

    private static void addEntries(FabricItemGroupEntries itemGroup) {
        for (Item item : PPItems.ITEMS.toRegister) {
            itemGroup.add(item);
        }
    }
}
