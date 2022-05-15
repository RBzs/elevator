//Displays the status of the floors and elevators.
//x - means stationary, v - means going down, ^ - means going up

const Elevator = require("./elevator.js");

function sleep(milliseconds) {
    //Yeah, it's copy & pasted.
    //I know that including random bits of code isn't healthy,
    //but I need a timeout that stops everything, and I need it now.
    const date = Date.now();
    let currentDate = null;
    do {
      currentDate = Date.now();
    } while((currentDate - date) < milliseconds);
}

module.exports = class ElevatorDisplay {
    constructor(floorNumber) {
        this.floorNumber = floorNumber;
    }

    displayStatus(elevator1, elevator2) {
        console.clear();
        sleep(2000);
        console.log(" |1|2| 1 | 2 |");
        for (let i = (this.floorNumber - 1); i >= 0; i--) {
            if ((i != elevator1.getFloor()) && (i != elevator2.getFloor())) {
                console.log(i + "| | |   |   |");
            } else {
                let floor = i + "|";
                let elevatorDisplay1 = "";
                let elevatorDisplay2 = "";
                if (i == elevator1.getFloor()) {
                    switch(elevator1.getMoving()) {
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
                    switch(elevator2.getMoving()) {
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
                console.log(floor);
            }
        }
        //This whole mess makes me wonder if it weren't
        //easier to learn something and not use the console.
    }
}