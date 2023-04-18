package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    Scanner keyboard = new Scanner(System.in);
    private final static FileOutput outFile = new FileOutput("animals.txt");
    private final static FileInput inFile = new FileInput("animals.txt");

    public void main(String[] args) {
        ArrayList<Talkable> zoo = new ArrayList<>();
        // Lines to Replace Begin Here

        System.out.println("\n \tHello what animal would you like to add to the zoo\n [A] to add a cat [B] to add a dog");
        boolean runVar = true;
        String name;
        int kills;
        boolean friendly;
        do{
            System.out.println("Welcome to the animal chooser program, would you like to add \n\t [A] Dog \n\t [B] Cat \n\t Any other input to exit the program");
            char resp = keyboard.nextLine().toUpperCase().charAt(0);
            switch(resp)
            {

                case 'A':
                    System.out.println("What would you like to name your dog?");
                    name = keyboard.nextLine();
                    System.out.println("Is the dog friendly\n\t [Y] Yes \n\t [N] No");
                    if(keyboard.nextLine().toUpperCase().charAt(0) == 'Y'){
                        friendly = true;
                    }else{
                        friendly = false;
                    }

                    zoo.add(new Dog(friendly, name));


                    break;

                case 'B':
                    System.out.println("What would you like to name your cat?");
                    name = keyboard.nextLine();
                    System.out.println("How many mice has your cat killed?");
                    kills = Integer.parseInt(keyboard.nextLine());
                    zoo.add(new Cat(kills, name));
                    break;



                default:
                    runVar = false;
                    break;

            }

        }while(runVar);
//        zoo.add(new Dog(true, "Bean"));
//        zoo.add(new Cat(9, "Charlie"));
//        zoo.add(new Teacher(44, "Stacy Read"));
        // End Lines to Replace

        for (Talkable thing : zoo) {
            printOut(thing);
        }
        outFile.fileClose();
        inFile.fileRead();
        inFile.fileClose();

        FileInput indata = new FileInput("animals.txt");
        String line;
        while ((line = indata.fileReadLine()) != null) {
            System.out.println(line);
        }
    }

    public static void printOut(Talkable p) {
        System.out.println(p.getName() + " says=" + p.talk());
        outFile.fileWrite(p.getName() + " | " + p.talk());
    }
}
