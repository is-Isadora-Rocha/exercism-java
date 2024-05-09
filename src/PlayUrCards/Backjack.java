package PlayUrCards;

import java.util.Objects;

public class Backjack {
    public int parseCard(String card) {
        if (card.equals("ace")){
            System.out.println(11);
        } else if (card.equals("queen")) {
            System.out.println(10);
        }
        return 11;
    }

    public boolean isBlackjack(String card1, String card2) {
        if (parseCard("ace") == 11 && parseCard("queen") == 10){
            isBlackjack("ace", "queen");
            return true;
        } else if (parseCard("queen") == 10 && parseCard("ace") == 11) {
            isBlackjack("queen", "ace");
            return true;
        } else
        return false;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        throw new UnsupportedOperationException("Please implement the Blackjack.largeHand method");
    }

    public String smallHand(int handScore, int dealerScore) {
        throw new UnsupportedOperationException("Please implement the Blackjack.smallHand method");
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
