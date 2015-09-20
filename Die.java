/*
 * Die.java
 * January 30, 2015
 */
package programmingactivities9;

import java.util.*;
/**
 *
 * @author 程博洋
 */
public class Die {
    int die1, die2;
    public Die () {
        die1 = 1;
        die2 = 1;
    }
    public void roll() {
        Random r = new Random();
        die1 = r.nextInt(6) + 1;
        die2 = r.nextInt(6) + 1;
    }
    public int getTotal() {
        int total;
        total = die1 + die2;
        return total;
    }
}
