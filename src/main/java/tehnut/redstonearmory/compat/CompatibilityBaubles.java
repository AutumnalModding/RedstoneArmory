package tehnut.redstonearmory.compat;

import cofh.core.util.crafting.RecipeUpgrade;
import cofh.lib.util.helpers.EnergyHelper;
import cofh.thermalexpansion.item.ItemCapacitor;
import cofh.thermalexpansion.item.TEItems;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tehnut.redstonearmory.ConfigHandler;
import tehnut.redstonearmory.enums.EnergyType;
import tehnut.redstonearmory.items.baubles.ItemCapacitorAmulet;
import tehnut.redstonearmory.util.LogHelper;
import tehnut.redstonearmory.util.ShapelessRecipeUpgrade;
import tehnut.redstonearmory.util.annot.Register;
import tehnut.redstonearmory.util.annot.Registerer;

public class CompatibilityBaubles {

    @Register
    public static Item capacitorBauble = new ItemCapacitorAmulet();

    static {
        LogHelper.info("Baubles Detected: Adding compatibility.");
        Registerer.scan(CompatibilityBaubles.class);
        addRecipes();
    }

    public static void addRecipes() {
        if (ConfigHandler.enableCapacitorBaubleCrafting && Loader.isModLoaded("Thermal Expansion")) {
            GameRegistry.addRecipe(new ShapedOreRecipe(EnergyHelper.setDefaultEnergyTag(ItemCapacitorAmulet.getStackItem(EnergyType.TUBEROUS), EnergyType.TUBEROUS.capacity), " S ", "S S", " C ", 'S', "stringFluxed", 'C', EnergyHelper.setDefaultEnergyTag(new ItemStack(TEItems.itemCapacitor, 1, ItemCapacitor.Types.POTATO.ordinal()), ItemCapacitor.CAPACITY[ItemCapacitor.Types.POTATO.ordinal()])));

            for (int i = 2; i < EnergyType.values().length; i++) {
                GameRegistry.addRecipe(new RecipeUpgrade(7, ItemCapacitorAmulet.getStackItem(EnergyType.values()[i]), new Object[]{" S ", "S S", " C ", 'S', "stringFluxed", 'C', new ItemStack(TEItems.itemCapacitor, 1, i)}));
                GameRegistry.addRecipe(new ShapelessRecipeUpgrade(new ItemStack(TEItems.itemCapacitor, 1, i), ItemCapacitorAmulet.getStackItem(EnergyType.values()[i])));
            }
        }
    }
}
