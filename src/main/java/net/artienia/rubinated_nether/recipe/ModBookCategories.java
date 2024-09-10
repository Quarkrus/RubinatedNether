package net.artienia.rubinated_nether.recipe;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import net.artienia.rubinated_nether.RubinatedNether;
import net.artienia.rubinated_nether.item.ModItems;
import net.artienia.rubinated_nether.screen.ModRecipeBookTypes;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;

import java.util.function.Supplier;

@Mod(RubinatedNether.MOD_ID)
@EventBusSubscriber(modid = RubinatedNether.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModBookCategories {
    public static final Supplier<RecipeBookCategories> FREEZABLE_SEARCH = Suppliers.memoize(() -> RecipeBookCategories.create("FREEZABLE_SEARCH", new ItemStack(Items.COMPASS)));
    public static final Supplier<RecipeBookCategories> FREEZABLE_MISC = Suppliers.memoize(() -> RecipeBookCategories.create("FREEZABLE_MISC", new ItemStack(ModItems.RUBY.get())));


    /**
     * Registers the mod's categories to be used in-game, along with functions to sort items.
     * To add sub-categories to be used by the search, use addAggregateCategories with the
     * search category as the first parameter.
     */
    @SubscribeEvent
    public static void registerRecipeCategories(RegisterRecipeBookCategoriesEvent event) {
        event.registerBookCategories(ModRecipeBookTypes.FREEZER, ImmutableList.of(FREEZABLE_SEARCH.get(), FREEZABLE_MISC.get()));
        event.registerAggregateCategory(FREEZABLE_SEARCH.get(), ImmutableList.of(FREEZABLE_MISC.get()));
        event.registerRecipeCategoryFinder(ModRecipeTypes.FREEZING.get(), recipe -> FREEZABLE_MISC.get());
    }
}
