package salyx.crystalline.divination.world;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;

public class CrystalGeneration extends OreFeatureConfig{

    public CrystalGeneration(RuleTest p_i241989_1_, BlockState state, int size) {
        super(p_i241989_1_, state, size);
        //TODO Auto-generated constructor stub
    }
    
    public static final class FillerBlockType {
        public static final RuleTest BASE_STONE_OVERWORLD = new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD);
        public static final RuleTest NETHERRACK = new BlockMatchRuleTest(Blocks.NETHERRACK);
        public static final RuleTest BASE_STONE_NETHER = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        public static final RuleTest GRASS = new BlockMatchRuleTest(Blocks.GRASS); // Solar
        public static final RuleTest RED_MUSHROOM = new BlockMatchRuleTest(Blocks.RED_MUSHROOM); //Lunar
        public static final RuleTest BROWN_MUSHROOM = new BlockMatchRuleTest(Blocks.BROWN_MUSHROOM); //Lunar
        public static final RuleTest WARPED_ROOTS = new BlockMatchRuleTest(Blocks.WARPED_ROOTS); //Pyro
        public static final RuleTest CRIMSON_ROOTS = new BlockMatchRuleTest(Blocks.CRIMSON_ROOTS); //Pyro
        public static final RuleTest DEAD_BUSH = new BlockMatchRuleTest(Blocks.DEAD_BUSH); // Pyro
        public static final RuleTest SEA_GRASS = new BlockMatchRuleTest(Blocks.SEAGRASS); // Water
        
    }
}
