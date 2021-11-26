package net.mcreator.thehistoryupdate.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thehistoryupdate.TheHistoryUpdateMod;

import java.util.Map;

public class SnowBerriesFoodEatenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheHistoryUpdateMod.LOGGER.warn("Failed to load dependency entity for procedure SnowBerriesFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LUCK, (int) 2400, (int) 1, (false), (true)));
	}
}
