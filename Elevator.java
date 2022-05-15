//Simple elevator class.

public class Elevator {
	private int floor;
	private int moving; // -1 - going down, 0 - stationary, 1 - going up
	
	public Elevator(int floor){
		this.floor = floor;
        this.moving = 0;
	}
	
	public int getFloor() {
        return this.floor;
    }

	public int getMoving() {
        return this.moving;
    }

	public void startUp() {
        this.moving = 1;
    }

	public void startDown() {
        this.moving = -1;
    }

	public void stop() {
        this.moving = 0;
    }

	public void goUp() {
        (this.floor)++;
    }

	public void goDown() {
        (this.floor)--;
    }

	public int getRelativePosition(int floor) {
        return this.floor - floor;
    }

	public int getPositivePosition(int floor) {
        return Math.abs(this.floor - floor);
    }
}
