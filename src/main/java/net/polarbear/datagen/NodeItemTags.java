package net.polarbear.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.polarbear.computer_node;
import net.polarbear.setup.Registration;

public class NodeItemTags  extends ItemTagsProvider {
    public NodeItemTags(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper){
        super(generator, blockTagsProvider, computer_node.MODID, existingFileHelper);
    }
    @Override
    protected void addTags(){
        tag(Tags.Items.ORES)
                .add(Registration.NODE_ORE_OVERWORLD_ITEM.get())
                .add(Registration.NODE_ORE_NETHER_ITEM.get())
                .add(Registration.NODE_ORE_END_ITEM.get())
                .add(Registration.NODE_ORE_DEEPSLATE_ITEM.get());
        tag(Tags.Items.INGOTS)
                .add(Registration.NODE_INGOT.get());

        tag(Registration.NODE_ORE_ITEM)
                .add(Registration.NODE_ORE_OVERWORLD_ITEM.get())
                .add(Registration.NODE_ORE_NETHER_ITEM.get())
                .add(Registration.NODE_ORE_END_ITEM.get())
                .add(Registration.NODE_ORE_DEEPSLATE_ITEM.get());


    }
    @Override
    public String getName() {return "computernode tags";}


}
