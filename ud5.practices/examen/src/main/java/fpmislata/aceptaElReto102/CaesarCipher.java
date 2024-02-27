package fpmislata.aceptaElReto102;

public class CaesarCipher {

    private int displacement;
    private String message;

    public CaesarCipher(int displacement, String message) {
        this.displacement = displacement;
        this.message = message;
    }

    public int getDisplacement() {
        return this.displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String cipher(int displacement, String message) {

        StringBuilder cipheredMessage = new StringBuilder();

        for (char character : message.toCharArray()) {
            if (character >= 'a' && character <= 'z') {
                char cipheredCharacter = (char) ((character - 'a' + displacement) % 26 + 'a');
                cipheredMessage.append(cipheredCharacter);

            } else if (character >= 'A' && character <= 'Z') {
                char cipheredCharacter = (char) ((character - 'A' + displacement) % 26 + 'A');
                cipheredMessage.append(cipheredCharacter);

            } else {
                cipheredMessage.append(character);
            }

        }
        return cipheredMessage.toString();
    }
}