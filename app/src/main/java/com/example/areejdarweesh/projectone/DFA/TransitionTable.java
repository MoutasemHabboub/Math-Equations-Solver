package com.example.areejdarweesh.projectone.DFA;

/**
 * Created by moten on 7/2/2019.
 */
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TransitionTable {
    private final Map<Integer, Map<String, Integer>> function = new HashMap<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setTransition(Integer startState, Integer goalState, String inputs) {
        function.putIfAbsent(startState, new HashMap<String, Integer>());
        function.get(startState).put(inputs, goalState);
    }

    public Integer process(Integer startState, Character input) {
        if (!function.containsKey(startState)) {
            return null;}

        for (Map.Entry<String, Integer> entry : function.get(startState).entrySet()) {
            if(entry.getKey().contains(input.toString())){
                return entry.getValue();
            }
        }
        return null;
    }
}
