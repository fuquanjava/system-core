package net.jcip.examples;

import java.util.*;



/**
 * SafeStates
 * <p/>
 * Initialization safety for immutable objects
 *
 * @author Brian Goetz and Tim Peierls
 */

public class SafeStates {
    private final Map<String, String> states;
    public SafeStates() {
        states = new HashMap<>();
        states.put("alaska", "AK");
    }
    public String getAbbreviation(String s) {
        return states.get(s);
    }
}
