//This class handles calling the closest elevator, and sending it to the correct floor.

const Elevator = require("./elevator.js");
const ElevatorDisplay = require("./elevatorDisplay.js")

module.exports = class ElevatorHandler {
    constructor(startingFloor1, startingFloor2, floorNumber) {
        this.elevator1 = new Elevator(startingFloor1);
        this.elevator2 = new Elevator(startingFloor2);
        this.elevatorDisplay = new ElevatorDisplay(floorNumber);
    }

    callElevator(floor) {
        let elevator = 0;
        return elevator;
    }
}