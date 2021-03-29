package salyx.crystalline.divination.core.init;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import salyx.crystalline.divination.CrystalDiv;
import salyx.crystalline.divination.common.containers.BaseRuneContainer;
import salyx.crystalline.divination.common.containers.PedestalContainer;
import salyx.crystalline.divination.common.containers.StorageRuneContainer;

public class ContainerTypeInit {
    
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister
    .create(ForgeRegistries.CONTAINERS, CrystalDiv.MOD_ID);

    public static final RegistryObject<ContainerType<PedestalContainer>> PEDESTAL_CONTAINER_TYPE = CONTAINER_TYPES
    .register("pedestal", () -> IForgeContainerType.create(PedestalContainer::new));

    public static final RegistryObject<ContainerType<BaseRuneContainer>> BASE_RUNE_CONTAINER_TYPE = CONTAINER_TYPES
    .register("base_rune", () -> IForgeContainerType.create(BaseRuneContainer::new));

    public static final RegistryObject<ContainerType<StorageRuneContainer>> STORAGE_RUNE_CONTAINER_TYPE = CONTAINER_TYPES
    .register("storage_rune", () -> IForgeContainerType.create(StorageRuneContainer::new));

}
