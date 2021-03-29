package salyx.crystalline.divination.core.event;

import java.util.List;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.EntityPlaceEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraft.block.Blocks;
//import net.minecraft.entity.item.ItemEntity;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.IWorld;
//import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import salyx.crystalline.divination.CrystalDiv;
import salyx.crystalline.divination.common.blocks.BaseRune;
import salyx.crystalline.divination.common.blocks.Pedestal;
import salyx.crystalline.divination.common.blocks.Rune;
import salyx.crystalline.divination.core.init.BlockInit;
//import salyx.crystalline.divination.core.init.BlockInit;
import salyx.crystalline.divination.core.init.ItemInit;

@EventBusSubscriber(modid = CrystalDiv.MOD_ID, bus = Bus.FORGE)
public class EventHandler {
    
    @SubscribeEvent
    public static void onBlockBreak(final BlockEvent.BreakEvent event) {
        //IWorld world = event.getWorld();
        //BlockPos pos = event.getPos();
        //if(event.getState().getBlock().equals(Blocks.GRASS_BLOCK)) {
        //    world.setBlockState(pos.add(0, 1, 0),
        //    BlockInit.EXAMPLE_BLOCK.get().getDefaultState(),
        //    Constants.BlockFlags.BLOCK_UPDATE);
        //}
        if(event.getPlayer().getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL_PICKAXE.get().getDefaultInstance()) ||
        event.getPlayer().getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL_AXE.get().getDefaultInstance()) ||
        event.getPlayer().getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL_SHOVEL.get().getDefaultInstance()) ||
        event.getPlayer().getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL_HOE.get().getDefaultInstance()) ||
        event.getPlayer().getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL_SWORD.get().getDefaultInstance())) {
            if(event.getPlayer().inventory.armorItemInSlot(0).isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL_BOOTS.get().getDefaultInstance()) &&
            event.getPlayer().inventory.armorItemInSlot(1).isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL_LEGGINGS.get().getDefaultInstance()) &&
            event.getPlayer().inventory.armorItemInSlot(2).isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL_CHESTPLATE.get().getDefaultInstance()) &&
            event.getPlayer().inventory.armorItemInSlot(3).isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL_HELMET.get().getDefaultInstance())) {
                event.getPlayer().addPotionEffect(new EffectInstance(Effects.HASTE, 20, 3));
            }
            else {
                event.getPlayer().addPotionEffect(new EffectInstance(Effects.HASTE, 20, 0));
            }
        }
    }
    
    @SubscribeEvent
    public static void onPlayerTickEvent(final PlayerTickEvent event) {
        // Solar Armor
        if(event.player.isSprinting()) {
            if(event.player.inventory.armorItemInSlot(0).isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL_BOOTS.get().getDefaultInstance())) {
                event.player.addPotionEffect(new EffectInstance(Effects.SPEED, 0, 0, false, false));
            }
        }
        if(event.player.inventory.armorItemInSlot(1).isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL_LEGGINGS.get().getDefaultInstance())) {
            event.player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 0, 1, false, false));
        }
        if(event.player.inventory.armorItemInSlot(0).isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL_BOOTS.get().getDefaultInstance()) &&
        event.player.inventory.armorItemInSlot(1).isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL_LEGGINGS.get().getDefaultInstance()) &&
        event.player.inventory.armorItemInSlot(2).isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL_CHESTPLATE.get().getDefaultInstance()) &&
        event.player.inventory.armorItemInSlot(3).isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL_HELMET.get().getDefaultInstance())) {
            event.player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 0, 3, false, false));
            if(event.player.isSprinting()) {
                event.player.addPotionEffect(new EffectInstance(Effects.SPEED, 0, 2, false, false));
            }
        }

        // Lunar Amor

        if(event.player.getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.LUNAR_CRYSTAL_SWORD.get().getDefaultInstance()) ||
        event.player.getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.LUNAR_CRYSTAL_PICKAXE.get().getDefaultInstance()) ||
        event.player.getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.LUNAR_CRYSTAL_AXE.get().getDefaultInstance()) ||
        event.player.getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.LUNAR_CRYSTAL_SHOVEL.get().getDefaultInstance()) ||
        event.player.getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.LUNAR_CRYSTAL_HOE.get().getDefaultInstance())) {
            AxisAlignedBB playerRange = new AxisAlignedBB(event.player.getPosX() - 50, event.player.getPosY() - 50, event.player.getPosZ() - 50, event.player.getPosX() + 50, event.player.getPosY() + 50, event.player.getPosZ() + 50);
            List<LivingEntity> inRangeEntities = event.player.getEntityWorld().getEntitiesWithinAABB(LivingEntity.class, playerRange, null);
            for(LivingEntity e : inRangeEntities) {
                if(e instanceof PlayerEntity) {
                    
                }
                else{
                    e.addPotionEffect(new EffectInstance(Effects.GLOWING, 2, 0, true, true));
                }
            }
        }
        if(event.player.inventory.armorItemInSlot(3).isItemEqualIgnoreDurability(ItemInit.LUNAR_CRYSTAL_HELMET.get().getDefaultInstance())) {
            event.player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 201, 0, false, false));
        }

        // Hydro Stuff
        if(event.player.isInWaterRainOrBubbleColumn()) {
            if(event.player.getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.HYDRO_CRYSTAL_PICKAXE.get().getDefaultInstance()) ||
                event.player.getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.HYDRO_CRYSTAL_AXE.get().getDefaultInstance()) ||
                event.player.getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.HYDRO_CRYSTAL_SHOVEL.get().getDefaultInstance()) ||
                event.player.getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.HYDRO_CRYSTAL_HOE.get().getDefaultInstance()) ||
                event.player.getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.HYDRO_CRYSTAL_SWORD.get().getDefaultInstance())) {
                event.player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 24, false, false));
            }
            if(event.player.inventory.armorItemInSlot(3).isItemEqualIgnoreDurability(ItemInit.HYDRO_CRYSTAL_HELMET.get().getDefaultInstance())) {
                event.player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 5, 0, false, false));
            }
            if(event.player.inventory.armorItemInSlot(2).isItemEqualIgnoreDurability(ItemInit.HYDRO_CRYSTAL_CHESTPLATE.get().getDefaultInstance())) {
                event.player.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 5, 0, false, false));
            }
            if(event.player.inventory.armorItemInSlot(0).isItemEqualIgnoreDurability(ItemInit.HYDRO_CRYSTAL_BOOTS.get().getDefaultInstance()) &&
            event.player.inventory.armorItemInSlot(1).isItemEqualIgnoreDurability(ItemInit.HYDRO_CRYSTAL_LEGGINGS.get().getDefaultInstance()) &&
            event.player.inventory.armorItemInSlot(2).isItemEqualIgnoreDurability(ItemInit.HYDRO_CRYSTAL_CHESTPLATE.get().getDefaultInstance()) &&
            event.player.inventory.armorItemInSlot(3).isItemEqualIgnoreDurability(ItemInit.HYDRO_CRYSTAL_HELMET.get().getDefaultInstance())) {
                AxisAlignedBB playerRange = new AxisAlignedBB(event.player.getPosX() - 32, event.player.getPosY() - 32, event.player.getPosZ() - 32, event.player.getPosX() + 32, event.player.getPosY() + 32, event.player.getPosZ() + 32);
                List<LivingEntity> inRangeEntities = event.player.getEntityWorld().getEntitiesWithinAABB(LivingEntity.class, playerRange, null);
                for(LivingEntity e : inRangeEntities) {
                    e.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 20, 0, false, false));
                }
            }
        }
        
        // Pyro Stuff
        if(event.player.inventory.armorItemInSlot(0).isItemEqualIgnoreDurability(ItemInit.PYRO_CRYSTAL_BOOTS.get().getDefaultInstance()) ||
            event.player.inventory.armorItemInSlot(1).isItemEqualIgnoreDurability(ItemInit.PYRO_CRYSTAL_LEGGINGS.get().getDefaultInstance()) ||
            event.player.inventory.armorItemInSlot(2).isItemEqualIgnoreDurability(ItemInit.PYRO_CRYSTAL_CHESTPLATE.get().getDefaultInstance()) ||
            event.player.inventory.armorItemInSlot(3).isItemEqualIgnoreDurability(ItemInit.PYRO_CRYSTAL_HELMET.get().getDefaultInstance())) {
                event.player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 1, 0, false, false));
            }
        if(!event.player.getHeldItemMainhand().getEnchantmentTagList().getString().contains("fire_aspect") && 
        (event.player.getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.PYRO_CRYSTAL_PICKAXE.get().getDefaultInstance()) ||
        event.player.getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.PYRO_CRYSTAL_AXE.get().getDefaultInstance()) ||
        event.player.getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.PYRO_CRYSTAL_SHOVEL.get().getDefaultInstance()) ||
        event.player.getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.PYRO_CRYSTAL_HOE.get().getDefaultInstance()) ||
        event.player.getHeldItemMainhand().isItemEqualIgnoreDurability(ItemInit.PYRO_CRYSTAL_SWORD.get().getDefaultInstance()))) {
            event.player.getHeldItemMainhand().addEnchantment(Enchantments.FIRE_ASPECT, 1);
        }
    }

    @SubscribeEvent
    public static void onPlayerEntityDamage(final LivingDamageEvent event) {
        Iterable<ItemStack> entityArmor = event.getEntityLiving().getArmorInventoryList();
        //System.out.println("Damage Dealt");
        //System.out.println(event.getAmount());
        //System.out.println(event.getEntityLiving());
        //System.out.println(event.getSource().damageType);
        //System.out.println(event.getSource().getTrueSource());
        boolean allInventoryLunar = true;
        for(ItemStack item : entityArmor) {
            if(item.isItemEqualIgnoreDurability(ItemInit.LUNAR_CRYSTAL_HELMET.get().getDefaultInstance()) ||
                item.isItemEqualIgnoreDurability(ItemInit.LUNAR_CRYSTAL_CHESTPLATE.get().getDefaultInstance()) ||
                item.isItemEqualIgnoreDurability(ItemInit.LUNAR_CRYSTAL_LEGGINGS.get().getDefaultInstance()) ||
                item.isItemEqualIgnoreDurability(ItemInit.LUNAR_CRYSTAL_BOOTS.get().getDefaultInstance())) {}
            else {allInventoryLunar = false;}
        }
            //System.out.println(allInventoryLunar);
        
        if(allInventoryLunar && (event.getSource().damageType == "mob" || event.getSource().damageType == "player")) {
            if(event.getSource().getTrueSource().isLiving()) {
                //System.out.println("Source is Living");
                event.getSource().getTrueSource().attackEntityFrom(DamageSource.GENERIC, event.getAmount()*2);
            }  
        }  
        // Pyro
        boolean allInventoryPyro = true;
        for(ItemStack item : entityArmor) {
            if(item.isItemEqualIgnoreDurability(ItemInit.PYRO_CRYSTAL_HELMET.get().getDefaultInstance()) ||
                item.isItemEqualIgnoreDurability(ItemInit.PYRO_CRYSTAL_CHESTPLATE.get().getDefaultInstance()) ||
                item.isItemEqualIgnoreDurability(ItemInit.PYRO_CRYSTAL_LEGGINGS.get().getDefaultInstance()) ||
                item.isItemEqualIgnoreDurability(ItemInit.PYRO_CRYSTAL_BOOTS.get().getDefaultInstance())) {}
            else {allInventoryPyro = false;}
        }
        if(allInventoryPyro && (event.getSource().damageType == "mob" || event.getSource().damageType == "player")) {
            event.getSource().getTrueSource().setFire(5);
        }
    }

    @SubscribeEvent
    public static void onRightClickBlock(final PlayerInteractEvent.RightClickBlock event) {
        
        if(event.getPlayer().getHeldItemMainhand().isItemEqual(ItemInit.DIVINATION_WAND.get().getDefaultInstance()) &&
        event.getPlayer().getHeldItemOffhand().isItemEqual(ItemInit.PURE_CRYSTAL_DUST.get().getDefaultInstance())) {
            //System.out.println("click");
            boolean success = false;
            if(event.getFace().equals(Direction.UP) && event.getWorld().isAirBlock(event.getPos().up())) {
                //System.out.println("Up");
                event.getWorld().setBlockState(event.getPos().up(), 
                BlockInit.BASE_RUNE.get().getDefaultState().with(BaseRune.FACING, Direction.DOWN));
                success = true;
            }
            else if(event.getFace().equals(Direction.DOWN) && event.getWorld().isAirBlock(event.getPos().down())) {
                //System.out.println("Down");
                event.getWorld().setBlockState(event.getPos().down(), 
                BlockInit.BASE_RUNE.get().getDefaultState().with(BaseRune.FACING, Direction.UP));
                success = true;
            }
            else if(event.getFace().equals(Direction.NORTH) && event.getWorld().isAirBlock(event.getPos().north())) {
                //System.out.println("North");
                event.getWorld().setBlockState(event.getPos().north(), 
                BlockInit.BASE_RUNE.get().getDefaultState().with(BaseRune.FACING, Direction.SOUTH));
                success = true;
            }
            else if(event.getFace().equals(Direction.SOUTH) && event.getWorld().isAirBlock(event.getPos().south())) {
                //System.out.println("South");
                event.getWorld().setBlockState(event.getPos().south(), 
                BlockInit.BASE_RUNE.get().getDefaultState().with(BaseRune.FACING, Direction.NORTH));
                success = true;
            }
            else if(event.getFace().equals(Direction.EAST) && event.getWorld().isAirBlock(event.getPos().east())) {
                //System.out.println("East");
                event.getWorld().setBlockState(event.getPos().east(), 
                BlockInit.BASE_RUNE.get().getDefaultState().with(BaseRune.FACING, Direction.WEST));
                success = true;
            }
            else if(event.getFace().equals(Direction.WEST) && event.getWorld().isAirBlock(event.getPos().west())) {
                //System.out.println("West");
                event.getWorld().setBlockState(event.getPos().west(), 
                BlockInit.BASE_RUNE.get().getDefaultState().with(BaseRune.FACING, Direction.EAST));
                success = true;
            }
            if(success) {
                event.getPlayer().getHeldItemOffhand().setCount(event.getPlayer().getHeldItemOffhand().getCount()-1);
            }
        }
    }
    @SubscribeEvent
    public static void placeBlockEvent(final EntityPlaceEvent event){
        if(event.getEntity() instanceof PlayerEntity){
            if(!event.getEntity().isSneaking() && (event.getPlacedAgainst().getBlock() instanceof Rune||
                                                    //event.getPlacedAgainst().equals(BlockInit.STORAGE_RUNE) ||
                                                    event.getPlacedAgainst().getBlock() instanceof Pedestal)) {
                event.setCanceled(true);
            }
        }
    }
}
