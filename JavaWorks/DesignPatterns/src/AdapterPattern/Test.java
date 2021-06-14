package AdapterPattern;

public class Test {
    public static void main(String[] args) {
        Crypt crypt = new CryptA();
        crypt.encrypt("Anıl");
        crypt.decrypt("Berk");

        System.out.println("---------------");

        crypt = new CryptB();
        crypt.encrypt("Mahmut");
        crypt.decrypt("Hasan");

        System.out.println("---------------");

        Codex codex = new Codex();
        crypt = new CodexAdapter(codex);
        crypt.encrypt("Ahmet");
        crypt.decrypt("Acar");

    }
}
