/*
 * DiceRollingGame.java
 * January 30, 2015
 */
package programmingactivities9;

import programmingactivities9.Die;
import java.util.*;
/**
 *
 * @author 程博洋
 */
public class DiceRollingGame {
    
    public static boolean checkPoints(int points) {
        if (points > 0) {
            return true;
        } else {
            return false;
        }
    }
    public static int checkTotal(int total, int points, int call, int risk) {
        if (call == 1 && total >= 8 && total <= 12) {
            points += 2 * risk;
        } else if (call == 0 && total >= 2 && total <= 6) {
            points += 2 * risk;
        } else {    
            points -= risk;
        } return points;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int point = 1000;
        int risk, call, total;
        Scanner input = new Scanner(System.in);
        Die player = new Die();
        risk = 0;
        
        while (risk != -1) {
            System.out.println("You have " + point + " points.");
            System.out.println("How many points do you want for risk?");
            risk = input.nextInt();
            if (risk == -1) {
                break;
            } else {
                System.out.print("High (0) or Low (1)? ");
                call = input.nextInt();
                player.roll();
                total = player.getTotal();
                point = checkTotal(total, point, call, risk);
                if (checkPoints(point) == true) {
                    System.out.println("You win. ");
                } else {
                    System.out.println("You are out of points, you lose.");
                }
            }
        }
    }
    
}
