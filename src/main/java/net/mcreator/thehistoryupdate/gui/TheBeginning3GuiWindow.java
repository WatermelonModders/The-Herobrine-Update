
package net.mcreator.thehistoryupdate.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.thehistoryupdate.TheHistoryUpdateMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class TheBeginning3GuiWindow extends ContainerScreen<TheBeginning3Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = TheBeginning3Gui.guistate;

	public TheBeginning3GuiWindow(TheBeginning3Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 343;
		this.ySize = 208;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("the_history_update:textures/the_beginning_3.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "The Beginning", 9, 10, -12829636);
		this.font.drawString(ms, "Notch lead his followers into the Nether. Notch fought with", 9, 28, -12829636);
		this.font.drawString(ms, "Herobrine, Notch won, but it took longer. Herobrine had been", 9, 46, -12829636);
		this.font.drawString(ms, "training his followers, so it was harder. Herobrine retreated", 9, 64, -12829636);
		this.font.drawString(ms, "again, this time created a dimension called 'The End\".", 9, 82, -12829636);
		this.font.drawString(ms, "The same thing happened again, except Notch found the portal", 9, 100, -12829636);
		this.font.drawString(ms, "that Herobrine had made, and went through that instead of", 9, 118, -12829636);
		this.font.drawString(ms, "building his own. Notch led Herobrine into war again. This", 9, 136, -12829636);
		this.font.drawString(ms, "time, Herobrine won. Like last time, Herobrine had been", 9, 154, -12829636);
		this.font.drawString(ms, "training.", 117, 172, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 261, this.guiTop + 181, 72, 20, new StringTextComponent("Next Page"), e -> {
			if (true) {
				TheHistoryUpdateMod.PACKET_HANDLER.sendToServer(new TheBeginning3Gui.ButtonPressedMessage(0, x, y, z));
				TheBeginning3Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 9, this.guiTop + 181, 93, 20, new StringTextComponent("Previous Page"), e -> {
			if (true) {
				TheHistoryUpdateMod.PACKET_HANDLER.sendToServer(new TheBeginning3Gui.ButtonPressedMessage(1, x, y, z));
				TheBeginning3Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
