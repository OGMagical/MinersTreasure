package gamehammad;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

/**
 * Original framework from CodeNmore
 * 
 */
public class Images {
	//width/height of pictures
	private static final int width = 40, height = 40;
	//all images
	public static BufferedImage dirt, playerTest, playerRight2,
			playerRight3, digRight, digLeft, down, bg, titleBG, health,
			treasure, play, howTo, title, wasd, spaceBar, healthBig, treasureBig, spike, rock, bigRock, bigSpike;
	//all animation arrays
	public static BufferedImage[] playerDown, playerRight, playerLeft, playerDead;

	//method to load images when given a path to resource folder
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(Images.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public static void init() {
		//spritesheets
		SpriteSheet sheet = new SpriteSheet(loadImage("/images/textures.png"));
		SpriteSheet player = new SpriteSheet(loadImage("/images/Miner.png"));
		
		//initialize/load each image
		dirt = sheet.crop(64, 0, 32, 32);
		digRight = player.crop(10, 5, width, height + 15);
		digLeft = player.crop(7 + width * 8, height + 20, width, height + 15);
		bg = loadImage("/images/BG.png");
		health = loadImage("/images/health.png");
		treasure = loadImage("/images/treasure.png");
		title = loadImage("/images/title.png");
		play = loadImage("/images/play.png");
		howTo = loadImage("/images/howto.png");
		titleBG = loadImage("/images/grassBG.png");
		wasd = loadImage("/images/wasd.png");
		spaceBar = loadImage("/images/spacebar.png");
		healthBig = loadImage("/images/healthbig.png");
		treasureBig = loadImage("/images/treasureBig.png");
		spike = loadImage("/images/spike.png");
		rock = loadImage("/images/rock.png");
		bigSpike = loadImage("/images/bigspike.png");
		bigRock = loadImage("/images/bigrock.png");
		
		//initialize each animation array
		playerDown = new BufferedImage[3];
		playerRight = new BufferedImage[3];
		playerLeft = new BufferedImage[3];
		playerDead = new BufferedImage[3];
		
		//load each frame of animation arrays
		playerDown[0] = player.crop(width * 7, 10, width - 5, height + 10);
		playerDown[1] = player.crop(width * 8, 10, width - 5, height + 10);
		playerDown[2] = player.crop(width * 9, 10, width - 5, height + 10);

		playerRight[0] = player.crop(5, 30 + (height * 5), width - 5, height);
		playerRight[1] = player.crop(5 + width, 30 + (height * 5), width - 5,
				height);
		playerRight[2] = player.crop(5 + width * 2, 30 + (height * 5),
				width - 7, height);
		
		//player Left
		playerLeft[0] = player.crop(5 + width * 10, 30 + (height * 5),
				width - 5, height);
		playerLeft[1] = player.crop(5 + width * 9, 30 + (height * 5),
				width - 5, height);
		playerLeft[2] = player.crop(10 + width * 8, 30 + (height * 5),
				width - 5, height);
		//player dead
		playerDead[0] = player.crop(width*4 + 15, 273, width, height - 10);
		playerDead[1] = player.crop(width*3 + 10, 273, width, height - 10);
		playerDead[2] = player.crop(width*2 + 5, 273, width, height - 10);

	}
}
