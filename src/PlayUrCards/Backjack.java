package PlayUrCards;

import java.util.Objects;

public class Backjack {
    // task 1 PASSED
    public int parseCard(String card) {
        switch (card){
            case "ace": return 11;

            case "ten":
            case "jack":
            case "queen":
            case "king":
                return 10;

            case "two": return 2;
            case "three": return 3;
            case "four": return 4;
            case "five": return 5;
            case "six": return 6;
            case "seven": return 7;
            case "eight": return 8;
            case "nine": return 9;
            default: return 0;
        }
    }

    // task 2 PASSED
    public boolean isBlackjack(String card1, String card2) {
        // VERSAO 1
//        if (parseCard(card1) == 10 && parseCard(card2) == 11 ||
//            parseCard(card1) == 11 && parseCard(card2) == 10) {
//            return true;
//        } else {
//            return false;
//        }

        // VERSAO 2
//        return parseCard(card1) == 10 && parseCard(card2) == 11 ||
//                parseCard(card1) == 11 && parseCard(card2) == 10;

        // VERSAO 3
        return parseCard(card1) + parseCard(card2) == 21;
    }
    // task 3 PASSED
    public String largeHand(boolean isBlackjack, int dealerScore) {
        //VERSAO 1
//        if (isBlackjack){
//            if (dealerScore < 10){
//                return "W";
//            } return "S";
//        } return "P";

        // VERSAO 2
        if (!isBlackjack) return "P";
        else if (dealerScore < 10) return "W";
        else return "S";
    }

    // task 4 PASSED
    public String smallHand(int handScore, int dealerScore) {
        if (handScore >= 17){
            return "S";
        } else if (handScore <= 11) {
            return "H";
        } else if (dealerScore < 7) {
            return "S";
        }
        return "H";
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
