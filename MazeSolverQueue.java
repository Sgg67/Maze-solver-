// Authors: Sage Yanoff and Hamza Al Elbousi

package ass2;

public class MazeSolverQueue extends MazeSolver {

    private MyQueue<Square> queue;

    public MazeSolverQueue(Maze maze) {
        super(maze);
        queue = new MyQueue<Square>();
        this.makeEmpty();
        Square start = this.maze.getStart();
        start.mark();
        this.add(start);
  
    }

    public void add(Square sq) {
        
        queue.enqueue(sq);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void makeEmpty() {
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
    }

   
    public Square next() {
        return queue.dequeue();
    }
}
