const prompt = require('prompt-sync')({sigint: true}); //So we can exit with Ctrl+c

/*
console.log("Welcome to the Elevator Building");

while (true) {
    console.log("What would you like to do?");
    console.log("Options:");
    console.log("1. Exit");
}
*/

const name = prompt("Enter your name: ");
console.log("Hello, " + name);