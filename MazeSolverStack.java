package ass2;

public class MazeSolverStack extends MazeSolver {
    private MyStack<Square> stack;

    public MazeSolverStack(Maze maze) {
        super(maze);
        stack = new MyStack<Square>();
        this.makeEmpty();
        Square start = this.maze.getStart();
        start.mark();
        this.add(start);
 } 

    

    public void add(Square sq) {
      
        stack.push(sq);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void makeEmpty() {
       
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }

    @Override
    public Square next() {
        return stack.pop();
    }
    
}