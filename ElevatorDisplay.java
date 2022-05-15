//Displays the status of the floors and elevators.
//x - means stationary, v - means going down, ^ - means going up

public class ElevatorDisplay {
	private int floorNumber;
	
	public ElevatorDisplay(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	
	public void displayStatus(Elevator elevator1, Elevator elevator2) throws InterruptedException {
		Thread.sleep(2000);
        System.out.println(" |1|2| 1 | 2 |");
        for (int i = (this.floorNumber - 1); i >= 0; i--) {
            if ((i != elevator1.getFloor()) && (i != elevator2.getFloor())) {
            	System.out.println(i + "| | |   |   |");
            } else {
                String floor = i + "|";
                String elevatorDisplay1 = "";
                String elevatorDisplay2 = "";
                if (i == elevator1.getFloor()) {
                    switch (elevator1.getMoving()) {
                        case -1:
                            floor += "v|";
                            elevatorDisplay1 = "v" + i + "v|";
                            break;
                        case 0:
                            floor += "x|";
                            elevatorDisplay1 = "x" + i + "x|";
                            break;
                        case 1:
                            floor += "^|";
                            elevatorDisplay1 = "^" + i + "^|";
                            break;
                    }
                } else {
                    floor += " |";
                    elevatorDisplay1 = "   |";
                }
                if (i == elevator2.getFloor()) {
                    switch (elevator2.getMoving()) {
                        case -1:
                            floor += "v|";
                            elevatorDisplay2 = "v" + i + "v|";
                            break;
                        case 0:
                            floor += "x|";
                            elevatorDisplay2 = "x" + i + "x|";
                            break;
                        case 1:
                            floor += "^|";
                            elevatorDisplay2 = "^" + i + "^|";
                            break;
                    }
                } else {
                    floor += " |";
                    elevatorDisplay2 = "   |";
                }
                floor = floor + elevatorDisplay1 + elevatorDisplay2;
                System.out.println(floor);
            }
        }
        System.out.println("--------------");
        //This whole mess makes me wonder if it weren't
        //easier to learn something and not use the console.
        //These musings were from the time the code was in JavaScript. I could hack something together, but I'm out of time.
	}
}
