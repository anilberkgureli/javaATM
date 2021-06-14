package AdapterPattern;

public class CryptB implements Crypt {

    public void encrypt(String text){
        System.out.println("#CryptB#Encrypt()");
    }

    public void decrypt(String text){
        System.out.println("#CryptB#Decrypt()");
    }
}
