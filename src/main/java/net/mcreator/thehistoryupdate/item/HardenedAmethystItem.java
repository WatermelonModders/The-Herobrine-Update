
package net.mcreator.thehistoryupdate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.thehistoryupdate.TheHistoryUpdateModElements;

@TheHistoryUpdateModElements.ModElement.Tag
public class HardenedAmethystItem extends TheHistoryUpdateModElements.ModElement {
	@ObjectHolder("the_history_update:hardened_amethyst")
	public static final Item block = null;

	public HardenedAmethystItem(TheHistoryUpdateModElements instance) {
		super(instance, 62);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("hardened_amethyst");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}