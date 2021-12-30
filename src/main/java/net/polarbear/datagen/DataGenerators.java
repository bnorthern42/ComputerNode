package net.polarbear.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.polarbear.computer_node;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid= computer_node.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        if(event.includeServer()){
            generator.addProvider(new NodeRecipes(generator));
            generator.addProvider(new NodeLootTables(generator));
            NodeBlockTags blockTags = new NodeBlockTags(generator, event.getExistingFileHelper());
            generator.addProvider(blockTags);
            generator.addProvider(new NodeItemTags(generator, blockTags, event.getExistingFileHelper()));
        }
        if(event.includeClient()){
            generator.addProvider(new NodeBlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new NodeItemModels(generator, event.getExistingFileHelper()));
            generator.addProvider(new NodeLanguageProvider(generator, "en_us"));
        }
    }
}
