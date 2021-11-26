
package net.mcreator.thehistoryupdate.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.thehistoryupdate.item.ObsidianPickaxeItem;
import net.mcreator.thehistoryupdate.item.LimestonePickaxeItem;
import net.mcreator.thehistoryupdate.item.HardenedAmethystPickaxeItem;
import net.mcreator.thehistoryupdate.item.EmeraldPackPickaxeItem;
import net.mcreator.thehistoryupdate.TheHistoryUpdateModElements;

@TheHistoryUpdateModElements.ModElement.Tag
public class OreEffiencyEnchantment extends TheHistoryUpdateModElements.ModElement {
	@ObjectHolder("the_history_update:ore_effiency")
	public static final Enchantment enchantment = null;

	public OreEffiencyEnchantment(TheHistoryUpdateModElements instance) {
		super(instance, 105);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("ore_effiency"));
	}

	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.UNCOMMON, EnchantmentType.DIGGER, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		protected boolean canApplyTogether(Enchantment ench) {
			if (ench == Enchantments.SILK_TOUCH)
				return true;
			if (ench == Enchantments.FORTUNE)
				return true;
			return false;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == HardenedAmethystPickaxeItem.block)
				return true;
			if (stack.getItem() == ObsidianPickaxeItem.block)
				return true;
			if (stack.getItem() == EmeraldPackPickaxeItem.block)
				return true;
			if (stack.getItem() == LimestonePickaxeItem.block)
				return true;
			if (stack.getItem() == Items.WOODEN_PICKAXE)
				return true;
			if (stack.getItem() == Items.STONE_PICKAXE)
				return true;
			if (stack.getItem() == Items.IRON_PICKAXE)
				return true;
			if (stack.getItem() == Items.DIAMOND_PICKAXE)
				return true;
			if (stack.getItem() == Items.NETHERITE_PICKAXE)
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}

		@Override
		public boolean canGenerateInLoot() {
			return true;
		}

		@Override
		public boolean canVillagerTrade() {
			return true;
		}
	}
}
