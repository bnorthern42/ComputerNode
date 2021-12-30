package net.polarbear.datagen;

import net.minecraft.data.DataGenerator;
import net.polarbear.setup.Registration;

public class NodeLootTables extends BaseLootTableProvider{
    public NodeLootTables(DataGenerator dataGenerator){
        super(dataGenerator);
    }

    @Override
    protected void addTables(){
        lootTables.put(Registration.NODE_ORE_OVERWORLD.get(),
                createSilkTouchTable("node_ore_overworld",
                        Registration.NODE_ORE_OVERWORLD.get(),
                        Registration.RAW_NODE_CHUNK.get(), 1, 3));
        lootTables.put(Registration.NODE_ORE_NETHER.get(),
                createSilkTouchTable("node_ore_overworld",
                        Registration.NODE_ORE_NETHER.get(),
                        Registration.RAW_NODE_CHUNK.get(), 1, 4));
        lootTables.put(Registration.NODE_ORE_END.get(),
                createSilkTouchTable("node_ore_overworld",
                        Registration.NODE_ORE_END.get(),
                        Registration.RAW_NODE_CHUNK.get(), 1, 5));
        lootTables.put(Registration.NODE_ORE_DEEPSLATE.get(),
                createSilkTouchTable("node_ore_overworld",
                        Registration.NODE_ORE_DEEPSLATE.get(),
                        Registration.RAW_NODE_CHUNK.get(), 1, 5));
    }
    /**/

}
