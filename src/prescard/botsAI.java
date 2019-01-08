/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescard;

/**
 *
 * @author user
 */
public class botsAI {
    boolean AI2Use,AI3Use;
    deck deckID = new deck();
    PresCard playerID = new PresCard();

    public void main(String[] args) {
        
    }
    public void AISetup(int numToSet){
        if(numToSet==2){
            AI2Use=true;
        }else if(numToSet==3){
            AI2Use=true;
            AI3Use=true;
        }
        //System.out.println(AI2Use,AI3Use);
    }
     public void handID(){
        int[] AI1Hand={deckID.generateCard(),deckID.generateCard(),deckID.generateCard(),deckID.generateCard(),deckID.generateCard()};
        if(AI2Use){
            int[] AI2Hand={deckID.generateCard(),deckID.generateCard(),deckID.generateCard(),deckID.generateCard(),deckID.generateCard()};
        }else if(AI2Use&&AI3Use){
            int[] AI2Hand={deckID.generateCard(),deckID.generateCard(),deckID.generateCard(),deckID.generateCard(),deckID.generateCard()};
            int[] AI3Hand={deckID.generateCard(),deckID.generateCard(),deckID.generateCard(),deckID.generateCard(),deckID.generateCard()};
        }
        
    }
}
