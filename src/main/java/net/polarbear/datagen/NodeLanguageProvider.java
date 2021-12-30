package net.polarbear.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import net.polarbear.computer_node;
import net.polarbear.setup.Registration;

import static net.polarbear.setup.ModSetup.TAB_NAME;

public class NodeLanguageProvider extends LanguageProvider {

    public NodeLanguageProvider(DataGenerator dataGenerator, String locale){
        super(dataGenerator, computer_node.MODID, locale);
    }
    @Override
    protected void addTranslations(){
        add("ItemGroup." + TAB_NAME, " computernode");
        add(Registration.NODE_ORE_OVERWORLD.get(), "Node Ore");
        add(Registration.NODE_ORE_NETHER.get(), "Node Ore");
        add(Registration.NODE_ORE_END.get(), "Node Ore");
        add(Registration.NODE_ORE_DEEPSLATE.get(), "Node Ore");
        add(Registration.RAW_NODE_CHUNK.get(), "Node Ore Chunk");
        add(Registration.NODE_INGOT.get(), "Node Ingot");
    }
}
