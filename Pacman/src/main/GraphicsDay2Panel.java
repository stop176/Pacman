package main;
//  Author: David Guo

import java.awt.event.*;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.net.URL;


public class GraphicsDay2Panel extends JPanel implements ActionListener //KeyListener
{

	private Timer time = new Timer(7, this);

	long time1 = 0;
	long time2 = 0;

	private final int MAP_HEIGHT = 576;
	private final int MAP_WIDTH = 448;
	Pacman pac;
	Pacman pac1;
	Wall wally;

	//BUFFEREDIMAGE
	private BufferedImage map;
	private BufferedImage pacGif;
	private BufferedImage pacDown;
	private BufferedImage pacLeft;
	private BufferedImage pacRight;
	private BufferedImage pacUp;
	private BufferedImage ghost;
	private Image image;


	public GraphicsDay2Panel() {




		pac = new Pacman(180, 328);
		pac1 = new Pacman(268, 328, 0);

		addKeyListener(pac);
		addKeyListener(pac1);

		time.start();
		setFocusable(true);
		//bufferedimages
		BufferedImageLoader loader = new BufferedImageLoader();
		map = loader.loadImage("/assets/pacman-background.png");


		pacRight = loader.loadImage("/assets/pacRight.png");
		pacLeft = loader.loadImage("/assets/pacRight.png");
		pacUp = loader.loadImage("/assets/pacRight.png");
		pacDown = loader.loadImage("/assets/pacRight.png");
		ghost = loader.loadImage("/assets/ghost.png");


		pacGif = loader.loadImage("/assets/pacman-icon.gif");

		Icon icon = new ImageIcon("/assets/pacman-icon.gif");
		URL url = this.getClass().getResource("/assets/pacman-icon.gif");
		image = new ImageIcon(url).getImage();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//buffered

		g.drawImage(map, 0, 0, MAP_WIDTH, MAP_HEIGHT, null);

		//points
		g.setColor(Color.white);
		for (int i = 0; i < Wall.walls.length; i++) {
			for (int j = 0; j < Wall.walls[0].length; j++) {
				if (Wall.wallExists(i, j) == 2)
					g.fillOval((j * 16) + 6, (i * 16) + 3, 5, 5);
				if (Wall.wallExists(i, j) == 3)
					g.fillOval((j * 16) - 2, (i * 16) - 3, 15, 15);
			}
		}
		if (pac1.getghost1() == false) {
			g.drawImage(pacGif, (int) pac1.getX1() - 15, (int) pac1.getY1() - 15, 30, 30, null);
		} else {
			g.drawImage(ghost, (int) pac1.getX1() - 15, (int) pac1.getY1() - 15, 30, 30, null);

		}

		if (pac.getghost() == false) {
			g.drawImage(pacGif, (int) pac.getX() - 15, (int) pac.getY() - 15, 30, 30, null);
		} else {
			g.drawImage(ghost, (int) pac.getX() - 15, (int) pac.getY() - 15, 30, 30, null);

		}


		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));


		g.drawString("" + Pacman.pacpoints, 78, 41);
		g.drawString("" + Pacman.pacpoints1, 330, 41);

/*
	if(pac.getDirection()==Direction.LEFT){
			g.drawImage(pacRight, (int)pac.getX()-15,(int)pac.getY()-15,30,30,null);
		}
		else if(pac.getDirection()==Direction.RIGHT){
			g.drawImage(pacRight, (int)pac.getX()-15,(int)pac.getY()-15,30,30,null);
		}
		else if(pac.getDirection()==Direction.UP){
			g.drawImage(pacRight, (int)pac.getX()-15,(int)pac.getY()-15,30,30,null);
		}
		else if(pac.getDirection()==Direction.DOWN){
			g.drawImage(pacRight, (int)pac.getX()-15,(int)pac.getY()-15,30,30,null);
		}
 */


	}


	public void actionPerformed(ActionEvent e) {
		//detection of points brah
		ghostTimer();
		ghostTimer1();
		Direction pacDir = pac.getDirection();

		pac.detectPoints();
		pac.detectPowerup();

		if (pacDir == Direction.LEFT && pac.canMoveLeft()) {
			pac.setRealDirection(Direction.LEFT);
		} else if (pacDir == Direction.RIGHT && pac.canMoveRight()) {
			pac.setRealDirection(Direction.RIGHT);
		} else if (pacDir == Direction.UP && pac.canMoveUp()) {
			pac.setRealDirection(Direction.UP);
		} else if (pacDir == Direction.DOWN && pac.canMoveDown()) {
			pac.setRealDirection(Direction.DOWN);
		}

		Direction realPacDir = pac.getRealDirection();

		if (realPacDir == Direction.LEFT && pac.canMoveLeft()) {
			pac.moveLeft();
		} else if (realPacDir == Direction.RIGHT && pac.canMoveRight()) {
			pac.moveRight();
		} else if (realPacDir == Direction.UP && pac.canMoveUp()) {
			pac.moveUp();
		} else if (realPacDir == Direction.DOWN && pac.canMoveDown()) {
			pac.moveDown();
		}
//pac1

		Direction pacDir1 = pac1.getDirection1();
		pac1.detectPoints();
		pac1.detectPowerup();
		if (pacDir1 == Direction.LEFT1 && pac1.canMoveLeft1()) {
			pac1.setRealDirection1(Direction.LEFT1);
			//System.out.println("left");
		} else if (pacDir1 == Direction.RIGHT1 && pac1.canMoveRight1()) {
			pac1.setRealDirection1(Direction.RIGHT1);
			//	System.out.println("right");
		} else if (pacDir1 == Direction.UP1 && pac1.canMoveUp1()) {
			pac1.setRealDirection1(Direction.UP1);
			//System.out.println("up");
		} else if (pacDir1 == Direction.DOWN1 && pac1.canMoveDown1()) {
			pac1.setRealDirection1(Direction.DOWN1);
			//System.out.println("down");
		}
		Direction realPacDir1 = pac1.getRealDirection1();

		if (realPacDir1 == Direction.LEFT1 && pac1.canMoveLeft1()) {
			pac1.moveLeft1();
		} else if (realPacDir1 == Direction.RIGHT1 && pac1.canMoveRight1()) {
			pac1.moveRight1();
		} else if (realPacDir1 == Direction.UP1 && pac1.canMoveUp1()) {
			pac1.moveUp1();
		} else if (realPacDir1 == Direction.DOWN1 && pac1.canMoveDown1()) {
			pac1.moveDown1();
		}
		repaint();
	}

	public void ghostTimer() {
		if (pac.getghost() == true) {
			if (time1 == 0) {
				time1 = System.currentTimeMillis();
			}

			if (System.currentTimeMillis() - time1 >= 5000) {
				pac.setghostfalse();
				time1 = 0;
			}


		}
	}

	public void ghostTimer1() {
		if (pac1.getghost1() == true) {
			if (time2 == 0) {
				time2 = System.currentTimeMillis();
			}

			if (System.currentTimeMillis() - time2 >= 5000) {
				pac1.setghostfalse1();
				time2 = 0;
			}


		}
	}


}