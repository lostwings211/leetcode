public class Solution {
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        if (p.length() == 2) {
            if (p.charAt(1) == '*') {
                if (p.charAt(0) == '.') {
                    return true;
                } else {
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) != p.charAt(0)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else if (p.length() == 1) {
            if (s.length() == 1) {
                if (p.charAt(0) == '.') {
                    return true;
                } else {
                    return (s.charAt(0) == p.charAt(0));
                }
            } else {
                return false;
            }
        } else if (p.length() == 0) {
            if (s.length() == 0) {
                return true;
            }
            return false;
        }

        char last_p = p.charAt(p.length() - 1);
        if (last_p != '*' && last_p != '.' && s.length() > 0) {
            char last_s = s.charAt(s.length() - 1);
            if (last_s != last_p) {
                return false;
            }
        }

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < p.length() - 1; j++) {
                String front_sub = s.substring(0, i);
                String back_sub = s.substring(i, s.length());
                String front_pattern = p.substring(0, j + 1);
                String back_pattern = p.substring(j + 1, p.length());

                if ((front_pattern.charAt(0) != '*')
                        && (back_pattern.charAt(0) != '*')) {
                    boolean front_match = isMatch(front_sub, front_pattern);
                    if (front_match == false) {
                        break;
                    }
                    boolean back_match = isMatch(back_sub, back_pattern);
                    if (front_match && back_match) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
