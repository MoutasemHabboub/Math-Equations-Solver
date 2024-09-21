package com.example.areejdarweesh.projectone.DFA;

/**
 * Created by moten on 7/2/2019.
 */

import java.util.Objects;
import java.util.Set;

public class DFA {
    private final int startState;
    private final Set<Integer> acceptingStates;
    private final TransitionTable transitionFunction;

    public DFA(TransitionTable transitionFunction, int startState, Set<Integer> acceptingStates) {
        this.transitionFunction =
                Objects.requireNonNull(transitionFunction,
                        "TransitionTable is null.");
        this.startState = startState;
        this.acceptingStates =
                Objects.requireNonNull(acceptingStates,
                        "Accepting state set is null.");
    }

    public Integer matches(String text) {
        Integer currentState = startState;

        for (char c : text.toCharArray()) {
            currentState = transitionFunction.process(currentState, c);

            if (currentState == null) {
                return -1;
            }
        }
        if(acceptingStates.contains(currentState)){
            return currentState;
        }
        return -1;
    }
}
