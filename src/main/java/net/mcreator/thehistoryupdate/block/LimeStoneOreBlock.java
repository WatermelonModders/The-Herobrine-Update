
package net.mcreator.thehistoryupdate.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.thehistoryupdate.item.LimestoneGemItem;
import net.mcreator.thehistoryupdate.TheHistoryUpdateModElements;

import java.util.List;
import java.util.Collections;

@TheHistoryUpdateModElements.ModElement.Tag
public class LimeStoneOreBlock extends TheHistoryUpdateModElements.ModElement {
	@ObjectHolder("the_history_update:lime_stone_ore")
	public static final Block block = null;

	public LimeStoneOreBlock(TheHistoryUpdateModElements instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.METAL).hardnessAndResistance(3f, 20f).setLightLevel(s -> 3).harvestLevel(3)
					.harvestTool(ToolType.AXE).setRequiresTool().slipperiness(1f).speedFactor(0.8f).jumpFactor(0.8f)
					.setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true));
			setRegistryName("lime_stone_ore");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(LimestoneGemItem.block, (int) (2)));
		}
	}
}
