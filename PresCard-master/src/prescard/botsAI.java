/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescard;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


/**
 *
 * @author user
 */
public class botsAI {
   

    public static boolean AI2Use,AI3Use;
   public static deck deckID = new deck();
    public static PresCard playerID = new PresCard();
    //public static int[] AI1Hand =new int
    public static List<Integer> AI1Hand =new ArrayList<>();
    public static List<Integer> AI2Hand =new ArrayList<>();
    public static List<Integer> AI3Hand =new ArrayList<>();
    public static void main(String[] args) {
        
    }
    public static void AISetup(int numToSet){
        if(numToSet==2){
            AI2Use=true;
        }else if(numToSet==3){
            AI2Use=true;
            AI3Use=true;
        }
        
    }
     public static void handID(){
       int f=deckID.numOfDcks*52;
       
         for(int i=0;i>=f/2;i++){
            AI1Hand.add(deckID.GimmeCardFace(deckID.generateCard()));
            if(AI2Use){
             AI2Hand.add(deckID.GimmeCardFace(deckID.generateCard()));
            }else if(AI2Use&&AI3Use){
             AI2Hand.add(deckID.GimmeCardFace(deckID.generateCard()));
             AI3Hand.add(deckID.GimmeCardFace(deckID.generateCard()));
            }
         }
        
        
        
        
    }
     public static void botPlay(){
          System.out.println("Bot number 1 is playing a ");
        
     }
     
     public static void botThink(){
         Collections.sort(AI1Hand);
        for(int i=0;i<=AI1Hand.size();i++){
             
         }
     }
     }

