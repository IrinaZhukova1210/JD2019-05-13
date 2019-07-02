package by.it.trudnitski.jd02_02;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
    static final int K_SPEED = 100;
    private static final int PLAN = 100;
    private static AtomicInteger buyerInMarket = new AtomicInteger(0);
    private static AtomicInteger buyerCounter = new AtomicInteger(0);

    static boolean planComplete() {
        return ((buyerCounter.get() == PLAN) && (buyerInMarket.get() == 0));
    }

    synchronized static void addBuyer() {
        buyerInMarket.getAndIncrement();
    }

    synchronized static void completeBuyer() {
        buyerInMarket.getAndDecrement();
        buyerCounter.getAndIncrement();
    }

    synchronized static boolean marketIsOpen() {
        return buyerInMarket.get() + buyerCounter.get() < PLAN;
    }

    static int getBuyerInMarket() {
        return buyerInMarket.get();
    }
}


