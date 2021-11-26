
package net.mcreator.thehistoryupdate.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.mcreator.thehistoryupdate.item.OilVeinItem;

@Mod.EventBusSubscriber
public class OilFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == OilVeinItem.block)
			event.setBurnTime(1000);
	}
}
