//Simple elevator class.

module.exports = class Elevator {
    constructor(floor) {
        this.floor = floor;
        this.moving = 0; // -1 - going down, 0 - stationary, 1 - going up
    }

    getFloor() {
        return this.floor;
    }

    getMoving() {
        return this.moving;
    }

    startUp() {
        this.moving = 1;
    }

    startDown() {
        this.moving = -1;
    }

    stop() {
        this.moving = 0;
    }

    goUp() {
        (this.floor)++;
    }

    goDown() {
        (this.floor)--;
    }
}