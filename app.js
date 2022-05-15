const Elevator = require("./elevator.js");

const prompt = require('prompt-sync')({sigint: true}); //So we can exit with Ctrl+c



let position = 0; //We enter on the ground floor
let elevator1 = new Elevator(0);
let elevator2 = new Elevator(6);



console.log("Welcome to the Elevator Building");

while (true){
    console.log("Options:");
    console.log("1. Exit");
    const option = Number(prompt("What would you like to do? "));
    if (option == 1){
        break;
    }
}

console.log("Bye!");