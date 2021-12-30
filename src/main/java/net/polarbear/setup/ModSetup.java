package net.polarbear.setup;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModSetup {
    public static final String TAB_NAME = "computer_node";

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(TAB_NAME) {
        @Override
        public ItemStack makeIcon() { //Registration.NODE_INGOT.get()
            return new ItemStack(Items.DIAMOND);
        }
    };

    public static void init(FMLCommonSetupEvent event){




    }
}
