package salyx.crystalline.divination.client.guis.ter;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import salyx.crystalline.divination.common.tiles.ExportRuneTile;
import salyx.crystalline.divination.core.init.ItemInit;

public class ExportRuneTileEntityRenderer extends TileEntityRenderer<ExportRuneTile>{
    private Minecraft mc = Minecraft.getInstance();

    public static float r = 0;
    private double h;

    public ExportRuneTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(ExportRuneTile te, float partialTicks, MatrixStack matrixStackIn,
            IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        ClientPlayerEntity player = mc.player;
        int lightLevel = getLightLevel(te.getWorld(), te.getPos());
        h = Math.sin(((Math.PI/2) * (r/2000)) + (Math.PI/2))/2;
        double d = 1;
        if(!te.getPos().withinDistance(player.getPosition(), 8)){
            if(!te.getPos().withinDistance(player.getPosition(), 16)){
                d = 0;
            }
            
            else{d = 52/(te.getPos().distanceSq(player.getPosX(), player.getPosY(), player.getPosZ(), true)-8);}
        }
        if(d>0)
        {if(te.getBlockState().toString().contains("down")) {
            renderItem(ItemInit.EXPORT_RUNE.get().getDefaultInstance(), new double[] {0.5d, 0.35+h, 0.5d}, Vector3f.YP.rotationDegrees((float) (r/5.555)), Vector3f.XP.rotationDegrees(0),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (((0.5-((float) h))*4)*d));

            ItemStack itemStack = ItemStack.read(te.getTileData().getCompound("itemFilter"));
            renderItem(itemStack, new double[] {0.5d, 0.2, 0.5d}, Vector3f.YP.rotationDegrees(0), Vector3f.XP.rotationDegrees(0),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.6*d));
        }
        if(te.getBlockState().toString().contains("up")) {
            renderItem(ItemInit.EXPORT_RUNE.get().getDefaultInstance(), new double[] {0.5d, 1.33-(h*2.4), 0.5d}, Vector3f.YP.rotationDegrees(-(float) (r/5.555)+180), Vector3f.XP.rotationDegrees(0),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (((0.5-((float) h))*4)*d));
            
            ItemStack itemStack = ItemStack.read(te.getTileData().getCompound("itemFilter"));
            renderItem(itemStack, new double[] {0.5d, 1-0.2, 0.5d}, Vector3f.YP.rotationDegrees(0), Vector3f.XP.rotationDegrees(180),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.6*d));
            
        }
        if(te.getBlockState().toString().contains("north")) {
            renderItem(ItemInit.EXPORT_RUNE.get().getDefaultInstance(), new double[] {0.5d, 0.5d, 0.35d+h}, Vector3f.ZP.rotationDegrees((float) (r/5.555)), Vector3f.XP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (((0.5-((float) h))*4)*d));
            
            ItemStack itemStack = ItemStack.read(te.getTileData().getCompound("itemFilter"));
            renderItem(itemStack, new double[] {0.5d, 0.5, 0.2}, Vector3f.YP.rotationDegrees(0), Vector3f.XP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.6*d));
            
        }
        if(te.getBlockState().toString().contains("south")) {
            renderItem(ItemInit.EXPORT_RUNE.get().getDefaultInstance(), new double[] {0.5d, 0.5d, 1.34d-(h*2.4)}, Vector3f.ZP.rotationDegrees(-(float) (r/5.555)), Vector3f.XP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (((0.5-((float) h))*4)*d));
            
            ItemStack itemStack = ItemStack.read(te.getTileData().getCompound("itemFilter"));
            renderItem(itemStack, new double[] {0.5d, 0.5, 1-0.2}, Vector3f.YP.rotationDegrees(0), Vector3f.XP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.6*d));
            
        }
        if(te.getBlockState().toString().contains("east")) {
            renderItem(ItemInit.EXPORT_RUNE.get().getDefaultInstance(), new double[] {0.65d-h, 0.5d, 0.5d}, Vector3f.XP.rotationDegrees((float) (r/5.555)+90), Vector3f.ZP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (((0.5-((float) h))*4)*d));
            
            ItemStack itemStack = ItemStack.read(te.getTileData().getCompound("itemFilter"));
            renderItem(itemStack, new double[] {1-0.2, 0.5, 0.5d}, Vector3f.YP.rotationDegrees(0), Vector3f.ZP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.6*d));
            
        }
        if(te.getBlockState().toString().contains("west")) {
            renderItem(ItemInit.EXPORT_RUNE.get().getDefaultInstance(), new double[] {-0.34d+(h*2.4), 0.5d, 0.5d}, Vector3f.XP.rotationDegrees(-(float) (r/5.555)), Vector3f.ZP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (((0.5-((float) h))*4)*d));
            
            ItemStack itemStack = ItemStack.read(te.getTileData().getCompound("itemFilter"));
            renderItem(itemStack, new double[] {0.2, 0.5, 0.5d}, Vector3f.YP.rotationDegrees(0), Vector3f.ZP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.6*d));
            
        }}
        
        ITextComponent label = ItemStack.read(te.getTileData().getCompound("itemFilter")).hasDisplayName() ? 
        ItemStack.read(te.getTileData().getCompound("itemFilter")).getDisplayName() :new 
        TranslationTextComponent(ItemStack.read(te.getTileData().getCompound("itemFilter")).getTranslationKey());

        int color;
        if(te.getIsWhiteList()){color = 0xffffff;}
        else{color = 0x000000;}
        if(player.getHeldItemMainhand().getItem() == ItemInit.DIVINATION_WAND.get() && 
        !ItemStack.read(te.getTileData().getCompound("itemFilter")).isEmpty()) {
            renderLabel(matrixStackIn, bufferIn, lightLevel, new double[] {0.5d, 0.5d, 0.5d}, label , color);   
        } 
                
    }

    private void renderItem(ItemStack stack, double[] translation, Quaternion rotation1, Quaternion rotation2, MatrixStack matrixStack,
    IRenderTypeBuffer buffer, float partialTicks, int combinedOverlay, int lightLevel, float scale) {

        matrixStack.push();
        matrixStack.translate(translation[0], translation[1], translation[2]);
        matrixStack.rotate(rotation1);
        matrixStack.rotate(rotation2);
        matrixStack.scale(scale, scale, scale);

        IBakedModel model = mc.getItemRenderer().getItemModelWithOverrides(stack, null, null);
        mc.getItemRenderer().renderItem(stack, ItemCameraTransforms.TransformType.GROUND, true, matrixStack, buffer, lightLevel, combinedOverlay, model);
        matrixStack.pop();
    }

    private void renderLabel(MatrixStack stack, IRenderTypeBuffer buffer, int lightLevel, double[] corner, ITextComponent text, int color) {
        
        FontRenderer font = mc.fontRenderer;
        
        stack.push();
        float scale = 0.01f;
        int opacity = (int) (.4f * 255.0f) << 24;
        float offset = (float) (-font.getStringPropertyWidth(text)/2);
        Matrix4f matrix = stack.getLast().getMatrix();

        stack.translate(corner[0], corner[1], corner[2]);
        stack.scale(scale, scale, scale);
        stack.rotate(mc.getRenderManager().getCameraOrientation());
        stack.rotate(Vector3f.ZP.rotationDegrees(180f));

        font.func_243247_a(text, offset, 0, color, false, matrix, buffer, false, opacity, lightLevel);
        stack.pop();
    }
    
    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightFor(LightType.BLOCK, pos);
        int sLight = world.getLightFor(LightType.SKY, pos);
        return LightTexture.packLight(bLight, sLight);
    }
}
