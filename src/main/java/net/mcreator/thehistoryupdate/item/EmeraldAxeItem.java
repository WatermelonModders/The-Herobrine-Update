
package net.mcreator.thehistoryupdate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.thehistoryupdate.TheHistoryUpdateModElements;

@TheHistoryUpdateModElements.ModElement.Tag
public class EmeraldAxeItem extends TheHistoryUpdateModElements.ModElement {
	@ObjectHolder("the_history_update:emerald_axe")
	public static final Item block = null;

	public EmeraldAxeItem(TheHistoryUpdateModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3000;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 22;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.EMERALD));
			}
		}, 1, -2f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("emerald_axe"));
	}
}
