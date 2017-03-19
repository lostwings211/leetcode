public class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char curr_val = s.charAt(i);
            if(map.containsKey(curr_val)) {
                map.put(curr_val, map.get(curr_val) + 1);
            }
            else {
                map.put(curr_val, 1);
            }
        }
        String[] map_array = new String[s.length() + 1];
        for(Character key : map.keySet()) {
            int val = map.get(key);
            if(map_array[val] == null) {
                map_array[val] = "" + key;
            }
            else {
                map_array[val] = map_array[val] + key;
            }
        }
        
        StringBuilder ret = new StringBuilder();;
        for(int i = s.length(); i >= 0; i--) {
            if(map_array[i] != null) {
                String curr_string = map_array[i];
                for(int index = 0; index < curr_string.length(); index++) {
                    char curr_char = curr_string.charAt(index);
                    for(int times = 0; times < i; times++) {
                        ret = ret.append(curr_char);
                    }
                }
            }
        }
        return ret.toString();
    }
}
