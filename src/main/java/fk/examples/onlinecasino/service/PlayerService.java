package fk.examples.onlinecasino.service;

import fk.examples.onlinecasino.Exceptions.InsufficientFundsException;
import fk.examples.onlinecasino.model.Player;

public class PlayerService {
    public void transfer(Player p1, Player p2, Integer i) {
        if (p1 == null || p2 == null){
            throw new IllegalArgumentException("Player can not be null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }
        if (p1.getCredit() < i || p2.getCredit() < i) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        else{
            p1.setCredit(p1.getCredit() - i);
            p2.setCredit(p2.getCredit() + i);
        }
    }
}
