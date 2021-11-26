
package net.mcreator.thehistoryupdate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.thehistoryupdate.procedures.RawSnowBerriePieFoodEatenProcedure;
import net.mcreator.thehistoryupdate.TheHistoryUpdateModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@TheHistoryUpdateModElements.ModElement.Tag
public class RawSnowBerriePieItem extends TheHistoryUpdateModElements.ModElement {
	@ObjectHolder("the_history_update:raw_snow_berrie_pie")
	public static final Item block = null;

	public RawSnowBerriePieItem(TheHistoryUpdateModElements instance) {
		super(instance, 111);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(8).saturation(1.2000000000000002f)

							.build()));
			setRegistryName("raw_snow_berrie_pie");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 40;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			RawSnowBerriePieFoodEatenProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll));
			return retval;
		}
	}
}
