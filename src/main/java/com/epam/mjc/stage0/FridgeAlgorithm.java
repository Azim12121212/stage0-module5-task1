package com.epam.mjc.stage0;

import com.epam.mjc.stage0.utils.Fridge;

public class FridgeAlgorithm {

    /**
     * This is a first task in this module. You need to get milk from a fridge =)
     * <p>
     * Call the methods of the Fridge object inside the fridgeAlgorithm method in the required logical order.
     * P.S All methods of interaction with the fridge can be found inside the {@see Fridge} class.
     */
    public void fridgeAlgorithm(Fridge fridge) {
        fridge.open();
        fridge.getMilk();
        fridge.close();
    }
    public static void main(String[] args) {
        Fridge fridge = new Fridge() {
            @Override
            public void close() {
                System.out.println("The fridge is closed");
            }

            @Override
            public void open() {
                System.out.println("The fridge is open");
            }

            @Override
            public void getMilk() {
                System.out.println("Milk has been taken from the fridge");
            }
        };

        new FridgeAlgorithm().fridgeAlgorithm(fridge);
    }
}
