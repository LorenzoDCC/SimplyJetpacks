package tonius.simplyjetpacks.config;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.config.Configuration;

public class JetpackConfig {
    
    public final ConfigSection section;
    public final JetpackDefaults defaults;
    
    public Integer energyCapacity;
    public Integer energyPerTick;
    
    public Double speedVertical;
    public Double accelVertical;
    public Double speedVerticalHover;
    public Double speedVerticalHoverSlow;
    public Double speedSideways;
    
    public Integer armorDisplay;
    public Double armorAbsorption;
    public Integer armorEnergyPerHit;
    
    public Boolean enchantable;
    public Integer enchantability;
    public Boolean emergencyHoverMode;
    
    public Integer chargerRate;
    
    public JetpackConfig(ConfigSection section, JetpackDefaults defaults) {
        this.section = section;
        this.defaults = defaults;
        this.setDefaults();
    }
    
    public void setDefaults() {
        this.energyCapacity = this.defaults.energyCapacity;
        this.energyPerTick = this.defaults.energyPerTick;
        
        this.speedVertical = this.defaults.speedVertical;
        this.accelVertical = this.defaults.accelVertical;
        this.speedVerticalHover = this.defaults.speedVerticalHover;
        this.speedVerticalHoverSlow = this.defaults.speedVerticalHoverSlow;
        this.speedSideways = this.defaults.speedSideways;
        
        this.armorDisplay = this.defaults.armorDisplay;
        this.armorAbsorption = this.defaults.armorAbsorption;
        this.armorEnergyPerHit = this.defaults.armorEnergyPerHit;
        
        this.enchantable = this.defaults.enchantable;
        this.enchantability = this.defaults.enchantability;
        this.emergencyHoverMode = this.defaults.emergencyHoverMode;
        
        this.chargerRate = this.defaults.chargerRate;
    }
    
    public void processConfig(Configuration config) {
        if (this.energyCapacity != null) {
            this.energyCapacity = config.get(this.section.name, "Energy Capacity", this.defaults.energyCapacity, "The maximum amount of energy that the jetpack can hold.").getInt(this.defaults.energyCapacity);
        }
        if (this.energyPerTick != null) {
            this.energyPerTick = config.get(this.section.name, "Energy Usage per Tick", this.defaults.energyPerTick, "The amount of energy that the jetpack uses every tick when flying.").getInt(this.defaults.energyPerTick);
        }
        
        this.speedVertical = config.get(this.section.name, "Vertical Speed", this.defaults.speedVertical, "The maximum vertical speed of the jetpack when flying.").getDouble(this.defaults.speedVertical);
        this.accelVertical = config.get(this.section.name, "Vertical Acceleration", this.defaults.accelVertical, "The vertical acceleration of the jetpack when flying; every tick, this amount of vertical speed will be added until the jetpack reaches the maximum speed.").getDouble(this.defaults.accelVertical);
        if (this.speedVerticalHover != null) {
            this.speedVerticalHover = config.get(this.section.name, "Vertical Speed (Hover Mode)", this.defaults.speedVerticalHover, "The maximum vertical speed of the jetpack when flying in hover mode.").getDouble(this.defaults.speedVerticalHover);
        }
        if (this.speedVerticalHoverSlow != null) {
            this.speedVerticalHoverSlow = config.get(this.section.name, "Vertical Speed (Hover Mode / Slow Descent)", this.defaults.speedVerticalHoverSlow, "The maximum vertical speed of the jetpack when slowly descending in hover mode.").getDouble(this.defaults.speedVerticalHoverSlow);
        }
        if (this.speedSideways != null) {
            this.speedSideways = config.get(this.section.name, "Sideways Speed", this.defaults.speedSideways, "The speed of the jetpack when flying sideways. This is mostly noticeable in hover mode.").getDouble(this.defaults.speedSideways);
        }
        
        if (this.armorDisplay != null) {
            this.armorDisplay = config.get(this.section.name, "Armor Display", this.defaults.armorDisplay, "How powerful the ARMORED version of the jetpack will show up on the ingame GUI. The higher the value, the more armor points show up.").getInt(this.defaults.armorDisplay);
        }
        if (this.armorAbsorption != null) {
            this.armorAbsorption = config.get(this.section.name, "Armor Absorption", this.defaults.armorAbsorption, "The relative amount of damage that the ARMORED version of the jetpack will absorb when getting hit.").getDouble(this.defaults.armorAbsorption);
        }
        if (this.armorEnergyPerHit != null) {
            int armorEnergyPerHit_temp = config.get(this.section.name, "Armor Energy Per Hit", this.defaults.armorEnergyPerHit, "The amount of energy that is consumed from the ARMORED version of the jetpack when getting hit. This value will be multiplied by the amount of damage done.").getInt(this.defaults.armorEnergyPerHit);
            this.armorEnergyPerHit = armorEnergyPerHit_temp > 0 ? armorEnergyPerHit_temp : 1;
        }
        
        if (this.enchantable != null) {
            this.enchantable = config.get(this.section.name, "Enchantable", this.defaults.enchantable, "When enabled, this jetpack will be enchantable using enchantment tables or anvils.").getBoolean(this.defaults.enchantable);
        }
        if (this.enchantability != null) {
            this.enchantability = config.get(this.section.name, "Enchantability", this.defaults.enchantability, "The enchantability of the jetpack. Note that the jetpack may be set not to be enchantable.").setMinValue(0).getInt(this.defaults.enchantability);
        }
        if (this.emergencyHoverMode != null) {
            this.emergencyHoverMode = config.get(this.section.name, "Emergency Hover Mode", this.defaults.emergencyHoverMode, "When enabled, this jetpack will activate hover mode automatically when the wearer is about to die from a fall.").getBoolean(this.defaults.emergencyHoverMode);
        }
        
        if (this.chargerRate != null) {
            this.chargerRate = config.get(this.section.name, "Charger Energy Rate", this.defaults.chargerRate, "The rate, in RF per tick, at which this jetpack can charge other items. Set to 0 to disable this jetpack charging items.").getInt(this.defaults.chargerRate);
        }
    }
    
    public void writeToNBT(NBTTagCompound tag) {
        if (this.energyCapacity != null) {
            tag.setInteger("EnergyCapacity", this.energyCapacity);
        }
        if (this.energyPerTick != null) {
            tag.setInteger("EnergyPerTick", this.energyPerTick);
        }
        
        tag.setDouble("SpeedVertical", this.speedVertical);
        tag.setDouble("AccelVertical", this.accelVertical);
        if (this.speedVerticalHover != null) {
            tag.setDouble("SpeedVerticalHover", this.speedVerticalHover);
        }
        if (this.speedVerticalHoverSlow != null) {
            tag.setDouble("SpeedVerticalHoverSlow", this.speedVerticalHoverSlow);
        }
        if (this.speedSideways != null) {
            tag.setDouble("SpeedSideways", this.speedSideways);
        }
        
        if (this.armorDisplay != null) {
            tag.setInteger("ArmorDisplay", this.armorDisplay);
        }
        
        if (this.chargerRate != null) {
            tag.setInteger("ChargerRate", this.chargerRate);
        }
    }
    
    public void readFromNBT(NBTTagCompound tag) {
        if (this.energyCapacity != null) {
            this.energyCapacity = tag.getInteger("EnergyCapacity");
        }
        if (this.energyPerTick != null) {
            this.energyPerTick = tag.getInteger("EnergyPerTick");
        }
        
        this.speedVertical = tag.getDouble("SpeedVertical");
        this.accelVertical = tag.getDouble("AccelVertical");
        if (this.speedVerticalHover != null) {
            this.speedVerticalHover = tag.getDouble("SpeedVerticalHover");
        }
        if (this.speedVerticalHoverSlow != null) {
            this.speedVerticalHoverSlow = tag.getDouble("SpeedVerticalHoverSlow");
        }
        if (this.speedSideways != null) {
            this.speedSideways = tag.getDouble("SpeedSideways");
        }
        
        if (this.armorDisplay != null) {
            this.armorDisplay = tag.getInteger("ArmorDisplay");
        }
        
        if (this.chargerRate != null) {
            this.chargerRate = tag.getInteger("ChargerRate");
        }
    }
    
}
