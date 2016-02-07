/**
 * Created by Vladimir on 02.02.2016.
 */
public class ex_4 {
    public static void main(String[] args){
        String str = "one";
        for (int i = 1; i <= str.length(); i++) {
            System.out.println(str.toCharArray()[str.length() - i]);
        }
    }
}
