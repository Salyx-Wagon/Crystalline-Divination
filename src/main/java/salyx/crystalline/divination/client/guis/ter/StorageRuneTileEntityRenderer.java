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
import salyx.crystalline.divination.common.tiles.StorageRuneTile;
import salyx.crystalline.divination.core.init.ItemInit;

public class StorageRuneTileEntityRenderer extends TileEntityRenderer<StorageRuneTile>{
    private Minecraft mc = Minecraft.getInstance();

    public static float r = 0;
    private double h;

    public StorageRuneTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(StorageRuneTile te, float partialTicks, MatrixStack matrixStackIn,
            IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        ClientPlayerEntity player = mc.player;
        int lightLevel = getLightLevel(te.getWorld(), te.getPos());
        int redstoneLevel = te.getWorld().getRedstonePowerFromNeighbors(te.getPos());
        h = (Math.sin((Math.PI/1800)*((r)-900))+1)/2.4;
        float r1 = 360-(r/10);
        double d = 1;
        if(!te.getPos().withinDistance(player.getPosition(), 8)){
            if(!te.getPos().withinDistance(player.getPosition(), 16)){
                d = 0;
            }
            
            else{d = 52/(te.getPos().distanceSq(player.getPosX(), player.getPosY(), player.getPosZ(), true)-8);}
        }
        if(d>0)
        {if(te.getBlockState().toString().contains("down") && redstoneLevel == 0) {
            renderItem(ItemInit.STORAGE_RUNE.get().getDefaultInstance(), new double[] {0.5d, 0.5+h, 0.5d}, Vector3f.YP.rotationDegrees(r/10), Vector3f.XP.rotationDegrees(0),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (2*d));
            for(int cir = 0; cir<3; cir++) {
                double h = ((float)cir/3.5)+0.22d;
            renderItem(te.getItem(9*cir+0), new double[] {0.5d, h, 0.5d}, Vector3f.YP.rotationDegrees(r1+45), Vector3f.XP.rotationDegrees(0),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+1), new double[] {0.3d, h+0.03, 0.3d}, Vector3f.YP.rotationDegrees(r1+0), Vector3f.XP.rotationDegrees(0),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+2), new double[] {1-0.3d, h+0.03, 0.3d}, Vector3f.YP.rotationDegrees(r1+0), Vector3f.XP.rotationDegrees(0),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+3), new double[] {1-0.3d, h+0.03, 1-0.3d}, Vector3f.YP.rotationDegrees(r1+0), Vector3f.XP.rotationDegrees(0),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+4), new double[] {0.3d, h+0.03, 1-0.3d}, Vector3f.YP.rotationDegrees(r1+0), Vector3f.XP.rotationDegrees(0),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+5), new double[] {0.5d, h-0.03, 0.2d}, Vector3f.YP.rotationDegrees(r1+45), Vector3f.XP.rotationDegrees(0),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+6), new double[] {1-0.2d, h-0.03, 0.5d}, Vector3f.YP.rotationDegrees(r1+45), Vector3f.XP.rotationDegrees(0),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+7), new double[] {0.5d, h-0.03, 1-0.2d}, Vector3f.YP.rotationDegrees(r1+45), Vector3f.XP.rotationDegrees(0),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+8), new double[] {0.2d, h-0.03, 0.5d}, Vector3f.YP.rotationDegrees(r1+45), Vector3f.XP.rotationDegrees(0),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            }
        }
        if(te.getBlockState().toString().contains("up") && redstoneLevel == 0) {
            renderItem(ItemInit.STORAGE_RUNE.get().getDefaultInstance(), new double[] {0.5d, 1.2-h, 0.5d}, Vector3f.YP.rotationDegrees(-r/10), Vector3f.XP.rotationDegrees(0),
        matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (2*d));
            for(int cir = 0; cir<3; cir++) {
                double h = 1-((float)cir/3.5) - (0.22d);
            renderItem(te.getItem(9*cir+0), new double[] {0.5d, h, 0.5d}, Vector3f.YP.rotationDegrees(45-r1), Vector3f.XP.rotationDegrees(180),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+1), new double[] {0.3d, h+0.03, 0.3d}, Vector3f.YP.rotationDegrees(0-r1), Vector3f.XP.rotationDegrees(180),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+2), new double[] {1-0.3d, h+0.03, 0.3d}, Vector3f.YP.rotationDegrees(0-r1), Vector3f.XP.rotationDegrees(180),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+3), new double[] {1-0.3d, h+0.03, 1-0.3d}, Vector3f.YP.rotationDegrees(0-r1), Vector3f.XP.rotationDegrees(180),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+4), new double[] {0.3d, h+0.03, 1-0.3d}, Vector3f.YP.rotationDegrees(0-r1), Vector3f.XP.rotationDegrees(180),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+5), new double[] {0.5d, h-0.03, 0.2d}, Vector3f.YP.rotationDegrees(45-r1), Vector3f.XP.rotationDegrees(180),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+6), new double[] {1-0.2d, h-0.03, 0.5d}, Vector3f.YP.rotationDegrees(45-r1), Vector3f.XP.rotationDegrees(180),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+7), new double[] {0.5d, h-0.03, 1-0.2d}, Vector3f.YP.rotationDegrees(45-r1), Vector3f.XP.rotationDegrees(180),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+8), new double[] {0.2d, h-0.03, 0.5d}, Vector3f.YP.rotationDegrees(45-r1), Vector3f.XP.rotationDegrees(180),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            }
        }
        if(te.getBlockState().toString().contains("north") && redstoneLevel == 0) {
            renderItem(ItemInit.STORAGE_RUNE.get().getDefaultInstance(), new double[] {0.5d, 0.5d, 0.5d+h}, Vector3f.ZP.rotationDegrees(r/10), Vector3f.XP.rotationDegrees(90),
        matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (2*d));
            for(int cir = 0; cir<3; cir++) {
                double h = 1-((float)(3-cir)/3.5) + (0.d);
            renderItem(te.getItem(9*cir+0), new double[] {0.5d, 0.5d, h}, Vector3f.ZP.rotationDegrees(r1+45), Vector3f.XP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+1), new double[] {0.3d, 0.3d, h+0.03}, Vector3f.ZP.rotationDegrees(r1+0), Vector3f.XP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+2), new double[] {1-0.3d, 0.3d, h+0.03}, Vector3f.ZP.rotationDegrees(r1+0), Vector3f.XP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+3), new double[] {1-0.3d, 1-0.3d, h+0.03}, Vector3f.ZP.rotationDegrees(r1+0), Vector3f.XP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+4), new double[] {0.3d, 1-0.3d, h+0.03}, Vector3f.ZP.rotationDegrees(r1+0), Vector3f.XP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+5), new double[] {0.5d, 0.2d, h-0.03}, Vector3f.ZP.rotationDegrees(r1+45), Vector3f.XP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+6), new double[] {1-0.2d, 0.5d, h-0.03}, Vector3f.ZP.rotationDegrees(r1+45), Vector3f.XP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+7), new double[] {0.5d, 1-0.2d, h-0.03}, Vector3f.ZP.rotationDegrees(r1+45), Vector3f.XP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+8), new double[] {0.2d, 0.5d, h-0.03}, Vector3f.ZP.rotationDegrees(r1+45), Vector3f.XP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            }
        }
        if(te.getBlockState().toString().contains("south") && redstoneLevel == 0) {
            renderItem(ItemInit.STORAGE_RUNE.get().getDefaultInstance(), new double[] {0.5d, 0.5d, 0.2d+(1-h)}, Vector3f.ZP.rotationDegrees(-r/10), Vector3f.XP.rotationDegrees(90),
        matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (2*d));
            for(int cir = 0; cir<3; cir++) {
                double h = ((float)(3-cir)/3.5) - (0.08d);
            renderItem(te.getItem(9*cir+0), new double[] {0.5d, 0.5d, h}, Vector3f.ZP.rotationDegrees(45-r1), Vector3f.XP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+1), new double[] {0.3d, 0.3d, h+0.03}, Vector3f.ZP.rotationDegrees(0-r1), Vector3f.XP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+2), new double[] {1-0.3d, 0.3d, h+0.03}, Vector3f.ZP.rotationDegrees(0-r1), Vector3f.XP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+3), new double[] {1-0.3d, 1-0.3d, h+0.03}, Vector3f.ZP.rotationDegrees(0-r1), Vector3f.XP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+4), new double[] {0.3d, 1-0.3d, h+0.03}, Vector3f.ZP.rotationDegrees(0-r1), Vector3f.XP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+5), new double[] {0.5d, 0.2d, h-0.03}, Vector3f.ZP.rotationDegrees(45-r1), Vector3f.XP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+6), new double[] {1-0.2d, 0.5d, h-0.03}, Vector3f.ZP.rotationDegrees(45-r1), Vector3f.XP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+7), new double[] {0.5d, 1-0.2d, h-0.03}, Vector3f.ZP.rotationDegrees(45-r1), Vector3f.XP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+8), new double[] {0.2d, 0.5d, h-0.03}, Vector3f.ZP.rotationDegrees(45-r1), Vector3f.XP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            }
        }
        if(te.getBlockState().toString().contains("east") && redstoneLevel == 0) {
            renderItem(ItemInit.STORAGE_RUNE.get().getDefaultInstance(), new double[] {0.5d-h, 0.5d, 0.5d}, Vector3f.XP.rotationDegrees(r/10), Vector3f.ZP.rotationDegrees(90),
        matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (2*d));
            for(int cir = 0; cir<3; cir++) {
                double h = 1-((float)cir/3.5) - (0.22d);
            renderItem(te.getItem(9*cir+0), new double[] {h, 0.5d, 0.5d}, Vector3f.XP.rotationDegrees(r1+45), Vector3f.ZP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+1), new double[] {h+0.03, 0.3d, 0.3d}, Vector3f.XP.rotationDegrees(r1+0), Vector3f.ZP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+2), new double[] {h+0.03, 0.3d, 1-0.3d}, Vector3f.XP.rotationDegrees(r1+0), Vector3f.ZP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+3), new double[] {h+0.03, 1-0.3d, 1-0.3d}, Vector3f.XP.rotationDegrees(r1+0), Vector3f.ZP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+4), new double[] {h+0.03, 1-0.3d, 0.3d}, Vector3f.XP.rotationDegrees(r1+0), Vector3f.ZP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+5), new double[] {h-0.03, 0.2d, 0.5d}, Vector3f.XP.rotationDegrees(r1+45), Vector3f.ZP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+6), new double[] {h-0.03, 0.5d, 1-0.2d}, Vector3f.XP.rotationDegrees(r1+45), Vector3f.ZP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+7), new double[] {h-0.03, 1-0.2d, 0.5d}, Vector3f.XP.rotationDegrees(r1+45), Vector3f.ZP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+8), new double[] {h-0.03, 0.5d, 0.2d}, Vector3f.XP.rotationDegrees(r1+45), Vector3f.ZP.rotationDegrees(90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            }
        }
        if(te.getBlockState().toString().contains("west") && redstoneLevel == 0) {
            renderItem(ItemInit.STORAGE_RUNE.get().getDefaultInstance(), new double[] {0.81d-(1-h), 0.5d, 0.5d}, Vector3f.XP.rotationDegrees(-r/10), Vector3f.ZP.rotationDegrees(90),
        matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (2*d));
            for(int cir = 0; cir<3; cir++) {
                double h = ((float)cir/3.5) + (0.22d);
            renderItem(te.getItem(9*cir+0), new double[] {h, 0.5d, 0.5d}, Vector3f.XP.rotationDegrees(45-r1), Vector3f.ZP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+1), new double[] {h+0.03, 0.3d, 0.3d}, Vector3f.XP.rotationDegrees(0-r1), Vector3f.ZP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+2), new double[] {h+0.03, 0.3d, 1-0.3d}, Vector3f.XP.rotationDegrees(0-r1), Vector3f.ZP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+3), new double[] {h+0.03, 1-0.3d, 1-0.3d}, Vector3f.XP.rotationDegrees(0-r1), Vector3f.ZP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+4), new double[] {h+0.03, 1-0.3d, 0.3d}, Vector3f.XP.rotationDegrees(0-r1), Vector3f.ZP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+5), new double[] {h-0.03, 0.2d, 0.5d}, Vector3f.XP.rotationDegrees(45-r1), Vector3f.ZP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+6), new double[] {h-0.03, 0.5d, 1-0.2d}, Vector3f.XP.rotationDegrees(45-r1), Vector3f.ZP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+7), new double[] {h-0.03, 1-0.2d, 0.5d}, Vector3f.XP.rotationDegrees(45-r1), Vector3f.ZP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            renderItem(te.getItem(9*cir+8), new double[] {h-0.03, 0.5d, 0.2d}, Vector3f.XP.rotationDegrees(45-r1), Vector3f.ZP.rotationDegrees(-90),
            matrixStackIn, bufferIn, partialTicks, combinedOverlayIn, lightLevel, (float) (0.4*d));
            }
        }}
        
        ITextComponent label = te.getItem(0).hasDisplayName() ? te.getItem(0).getDisplayName() :new TranslationTextComponent(te.getItem(0).getTranslationKey());
        if(player.getHeldItemMainhand().getItem() == ItemInit.ADVANCED_ITEM.get()) {
            renderLabel(matrixStackIn, bufferIn, lightLevel, new double[] {0.5d, 1.3d, 0.5d}, label , 0xffffff);   
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
