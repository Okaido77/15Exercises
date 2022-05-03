package Service;

import model.Card;

import java.util.List;
import java.util.Optional;

public class LibraryManager {
    List<Card> cards;

    public LibraryManager(List<Card> cards) {
        this.cards = cards;
    }
    public boolean addACard(Card card){
        Optional<Card> r = cards.stream().filter(c -> c.equals(card)).findFirst();
        if(r.isPresent()) return false;
        cards.add(card);
        return true;
    }
    public boolean deleteACard(String borrowCode){
        Optional<Card> r = cards.stream().filter(c -> c.getBorrowCode().equals(borrowCode)).findFirst();
        if(r.isPresent()){
            return cards.remove(r.get());
        }
        return false;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
