package org.trabalho2.agendaProject.Helper;

public class Codificador {
    public static String criptografaPalavra(String palavra)
    {
        int half = palavra.length()/2;
        char [] cryptArray = new char[half+1];
        int halfArray = 0;
        int y = 0;
        for (int i = 0; i < palavra.length(); i++) {
            if ((half <= i)){
                cryptArray[y] = (char)(palavra.charAt(i)+8);
                y++;
            }
            else{
                halfArray += palavra.charAt(i);
            }
        }

        String cryptString = new String(cryptArray);
        return halfArray + cryptString;
    }

    public static String descriptografaPalavra(String palavra)
    {
        char [] decryptArray = new char[palavra.length()];
        for (int i = 0; i < palavra.length(); i++) {
            decryptArray[i] = (char)(palavra.charAt(i)-8);
        }
        return new String(decryptArray);
    }
}
