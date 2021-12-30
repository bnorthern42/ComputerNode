package net.polarbear.setup;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.polarbear.computer_node.MODID;

public class Registration {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS =  DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }
    /**
     * Commond Properties for blocks and items
     * */
    public static final BlockBehaviour.Properties ORE_PROPERTIES =
            BlockBehaviour.Properties.of(Material.STONE).strength(2f);
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);

    public static final BlockBehaviour.Properties DEEPSLATE_ORE_PROPERTIES =
            BlockBehaviour.Properties.of(Material.STONE).strength(4.5f);

    public static final BlockBehaviour.Properties NETHER_ORE_PROPERTIES =
            BlockBehaviour.Properties.of(Material.STONE).strength(3f);

    public static final BlockBehaviour.Properties END_ORE_PROPERTIES =
            BlockBehaviour.Properties.of(Material.STONE).strength(3f);


    /**
     * Register each block item pair for each dimension
     * */
    public static final RegistryObject<Block> NODE_ORE_OVERWORLD =
            BLOCKS.register("node_ore_overworld", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item>  NODE_ORE_OVERWORLD_ITEM =
            fromBlock(NODE_ORE_OVERWORLD);

    public static final RegistryObject<Block> NODE_ORE_NETHER =
            BLOCKS.register("node_ore_nether", () -> new Block(NETHER_ORE_PROPERTIES));
    public static final RegistryObject<Item> NODE_ORE_NETHER_ITEM =
            fromBlock(NODE_ORE_NETHER);

    public static final RegistryObject<Block> NODE_ORE_END =
            BLOCKS.register("node_ore_end", () -> new Block(END_ORE_PROPERTIES));
    public static final RegistryObject<Item> NODE_ORE_END_ITEM =
            fromBlock(NODE_ORE_END);

    public static final RegistryObject<Block> NODE_ORE_DEEPSLATE =
            BLOCKS.register("node_ore_deepslate", () -> new Block(DEEPSLATE_ORE_PROPERTIES));
    public static final RegistryObject<Item> NODE_ORE_DEEPSLATE_ITEM =
            fromBlock(NODE_ORE_DEEPSLATE);

    /** Add item and chunk for node ore and node chunk, etc...
    */
    public static final RegistryObject<Item> RAW_NODE_CHUNK = ITEMS.register("raw_node_chunk", ()-> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> NODE_INGOT = ITEMS.register("node_ingot", ()-> new Item(ITEM_PROPERTIES));

    /** Add our own tag to make life easier so that we don't have to go ..._OVER , ..._NETH.. etc...
     * Will be referenced by this tag instead
     */
    public static final Tags.IOptionalNamedTag<Block> NODE_ORE = BlockTags.createOptional(
            new ResourceLocation(MODID, "node_ore")
    );
    public static final Tags.IOptionalNamedTag<Item> NODE_ORE_ITEM = ItemTags.createOptional(
            new ResourceLocation(MODID, "node_ore")
    );
    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block){
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }
}
