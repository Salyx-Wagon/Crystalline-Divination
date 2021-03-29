package salyx.crystalline.divination.common.blocks;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

public class LunarCrystalCluster extends BaseCrystalCluster{

    public LunarCrystalCluster(Properties properties) {
        super(properties);
        //TODO Auto-generated constructor stub
    }
    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        // TODO Auto-generated method stub
        return 4;
    }
    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        // TODO Auto-generated method stub
        worldIn.spawnParticle(ParticleTypes.ASH, 0.5 + pos.getX(), 1.5 + pos.getY(), 0.5 + pos.getZ(), 10, 0.3, 0.3, 0.3, 0.1);
    }
}
