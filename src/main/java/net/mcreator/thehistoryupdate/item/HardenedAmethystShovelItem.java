
package net.mcreator.thehistoryupdate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.thehistoryupdate.TheHistoryUpdateModElements;

@TheHistoryUpdateModElements.ModElement.Tag
public class HardenedAmethystShovelItem extends TheHistoryUpdateModElements.ModElement {
	@ObjectHolder("the_history_update:hardened_amethyst_shovel")
	public static final Item block = null;

	public HardenedAmethystShovelItem(TheHistoryUpdateModElements instance) {
		super(instance, 71);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 660;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(HardenedAmethystItem.block));
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("hardened_amethyst_shovel"));
	}
}
