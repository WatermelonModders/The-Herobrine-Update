package net.mcreator.thehistoryupdate.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thehistoryupdate.TheHistoryUpdateMod;

import java.util.Map;

public class ExitProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheHistoryUpdateMod.LOGGER.warn("Failed to load dependency entity for procedure Exit!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
