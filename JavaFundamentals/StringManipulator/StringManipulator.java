public class StringManipulator {

    public String trimAndConcat(String a, String b) {
       String NewA = a.trim();
       String NewB = b.trim();
       String c = NewA.concat(NewB);
       return c;
    } 
    
    public Integer getIndexOrNull(String a, String b) {
        int answer = a.indexOf(b);
        if(answer == -1){
            return null;
        }
        return answer;
    }

    public String concatSubstring(String a, int start, int end, String b) {
        String newstring = a.substring(start, end);
        String finalstring = newstring.concat(b);
        return finalstring;
    }
}