package algorithm;

import java.util.HashMap;
import java.util.LinkedHashSet;

class LFUCache_460 {

    HashMap<Integer, Integer> keyToVal;

    HashMap<Integer, Integer> keyToFreq;

    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    int minFreq;

    int cap;

    public LFUCache_460(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (this.cap <= 0) return;
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }

        if (this.cap <= keyToFreq.size()) {
            removeMinFreqKey();
        }
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        minFreq = 1;
    }

    public void increaseFreq(int key) {
        Integer freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);

        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == minFreq) {
                this.minFreq++;
            }
        }
    }

    public void removeMinFreqKey() {
        LinkedHashSet<Integer> keys = freqToKeys.get(this.minFreq);
        Integer deleteKey = keys.iterator().next();
        keys.remove(deleteKey);
        if (keys.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }

        keyToVal.remove(deleteKey);
        keyToFreq.remove(deleteKey);
    }
}

