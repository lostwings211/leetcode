public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] splited_version1 = version1.split("\\.");
        String[] splited_version2 = version2.split("\\.");
        
        int length =  Math.min(splited_version1.length, splited_version2.length);
        for(int i = 0; i < length; i++) {
            if(Integer.parseInt(splited_version1[i]) > Integer.parseInt(splited_version2[i])) {
                return 1;
            }
            else if (Integer.parseInt(splited_version2[i]) > Integer.parseInt(splited_version1[i])) {
                return -1;
            }
        }
        
        if(splited_version1.length >  splited_version2.length) {
            for(int i = length; i < splited_version1.length; i++) {
                if(Integer.parseInt(splited_version1[i]) > 0) {
                    return 1;
                }
            }
            return 0;
        }
        else if (splited_version2.length >  splited_version1.length) {
            for(int i = length; i < splited_version2.length; i++) {
                if(Integer.parseInt(splited_version2[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        }
        else {
            return 0;
        }
    }
}
