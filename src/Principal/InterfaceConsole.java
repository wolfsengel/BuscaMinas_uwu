package Principal;

public class InterfaceConsole {
    public void presentacion(){
        System.out.println("Buenos días y bienvenidos!");
        System.out.println("Este juego es el Busca Minas!");
        System.out.println("EL TABLERO ES ASI: ");
        System.out.println("  | 1 | | 2 | | 3 | | 4 | | 5 | | 6 | | 7 | | 8 | ");
        System.out.println("1 |   | |   | |   | |   | |   | |   | |   | |   | ");
        System.out.println("2 |   | |   | |   | |   | |   | |   | |   | |   | ");
        System.out.println("3 |   | |   | |   | |   | |   | |   | |   | |   | ");
        System.out.println("4 |   | |   | |   | |   | |   | |   | |   | |   | ");
        System.out.println("5 |   | |   | |   | |   | |   | |   | |   | |   | ");
        System.out.println("6 |   | |   | |   | |   | |   | |   | |   | |   | ");
        System.out.println("7 |   | |   | |   | |   | |   | |   | |   | |   | ");
        System.out.println("8 |   | |   | |   | |   | |   | |   | |   | |   | ");
        System.out.println("Es tan senncillo como indicar donde quieres pinchar con una orden pEj.: 25 indicando linea y columna");
        System.out.println("A jugaaar!!");
    }
    public static void main(String[] args) {
        InterfaceConsole jogo = new InterfaceConsole();
        jogo.presentacion();
    }
}
