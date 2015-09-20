package programmingactivities6;

import java.util.*;

/**
 *
 * @author 程博洋
 */

public class Blackjack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Let's play Blackjack!\n");
        Scanner input = new Scanner(System.in);
        int inputs, add, add1,total1,total;
        total1=0;
        total=0;
        
        String [] card = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        Random r = new Random();
        int plc1 = r.nextInt(13);
        int plc2 = r.nextInt(13);
        int dlc1 = r.nextInt(13);
        int dlc2 = r.nextInt(13);
        String [] player = new String[11];
        String [] dealer = new String[11];
        System.out.println("Player Cards: " + card[plc1] + " " + card[plc2]);
        System.out.println("Dealer Cards: " + "* " + card[plc2]);
        player[0] = card[plc1];
        player[1] = card[plc2];
        dealer[0] = card[dlc1];
        dealer[1] = card[dlc2];
        System.out.print("HIT (0) or STAY (1): ");
           
        inputs = input.nextInt();
        int i = 2;
        int j = 2;
        int p = 0;
        int q = 0;
        while(inputs != 1) {
            add = r.nextInt(13);
            player[i] = card[add];
            System.out.print("Player Cards: ");
            do{
                System.out.print(player[p] + " ");
                p++;
            } while (p <= i);
            i++;
            p = 0;
               
            add1 = r.nextInt(13);
            dealer[j] = card[add1];
            for (int count1 = 0; count1 < dealer.length && dealer[count1] != null; count1++) {
            if (card[10].equalsIgnoreCase(dealer[count1]) || card[11].equalsIgnoreCase(dealer[count1]) || card[12].equalsIgnoreCase(dealer[count1])) {
                total1 += 10;
            } else if (card[0].equalsIgnoreCase(dealer[count1]) && total1 <= 10) {
                total1 += 11;
            } else if (card[0].equalsIgnoreCase(dealer[count1]) && total1 > 10) {
                total1 += 1;
            } else {
            total1 += Integer.parseInt(dealer[count1]);
            }
        } 
            
            do{    
                q++;
            } while (q <= i);
            j++;
            q = 0;
            if(total1<17){
                 add1 = r.nextInt(13);
            dealer[i] = card[add];
            }else{}       
            System.out.print ("\nHIT (0) or STAY (1): ");
            inputs = input.nextInt();
        }
        
        total = 0;
        total1 = 0;
        i--;
        j--;
        do{
            System.out.print(player[p] + " ");
            p++;
        } while (p <= i);
        for (int count = 0; count <= player.length - 1&&player[count]!=null; count++) {
            if (card[10].equalsIgnoreCase(player[count]) || card[11].equalsIgnoreCase(player[count]) || card[12].equalsIgnoreCase(player[count])) {
                total += 10;
            } else if (card[0].equalsIgnoreCase(player[count]) && total <= 10) {
                total += 11;
            } else if (card[0].equalsIgnoreCase(player[count]) && total > 10) {
                total += 1;
            } else {
                
            total += Integer.parseInt(player[count]);
            count++;
            }
        }
        System.out.println("Total: " + total);
            
        do{
            System.out.print(dealer[q] + " ");
            q++;
        } while (q <= i);
        for (int count1 = 0; count1 <= dealer.length - 1&&dealer[count1]!=null; count1++) {
            if (card[10].equalsIgnoreCase(dealer[count1]) || card[11].equalsIgnoreCase(dealer[count1]) || card[12].equalsIgnoreCase(dealer[count1])) {
                total1 += 10;
            } else if (card[0].equalsIgnoreCase(dealer[count1]) && total1 <= 10) {
                total1 += 11;
            } else if (card[0].equalsIgnoreCase(dealer[count1]) && total1 > 10) {
                total1 += 1;
            } else {
            total1 += Integer.parseInt(dealer[count1]);
            }
        }
        System.out.println("Total: " + total1);
        if (total>total1&&total<21){
            System.out.println("Winner");
            
        }else{
            System.out.println("LOser");
        } 
    }
}
