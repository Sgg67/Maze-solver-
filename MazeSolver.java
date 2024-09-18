package ass2;

import java.util.*;

abstract class MazeSolver {
   
    public static final int STACK = 1, QUEUE = 2;
    protected Maze maze;
    protected boolean finished = false;
    protected boolean pathFound = false;
    private List<Square> path;

    MazeSolver(Maze maze) {
        this.maze = maze;
     
    }

    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    public boolean isFinished() {
        return finished;
    }

    public boolean pathFound() {
        return pathFound; // Return the internal pathFound variable.
    }

    /*
     * Once the finish square is reached, this method makes a list of the squares on a path
     * from the start square to the exit square
     */
    private void buildPath(Square sq) {
        this.path = new LinkedList<Square>();
   
        while (sq != null) {
        	sq.setOnPath();
            path.add(0,sq);
            sq = sq.getPrevious();    
        }
        
    }

    public boolean isWall(Square sq) {
        return sq.getType() == Square.WALL;
    }

    public List<Square> getPath() {
        return this.path;
    }

    private boolean isExit(Square sq) {
        return sq != null && sq.getType() == Square.EXIT;
    }

    public void step() {
        if (isEmpty()) {
            finished = true;
            if (!pathFound) {
                System.out.println("No path to the exit.");
            }
            return;
           
        }

        Square nextSquare = this.next();

        if (isExit(nextSquare)) {
            pathFound = true;
            finished = true;
            buildPath(nextSquare);
            return;
        }

        ArrayList<Square> neighbors = maze.getNeighbors(nextSquare);
        for (Square neighbor : neighbors) {
            if (!neighbor.isMarked() && !isWall(neighbor)) {
                neighbor.setPrevious(nextSquare);
                neighbor.mark();
                add(neighbor);
            }  
          
          }
            
    }
}