const prompt = require('prompt-sync')({sigint: true}); //So we can exit with Ctrl+c



let position = 0; //We enter on the ground floor
let inside = true;


/*
console.log("Welcome to the Elevator Building");

while (inside){
    console.log("Options:");
    console.log("1. Exit");
    console.log("2. Go up");
    console.log("3. Go down")
    const option = Number(prompt("What would you like to do? "));
    switch(option){
        case 1:
            inside = false;
            break;
        case 2:
            elevator1.setFloor()
    }
}

console.log("Bye!");*/