package AdapterPattern;

public class CodexAdapter implements Crypt {

    private Codex codeX;

    public CodexAdapter(Codex codex){
        this.codeX = codex;
    }

    public void encrypt(String text){
        codeX.textToCode(text);
    }

    public void decrypt(String text){
        codeX.codeToText(text);
    }
}
