package squeek.spiceoflife.foodtracker.foodqueue;

import squeek.spiceoflife.foodtracker.FoodEaten;

public class FixedHungerQueue extends FixedSizeQueue {

    protected int hunger;
    protected int hungerOverflow;

    public FixedHungerQueue(int limit) {
        super(limit);
    }

    @Override
    public boolean add(FoodEaten foodEaten) {
        boolean added = super.add(foodEaten);
        if (added) {
            hunger += foodEaten.foodValues.hunger;
            trimToMaxSize();
        }
        return added;
    }

    @Override
    public void clear() {
        super.clear();
        hunger = hungerOverflow = 0;
    }

    public int hunger() {
        return hunger;
    }

    @Override
    protected void trimToMaxSize() {
        while (hunger > limit && peekFirst() != null) {
            hunger -= 1;
            hungerOverflow += 1;

            while (hungerOverflow >= peekFirst().foodValues.hunger) {
                hungerOverflow -= removeFirst().foodValues.hunger;
            }
        }
    }
}
