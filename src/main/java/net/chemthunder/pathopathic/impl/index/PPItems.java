package net.chemthunder.pathopathic.impl.index;

import net.acoyt.acornlib.api.registrants.ItemRegistrant;
import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.item.FoulPouchItem;
import net.chemthunder.pathopathic.impl.item.TestItem;
import net.chemthunder.pathopathic.impl.item.WrappedStickItem;
import net.minecraft.item.Item;

public interface PPItems {
    ItemRegistrant ITEMS = new ItemRegistrant(Pathopathic.MOD_ID);

    Item WRAPPED_STICK = ITEMS.register("wrapped_stick", WrappedStickItem::new, new Item.Settings().maxCount(1));
    Item FOUL_POUCH = ITEMS.register("foul_pouch", FoulPouchItem::new, new Item.Settings().maxCount(1));

    Item TEST = ITEMS.register("test", TestItem::new, new Item.Settings().maxCount(1));

    static void init() {}
}
