/**
 * Created by Zachary on 6/17/2017.
 */
public class Main {
    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 \n";
        Text_Utilities.generateRandomFile(1000, alphabet);
        Text_Utilities.generateRandomFile(1000000, alphabet);
        Text_Utilities.generateRandomFile(1000000000, alphabet);
    }
}
