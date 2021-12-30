package net.polarbear.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.polarbear.computer_node;
import net.polarbear.setup.Registration;

public class NodeBlockStates extends BlockStateProvider {
    public NodeBlockStates(DataGenerator gen, ExistingFileHelper helper){
        super(gen, computer_node.MODID, helper);
    }
    @Override
    protected void registerStatesAndModels(){
        simpleBlock(Registration.NODE_ORE_OVERWORLD.get());
        simpleBlock(Registration.NODE_ORE_NETHER.get());
        simpleBlock(Registration.NODE_ORE_END.get());
        simpleBlock(Registration.NODE_ORE_DEEPSLATE.get());
    }
}
