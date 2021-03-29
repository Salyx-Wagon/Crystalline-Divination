package salyx.crystalline.divination.common.items;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SpecialItem extends Item{

    public SpecialItem(Properties properties) {
        super(properties);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip,
            ITooltipFlag flagIn) {
        // TODO Auto-generated method stub
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new StringTextComponent("This is an advanced item."));
        if(InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
            tooltip.add(new StringTextComponent("\u00A74Woo!"));
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        // TODO Auto-generated method stub
        if (!playerIn.getCooldownTracker().hasCooldown(this)) {
            playerIn.addPotionEffect(new EffectInstance(Effects.GLOWING, 200, 3));
            ZombieEntity entity = new ZombieEntity(worldIn);
            entity.setPosition(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ());
            worldIn.addEntity(entity);
            playerIn.getCooldownTracker().setCooldown(this, 20);
            return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
        }
        return ActionResult.resultFail(playerIn.getHeldItem(handIn));
    }
}
