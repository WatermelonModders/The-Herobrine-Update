package net.mcreator.thehistoryupdate.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.thehistoryupdate.entity.GhoulEntity;
import net.mcreator.thehistoryupdate.TheHistoryUpdateMod;

import java.util.Map;

public class DupeGhoulProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheHistoryUpdateMod.LOGGER.warn("Failed to load dependency world for procedure DupeGhoul!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheHistoryUpdateMod.LOGGER.warn("Failed to load dependency x for procedure DupeGhoul!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheHistoryUpdateMod.LOGGER.warn("Failed to load dependency y for procedure DupeGhoul!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheHistoryUpdateMod.LOGGER.warn("Failed to load dependency z for procedure DupeGhoul!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerWorld) {
			Entity entityToSpawn = new GhoulEntity.CustomEntity(GhoulEntity.entity, (World) world);
			entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
			world.addEntity(entityToSpawn);
		}
	}
}
