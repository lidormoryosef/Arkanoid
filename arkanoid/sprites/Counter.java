package sprites;

/**
 * Counter is a simple class that is used for counting things.
 */
public class Counter {
    private int count;
    // get current count.

    /**
     * constructor.
     * @param count , number of things.
     */
    public Counter(int count) {
        this.count = count;

    }

    /**
     * constructor.
     */
    public Counter() {
        this.count = 0;
    }
    /**
     * add number to current count.
     * @param number , the number of things we want to increase.
     */
    public void increase(int number) {
        this.count += number;

    }
    /**
     * subtract number from current count.
     * @param number , the number of things we want to decrease.
     */
    public void decrease(int number) {
        this.count -= number;

    }
    /**
     * get current count.
     * @return , the number counter.
     */
    public int getValue() {
        return this.count;
    }
}
