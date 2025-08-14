package net.phoenix.core.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

public class PhoenixElements {

    public static final Element APNS = createAndRegister(35, 450, -1, null, "Almost Pure Nevvonian Steel", "", false);
    public static final Element Pi = createAndRegister(1, 0, -1, null, "Prisma", "", false);
    public static final Element Vir = createAndRegister(1, 0, -1, null, "Vitrius", "", false);

    public static Element createAndRegister(long protons, long neutrons, long halfLifeSeconds, String decayTo,
                                            String name, String symbol, boolean isIsotope) {
        Element element = new Element(protons, neutrons, halfLifeSeconds, decayTo, name, symbol, isIsotope);
        GTRegistries.ELEMENTS.register(name, element);
        return element;
    }

    public static void init() {}
}
