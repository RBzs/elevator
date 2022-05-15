//This class handles calling the closest elevator, and sending it to the correct floor.

public class ElevatorHandler {
	private Elevator elevator1;
	private Elevator elevator2;
	private ElevatorDisplay elevatorDisplay;
	
	public ElevatorHandler(int startingFloor1, int startingFloor2, int floorNumber) {
		this.elevator1 = new Elevator(startingFloor1);
        this.elevator2 = new Elevator(startingFloor2);
        this.elevatorDisplay = new ElevatorDisplay(floorNumber);
	}
	
	private void firstElevatorUp(int destination) throws InterruptedException {
		this.elevator1.startUp();
        this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);

        while (this.elevator1.getFloor() != destination) {
            this.elevator1.goUp();
            this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);
        }

        this.elevator1.stop();
        this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);
	}
	
	private void firstElevatorDown(int destination) throws InterruptedException {
		this.elevator1.startDown();
        this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);

        while (this.elevator1.getFloor() != destination) {
            this.elevator1.goDown();
            this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);
        }

        this.elevator1.stop();
        this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);
	}
	
	private void secondElevatorUp(int destination) throws InterruptedException {
		this.elevator2.startUp();
        this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);

        while (this.elevator2.getFloor() != destination) {
            this.elevator2.goUp();
            this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);
        }

        this.elevator2.stop();
        this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);
	}
	
	private void secondElevatorDown(int destination) throws InterruptedException {
		this.elevator2.startDown();
        this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);

        while (this.elevator2.getFloor() != destination) {
            this.elevator2.goDown();
            this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);
        }

        this.elevator2.stop();
        this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);
	}
	
	public void sendElevator(int elevatorNr, int destination) throws InterruptedException {
		if (elevatorNr == 1) {
			if (this.elevator1.getFloor() == destination) {
				this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);
				return;
			}
			if (this.elevator1.getFloor() < destination) {
				//Going up
				firstElevatorUp(destination);
			} else {
				//Going down
				firstElevatorDown(destination);
			}
		} else {
			if (this.elevator2.getFloor() == destination) {
				this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);
				return;
			}
			if (this.elevator2.getFloor() < destination) {
				//Going up
				secondElevatorUp(destination);
			} else {
				//Going down
				secondElevatorDown(destination);
			}
		}
	}
	
	public int callElevator(int floor) throws InterruptedException {
        //Let's check if there isn't an elevator already there:
        if (floor == this.elevator1.getFloor()) {
            this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);
            return 1;
        }
        if (floor == this.elevator2.getFloor()) {
            this.elevatorDisplay.displayStatus(this.elevator1, this.elevator2);
            return 2;
        }

        //Let's find the closest elevator:
        int elevatorNr = 1;
        if (this.elevator2.getPositivePosition(floor) < this.elevator1.getPositivePosition(floor)) {
            elevatorNr = 2;
        }

        //Let's check they're not equidistant:
        if (this.elevator1.getPositivePosition(floor) == this.elevator2.getPositivePosition(floor)) {
            //So, they're equidistant.
            //Basically, I prioritize calling the first elevator.
            //If the test case below means that elevator nr. 2 is on a lower floor, it get's called.
            //Otherwise we default to 1.
            if (this.elevator2.getRelativePosition(floor) < 0) {
                elevatorNr = 2;
            }
        }

        //Now let's call the elevator (finally!).
        sendElevator(elevatorNr, floor);

        return elevatorNr;
    }
}
