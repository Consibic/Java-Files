/*
 * Blackjack2.java
 * This program will offer a series of cards for players to play the game "blackjack" and calculate the total times as well as percentages of winning.
 * Constantine Boyang Cheng
 * ICS4U
 * January 27 - 28, 2015
 */
package programmingactivities7;

/**
 *
 * @author Steve Sicheng Zhu, Constantine Boyang Cheng, Shane Renxi Sheng
 */
//we love Campbell
import java.util.Scanner;
import java.util.Random;
import java.text.NumberFormat;

public class Blackjack2 {
    static Scanner input = new Scanner(System.in);
    
    /**
     * Return the array for all of player cards, ask the player to hit or stay and print the player cards every time the player hit or stayed;
     * Pre: String [ ] card == card [ ] in the main method && player.length is smaller than 11;
     * Post: the array of the player cards is returned.
     * @param player
     * @param card
     * @return 
     */
    public static String[] playerCard(String [] player, String [] card) {
        Random r = new Random();
        System.out.print("HIT(0) or STAY(1): "); //ask the player to hit or stay
        int enter = input.nextInt(); //let the player to input the choice
        int add; //to represent the origin index of elements added in card[] 
        int placeAll = 2; //to represent the index of element added into player[]
        int placePrint = 0; //for printing each element of player[]
        while(enter != 1) {
            add = r.nextInt(13); //to create a number randomly in the range the indexs of player[]
            player[placeAll] = card[add]; //use the random number to represent the random index of element
            System.out.print("Player Cards: "); 
            do{
                System.out.print(player[placePrint] + " ");
                placePrint++;
            } while (placePrint <= placeAll); //use the loop to print the non-null elements of player[]
            placeAll++; //ensure the element added in the next loop is printed after the player chooses "hit"
            placePrint = 0; //ensure the printing is from the first element after the player chooses "hit"
            System.out.print("\nHIT(0) or STAY(1): "); 
            enter = input.nextInt();   
        }
        return(player); 
    } 
    
    /**
     * Return the array for all of dealer cards;
     * Pre: String [ ] card == card [ ] in the main method && dealer.length is smaller than 11;
     * Post: the array for dealer cards is returned. 
     * @param dealer
     * @param card
     * @return 
     */
    public static String[] dealerCard(String [] dealer, String [] card) {
        
        Random r1 = new Random();
        int place = 2; //to represent the index of element added into dealer[]
        int add1; //to represent the origin index of elements added in card[] 
        /*to add card for dealer before the total number equals 17 */
        while(Calculation(dealer, card) < 17) { 
            add1 = r1.nextInt(13); //to create a number randomly in the range the indexs of dealer[]
            dealer[place] = card[add1]; //use the random number to represent the random index of element
            place++;
        }
        return dealer;
    }
    
    /**
     * Return the value of each card into number when the card is in the range from 2 to 10;
     * Pre: cardNum != null && String [ ] card == card [ ] in the main method;
     * Post: the value of the card is returned.
     * @param card
     * @param cardNum
     * @return 
     */
    public static int numberCal(String [] card, String cardNum) {
        int place = 0; //test the card from the first element of String [] card
        /* to find if cardNum is the same as the tested element of card[] */
        while (place < card.length && card[place].equals(cardNum) == false) {  
            place++; //to compare the next element of String [] card
        }
        return place + 1; //transfer the string element(the card) to the value it is represented
    }    
    
    /**
     * Add the value of cards up for the calculating the total numbers, and return the total number;
     * Pre: String [ ] card == card[ ] in the main method && result.length is smaller than 11;
     * Post: the total number is returned.  
     * @param result
     * @param card
     * @return 
     */
    public static int Calculation(String [] result, String [] card) {
        int totalScore = 0; //initialize the totalscore
        /* calculate the total score of the player or the dealer */
        for (int count1 = 0; count1 < result.length && result[count1] != null; count1++) { 
            if (card[10].equals(result[count1]) || card[11].equals(result[count1]) || card[12].equals(result[count1])) {
                totalScore += 10; //to add the value of J, Q, K into the totalscore
            } else if (card[0].equals(result[count1]) && totalScore <= 10) {
                totalScore += 11; //to add value of A if the totalscore will be smaller than or equal to 21 after adding the value of A 
            } else if (card[0].equals(result[count1]) && totalScore > 10) {
                totalScore += 1; //to add value of A if the totalscore will be larger than 21 after adding the value of A
            } else {
                totalScore += numberCal(card, result[count1]);
            }
            totalScore = check(result, card, totalScore);
        } 
        return totalScore;
    }
    
    /**
     * To re-choose the value of A from 1 and 11 by checking if the total number is larger than 21 and return the total score after rechoosing the value of A;
     * Pre: result.length is smaller than 11 && String [ ] card == card [] in the main method;
     * Post: the total score after rechoosing the value of A is returned.
     * @param result
     * @param card
     * @param totalScore
     * @return 
     */
    public static int check(String [] result, String [] card, int totalScore) {
        /* chech whether the value of A is 1 or 11 */
        for (int place = 0; place < result.length && totalScore > 21; place++) {
            if (result[place] == card[0]) { 
                totalScore -= 10; //to change the value of A from 11 to 1 if the card after A makes the total number larger than 21
            }
        }
        return totalScore;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        System.out.println("Let's play Blackjack\n");
        String [] card = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; //for picking cards
        String [] player = new String[11]; //the array for player's cards
        String [] dealer = new String[11]; //the array for dealer's cards
        String playAgain;
        int winTimes = 0;
        int gameTimes = 0;
        do {
            Random r = new Random();
            /* generate two player cards. */
            int plc1 = r.nextInt(13);   
            int plc2 = r.nextInt(13);
            /* generate two dealer cards. */
            int dlc1 = r.nextInt(13);
            int dlc2 = r.nextInt(13);
            System.out.println("Player Cards: " + card[plc1] + " " + card[plc2]);
            System.out.println("Dealer Cards: " + "* " + card[dlc2]);
            /* store the card into the array for player cards. */
            player[0] = card[plc1];
            player[1] = card[plc2];
            /* store the card into the array for dealer cards. */
            dealer[0] = card[dlc1];
            dealer[1] = card[dlc2];
            
            player = playerCard(player, card); // let the player choose hit or stay.
            
            System.out.print("Player Cards: ");
            for (int i = 0; i < player.length && player[i] != null; i++) {
                System.out.print(player[i] + " ");
            }
            int totalPlayer = Calculation(player, card); // calculate the total score of the player
            System.out.println("Total: " + totalPlayer);
            dealer = dealerCard(dealer, card);  // determine whether dealer will add a card 
            System.out.print("Dealer Cards: ");
            for (int i = 0; i < dealer.length && dealer[i] != null; i++) {
            System.out.print(dealer[i] + " ");
            }
            int totalDealer = Calculation(dealer, card); // calculate the total score of dealer
            System.out.println("Total: " + totalDealer);
            /* determine whether player wins or not */
            if (totalPlayer > totalDealer && totalPlayer <= 21){
                System.out.println("Player wins!");
                winTimes++; //count the total times the player win
            } else if (totalDealer > 21 && totalPlayer <= 21) {
                System.out.println("Player wins!");
                winTimes++;// count the total times the player win.
            } else {
                System.out.println("Player loses.");
            }
            System.out.print("Would you like to play again? (y for yes, n for no): ");
            playAgain = input.next();
            gameTimes++;  // count the total times of game played
        } while (playAgain.equals("y") == true); 
        double percentage = (double)winTimes / (double)gameTimes; //calculate the percentage of wining
        NumberFormat percent = NumberFormat.getPercentInstance();
        System.out.println("You have won " + winTimes + " game(s). You have won " + percent.format(percentage) + " of games played.");
        input.close();
    }
}
