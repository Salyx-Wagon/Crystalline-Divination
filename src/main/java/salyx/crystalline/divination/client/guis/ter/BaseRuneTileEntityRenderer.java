package salyx.crystalline.divination.client.guis.ter;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
//import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
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
import salyx.crystalline.divination.common.tiles.BaseRuneTile;
import salyx.crystalline.divination.core.init.ItemInit;

public class BaseRuneTileEntityRenderer extends TileEntityRenderer<BaseRuneTile> {

    private Minecraft mc = Minecraft.getInstance();

    public BaseRuneTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(BaseRuneTile te, float partialTicks, MatrixStack matrixStackIn,
            IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        if(te.getItem(0).equals(ItemStack.EMPTY)) 
            return; 
                
            
            ClientPlayerEntity player = mc.player;
            int lightLevel = getLightLevel(te.getWorld(), te.getPos().up());
            //System.out.println(te.getBlockState());
            if(te.getBlockState().toString().contains("down")) {
                renderItem(te.getItem(0), new double[] {0.5d, 0.3d, 0.5d}, Vector3f.YP.rotationDegrees(0),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.8f);
                renderItem(te.getItem(1), new double[] {0.3d, 0.3d, 0.3d}, Vector3f.YP.rotationDegrees(0),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(2), new double[] {1-0.3d, 0.3d, 0.3d}, Vector3f.YP.rotationDegrees(0),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(3), new double[] {1-0.3d, 0.3d, 1-0.3d}, Vector3f.YP.rotationDegrees(0),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(4), new double[] {0.3d, 0.3d, 1-0.3d}, Vector3f.YP.rotationDegrees(0),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
            }
            if(te.getBlockState().toString().contains("up")) {
                renderItem(te.getItem(0), new double[] {0.5d, 1-0.3d, 0.5d}, Vector3f.XP.rotationDegrees(180),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.8f);
                renderItem(te.getItem(1), new double[] {0.3d, 1-0.3d, 0.3d}, Vector3f.XP.rotationDegrees(180),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(2), new double[] {1-0.3d, 1-0.3d, 0.3d}, Vector3f.XP.rotationDegrees(180),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(3), new double[] {1-0.3d, 1-0.3d, 1-0.3d}, Vector3f.XP.rotationDegrees(180),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(4), new double[] {0.3d, 1-0.3d, 1-0.3d}, Vector3f.XP.rotationDegrees(180),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
            }
            if(te.getBlockState().toString().contains("north")) {
                renderItem(te.getItem(0), new double[] {0.5d, 0.5d, 0.3d}, Vector3f.XP.rotationDegrees(90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.8f);
                renderItem(te.getItem(1), new double[] {0.3d, 0.3d, 0.3d}, Vector3f.XP.rotationDegrees(90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(2), new double[] {1-0.3d, 0.3d, 0.3d}, Vector3f.XP.rotationDegrees(90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(3), new double[] {1-0.3d, 1-0.3d, 0.3d}, Vector3f.XP.rotationDegrees(90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(4), new double[] {0.3d, 1-0.3d, 0.3d}, Vector3f.XP.rotationDegrees(90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
            }
            if(te.getBlockState().toString().contains("south")) {
                renderItem(te.getItem(0), new double[] {0.5d, 0.5d, 1-0.3d}, Vector3f.XP.rotationDegrees(-90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.8f);
                renderItem(te.getItem(1), new double[] {0.3d, 0.3d, 1-0.3d}, Vector3f.XP.rotationDegrees(-90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(2), new double[] {1-0.3d, 0.3d, 1-0.3d}, Vector3f.XP.rotationDegrees(-90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(3), new double[] {1-0.3d, 1-0.3d, 1-0.3d}, Vector3f.XP.rotationDegrees(-90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(4), new double[] {0.3d, 1-0.3d, 1-0.3d}, Vector3f.XP.rotationDegrees(-90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
            }
            if(te.getBlockState().toString().contains("east")) {
                renderItem(te.getItem(0), new double[] {1-0.3d, 0.5d, 0.5d}, Vector3f.ZP.rotationDegrees(90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.8f);
                renderItem(te.getItem(1), new double[] {1-0.3d, 0.3d, 0.3d}, Vector3f.ZP.rotationDegrees(90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(2), new double[] {1-0.3d, 1-0.3d, 0.3d}, Vector3f.ZP.rotationDegrees(90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(3), new double[] {1-0.3d, 1-0.3d, 1-0.3d}, Vector3f.ZP.rotationDegrees(90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(4), new double[] {1-0.3d, 0.3d, 1-0.3d}, Vector3f.ZP.rotationDegrees(90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
            }
            if(te.getBlockState().toString().contains("west")) {
                renderItem(te.getItem(0), new double[] {0.3d, 0.5d, 0.5d}, Vector3f.ZP.rotationDegrees(-90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.8f);
                renderItem(te.getItem(1), new double[] {0.3d, 0.3d, 0.3d}, Vector3f.ZP.rotationDegrees(-90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(2), new double[] {0.3d, 1-0.3d, 0.3d}, Vector3f.ZP.rotationDegrees(-90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(3), new double[] {0.3d, 1-0.3d, 1-0.3d}, Vector3f.ZP.rotationDegrees(-90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
                renderItem(te.getItem(4), new double[] {0.3d, 0.3d, 1-0.3d}, Vector3f.ZP.rotationDegrees(-90),
                matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, 0.6f);
            }
            
            ITextComponent label = te.getItem(0).hasDisplayName() ? te.getItem(0).getDisplayName() :new TranslationTextComponent(te.getItem(0).getTranslationKey());
            if(player.getHeldItemMainhand().getItem() == ItemInit.ADVANCED_ITEM.get()) {
                renderLabel(matrixStackIn, bufferIn, lightLevel, new double[] {0.5d, 1.3d, 0.5d}, label , 0xffffff);   
            } 
                
    }

    private void renderItem(ItemStack stack, double[] translation, Quaternion rotation, MatrixStack matrixStack,
    IRenderTypeBuffer buffer, float partialTicks, int combinedOverlay, int lightLevel, float scale) {

        matrixStack.push();
        matrixStack.translate(translation[0], translation[1], translation[2]);
        matrixStack.rotate(rotation);
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

        stack.translate(corner[0], corner[1] +.4f, corner[2]);
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
