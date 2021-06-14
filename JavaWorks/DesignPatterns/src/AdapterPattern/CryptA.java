package AdapterPattern;

public class CryptA implements Crypt {

    public void encrypt(String text){
        System.out.println("#CryptA#Encrypt()");
    }

    public void decrypt(String text){
        System.out.println("#CryptA#Decrypt()");
    }
}
