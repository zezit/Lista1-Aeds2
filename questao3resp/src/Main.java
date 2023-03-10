public class Main {
    public static void main(String[] args) {
        String input = new String();
        String inputAux = new String();
        input = MyIO.readLine("Insira uma string: ");

        for (int i = 0; i < input.length(); i++){
            inputAux += input.charAt(input.length()-1-i);
        }

        MyIO.println(input);
        MyIO.println(inputAux);
    }
}