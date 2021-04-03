package salyx.crystalline.divination.core.util;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import salyx.crystalline.divination.CrystalDiv;
import salyx.crystalline.divination.client.guis.BaseRuneScreen;
import salyx.crystalline.divination.client.guis.PedestalBlockScreen;
import salyx.crystalline.divination.client.guis.StorageRuneScreen;
import salyx.crystalline.divination.client.guis.ter.BaseRuneTileEntityRenderer;
import salyx.crystalline.divination.client.guis.ter.ExportRuneTileEntityRenderer;
import salyx.crystalline.divination.client.guis.ter.ImportRuneTileEntityRenderer;
import salyx.crystalline.divination.client.guis.ter.PedestalTileEntityRenderer;
import salyx.crystalline.divination.client.guis.ter.StorageRuneTileEntityRenderer;
import salyx.crystalline.divination.core.init.ContainerTypeInit;
import salyx.crystalline.divination.core.init.TileEntityInit;

@Mod.EventBusSubscriber(modid = CrystalDiv.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ScreenManager.registerFactory(ContainerTypeInit.PEDESTAL_CONTAINER_TYPE.get(), PedestalBlockScreen::new);
        ScreenManager.registerFactory(ContainerTypeInit.BASE_RUNE_CONTAINER_TYPE.get(), BaseRuneScreen::new);
        ScreenManager.registerFactory(ContainerTypeInit.STORAGE_RUNE_CONTAINER_TYPE.get(), StorageRuneScreen::new);

        ClientRegistry.bindTileEntityRenderer(TileEntityInit.PEDESTAL_TILE_TYPE.get(), PedestalTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(TileEntityInit.BASE_RUNE_TILE_TYPE.get(), BaseRuneTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(TileEntityInit.STORAGE_RUNE_TILE_TYPE.get(), StorageRuneTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(TileEntityInit.EXPORT_RUNE_TILE_TYPE.get(), ExportRuneTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(TileEntityInit.IMPORT_RUNE_TILE_TYPE.get(), ImportRuneTileEntityRenderer::new);
        
    }
}
