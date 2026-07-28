class Solution {

    public int getIntegerValueOfString(String versionNumber){
        int size = versionNumber.length();
        int answer = 0;
        for(int i = 0; i < size; i++){
            answer = answer * 10 + (versionNumber.charAt(i) - '0');
        }
        return answer;
    }

    public int compareVersion(String version1, String version2) {
        String [] ver1 = version1.split("[.]");
        String [] ver2 = version2.split("[.]");
        int size = Math.max(ver1.length, ver2.length);
        for(int i = 0; i < size; i++){
            int versionNumber1 = i < ver1.length ? getIntegerValueOfString(ver1[i]) : 0;
            int versionNumber2 = i < ver2.length ? getIntegerValueOfString(ver2[i]) : 0;
            if(versionNumber1 == versionNumber2) continue;
            else if(versionNumber1 > versionNumber2) return 1;
            else if(versionNumber1 < versionNumber2) return -1;
        }
        return 0;
    }

}