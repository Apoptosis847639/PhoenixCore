package net.phoenix.core.common.machine.multiblock.part.hpca;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.IHPCACoolantProvider;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.common.machine.multiblock.part.hpca.HPCAComponentPartMachine;

import com.lowdragmc.lowdraglib.gui.texture.ResourceTexture;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.phoenix.core.configs.PhoenixConfigs;

import lombok.Getter;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * A custom HPCA Cooler Part for the Phoenix mod.
 * This class is designed to handle both a standard and an advanced version
 * within the same class, similar to the original GTCEu implementation.
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class BasicPhoenixCoolerPartMachine extends HPCAComponentPartMachine implements IHPCACoolantProvider {

    // The 'advanced' property is handled by the HPCAComponentPartMachine base class.
    // We simply use the value from the superclass to determine behavior.

    @Getter
    private final boolean advanced;

    public BasicPhoenixCoolerPartMachine(IMachineBlockEntity holder, boolean advanced) {
        // We pass 'false' to the super constructor because we are defining a new,
        // single-tier part that isn't 'advanced' in the base sense.
        super(holder);
        this.advanced = advanced;
    }

    /**
     * Defines the component icon based on whether it is the advanced version.
     * 
     * @return The resource texture for the part's icon.
     */
    @Override
    public ResourceTexture getComponentIcon() {
        return advanced ? GuiTextures.HPCA_ICON_ACTIVE_COOLER_COMPONENT : GuiTextures.HPCA_ICON_HEAT_SINK_COMPONENT;
    }

    @Override
    public int getUpkeepEUt() {
        return advanced ? GTValues.VA[GTValues.IV] : 0;
    }

    @Override
    public boolean canBeDamaged() {
        return false;
    }

    @Override
    public int getCoolingAmount() {
        return advanced ? PhoenixConfigs.INSTANCE.features.PCCUStrength :
                PhoenixConfigs.INSTANCE.features.BasicPCCUStrength;
    }

    @Override
    public boolean isActiveCooler() {
        return advanced;
    }

    @Override
    public int getMaxCoolantPerTick() {
        return advanced ? 12 : 0;
    }
}
