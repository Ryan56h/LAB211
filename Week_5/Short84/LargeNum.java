package Week_5.Short84;

public class LargeNum {

    String value ;
    
    public LargeNum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public LargeNum addTwoNum(LargeNum other){
        
        return new LargeNum(addLargeNum(this.value, other.value));
    }
    
    public String addLargeNum(String so1, String so2){
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for(int i = so1.length() - 1; i >= 0; i--){
            int s1 = so1.charAt(i) - '0';
            int s2 = so2.charAt(i) - '0';
            int sum = s1 + s2;
            result.append(sum%10);
            carry = sum/10;
        }
        if(carry > 0){
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
