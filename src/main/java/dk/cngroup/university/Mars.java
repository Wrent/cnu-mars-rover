package dk.cngroup.university;

public class Mars {
    private Rover rover;
    private Landscape landscape;
    private RoverPosition position;


    public Mars(Rover rover, Landscape landscape, RoverPosition position) {
        this.rover = rover;
        this.landscape = landscape;
        this.position = position;
    }

    public RoverPosition moveForward() {
        RoverPosition forwardPosition = RoverPositionFactory
                .getForwardPosition(position, rover.getDirection());
        if (landscape.isFieldAccessible(forwardPosition)) {
            return forwardPosition;
        } else {
            return position;
        }
    }

    public RoverPosition moveBackward() {
        RoverPosition backwardPosition = RoverPositionFactory
                .getBackwardPosition(position, rover.getDirection());
        if (landscape.isFieldAccessible(backwardPosition)) {
            return backwardPosition;
        } else {
            return position;
        }
    }

    public RoverPosition getPosition() {
        return position;
    }

    public void movementInstructions(Mars mars, Rover rover, Instruction instruction) {
        switch (instruction) {
            case FORWARD:
                mars.moveForward();
                break;
            case BACKWARD:
                mars.moveBackward();
                break;
            case TURNLEFT:
                rover.turnLeft();
                break;
            case TURNRIGHT:
                rover.turnRight();
                break;
        }
        throw new RuntimeException("this command is unknown");
    }
}
