package salyx.crystalline.divination.world;

import net.minecraft.block.BlockState;
//import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import salyx.crystalline.divination.core.init.BlockInit;

public class OreGeneration {
    
    //public static void generateOres(final BiomeLoadingEvent event) {
    //    if(!event.getCategory().equals(Biome.Category.NETHER) || !event.getCategory().equals(Biome.Category.THEEND)) {
    //        generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BlockInit.EXAMPLE_ORE.get().getDefaultState(),
    //        20, 1, 255, 40);
    //    }
    //}

    public static void generateCrystals(final BiomeLoadingEvent event) {
        generateCrystal(event.getGeneration(), CrystalGeneration.FillerBlockType.GRASS, BlockInit.SOLAR_CRYSTAL_CLUSTER.get().getDefaultState(),
            5, 50, 255, 15);
        generateCrystal(event.getGeneration(), CrystalGeneration.FillerBlockType.BROWN_MUSHROOM, BlockInit.LUNAR_CRYSTAL_CLUSTER.get().getDefaultState(),
        5, 1, 255, 3000);
        generateCrystal(event.getGeneration(), CrystalGeneration.FillerBlockType.RED_MUSHROOM, BlockInit.LUNAR_CRYSTAL_CLUSTER.get().getDefaultState(),
        5, 1, 255, 3000);
        generateCrystal(event.getGeneration(), CrystalGeneration.FillerBlockType.GRASS, BlockInit.LUNAR_CRYSTAL_CLUSTER.get().getDefaultState(),
        5, 50, 255, 8);
        generateCrystal(event.getGeneration(), CrystalGeneration.FillerBlockType.DEAD_BUSH, BlockInit.PYRO_CRYSTAL_CLUSTER.get().getDefaultState(),
        5, 50, 255, 250);
        generateCrystal(event.getGeneration(), CrystalGeneration.FillerBlockType.CRIMSON_ROOTS, BlockInit.PYRO_CRYSTAL_CLUSTER.get().getDefaultState(),
        5, 1, 255, 200);
        generateCrystal(event.getGeneration(), CrystalGeneration.FillerBlockType.WARPED_ROOTS, BlockInit.PYRO_CRYSTAL_CLUSTER.get().getDefaultState(),
        5, 1, 255, 200);
        generateCrystal(event.getGeneration(), CrystalGeneration.FillerBlockType.SEA_GRASS, BlockInit.HYDRO_CRYSTAL_CLUSTER.get().getDefaultState(),
            5, 0, 70, 25);
    }

    //private static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int Veinsize, int minHeight, int maxHeight, int amount) {
    //    settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
    //        Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, Veinsize))
    //        .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
    //        .square().func_242731_b(amount));
    //}

    private static void generateCrystal(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int Veinsize, int minHeight, int maxHeight, int amount) {
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
            Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, Veinsize))
            .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
            .square().func_242731_b(amount));
    }

    
}
