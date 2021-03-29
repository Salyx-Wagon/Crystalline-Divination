package salyx.crystalline.divination;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import salyx.crystalline.divination.core.init.BlockInit;
import salyx.crystalline.divination.core.init.ContainerTypeInit;
import salyx.crystalline.divination.core.init.ItemInit;
import salyx.crystalline.divination.core.init.TileEntityInit;
import salyx.crystalline.divination.world.OreGeneration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CrystalDiv.MOD_ID)
public class CrystalDiv
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "crystaldiv";
    public static final ItemGroup CRYSTALLINE_DIVINATION_GROUP = new CrystallineDivinationGroup("crystalline_divination");

    public CrystalDiv() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        TileEntityInit.TILE_ENTITY_TYPE.register(bus);
        ContainerTypeInit.CONTAINER_TYPES.register(bus);

        //MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH,OreGeneration::generateOres);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.LOWEST, OreGeneration::generateCrystals);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLClientSetupEvent event) {  
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockInit.BASE_RUNE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.STORAGE_RUNE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.SOLAR_CRYSTAL_CLUSTER.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.LUNAR_CRYSTAL_CLUSTER.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.PYRO_CRYSTAL_CLUSTER.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.HYDRO_CRYSTAL_CLUSTER.get(), RenderType.getTranslucent());
    }

    public static class CrystallineDivinationGroup extends ItemGroup {

        public CrystallineDivinationGroup(String label) {
            super("crystalline_divination");
        }

        @Override
        public ItemStack createIcon() {
            // TODO Auto-generated method stub
            return ItemInit.PURE_CRYSTAL.get().getDefaultInstance();
        }
        
        @Override
        public void fill(NonNullList<ItemStack> items) {
            items.add(ItemInit.SOLAR_CRYSTAL_CLUSTER.get().getDefaultInstance());
            items.add(ItemInit.LUNAR_CRYSTAL_CLUSTER.get().getDefaultInstance());
            items.add(ItemInit.PYRO_CRYSTAL_CLUSTER.get().getDefaultInstance());
            items.add(ItemInit.HYDRO_CRYSTAL_CLUSTER.get().getDefaultInstance());
            items.add(ItemInit.SOLAR_CRYSTAL.get().getDefaultInstance());
            items.add(ItemInit.LUNAR_CRYSTAL.get().getDefaultInstance());
            items.add(ItemInit.PYRO_CRYSTAL.get().getDefaultInstance());
            items.add(ItemInit.HYDRO_CRYSTAL.get().getDefaultInstance());
            items.add(ItemInit.PURE_CRYSTAL.get().getDefaultInstance());
            items.add(ItemInit.CRYSTAL_SWORD.get().getDefaultInstance());
            items.add(ItemInit.CRYSTAL_AXE.get().getDefaultInstance());
            items.add(ItemInit.CRYSTAL_PICKAXE.get().getDefaultInstance());
            items.add(ItemInit.CRYSTAL_SHOVEL.get().getDefaultInstance());
            items.add(ItemInit.CRYSTAL_HOE.get().getDefaultInstance());
            items.add(ItemInit.CRYSTAL_HELMET.get().getDefaultInstance());
            items.add(ItemInit.CRYSTAL_CHESTPLATE.get().getDefaultInstance());
            items.add(ItemInit.CRYSTAL_LEGGINGS.get().getDefaultInstance());
            items.add(ItemInit.CRYSTAL_BOOTS.get().getDefaultInstance());
            items.add(ItemInit.SOLAR_CRYSTAL_SWORD.get().getDefaultInstance());
            items.add(ItemInit.SOLAR_CRYSTAL_AXE.get().getDefaultInstance());
            items.add(ItemInit.SOLAR_CRYSTAL_PICKAXE.get().getDefaultInstance());
            items.add(ItemInit.SOLAR_CRYSTAL_SHOVEL.get().getDefaultInstance());
            items.add(ItemInit.SOLAR_CRYSTAL_HOE.get().getDefaultInstance());
            items.add(ItemInit.SOLAR_CRYSTAL_HELMET.get().getDefaultInstance());
            items.add(ItemInit.SOLAR_CRYSTAL_CHESTPLATE.get().getDefaultInstance());
            items.add(ItemInit.SOLAR_CRYSTAL_LEGGINGS.get().getDefaultInstance());
            items.add(ItemInit.SOLAR_CRYSTAL_BOOTS.get().getDefaultInstance());
            items.add(ItemInit.LUNAR_CRYSTAL_SWORD.get().getDefaultInstance());
            items.add(ItemInit.LUNAR_CRYSTAL_AXE.get().getDefaultInstance());
            items.add(ItemInit.LUNAR_CRYSTAL_PICKAXE.get().getDefaultInstance());
            items.add(ItemInit.LUNAR_CRYSTAL_SHOVEL.get().getDefaultInstance());
            items.add(ItemInit.LUNAR_CRYSTAL_HOE.get().getDefaultInstance());
            items.add(ItemInit.LUNAR_CRYSTAL_HELMET.get().getDefaultInstance());
            items.add(ItemInit.LUNAR_CRYSTAL_CHESTPLATE.get().getDefaultInstance());
            items.add(ItemInit.LUNAR_CRYSTAL_LEGGINGS.get().getDefaultInstance());
            items.add(ItemInit.LUNAR_CRYSTAL_BOOTS.get().getDefaultInstance());
            items.add(ItemInit.PYRO_CRYSTAL_SWORD.get().getDefaultInstance());
            items.add(ItemInit.PYRO_CRYSTAL_AXE.get().getDefaultInstance());
            items.add(ItemInit.PYRO_CRYSTAL_PICKAXE.get().getDefaultInstance());
            items.add(ItemInit.PYRO_CRYSTAL_SHOVEL.get().getDefaultInstance());
            items.add(ItemInit.PYRO_CRYSTAL_HOE.get().getDefaultInstance());
            items.add(ItemInit.PYRO_CRYSTAL_HELMET.get().getDefaultInstance());
            items.add(ItemInit.PYRO_CRYSTAL_CHESTPLATE.get().getDefaultInstance());
            items.add(ItemInit.PYRO_CRYSTAL_LEGGINGS.get().getDefaultInstance());
            items.add(ItemInit.PYRO_CRYSTAL_BOOTS.get().getDefaultInstance());
            items.add(ItemInit.HYDRO_CRYSTAL_SWORD.get().getDefaultInstance());
            items.add(ItemInit.HYDRO_CRYSTAL_AXE.get().getDefaultInstance());
            items.add(ItemInit.HYDRO_CRYSTAL_PICKAXE.get().getDefaultInstance());
            items.add(ItemInit.HYDRO_CRYSTAL_SHOVEL.get().getDefaultInstance());
            items.add(ItemInit.HYDRO_CRYSTAL_HOE.get().getDefaultInstance());
            items.add(ItemInit.HYDRO_CRYSTAL_HELMET.get().getDefaultInstance());
            items.add(ItemInit.HYDRO_CRYSTAL_CHESTPLATE.get().getDefaultInstance());
            items.add(ItemInit.HYDRO_CRYSTAL_LEGGINGS.get().getDefaultInstance());
            items.add(ItemInit.HYDRO_CRYSTAL_BOOTS.get().getDefaultInstance());
            items.add(ItemInit.SOLAR_CRYSTAL_DUST.get().getDefaultInstance());
            items.add(ItemInit.LUNAR_CRYSTAL_DUST.get().getDefaultInstance());
            items.add(ItemInit.PYRO_CRYSTAL_DUST.get().getDefaultInstance());
            items.add(ItemInit.HYDRO_CRYSTAL_DUST.get().getDefaultInstance());
            items.add(ItemInit.PURE_CRYSTAL_DUST.get().getDefaultInstance());
            items.add(ItemInit.DIVINATION_WAND.get().getDefaultInstance());
            items.add(ItemInit.CRYSTALLINE_TABLET.get().getDefaultInstance());
            items.add(ItemInit.PEDESTAL.get().getDefaultInstance());
            items.add(ItemInit.ADVANCED_ITEM.get().getDefaultInstance());
            items.add(ItemInit.BASE_RUNE.get().getDefaultInstance());
            items.add(ItemInit.STORAGE_RUNE.get().getDefaultInstance());
        }
    }
}
