package squeek.spiceoflife.gui.widget;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import squeek.spiceoflife.ModInfo;

import java.util.Locale;

@SideOnly(Side.CLIENT)
public class WidgetButtonSortDirection extends GuiButton
{
	private static final ResourceLocation modIcons = new ResourceLocation(ModInfo.MODID.toLowerCase(Locale.ROOT), "textures/icons.png");

	/**
	 * True for sorted descending (newest first), false for sorted ascending (oldest first).
	 */
	public boolean sortDesc;

	public WidgetButtonSortDirection(int id, int x, int y, boolean sortDesc)
	{
		super(id, x, y, 11, 8, "");
		this.sortDesc = sortDesc;
	}

	/**
	 * Draws this button to the screen.
	 */
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{
		if (this.visible)
		{
			boolean isHovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			mc.getTextureManager().bindTexture(modIcons);
			int x = 0;
			int y = 0;

			if (isHovered)
			{
				x += this.width;
			}

			if (!sortDesc)
			{
				x += this.width * 2;
			}

			this.drawTexturedModalRect(this.x, this.y, x, y, width, height);
		}
	}
}
