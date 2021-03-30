package salyx.crystalline.divination.core.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import salyx.crystalline.divination.CrystalDiv;
import salyx.crystalline.divination.common.blocks.BaseRune;
import salyx.crystalline.divination.common.blocks.Pedestal;
import salyx.crystalline.divination.common.blocks.StorageRune;
import salyx.crystalline.divination.common.blocks.HydroCrystalCluster;
import salyx.crystalline.divination.common.blocks.LunarCrystalCluster;
import salyx.crystalline.divination.common.blocks.PyroCrystalCluster;
import salyx.crystalline.divination.common.blocks.SolarCrystalCluster;
import salyx.crystalline.divination.common.blocks.SolarCrystalSeed;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CrystalDiv.MOD_ID);

    public static final RegistryObject<Pedestal> PEDESTAL = BLOCKS.register("pedestal", () -> new Pedestal(AbstractBlock.Properties
    .create(Material.WOOD)
    .harvestTool(ToolType.PICKAXE)
    .harvestLevel(1)
    .sound(SoundType.STONE)
    .hardnessAndResistance(0.7f, 0.7f)));

    public static final RegistryObject<BaseRune> BASE_RUNE = BLOCKS.register("base_rune", () -> new BaseRune(AbstractBlock.Properties
    .create(Material.GLASS)
    .sound(SoundType.CLOTH)
    .notSolid()));

    public static final RegistryObject<Block> EXAMPLE_ORE = BLOCKS.register("example_ore", () -> new Block(AbstractBlock.Properties
    .from(Blocks.DIAMOND_ORE)));

    public static final RegistryObject<SolarCrystalCluster> SOLAR_CRYSTAL_CLUSTER = BLOCKS.register("solar_crystal_cluster", () -> new SolarCrystalCluster(AbstractBlock.Properties
    .from(Blocks.GLASS)
    .sound(SoundType.GLASS)
    .harvestTool(ToolType.PICKAXE)
    .harvestLevel(3)
    .notSolid()
    .hardnessAndResistance(0.5f, 0.5f)
    .setRequiresTool()));

    public static final RegistryObject<LunarCrystalCluster> LUNAR_CRYSTAL_CLUSTER = BLOCKS.register("lunar_crystal_cluster", () -> new LunarCrystalCluster(AbstractBlock.Properties
    .from(Blocks.GLASS)
    .sound(SoundType.GLASS)
    .harvestTool(ToolType.PICKAXE)
    .harvestLevel(3)
    .notSolid()
    .hardnessAndResistance(0.5f, 0.5f)
    .setRequiresTool()));

    public static final RegistryObject<PyroCrystalCluster> PYRO_CRYSTAL_CLUSTER = BLOCKS.register("pyro_crystal_cluster", () -> new PyroCrystalCluster(AbstractBlock.Properties
    .from(Blocks.GLASS)
    .sound(SoundType.GLASS)
    .harvestTool(ToolType.PICKAXE)
    .harvestLevel(3)
    .notSolid()
    .hardnessAndResistance(0.5f, 0.5f)
    .setRequiresTool()));

    public static final RegistryObject<HydroCrystalCluster> HYDRO_CRYSTAL_CLUSTER = BLOCKS.register("hydro_crystal_cluster", () -> new HydroCrystalCluster(AbstractBlock.Properties
    .from(Blocks.GLASS)
    .sound(SoundType.GLASS)
    .harvestTool(ToolType.PICKAXE)
    .harvestLevel(3)
    .notSolid()
    .hardnessAndResistance(0.5f, 0.5f)
    .setRequiresTool()));

    public static final RegistryObject<StorageRune> STORAGE_RUNE = BLOCKS.register("storage_rune", () -> new StorageRune(AbstractBlock.Properties
    .create(Material.GLASS)
    .sound(SoundType.CLOTH)
    .notSolid()));
    
    public static final RegistryObject<SolarCrystalSeed> SOLAR_CRYSTAL_SEED = BLOCKS.register("solar_crystal_seed", () -> new SolarCrystalSeed(AbstractBlock.Properties
    .create(Material.GLASS)
    .sound(SoundType.GLASS)
    .notSolid()));
}