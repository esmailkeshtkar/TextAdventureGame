import java.util.Scanner;
//Adventure text game with a battle system, loops until the player defeats the goblin
//no error checking for incorrect inputs
//The goal is to find the path to defeat the goblin and obtain its hat

public class Game {

	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	String pName;
	int pHP;
	String pWeapon;
	int choice;
	int mHP;
	boolean hat = false;
	
	public static void main(String[] args) {
		
		Game game = new Game();
		game.playerSetUp();
		game.startingTown();
		
	}
	
	public void playerSetUp() {
		
		pHP = 20;
		pWeapon = "Club";
		mHP = 30;
		System.out.print("Please enter your player name: ");
		pName = sc.nextLine();
		System.out.println("Hello " +pName+ ", your adventure is beginning!");
		System.out.println("You have " +pHP +" HP.");
		System.out.println("Your current weapon is a "+pWeapon +".");
		
	}
	
	public void startingTown() {
		
		System.out.println("\n---------------------------------------------\n");
		System.out.println("You are starting in Adventure Town.\nA town guard is standing in front of you.");
		System.out.println("What do you do?");
		System.out.println("1: Talk to the guard.");
		System.out.println("2: Attack the guard.");
		System.out.println("3: Ignore the guard and leave the town.");
		System.out.println("\n---------------------------------------------\n");
		choice = sc.nextInt();
		
		if(choice == 1)
		{
			if(hat)
				ending();
			System.out.println("Guard: Good day to you " +pName + ". Sorry but you cannot leave the town as it is too dangerous.");
			sc2.nextLine();
			startingTown();
		}
		if(choice == 2)
		{
			System.out.println("The guard attacks back and you take 1 damage.");
			pHP-=1;
			System.out.println("Your HP is now :"+pHP);
			sc2.nextLine();
			startingTown();
		}
		if(choice == 3)
			road();
		else 
			startingTown();
	}
	
	public void road() {
		System.out.println("\n---------------------------------------------\n");
		System.out.println("You are at a road. You can choose one of four directions.");
		System.out.println("1: Head north.");
		System.out.println("2: Turn east.");
		System.out.println("3: Turn west.");
		System.out.println("4: Go back south to town.");
		System.out.println("\n---------------------------------------------\n");
		choice = sc.nextInt();
		
		if(choice == 1)
			north();
		if(choice == 2)
			east();
		if(choice == 3)
			west();
		if(choice == 4)
			startingTown();
		else
			road();
	}
	
	public void north() {
		System.out.println("\n---------------------------------------------\n");
		System.out.println("You arrive at a river. You decide to take camp and rest.");
		System.out.println("Your HP is recovered slightly");
		pHP +=1;
		System.out.println("Your HP is now "+pHP);
		System.out.println("\n1: Head back to the road you came from?");
		System.out.println("\n---------------------------------------------\n");
		choice = sc.nextInt();
		
		if(choice == 1)
			road();
		else
			north();
	}
	
	public void east() {
		System.out.println("\n---------------------------------------------\n");
		System.out.println("You arrived in a cave and found a greatsword.");
		pWeapon = "Greatsword";
		System.out.println("Your weapoon is "+ pWeapon);
		System.out.println("\n1: Head back to the raoad you came from?");
		System.out.println("\n---------------------------------------------\n");
		choice = sc.nextInt();
		
		if(choice == 1)
			road();
		else
			east();
	}

	public void west() {
		System.out.println("\n---------------------------------------------\n");
		System.out.println("You encounter an angry goblin!");
		System.out.println("1: Fight the goblin");
		System.out.println("2: Run from the goblin");
		System.out.println("\n---------------------------------------------\n");
		choice = sc.nextInt();
		
		if(choice == 1)
			fight();
		if(choice == 2)
			road();
		else 
			west();
	}
	
	public void fight(){
		System.out.println("\n---------------------------------------------\n");
		System.out.println("Your HP :"+pHP);
		System.out.println("Monster's HP: " +mHP);
		System.out.println("\n1: Attack");
		System.out.println("2: Run");
		System.out.println("\n---------------------------------------------\n");
		choice = sc.nextInt();
		
		if(choice == 1)
			attack();
		if(choice == 2)
			road();
		else
			fight();
	}

	public void attack() {
		int weaponDmg = 0;
		int playerDmg = 0;
		
		if(pWeapon.equals("Club"))
			weaponDmg = 1;
		else if(pWeapon.equals("Greatsword"))
			weaponDmg = 5;
		
		playerDmg = new java.util.Random().nextInt(weaponDmg);
		
		System.out.println("You attack the goblin and dealt "+ playerDmg +" damage.");
		mHP -= playerDmg;
		
		System.out.println("The goblin's HP is "+mHP);
		
		if(mHP <= 0)
			win();
		if(mHP > 0)
		{
			int monsterDmg;
			monsterDmg = new java.util.Random().nextInt(4);
			
			System.out.println("The goblin attacked and you took "+ monsterDmg +" damage!");
			pHP = pHP - monsterDmg;
			
			System.out.println("Your HP is now :"+ pHP);
			
			if(pHP <= 0)
				dead();
			if(pHP > 0)
				fight();
		}
		
	}

	public void dead(){
		System.out.println("\n---------------------------------------------\n");
		System.out.println("You died!");
		System.out.println("\nGAME OVER!");
		System.out.println("\n---------------------------------------------\n");
	}
	
	public void win() {
		System.out.println("\n---------------------------------------------\n");
		System.out.println("You defeated the goblin!");
		System.out.println("The goblin dropped a hat!");
		System.out.println("You obtained a Goblin Hat!");
		System.out.println("1: Go east");
		System.out.println("\n---------------------------------------------\n");
		
		choice = sc.nextInt();
		if(choice == 1)
			road();
		else
			win();
		
		hat = true;
	}
	
	public void ending() {
		System.out.println("\n---------------------------------------------\n");
		System.out.println("Guard: You defeated the goblin that was terrorizing the town!");
		System.out.println("Guard: The town is saved all thanks to you!");
		System.out.println("Guard: We shall annoint you the hero of our town, "+pName+"!");
		System.out.println("\n                  THE END                   \n");
		System.out.println("\n---------------------------------------------\n");
	}
}
