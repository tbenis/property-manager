/**
 * Plot class.
 *
 * @author Benis Tambe
 *
 */

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot() {
        this.x = 0;
        this.y = 0;
        this.depth = 1;
        this.width = 1;
    }

    /** Parameterized Copy Contstructor takes in a plot object and returns
     * @param plot
     * @return
     */
    public Plot(Plot plot) {
        this.x = plot.x;
        this.y = plot.y;
        this.depth = plot.depth;
        this.width = plot.width;
    }

    /** Parameterized Costructor
     * @param x
     * @param y
     * @param w
     * @param d
     * @return
     */
    public Plot(int x, int y, int w, int d) {
        this.x = x;
        this.y = y;
        this.depth = d;
        this.width = w;
    }
    /**
     * Getter and setter Methods
     */
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    /** method takes in a plot object and returns a boolean if it overlaps
     * @return
     */
    public boolean overlaps(Plot plot) {
        double currentRightX = x + width;
        double currentBottomY = y + depth;
        double newRightX = plot.x+plot.width;
        double newBottomY = plot.y+ plot.depth;

        boolean overlap = false;

        if (plot.y<this.y && this.y<newBottomY && plot.x<this.x && this.x<newRightX){
            overlap = true;
        }
        if (plot.y<this.y && this.y<newBottomY &&
                this.x<plot.x && plot.x<currentRightX) {
            overlap = true;
        }
        if (this.y<plot.y && plot.y<currentBottomY && plot.x<this.x && this.x<newRightX) {
            overlap = true;
        }
        if (this.y<plot.y && plot.y<currentBottomY && this.x<plot.x && plot.x<currentRightX) {
            overlap = true;
        }
        if (plot.x>=x && newRightX<=currentRightX && plot.y>=y && newBottomY<=currentBottomY) {
            overlap = true;
        }
        if (plot.x<=x && newRightX>=currentRightX && plot.y<=y && newBottomY>=currentBottomY) {
            overlap = true;
        }
        return overlap;
    }

    /** method takes in a plot object and returns a boolean if it encompasses
     * @return
     */
    public boolean encompasses(Plot plot) {
        double currentRightX = x + width;
        double currentBottomY = y + depth;

        boolean encompasses = false;

        double newRightX = plot.getX()+plot.getWidth();
        double newBottomY = plot.getY() + plot.getDepth();

        if (this.x<=plot.getX() && plot.getX()<=currentRightX && this.y<=plot.getY() && plot.getY()<=currentBottomY
                && this.x<=currentRightX && newRightX<=currentRightX
                && this.y<=newBottomY && newBottomY<=currentBottomY) {
            encompasses = true;
        }
        return encompasses;
    }
    /** toString method overrides java toString method and returns a string
     * @return
     */
    public String toString() {

        return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
    }
}
