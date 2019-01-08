/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescard;

import java.util.Scanner;

/**
 *
 * @author te233146
 */
public class deck {

    // A to K is 0 to 12
    // Suits are in order 0Spades, 1Hearts, 2Clubs, 3Diamonds
    //ARRAY FOR HE NUMBER OF EACH CARD THAT HAS BEEN GENERATED
    public int[] deck = new int[52];
    public int[] discardDeck = new int[52];

    //ARRAY FOR STORING THE NUMBERS THAT ARE GENERATED
    public int[] CardVals = new int[52];

    //CHANGE TO ALLOW USER TO ENTER THE NUMBER OF DECKS AS WELL. /\ /\ /\
    public String dispText = "Your card is a ";
    public int numOfDcks = 1;
    public int randomCard = 0;
    public int cardFaceNum = 0;
    public int cardSuitNum = 0;
    //INITIALIZES THE CARD FACE AND SUIT STRINGS FOR PRINTING, STORES THIS IN 2 DIFFERENT ARRAYS
    public String suits[] = {"Spades", "Hearts", "Clubs", "Diamonds"};
    public String faces[] = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

    public void main(String[] args) {
       

        //FILLS THE DECK WITH ZEROS TO START
        for (int i = 0; i < deck.length; i++) {
            deck[i] = -1;
        }

        //DO WHILE LOOP TO CONTINUALLY GENERATE A NEW NUMBER UNTIL ONE THAT IS NOT USED SHOWS UP
        //NOTE THAT (numOfDecks) IS USED TO DETERMINE THE MAX AMOUNT OF EACH CARD THAT CAN BE GENERATED
        do {
            randomCard = (int) (Math.random() * 52);
        } while (deck[randomCard] >= numOfDcks);
        //PUTS INTO THE DECK ARRAY THAT THIS CARD HAS BEEN GENERATED
        deck[randomCard]++;

        //System.out.println(j);
        //FINDS THE CARD FACE OF THE NUMBER GENERATED AS WELL AS THE SUIT OF THE CARD
        cardFaceNum = randomCard % 13;
        cardSuitNum = randomCard / 13;
        //System.out.println(faces[cardFaceNum] + " of " + suits[cardSuitNum]);

    }

    public int generateCard() {
        int gendCard = 0;
        //DO WHILE LOOP TO CONTINUALLY GENERATE A NEW NUMBER UNTIL ONE THAT IS NOT USED SHOWS UP
        //NOTE THAT (numOfDecks) IS USED TO DETERMINE THE MAX AMOUNT OF EACH CARD THAT CAN BE GENERATED
        do {
            randomCard = (int) (Math.random() * 52);
        } while (deck[randomCard] >= numOfDcks);
        //PUTS INTO THE DECK ARRAY THAT THIS CARD HAS BEEN GENERATED
        deck[randomCard]++;

        //RETURNS THE GENERATED CARD TO THE USER SO THEY CAN USE IT
        gendCard = randomCard;
        return gendCard;
    }

    //TAKES THE NUMBER (card) GIVEN TO THIS METHOD AND FINDS THE FACE VALUE. RETURNS THE NUMBER  (0-12)
    public static int GimmeCardFace(int GivenNum) {
        int FaceVal = 0;
        FaceVal = GivenNum % 13;

        return FaceVal;
    }

    //TAKES THE NUMBER (card) GIVEN TO THIS METHOD AND FINDS THE SUIT. RETURNS THE NUMBER OF THE SUIT (1-4)
    public static int GimmeCardSuit(int GivenNum) {
        int SuitVal = 0;
        SuitVal = GivenNum / 13;

        return SuitVal;
    }

    public void DisplayCard(int GivenNum) {
        int FaceVal = 0;
        FaceVal = GivenNum % 13;

        int SuitVal = 0;
        SuitVal = GivenNum / 13;

        System.out.println(dispText + faces[FaceVal] + " of " + suits[SuitVal]);
    }

    public String getSuit(int suitVal) {
        String suitType = suits[suitVal];
        return suitType;
    }

    public String getFace(int faceVal) {
        String faceType = faces[faceVal];
        return faceType;
    }

    public void SetDckNum(int DckNum) {
        numOfDcks = DckNum;
    }

    public void setDispText(String setString) {
        dispText = setString;
    }

    public int suitsGend(int SuitType) {
        int suitsGend = 0;

        //I WANT ALL OF THE SPADES. SPADES IS 0.
        //REPEATS TO CHECK ALL 52 CARDS
        for (int i = 0; i < 52; i++) {
            //CHECKS IF THE CARD IN THIS SPOT WOULD HAVE BEEN A CERTAIN SUIT
            if (i / 13 == SuitType) {
                //IF THE CARD WAS THE CERTAIN SUIT, CHECKS IF THAT CARD HAS BEEN GENERATED ALREADY
                if (deck[i] > 0) {
                    //IF IT HAS BEEN GENERATED ALREADY, THEN ADD ONE TO THE CERTAIN SUIT GENERATED COUNT
                    suitsGend += deck[i];
                }
            }
        }
        return suitsGend;
    }

    public int faceGend(int FaceType) {
        int FaceGend = 0;

        //REPEATS TO CHECK ALL 52 CARDS
        //WHAT ABOUT MUTIPLE DECKS*********************
        for (int i = 0; i < 52; i++) {

            if (i % 13 == FaceType) {
                //IF THE CARD WAS THE CERTAIN SUIT, CHECKS IF THAT CARD HAS BEEN GENERATED ALREADY
                if (deck[i] > 0) {
                    //IF IT HAS BEEN GENERATED ALREADY, THEN ADD ONE TO THE CERTAIN SUIT GENERATED COUNT
                    FaceGend += deck[i];
                }
            }
        }
        return FaceGend;
    }
    //DISCARDS A CARD. MUST SEND THE INTEGER VALUE (0-51). INCREASES THE VALUE OF THAT CARD TYPE BY 1. 
    //(ie one three of spades has been discarded already, another has just been discarded so now there have been 2 discarded)

    public void DicardCard(int cardToDiscard) {
        discardDeck[cardToDiscard] = discardDeck[cardToDiscard] + 1;
        System.out.println(discardDeck[cardToDiscard]);

    }

    public void DiscardDeck() {
        //REPLACE ALL OF THE CARDS IN THE DECK WITH AN EMPTY VALUE IF THEY ARE IN THE DISCARD PILE
        //EMPTY THE DISCARD PILE
        for (int DD = 0; DD < 52; DD++) {
            System.out.print(" " + discardDeck[DD]);
        }
        System.out.println();

        for (int DD = 0; DD < 52; DD++) {
            if (discardDeck[DD] > 0) {
                //EMPTIES THE DECK BY FILLING THAT DECK SPOT WITH -1 INDICATING THAT THE CARD HAS NOT BEEN GENERATED

                deck[DD] -= discardDeck[DD];
                discardDeck[DD] = 0;
            }
        }

    }
}


