package net.polarbear.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.polarbear.computer_node;
import net.polarbear.setup.Registration;

public class NodeItemModels extends ItemModelProvider {
    public NodeItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper){
        super(generator, computer_node.MODID, existingFileHelper);
    }
    @Override
    protected void registerModels(){
        withExistingParent(Registration.NODE_ORE_OVERWORLD_ITEM.get()
                .getRegistryName().getPath(), modLoc("block/node_ore_overworld"));
        withExistingParent(Registration.NODE_ORE_NETHER_ITEM.get()
                .getRegistryName().getPath(), modLoc("block/node_ore_nether"));
        withExistingParent(Registration.NODE_ORE_END_ITEM.get()
                .getRegistryName().getPath(), modLoc("block/node_ore_end"));
        withExistingParent(Registration.NODE_ORE_DEEPSLATE_ITEM.get()
                .getRegistryName().getPath(), modLoc("block/node_ore_deepslate"));

        singleTexture(Registration.RAW_NODE_CHUNK.get().getRegistryName().getPath(),
                        mcLoc("item/generated"),
                        "layer0", modLoc("item/raw_node_chunk"));
        singleTexture(Registration.NODE_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/node_ingot"));
    }
}
