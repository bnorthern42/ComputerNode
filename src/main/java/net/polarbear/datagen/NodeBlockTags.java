package net.polarbear.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.polarbear.computer_node;
import net.polarbear.setup.Registration;

public class NodeBlockTags extends BlockTagsProvider {

    public NodeBlockTags(DataGenerator generator, ExistingFileHelper existingFileHelper){
        super(generator, computer_node.MODID, existingFileHelper);
    }
    @Override
   protected void addTags(){
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Registration.NODE_ORE_OVERWORLD.get())
                .add(Registration.NODE_ORE_NETHER.get())
                .add(Registration.NODE_ORE_END.get())
                .add(Registration.NODE_ORE_DEEPSLATE.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Registration.NODE_ORE_OVERWORLD.get())
                .add(Registration.NODE_ORE_NETHER.get())
                .add(Registration.NODE_ORE_END.get())
                .add(Registration.NODE_ORE_DEEPSLATE.get());
        tag(Tags.Blocks.ORES)
                .add(Registration.NODE_ORE_OVERWORLD.get())
                .add(Registration.NODE_ORE_NETHER.get())
                .add(Registration.NODE_ORE_END.get())
                .add(Registration.NODE_ORE_DEEPSLATE.get());

        tag(Registration.NODE_ORE)
                .add(Registration.NODE_ORE_OVERWORLD.get())
                .add(Registration.NODE_ORE_NETHER.get())
                .add(Registration.NODE_ORE_END.get())
                .add(Registration.NODE_ORE_DEEPSLATE.get());



    }
    @Override
    public String getName() {return "computer_node Tags";}
}
