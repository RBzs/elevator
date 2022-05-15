module.exports = class Elevator{
    constructor(currentFloor){
        this.currentFloor = currentFloor;
    }

    getFloor(){
        return this.currentFloor;
    }

    setFloor(newFloor){
        if (newFloor > this.currentFloor){
            for (let i = this.currentFloor; i < newFloor; i++){
                console.log("Now on floor " + i);
            }
        } else{
            for (let i = this.currentFloor; i > newFloor; i--){
                console.log("Now on floor " + i);
            }
        }
        console.log("Now on floor " + newFloor);
        console.log("DING!");
        this.currentFloor = newFloor;
    }
}