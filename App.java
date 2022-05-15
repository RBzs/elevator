import java.util.Scanner;

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner input = new Scanner(System.in);
		
		ElevatorHandler elevatorHandler = new ElevatorHandler(0, 6, 7);

		int option;
		int elevator;
		int floor;
		int position = 0;
		boolean inside = true;
		
		
		System.out.println("Welcome to the Elevator Building");

		while (inside){
			System.out.println("Options:");
			System.out.println("1. Exit");
			System.out.println("2. Call elevator");
		    option = input.nextInt(); //Yes, error handling would be nice.
		    switch (option) {
		        case 1:
		            inside = false;
		            break;
		        case 2:
		            elevator = elevatorHandler.callElevator(position);
		            System.out.println("Enter a floor:");
		            floor = input.nextInt();
		            elevatorHandler.sendElevator(elevator, floor);
		            break;
		    }
		}

		input.close();
		System.out.println("Bye!");
	}
}