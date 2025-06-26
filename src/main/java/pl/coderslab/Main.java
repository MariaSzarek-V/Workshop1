package pl.coderslab;
import org.apache.commons.lang3.StringUtils;

public class Main {

    public static void main(String[] args) {
        System.out.println(reverseString("cokolwiek"));
    }
    public static String reverseString(String str){
        return StringUtils.reverse(str);
    }
}
