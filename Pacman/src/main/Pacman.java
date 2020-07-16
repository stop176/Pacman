package main;

import java.awt.event.*;
import java.awt.event.KeyListener;



public class Pacman implements KeyListener {

	private double xBall;
	private double yBall;
	private double xBall1;
	private double yBall1;
	private boolean ghost=false;
	private boolean ghost1=false;

	public static int pacpoints;
	public static int pacpoints1;


	private Direction direction;
	private Direction direction1;

	private double stepSize = 1;
	Wall wall = new Wall();
	//booleans for the wall

	//variable for movement

	private Direction realDirection;
	private Direction realDirection1;

	public Direction getRealDirection() {
		return realDirection;
	}
	public Direction getRealDirection1() {
		return realDirection1;
	}


	public void setRealDirection(Direction x) {
		realDirection = x;
	}
	public void setRealDirection1(Direction x) {
		realDirection1 = x;
	}


	//getters for wall boolean
	public boolean isWallDown() {
		return wall.wallExists(getBlockRow(Direction.DOWN) + 1, getBlockColumn(Direction.DOWN)) == 1;
	}

	public boolean isWallRight() {
		return wall.wallExists(getBlockRow(Direction.RIGHT), getBlockColumn(Direction.RIGHT) + 1) == 1;
	}

	public boolean isWallUp() {
		return wall.wallExists(getBlockRow(Direction.UP) - 1, getBlockColumn(Direction.UP)) == 1;
	}

	public boolean isWallLeft() {
		return wall.wallExists(getBlockRow(Direction.LEFT), getBlockColumn(Direction.LEFT) - 1) == 1;
	}
	//getters for wall boolean 2

	public boolean isWallDown1() {
		return wall.wallExists(getBlockRow1(Direction.DOWN1) + 1, getBlockColumn1(Direction.DOWN1)) == 1;
	}

	public boolean isWallRight1() {
		return wall.wallExists(getBlockRow1(Direction.RIGHT1), getBlockColumn1(Direction.RIGHT1) + 1) == 1;
	}

	public boolean isWallUp1() {
		return wall.wallExists(getBlockRow1(Direction.UP1) - 1, getBlockColumn1(Direction.UP1)) == 1;
	}

	public boolean isWallLeft1() {
		return wall.wallExists(getBlockRow1(Direction.LEFT1), getBlockColumn1(Direction.LEFT1) - 1) == 1;
	}


	public boolean onInvisibleLine(double position) {
		return (position + 8) % 16 == 0;
	}

	public boolean onInvisibleLine1(double position) {
		return (position + 8) % 16 == 0;
	}

	public boolean canMoveDown() {
		return !isWallDown() && onInvisibleLine(xBall);
	}

	public boolean canMoveRight() {
		return !isWallRight() && onInvisibleLine(yBall);
	}

	public boolean canMoveUp() {
		return !isWallUp() && onInvisibleLine(xBall);
	}

	public boolean canMoveLeft() {
		return !isWallLeft() && onInvisibleLine(yBall);
	}

	public boolean canMoveDown1() {
		return !isWallDown1() && onInvisibleLine1(xBall1);
	}

	public boolean canMoveRight1() {
		return !isWallRight1() && onInvisibleLine1(yBall1);
	}

	public boolean canMoveUp1() {
		return !isWallUp1() && onInvisibleLine1(xBall1);
	}

	public boolean canMoveLeft1() {
		return !isWallLeft1() && onInvisibleLine1(yBall1);
	}

	public Pacman(double x, double y) {
		xBall = x;
		yBall = y;
	}

	public Pacman(double x, double y, int z) {
		xBall1 = x;
		yBall1 = y;
	}


	public int getBlockColumn(Direction direction) {
		int offset = 0;
		if (direction == Direction.LEFT) {
			offset = 7;
		} else if (direction == Direction.RIGHT) {
			offset = -8;
		} else if (direction == Direction.UP || direction == Direction.DOWN) {
			offset = 0;
		}
		return (int) ((xBall + offset) / 16);
	}

	public int getBlockColumn1(Direction direction1) {
		int offset = 0;
		if (direction1 == Direction.LEFT1) {
			offset = 7;
		} else if (direction1 == Direction.RIGHT1) {
			offset = -8;
		} else if (direction1 == Direction.UP1 || direction1 == Direction.DOWN1) {
			offset = 0;
		}
		return (int) ((xBall1 + offset) / 16);
	}


	public int getBlockRow(Direction direction) {
		int offset = 0;
		if (direction == Direction.UP) {
			offset = 7;
		} else if (direction == Direction.DOWN) {
			offset = -8;
		} else if (direction == Direction.LEFT || direction == Direction.RIGHT) {
			offset = 0;
		}
		return (int) ((yBall + offset) / 16);
	}

	public int getBlockRow1(Direction direction1) {
		int offset = 0;
		if (direction1 == Direction.UP1) {
			offset = 7;
		} else if (direction1 == Direction.DOWN1) {
			offset = -8;
		} else if (direction1 == Direction.LEFT1 || direction1 == Direction.RIGHT1) {
			offset = 0;
		}
		return (int) ((yBall1 + offset) / 16);
	}


	//getters for pixels
	public double getX() {
		return xBall;
	}

	public double getY() {
		return yBall;
	}

	public double getX1() {
		return xBall1;
	}

	public double getY1() {
		return yBall1;
	}


	//getters for movement
	public Direction getDirection() {
		return direction;
	}

	public Direction getDirection1() {
		return direction1;
	}


	//boolean for movement
	public void keyPressed(KeyEvent k) {
		int c = k.getKeyCode();
		//System.out.println("right: "+ canMoveRight()+" left: "+ canMoveLeft()+" up: "+ canMoveUp()+" down: "+ canMoveDown() +"direction" + getDirection()) ;
		//System.out.println("pos: "+ xBall + ", " + yBall);

		if (c == KeyEvent.VK_LEFT) {
			direction = Direction.LEFT;
		}
		if (c == KeyEvent.VK_RIGHT) {
			direction = Direction.RIGHT;
		}
		if (c == KeyEvent.VK_UP) {
			direction = Direction.UP;
		}
		if (c == KeyEvent.VK_DOWN) {
			direction = Direction.DOWN;
		}

		if (c == KeyEvent.VK_A) {
			direction1 = Direction.LEFT1;
		}
		if (c == KeyEvent.VK_D) {
			direction1 = Direction.RIGHT1;
		}
		if (c == KeyEvent.VK_W) {
			direction1 = Direction.UP1;
		}
		if (c == KeyEvent.VK_S) {
			direction1 = Direction.DOWN1;
		}


/*
		if(c ==KeyEvent.VK_V){
			System.out.println("invisible: "+onInvisibleLine(xBall)+", "+onInvisibleLine(yBall));
		}
		if(c ==KeyEvent.VK_B) {
			System.out.println("block: " + getBlockColumn(Direction.LEFT) + ", " + getBlockRow(Direction.LEFT));
		}

 */
	}
	//when to remove the rendering of point thingy and add points
	public void detectPowerup(){
		if (Wall.walls[getBlockRow(Direction.LEFT)][getBlockColumn(Direction.LEFT)] == 3) {
			Wall.walls[getBlockRow(Direction.LEFT)][getBlockColumn(Direction.LEFT)] = 0;
			ghost=true;
			stepSize=1.5;
		} else if (Wall.walls[getBlockRow(Direction.RIGHT)][getBlockColumn(Direction.RIGHT)] == 3) {
			Wall.walls[getBlockRow(Direction.RIGHT)][getBlockColumn(Direction.RIGHT)] = 0;
			ghost=true;
			stepSize=1.5;
		} else if (Wall.walls[getBlockRow(Direction.UP)][getBlockColumn(Direction.UP)] == 3) {
			Wall.walls[getBlockRow(Direction.UP)][getBlockColumn(Direction.UP)] = 0;
			ghost=true;
			stepSize=1.5;

		} else if (Wall.walls[getBlockRow(Direction.DOWN)][getBlockColumn(Direction.DOWN)] == 3) {
			Wall.walls[getBlockRow(Direction.DOWN)][getBlockColumn(Direction.DOWN)] = 0;
			ghost=true;
			stepSize=1.5;

		}
//for pac1
		if (Wall.walls[getBlockRow1(Direction.LEFT1)][getBlockColumn1(Direction.LEFT1)] == 3) {
			Wall.walls[getBlockRow1(Direction.LEFT1)][getBlockColumn1(Direction.LEFT1)] = 0;
			ghost1=true;
			stepSize=1.5;

		} else if (Wall.walls[getBlockRow1(Direction.RIGHT1)][getBlockColumn1(Direction.RIGHT1)] == 3) {
			Wall.walls[getBlockRow1(Direction.RIGHT1)][getBlockColumn1(Direction.RIGHT1)] = 0;
			ghost1=true;
			stepSize=1.5;

		} else if (Wall.walls[getBlockRow1(Direction.UP1)][getBlockColumn1(Direction.UP1)] == 3) {
			Wall.walls[getBlockRow1(Direction.UP1)][getBlockColumn1(Direction.UP1)] = 0;
			ghost1=true;
			stepSize=1.5;

		} else if (Wall.walls[getBlockRow1(Direction.DOWN1)][getBlockColumn1(Direction.DOWN1)] == 3) {
			Wall.walls[getBlockRow1(Direction.DOWN1)][getBlockColumn1(Direction.DOWN1)] = 0;
			ghost1=true;
			stepSize=1.5;

		}

	}
/*
	public void ghostEat() {

	    if(getDirection()==Direction.LEFT)


        if (ghost1 == true) {
            if Wall.wallExists()


        }
    }
*/

        public void detectPoints () {
            if (Wall.walls[getBlockRow(Direction.LEFT)][getBlockColumn(Direction.LEFT)] == 2 && ghost == false) {
                Wall.walls[getBlockRow(Direction.LEFT)][getBlockColumn(Direction.LEFT)] = 0;
                pacpoints = pacpoints + 10;
            } else if (Wall.walls[getBlockRow(Direction.RIGHT)][getBlockColumn(Direction.RIGHT)] == 2 && ghost == false) {
                Wall.walls[getBlockRow(Direction.RIGHT)][getBlockColumn(Direction.RIGHT)] = 0;
                pacpoints = pacpoints + 10;
            } else if (Wall.walls[getBlockRow(Direction.UP)][getBlockColumn(Direction.UP)] == 2 && ghost == false) {
                Wall.walls[getBlockRow(Direction.UP)][getBlockColumn(Direction.UP)] = 0;
                pacpoints = pacpoints + 10;
            } else if (Wall.walls[getBlockRow(Direction.DOWN)][getBlockColumn(Direction.DOWN)] == 2 && ghost == false) {
                Wall.walls[getBlockRow(Direction.DOWN)][getBlockColumn(Direction.DOWN)] = 0;
                pacpoints = pacpoints + 10;
            }

            if (Wall.walls[getBlockRow1(Direction.LEFT1)][getBlockColumn1(Direction.LEFT1)] == 2 && ghost1 == false) {
                Wall.walls[getBlockRow1(Direction.LEFT1)][getBlockColumn1(Direction.LEFT1)] = 0;
                pacpoints1 = pacpoints1 + 10;
            } else if (Wall.walls[getBlockRow1(Direction.RIGHT1)][getBlockColumn1(Direction.RIGHT1)] == 2 && ghost1 == false) {
                Wall.walls[getBlockRow1(Direction.RIGHT1)][getBlockColumn1(Direction.RIGHT1)] = 0;
                pacpoints1 = pacpoints1 + 10;
            } else if (Wall.walls[getBlockRow1(Direction.UP1)][getBlockColumn1(Direction.UP1)] == 2 && ghost1 == false) {
                Wall.walls[getBlockRow1(Direction.UP1)][getBlockColumn1(Direction.UP1)] = 0;
                pacpoints1 = pacpoints1 + 10;
            } else if (Wall.walls[getBlockRow1(Direction.DOWN1)][getBlockColumn1(Direction.DOWN1)] == 2 && ghost1 == false) {
                Wall.walls[getBlockRow1(Direction.DOWN1)][getBlockColumn1(Direction.DOWN1)] = 0;
                pacpoints1 = pacpoints1 + 10;
            }
        }

	//movements
	public void moveRight(){
		xBall+=stepSize;
		if(xBall >= 440) xBall = 8;
	}
	public void moveUp(){
		yBall-=stepSize;
	}
	public void moveLeft(){
		xBall-=stepSize;
		if(xBall <= 8) xBall = 440;
	}
	public void moveDown(){
		yBall+=stepSize;
	}

	//movements for pac1
	public void moveRight1(){
		xBall1+=stepSize;
		if(xBall1 >= 440) xBall1 = 8;
	}
	public void moveUp1(){
		yBall1-=stepSize;
	}
	public void moveLeft1(){
		xBall1-=stepSize;
		if(xBall1 <= 8) xBall1 = 440;
	}
	public void moveDown1() {
			yBall1 += stepSize;
	}

	public boolean getghost(){
		return ghost;
	}
	public boolean getghost1(){
		return ghost1;
	}

	public void setghostfalse() {
		ghost=false;
		stepSize=1;
	}
	public void setghostfalse1(){
		ghost1=false;
		stepSize=1;
	}






	public void keyReleased (KeyEvent k){

	}

	public void keyTyped (KeyEvent k){

	}


}