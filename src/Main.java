import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String entrada = scanner.nextLine();
            if (entrada.equals("9999 ZZZ"))
                break;
            String[] partes = entrada.split(" ");
            int parteNumero = Integer.parseInt(partes[0]);
            String parteLetra = partes[1];



            String siguientePlaca = obtenerSiguientePlaca(parteNumero, parteLetra);
            System.out.println(siguientePlaca);
        }

        scanner.close();
    }

    public static String obtenerSiguientePlaca(int parteNumero, String parteLetra) {
        parteNumero++;
        if (parteNumero > 9999) {
            parteNumero = 0;
            parteLetra = reiniciarLetras(parteLetra);
        }
        return String.format("%04d %s", parteNumero, parteLetra);
    }

    public static String reiniciarLetras(String letras) {
        char[] caracteres = letras.toCharArray();
        int carry = 1;
        for (int i = caracteres.length - 1; i >= 0; i--) {
            char c = caracteres[i];
            if (carry == 0)
                break;
            if (c != 'Z') {
                caracteres[i]++;
                if (caracteres[i] == 'A' || caracteres[i] == 'E' || caracteres[i] == 'I' || caracteres[i] == 'O' || caracteres[i] == 'U')
                    caracteres[i]++;
                carry = 0;
            } else {
                caracteres[i] = 'B';
                if (i > 0 && caracteres[i - 1] != 'Z') {
                    caracteres[i - 1]++;
                    if (caracteres[i - 1] == 'A' || caracteres[i - 1] == 'E' || caracteres[i - 1] == 'I' || caracteres[i - 1] == 'O' || caracteres[i - 1] == 'U')
                        caracteres[i - 1]++;
                }
                carry = 0;
            }
        }
        return new String(caracteres);
    }
}