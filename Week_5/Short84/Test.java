package Week_5.Short84;

import java.math.BigInteger;

public class Test {
    
    public static void main(String[] args) {
     
        LargeNum s1 = new LargeNum("123456");
        LargeNum s2 = new LargeNum("123456");
        LargeNum s = s1.addTwoNum(s2);
        System.out.println("Result = " + s.getValue());
        
        BigInteger max1 = new BigInteger("123456");
        BigInteger max2 = new BigInteger("123456");
        BigInteger sum = max1.add(max2);
        System.out.println("Result = " + sum);
    }
}
