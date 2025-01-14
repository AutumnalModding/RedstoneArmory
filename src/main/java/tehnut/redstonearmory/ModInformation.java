package tehnut.redstonearmory;

public class ModInformation {

    public static final String NAME = "Redstone Armory";
    public static final String ID = "RArm";
    public static final String CHANNEL = "RedstoneArmory";
    public static final String VERSION = "@VERSION@";
    public static final String GUIFACTORY = "tehnut.redstonearmory.client.gui.ConfigGuiFactory";
    public static final String REQUIRED = "required-after:RedstoneArsenal;" + "required-after:endercore;" + "after:ThermalFoundation;" + "after:ThermalExpansion;" + "after:Baubles";
    public static final String CLIENTPROXY = "tehnut.redstonearmory.proxies.ClientProxy";
    public static final String COMMONPROXY = "tehnut.redstonearmory.proxies.CommonProxy";
}
