package salyx.crystalline.divination.common.blocks;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

public class PyroCrystalCluster extends BaseCrystalCluster{

    public PyroCrystalCluster(Properties properties) {
        super(properties);
        //TODO Auto-generated constructor stub
    }
    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        // TODO Auto-generated method stub
        return 12;
    }
    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        // TODO Auto-generated method stub
        worldIn.spawnParticle(ParticleTypes.FLAME, 0.5 + pos.getX(), 1 + pos.getY(), 0.5 + pos.getZ(), 10, 0.2, 0.2, 0.2, 0.02);
    }
}
