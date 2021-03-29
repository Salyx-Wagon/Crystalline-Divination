package salyx.crystalline.divination.common.materials;

import java.util.function.Supplier;

import salyx.crystalline.divination.core.init.ItemInit;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum LunarCrystalArmorMaterial implements IArmorMaterial{
    LUNAR_CRYSTAL_ARMOR("lunar_crystal", 10, new int[] {6, 9, 8, 6}, 17, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4f, 0.2f,() -> Ingredient.fromItems(ItemInit.LUNAR_CRYSTAL.get()));
    
    private static final int[] baseDurability = { 128, 144, 160, 112 };
    private final String name;
    private final int durabilityMultiplier;
    private final int[] armorVal;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Ingredient repairIngredient;

    LunarCrystalArmorMaterial(String name, int durabilityMultiplier, int[] armorVal, int enchantability,
    SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.armorVal = armorVal;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient.get();
    }

    @Override
    public int getDurability(EquipmentSlotType slot) {
        return LunarCrystalArmorMaterial.baseDurability[slot.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slot) {
        return this.armorVal[slot.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairIngredient;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
    
}
