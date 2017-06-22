import java.util.*;

public class Zork {

	public static void main(String[] args) {
		
		Random rand = new Random();
		boolean secret;
		String[] items = {"n/a","Dead Scorpion","Piano","Spider","Bats","Dusty Empty Box","3 Walking Skeletons","Treasure Chest","Piles of Gold"};
		boolean[] roomsVisited = new boolean[9];
		int room =1;
		int count = 0;
		double money = 0;
		String choice;
		Scanner key = new Scanner(System.in);
		System.out.println("Welcome to the house! Zorky!");
		double[] roomMoney = new double[9];
		for (int i=0; i<9; i++) {
			roomMoney[i] = rand.nextDouble() * 1000;
		}
		int charRoom = rand.nextInt(8) + 1;
		
		String quit;
		
		
		
		while (true) {
			System.out.println("You currently have " + money + " dollars");
			count++;
			roomsVisited[room] = true;
			
			if (charRoom == room) {
				System.err.println("Monster is here, he is stealing all of your money");
				roomMoney[charRoom] = 0;
				money = 0;
				charRoom = 99;
			}
			if (room == 1) {
				
				System.out.println("Money in this room is: " + roomMoney[1] );
				money = money + roomMoney[1];
				roomMoney[1] = 0;
				
				System.out.println("You are in the foyer room!");
				System.out.println("There is a dead scorpion in the room!");	
				System.out.println("Which direction do you want to go? (North)");
				
				choice = key.next();
				if (choice.equals("North")) {
					room = 2;
				}
				else {
					System.out.println("Please enter a valid choice!");
				}
				
			}
			else if (room == 2) {
				
				System.out.println("Money in this room is: " + roomMoney[2] );
				money = money + roomMoney[2];
				roomMoney[2] = 0;
				
				System.out.println("You are in the front room!");
				System.out.println("There is a piano in the room!");
				System.out.println("Which direction do you want to go? (South) (West) (East)");
				choice = key.next();
				if (choice.equals("South")) {
					room = 1;
				}
				else if (choice.equals("West")) {
					room = 3;
				}
				else if (choice.equals("East")) {
					room = 4;
				}
				else {
					System.out.println("Please enter a valid choice!");
				}
				
			}
			else if (room == 3) {
				
				System.out.println("Money in this room is: " + roomMoney[3] );
				money = money + roomMoney[3];
				roomMoney[3] = 0;
				
				System.out.println("You are in the libary room!");
				System.out.println("There is a spider in the room!");
				System.out.println("Which direction do you want to go? (North) (East)");
				choice = key.next();
				if (choice.equals("North")) {
					room = 5;
				}
				else if (choice.equals("East")) {
					room = 2;
				}
				else {
					System.out.println("Please enter a valid choice!");
				}
				
			}
			else if (room == 4) {
				
				System.out.println("Money in this room is: " + roomMoney[4] );
				money = money + roomMoney[4];
				roomMoney[4] = 0;
				
				System.out.println("You are in the kitchen room!");
				System.out.println("There is a bats in the room!");
				System.out.println("Which direction do you want to go? (North) (West)");
				choice = key.next();
				if (choice.equals("North")) {
					room = 7;
				}
				else if (choice.equals("West")) {
					room = 2;
				}
				else {
					System.out.println("Please enter a valid choice!");
				}
				
			}
			else if (room == 5) {
				
				System.out.println("Money in this room is: " + roomMoney[5] );
				money = money + roomMoney[5];
				roomMoney[5] = 0;
				
				System.out.println("You are in the dining room!");
				System.out.println("There is a dusty empty box in the room!");
				System.out.println("Which direction do you want to go? (South)");
				choice = key.next();
				if (choice.equals("South")) {
					room = 3;
				}
				else {
					System.out.println("Please enter a valid choice!");
				}
				
			}
			else if (room == 6) {
				
				System.out.println("Money in this room is: " + roomMoney[6] );
				money = money + roomMoney[6];
				roomMoney[6] = 0;
				
				System.out.println("You are in the vault room!");
				System.out.println("There is a 3 walking skeletons in the room!");
				System.out.println("Which direction do you want to go? (East)");
				choice = key.next();
				if (choice.equals("East")) {
					secret = secretRoom();
					if (secret == false){
						room = 7;
					}
					else{
						room = 8;
					}
				}
				else {
					System.out.println("Please enter a valid choice!");
				}
				
			}
			else if (room == 7) {
				System.out.println("Money in this room is: " + roomMoney[7] );
				money = money + roomMoney[7];
				roomMoney[7] = 0;
				
				System.out.println("You are in the parlor room!");
				System.out.println("There is a treasure chest in the room!");
				System.out.println("Which direction do you want to go? (South) (West)");
				choice = key.next();
				if (choice.equals("West")) {
					room = 6;
				}
				else if (choice.equals("South")) {
					room = 4;
				}
				else {
					System.out.println("Please enter a valid choice!");
				}
				
			}
			else if (room == 8) {
				System.out.println("Money in this room is: " + roomMoney[8] );
				money = money + roomMoney[8];
				roomMoney[8] = 0;
				
				System.out.println("You are in the secret room!");
				System.out.println("There is a piles of gold in the room!");
				System.out.println("Which direction do you want to go?  (West)");
				choice = key.next();
				if (choice.equals("West")) {
					room = 6;
				}
				else {
					System.out.println("Please enter a valid choice!");
				}
				
			}
			System.out.println("Would you like to quit (y/n)");
			quit = key.next();
			if (quit.equals("y")){
				System.out.println("You visited " + count + " rooms and you saw:");
				for (int i = 0; i < 9; i++){
					if (roomsVisited[i] == true)
						System.out.println(items[i]);
				}
				break;
			}
		}
		
	}
	
	public static boolean secretRoom() {
		Scanner scan = new Scanner(System.in);
		String decision;
		Random r = new Random();
		
		int x = 1 + r.nextInt(4);
		if (x == 3) {
			System.out.println("Do you want to go to secret room? yes or no");
			decision = scan.next();
			if (decision.equals("yes") ) {
				return true;
			}
		}
		return false;
	}
	

}
