package salyx.crystalline.divination.core.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import salyx.crystalline.divination.CrystalDiv;
import salyx.crystalline.divination.common.items.CrystallineTablet;
import salyx.crystalline.divination.common.items.DivinationWand;
import salyx.crystalline.divination.common.items.SpecialItem;
import salyx.crystalline.divination.common.materials.CrystalArmorMaterial;
import salyx.crystalline.divination.common.materials.SolarCrystalArmorMaterial;
import salyx.crystalline.divination.common.materials.CustomToolMateral;
import salyx.crystalline.divination.common.materials.HydroCrystalArmorMaterial;
import salyx.crystalline.divination.common.materials.LunarCrystalArmorMaterial;
import salyx.crystalline.divination.common.materials.PyroCrystalArmorMaterial;

public class ItemInit { 
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CrystalDiv.MOD_ID);

    // Items

    public static final RegistryObject<SpecialItem> ADVANCED_ITEM = ITEMS.register("advanced_item", () -> new SpecialItem(new Item.Properties()
    .group(ItemGroup.MISC)
    .addToolType(ToolType.PICKAXE, 10)));

    public static final RegistryObject<Item> SOLAR_CRYSTAL = ITEMS.register("solar_crystal", () -> new Item(new Item.Properties()
    .group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Item> LUNAR_CRYSTAL = ITEMS.register("lunar_crystal", () -> new Item(new Item.Properties()
    .group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Item> PYRO_CRYSTAL = ITEMS.register("pyro_crystal", () -> new Item(new Item.Properties()
    .group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Item> HYDRO_CRYSTAL = ITEMS.register("hydro_crystal", () -> new Item(new Item.Properties()
    .group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Item> PURE_CRYSTAL = ITEMS.register("pure_crystal", () -> new Item(new Item.Properties()
    .group(ItemGroup.MATERIALS)));

    public static final RegistryObject<DivinationWand> DIVINATION_WAND = ITEMS.register("divination_wand", () -> new DivinationWand(new Item.Properties()
    .group(ItemGroup.TOOLS)));

    public static final RegistryObject<Item> PURE_CRYSTAL_DUST = ITEMS.register("pure_crystal_dust", () -> new Item(new Item.Properties()
    .group(ItemGroup.MATERIALS)));
    
    public static final RegistryObject<Item> SOLAR_CRYSTAL_DUST = ITEMS.register("solar_crystal_dust", () -> new Item(new Item.Properties()
    .group(ItemGroup.MATERIALS)));
    
    public static final RegistryObject<Item> LUNAR_CRYSTAL_DUST = ITEMS.register("lunar_crystal_dust", () -> new Item(new Item.Properties()
    .group(ItemGroup.MATERIALS)));
    
    public static final RegistryObject<Item> PYRO_CRYSTAL_DUST = ITEMS.register("pyro_crystal_dust", () -> new Item(new Item.Properties()
    .group(ItemGroup.MATERIALS)));
    
    public static final RegistryObject<Item> HYDRO_CRYSTAL_DUST = ITEMS.register("hydro_crystal_dust", () -> new Item(new Item.Properties()
    .group(ItemGroup.MATERIALS)));
    

    public static final RegistryObject<CrystallineTablet> CRYSTALLINE_TABLET = ITEMS.register("crystalline_tablet", () -> new CrystallineTablet(new Item.Properties()
    .group(ItemGroup.TOOLS)));

    // Tools and Armor
    public static final RegistryObject<Item> CRYSTAL_SWORD = ITEMS.register("crystal_sword", () -> new SwordItem(
        CustomToolMateral.CRYSTAL_TOOL, 8, 1.6f, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> CRYSTAL_AXE = ITEMS.register("crystal_axe", () -> new AxeItem(
        CustomToolMateral.CRYSTAL_TOOL, 10, 1f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> CRYSTAL_PICKAXE = ITEMS.register("crystal_pickaxe", () -> new PickaxeItem(
        CustomToolMateral.CRYSTAL_TOOL, 6, 1.2f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> CRYSTAL_SHOVEL = ITEMS.register("crystal_shovel", () -> new ShovelItem(
        CustomToolMateral.CRYSTAL_TOOL, 6, 1f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> CRYSTAL_HOE = ITEMS.register("crystal_hoe", () -> new HoeItem(
        CustomToolMateral.CRYSTAL_TOOL, 1, 4f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> CRYSTAL_HELMET = ITEMS.register("crystal_helmet", () -> new ArmorItem(
        CrystalArmorMaterial.CRYSTAL_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> CRYSTAL_CHESTPLATE = ITEMS.register("crystal_chestplate", () -> new ArmorItem(
        CrystalArmorMaterial.CRYSTAL_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> CRYSTAL_LEGGINGS = ITEMS.register("crystal_leggings", () -> new ArmorItem(
        CrystalArmorMaterial.CRYSTAL_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> CRYSTAL_BOOTS = ITEMS.register("crystal_boots", () -> new ArmorItem(
        CrystalArmorMaterial.CRYSTAL_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> SOLAR_CRYSTAL_SWORD = ITEMS.register("solar_crystal_sword", () -> new SwordItem(
        CustomToolMateral.CRYSTAL_TOOL, 8, 1.6f, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> SOLAR_CRYSTAL_AXE = ITEMS.register("solar_crystal_axe", () -> new AxeItem(
        CustomToolMateral.CRYSTAL_TOOL, 10, 1f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> SOLAR_CRYSTAL_PICKAXE = ITEMS.register("solar_crystal_pickaxe", () -> new PickaxeItem(
        CustomToolMateral.CRYSTAL_TOOL, 6, 1.2f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> SOLAR_CRYSTAL_SHOVEL = ITEMS.register("solar_crystal_shovel", () -> new ShovelItem(
        CustomToolMateral.CRYSTAL_TOOL, 6, 1f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> SOLAR_CRYSTAL_HOE = ITEMS.register("solar_crystal_hoe", () -> new HoeItem(
        CustomToolMateral.CRYSTAL_TOOL, 1, 4f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> SOLAR_CRYSTAL_HELMET = ITEMS.register("solar_crystal_helmet", () -> new ArmorItem(
        SolarCrystalArmorMaterial.SOLAR_CRYSTAL_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> SOLAR_CRYSTAL_CHESTPLATE = ITEMS.register("solar_crystal_chestplate", () -> new ArmorItem(
        SolarCrystalArmorMaterial.SOLAR_CRYSTAL_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> SOLAR_CRYSTAL_LEGGINGS = ITEMS.register("solar_crystal_leggings", () -> new ArmorItem(
        SolarCrystalArmorMaterial.SOLAR_CRYSTAL_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> SOLAR_CRYSTAL_BOOTS = ITEMS.register("solar_crystal_boots", () -> new ArmorItem(
        SolarCrystalArmorMaterial.SOLAR_CRYSTAL_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> LUNAR_CRYSTAL_SWORD = ITEMS.register("lunar_crystal_sword", () -> new SwordItem(
        CustomToolMateral.CRYSTAL_TOOL, 8, 1.6f, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> LUNAR_CRYSTAL_AXE = ITEMS.register("lunar_crystal_axe", () -> new AxeItem(
        CustomToolMateral.CRYSTAL_TOOL, 10, 1f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> LUNAR_CRYSTAL_PICKAXE = ITEMS.register("lunar_crystal_pickaxe", () -> new PickaxeItem(
        CustomToolMateral.CRYSTAL_TOOL, 6, 1.2f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> LUNAR_CRYSTAL_SHOVEL = ITEMS.register("lunar_crystal_shovel", () -> new ShovelItem(
        CustomToolMateral.CRYSTAL_TOOL, 6, 1f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> LUNAR_CRYSTAL_HOE = ITEMS.register("lunar_crystal_hoe", () -> new HoeItem(
        CustomToolMateral.CRYSTAL_TOOL, 1, 4f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> LUNAR_CRYSTAL_HELMET = ITEMS.register("lunar_crystal_helmet", () -> new ArmorItem(
        LunarCrystalArmorMaterial.LUNAR_CRYSTAL_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> LUNAR_CRYSTAL_CHESTPLATE = ITEMS.register("lunar_crystal_chestplate", () -> new ArmorItem(
        LunarCrystalArmorMaterial.LUNAR_CRYSTAL_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> LUNAR_CRYSTAL_LEGGINGS = ITEMS.register("lunar_crystal_leggings", () -> new ArmorItem(
        LunarCrystalArmorMaterial.LUNAR_CRYSTAL_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> LUNAR_CRYSTAL_BOOTS = ITEMS.register("lunar_crystal_boots", () -> new ArmorItem(
        LunarCrystalArmorMaterial.LUNAR_CRYSTAL_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> HYDRO_CRYSTAL_SWORD = ITEMS.register("hydro_crystal_sword", () -> new SwordItem(
        CustomToolMateral.CRYSTAL_TOOL, 8, 1.6f, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> HYDRO_CRYSTAL_AXE = ITEMS.register("hydro_crystal_axe", () -> new AxeItem(
        CustomToolMateral.CRYSTAL_TOOL, 10, 1f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> HYDRO_CRYSTAL_PICKAXE = ITEMS.register("hydro_crystal_pickaxe", () -> new PickaxeItem(
        CustomToolMateral.CRYSTAL_TOOL, 6, 1.2f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> HYDRO_CRYSTAL_SHOVEL = ITEMS.register("hydro_crystal_shovel", () -> new ShovelItem(
        CustomToolMateral.CRYSTAL_TOOL, 6, 1f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> HYDRO_CRYSTAL_HOE = ITEMS.register("hydro_crystal_hoe", () -> new HoeItem(
        CustomToolMateral.CRYSTAL_TOOL, 1, 4f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> HYDRO_CRYSTAL_HELMET = ITEMS.register("hydro_crystal_helmet", () -> new ArmorItem(
        HydroCrystalArmorMaterial.HYDRO_CRYSTAL_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> HYDRO_CRYSTAL_CHESTPLATE = ITEMS.register("hydro_crystal_chestplate", () -> new ArmorItem(
        HydroCrystalArmorMaterial.HYDRO_CRYSTAL_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> HYDRO_CRYSTAL_LEGGINGS = ITEMS.register("hydro_crystal_leggings", () -> new ArmorItem(
        HydroCrystalArmorMaterial.HYDRO_CRYSTAL_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> HYDRO_CRYSTAL_BOOTS = ITEMS.register("hydro_crystal_boots", () -> new ArmorItem(
        HydroCrystalArmorMaterial.HYDRO_CRYSTAL_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> PYRO_CRYSTAL_SWORD = ITEMS.register("pyro_crystal_sword", () -> new SwordItem(
        CustomToolMateral.CRYSTAL_TOOL, 8, 1.6f, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> PYRO_CRYSTAL_AXE = ITEMS.register("pyro_crystal_axe", () -> new AxeItem(
        CustomToolMateral.CRYSTAL_TOOL, 10, 1f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> PYRO_CRYSTAL_PICKAXE = ITEMS.register("pyro_crystal_pickaxe", () -> new PickaxeItem(
        CustomToolMateral.CRYSTAL_TOOL, 6, 1.2f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> PYRO_CRYSTAL_SHOVEL = ITEMS.register("pyro_crystal_shovel", () -> new ShovelItem(
        CustomToolMateral.CRYSTAL_TOOL, 6, 1f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> PYRO_CRYSTAL_HOE = ITEMS.register("pyro_crystal_hoe", () -> new HoeItem(
        CustomToolMateral.CRYSTAL_TOOL, 1, 4f, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> PYRO_CRYSTAL_HELMET = ITEMS.register("pyro_crystal_helmet", () -> new ArmorItem(
        PyroCrystalArmorMaterial.PYRO_CRYSTAL_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> PYRO_CRYSTAL_CHESTPLATE = ITEMS.register("pyro_crystal_chestplate", () -> new ArmorItem(
        PyroCrystalArmorMaterial.PYRO_CRYSTAL_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> PYRO_CRYSTAL_LEGGINGS = ITEMS.register("pyro_crystal_leggings", () -> new ArmorItem(
        PyroCrystalArmorMaterial.PYRO_CRYSTAL_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> PYRO_CRYSTAL_BOOTS = ITEMS.register("pyro_crystal_boots", () -> new ArmorItem(
        PyroCrystalArmorMaterial.PYRO_CRYSTAL_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    
    // Block Items

    public static final RegistryObject<BlockItem> PEDESTAL = ITEMS.register("pedestal", () -> new BlockItem(BlockInit.PEDESTAL.get(), new Item.Properties()
    .group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> BASE_RUNE = ITEMS.register("base_rune", () -> new BlockItem(BlockInit.BASE_RUNE.get(), new Item.Properties()
    .group(ItemGroup.MISC)));

    public static final RegistryObject<BlockItem> SOLAR_CRYSTAL_CLUSTER = ITEMS.register("solar_crystal_cluster", () -> new BlockItem(BlockInit.SOLAR_CRYSTAL_CLUSTER.get(), new Item.Properties()
    .group(ItemGroup.MATERIALS)));

    public static final RegistryObject<BlockItem> LUNAR_CRYSTAL_CLUSTER = ITEMS.register("lunar_crystal_cluster", () -> new BlockItem(BlockInit.LUNAR_CRYSTAL_CLUSTER.get(), new Item.Properties()
    .group(ItemGroup.MATERIALS)));

    public static final RegistryObject<BlockItem> PYRO_CRYSTAL_CLUSTER = ITEMS.register("pyro_crystal_cluster", () -> new BlockItem(BlockInit.PYRO_CRYSTAL_CLUSTER.get(), new Item.Properties()
    .group(ItemGroup.MATERIALS)));

    public static final RegistryObject<BlockItem> HYDRO_CRYSTAL_CLUSTER = ITEMS.register("hydro_crystal_cluster", () -> new BlockItem(BlockInit.HYDRO_CRYSTAL_CLUSTER.get(), new Item.Properties()
    .group(ItemGroup.MATERIALS)));

    public static final RegistryObject<BlockItem> STORAGE_RUNE = ITEMS.register("storage_rune", () -> new BlockItem(BlockInit.STORAGE_RUNE.get(), new Item.Properties()
    .group(ItemGroup.MATERIALS)));

    public static final RegistryObject<BlockItem> EXPORT_RUNE = ITEMS.register("export_rune", () -> new BlockItem(BlockInit.EXPORT_RUNE.get(), new Item.Properties()
    .group(ItemGroup.MATERIALS)));

    public static final RegistryObject<BlockItem> IMPORT_RUNE = ITEMS.register("import_rune", () -> new BlockItem(BlockInit.IMPORT_RUNE.get(), new Item.Properties()
    .group(ItemGroup.MATERIALS)));
}
