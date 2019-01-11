/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

/**
 *
 * @author user
 */
public class PresCard {

    public static deck masDeck = new deck();
    public static botsAI someBots = new botsAI();
    public static List<Integer> playerHand = new ArrayList<>();

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        gameStart();
    }

    public static void gameStart() {
        Scanner kI = new Scanner(System.in);
        System.out.println("Presedent: the card game");
        System.out.println("==========================");
        System.out.println("Number of decks?");
        int numDeck = kI.nextInt();
        rounds(numDeck);
        System.out.println("You're now playing with " + numDeck + " deck(s)");
        System.out.println("How many AI bots will be playing (1,2,3)?");
        int botNum = kI.nextInt();
        botsNums(botNum);
        System.out.println(botNum + " bot(s) have been setup");
        handGive();
    }

    public static void rounds(int Input1) {
        masDeck.numOfDcks = Input1;
    }

    public static void botsNums(int Input1) {
        switch (Input1) {
            case 1:
                someBots.AISetup(1);
                break;
            case 2:
                someBots.AISetup(2);
                break;
            case 3:
                someBots.AISetup(3);
                break;
        }
    }

    public static void cardVal() {
        int[] tier = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 1};
    }

    public static void handGive() {
        if (!someBots.AI2Use) {
            for (int i = 1; i <= masDeck.numOfDcks * 26; i++) {
                playerHand.add(masDeck.GimmeCardFace(masDeck.generateCard()));
            }
            for (int i = 26; i <=34; i++) {
              playerHand.add(0);  
            }
        } else if (someBots.AI2Use) {
            for (int i = 1; i <= masDeck.numOfDcks * 18; i++) {
                playerHand.add(masDeck.GimmeCardFace(masDeck.generateCard()));
            }
            for (int i = 18; i <=26; i++) {
              playerHand.add(0);  
            }
        } else if (someBots.AI3Use) {
            for (int i = 1; i <= masDeck.numOfDcks * 13; i++) {
                playerHand.add(masDeck.GimmeCardFace(masDeck.generateCard()));
            }
            for (int i = 13; i <=21; i++) {
              playerHand.add(0);  
            }
        }
        Collections.sort(playerHand);
        int lard=playerHand.size();
       for(int i= 0;i<=playerHand.size();i++){
           int aCheck=playerHand.get(i);
           if(aCheck==0){
               playerHand.set(lard+1, aCheck);
           }
           int tCheck=playerHand.get(i);
           if(tCheck==1){
               playerHand.set(lard+1, tCheck);
           }
       }
        System.out.println("Your hand is " + playerHand);

    }
}
