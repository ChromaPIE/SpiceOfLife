package squeek.spiceoflife.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NetworkHelper
{
	public static EntityPlayer getSidedPlayer(MessageContext ctx)
	{
		return ctx.side == Side.SERVER ? ctx.getServerHandler().player : getClientPlayer();
	}

	@SideOnly(Side.CLIENT)
	public static EntityPlayer getClientPlayer()
	{
		return FMLClientHandler.instance().getClientPlayerEntity();
	}
}
