package net.supercraftalex.nuclearmod.init;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.supercraftalex.nuclearmod.ModConstants;
import net.supercraftalex.nuclearmod.NuclearMod;
import net.supercraftalex.nuclearmod.entities.EntityMissile1;
import net.supercraftalex.nuclearmod.entities.render.RenderMissile1;

public class ModInitEntities {

    public static void registerEntities()
    {
        registerEntity("missile_1", EntityMissile1.class, 201, 50, 11437146, 000000);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(ModConstants.MODID + ":" + name), entity, name, id, NuclearMod.getInstance(), range, 1, true, color1, color2);
    }

    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityMissile1.class, manager -> new RenderMissile1(manager));
    }

}
