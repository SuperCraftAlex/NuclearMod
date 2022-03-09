package net.supercraftalex.nuclearmod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMissile1 extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer fins;
	private final ModelRenderer cube_r1;
	private final ModelRenderer head;

	public ModelMissile1() {
		textureWidth = 16;
		textureHeight = 16;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -2.0F, -1.0F, -14.0F, 3, 1, 33, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, -2.0F, -5.0F, -14.0F, 3, 1, 33, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, -3.0F, -4.0F, -14.0F, 1, 3, 33, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, 1.0F, -4.0F, -14.0F, 1, 3, 33, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, -2.0F, -4.0F, 19.0F, 3, 3, 1, 0.0F, false));

		fins = new ModelRenderer(this);
		fins.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(fins);
		fins.cubeList.add(new ModelBox(fins, 0, 0, -1.0F, -6.0F, 10.0F, 1, 1, 4, 0.0F, false));
		fins.cubeList.add(new ModelBox(fins, 0, 0, -1.0F, 0.0F, 10.0F, 1, 1, 4, 0.0F, false));
		fins.cubeList.add(new ModelBox(fins, 0, 0, -1.0F, -7.0F, 11.0F, 1, 1, 3, 0.0F, false));
		fins.cubeList.add(new ModelBox(fins, 0, 0, -1.0F, 1.0F, 11.0F, 1, 1, 3, 0.0F, false));
		fins.cubeList.add(new ModelBox(fins, 0, 0, -1.0F, -8.0F, 12.0F, 1, 1, 2, 0.0F, false));
		fins.cubeList.add(new ModelBox(fins, 0, 0, -1.0F, 2.0F, 12.0F, 1, 1, 2, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, -2.0F);
		fins.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 1.5708F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -3.0F, 5.0F, 14.0F, 1, 1, 2, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -3.0F, -5.0F, 14.0F, 1, 1, 2, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -3.0F, 4.0F, 13.0F, 1, 1, 3, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -3.0F, -4.0F, 13.0F, 1, 1, 3, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -3.0F, 3.0F, 12.0F, 1, 1, 4, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -3.0F, -3.0F, 12.0F, 1, 1, 4, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, -15.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -2.0F, -4.0F, -1.0F, 3, 3, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -1.0F, -3.0F, -3.0F, 1, 1, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -1.0F, -4.0F, -2.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, 0.0F, -3.0F, -2.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -2.0F, -3.0F, -2.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -1.0F, -2.0F, -2.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -3.0F, -3.0F, 0.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -1.0F, -5.0F, 0.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, 1.0F, -3.0F, 0.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		head.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}