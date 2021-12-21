import java.util.Scanner;

class Delegation {
    static String line = new String(new char[111]).replace('\0', '=');
    static Scanner clavier = new Scanner(System.in);
    static  boolean fin = false;
    static int choix;

    public static void main(String[] args) {
        // La classe TicketBookingByAgent est interne
        // Delagation dans les autres classes
        while (!fin) {
            presenterMenu();
            choix = lireChoix();

            switch (choix) {
                case 1:
                    TicketBookingByPerson person = new TicketBookingByPerson(new TrainBooking());
                    person.bookTicket();
                    break;
                case 2:
                    person = new TicketBookingByPerson(new AirBooking());
                    person.bookTicket();
                    break;
                case 0:
                    System.out.println("Vous avez quitté.");
                    fin = true;
                    break;
                default:
                    System.out.println("Choix invalide!");
                    break;
            }
        }
    }
    static void presenterIntro() {
        System.out.println();
        System.out.println(line);
        System.out.println("====================    B I E N V E N U E   C H E Z    A B C   V O Y A G E S     ==============================");
        System.out.println(line);
        System.out.println();
    }

    static int lireChoix() {
        int choix = -1;
        while (choix < 0){
            try {
                System.out.print("Votre choix: ");
                choix = Integer.parseInt(clavier.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Choix Invalide.");
            }
        }
        return choix;
    }

    //=======================================================================
    //methode qui permet d'afficher le message d'introduction
    static void presenterMenu() {
        presenterIntro();
        System.out.println("Que voulez-vous faire?\n");
        System.out.println("1: Reserver un billet d'avion.");
        System.out.println("2: Reserver un billet de train.");
        System.out.println("0: Quitter\n");
    }

}