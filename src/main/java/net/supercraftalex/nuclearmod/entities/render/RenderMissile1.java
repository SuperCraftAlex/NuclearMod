package net.supercraftalex.nuclearmod.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelEnderCrystal;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderDragon;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.supercraftalex.nuclearmod.ModConstants;
import net.supercraftalex.nuclearmod.entities.EntityMissile1;
import net.supercraftalex.nuclearmod.models.ModelMissile1;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderMissile1 extends Render<EntityMissile1> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(ModConstants.MODID + ":textures/entity/missile1.png");
    private final ModelBase model = new ModelMissile1();

    public RenderMissile1(RenderManager manager)
    {
        super(manager);
    }


    public void doRender(EntityMissile1 entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        this.bindTexture(TEXTURES);

        this.model.render(entity, 0.0F, 3.0F, 0.2F, 0.0F, 0.0F, 0.0625F);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.popMatrix();

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMissile1 entity) {
        return null;
    }

}
