package net.vadamdev.customcontent.api.items;

import net.vadamdev.customcontent.api.IRegistrable;
import net.vadamdev.customcontent.lib.events.ItemBreakBlockEvent;
import net.vadamdev.customcontent.lib.events.ItemUseEvent;
import net.vadamdev.customcontent.utils.NBTHelper;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author VadamDev
 * @since 22/12/2021
 */
public abstract class CustomItem implements IRegistrable {
    protected ItemStack itemStack;
    protected final List<String> defaultLore;

    public CustomItem(ItemStack itemStack) {
        this.itemStack = NBTHelper.setStringInNBTTag(itemStack, "RegistryName", getRegistryName());
        this.defaultLore = itemStack.getItemMeta().getLore();
    }

    public Consumer<ItemUseEvent> getInteractAction() {
        return null;
    }

    public Consumer<ItemBreakBlockEvent> getBlockBreakAction() {
        return null;
    }

    @Override
    public ItemStack getItemStack() {
        return itemStack;
    }
}
