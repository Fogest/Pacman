//______                                                       
//| ___ \                                
//| |_/ /__ _  ___ _ __ ___   __ _ _ __  
//|  __// _` |/ __| '_ ` _ \ / _` | '_ \ 
//| |  | (_| | (__| | | | | | (_| | | | |
//\_|   \__,_|\___|_| |_| |_|\__,_|_| |_|
//______           ___           _   _         _   _ _                   
//| ___ \         |_  |         | | (_)       | | | (_)                  
//| |_/ /_   _      | |_   _ ___| |_ _ _ __   | | | |_ ___ ___  ___ _ __ 
//| ___ \ | | |     | | | | / __| __| | '_ \  | | | | / __/ __|/ _ \ '__|
//| |_/ / |_| | /\__/ / |_| \__ \ |_| | | | | \ \_/ / \__ \__ \  __/ |   
//\____/ \__, | \____/ \__,_|___/\__|_|_| |_|  \___/|_|___/___/\___|_|   
//        __/ |                                                          
//       |___/                                                           
// _____ _____ _____  _____ _   _ _____      _____  __  
//|_   _/  __ |  ___||____ | | | |_   _|    |  _  |/  | 
//  | | | /  \| `--.     / / | | | | |______| |/' |`| | 
//  | | | |    `--. \    \ \ | | | | |______|  /| | | | 
// _| |_| \__/|\__/ /.___/ / |_| |_| |_     \ |_/ /_| |_
// \___/ \____|____/ \____/ \___/ \___/      \___/ \___/      
//       _                                      ___   ___      ___   ___ __ ___  
//      | |                                    |__ \ / _ \    |__ \ / _ |_ |__ \ 
//      | | __ _ _ __  _   _  __ _ _ __ _   _     ) | | | |      ) | | | | |  ) |
//  _   | |/ _` | '_ \| | | |/ _` | '__| | | |   / /| | | |     / /| | | | | / / 
// | |__| | (_| | | | | |_| | (_| | |  | |_| |  / /_| |_| |_   / /_| |_| | |/ /_ 
//  \____/ \__,_|_| |_|\__,_|\__,_|_|   \__, | |____|\___/( ) |____|\___/|_|____|
//                                       __/ |            |/                     
//                                      |___/                                    
//Description:
//Pacman Game



// _____                            _       
//|_   _|                          | |      
//  | |  _ __ ___  _ __   ___  _ __| |_ ___ 
//  | | | '_ ` _ \| '_ \ / _ \| '__| __/ __|
// _| |_| | | | | | |_) | (_) | |  | |_\__ \
// \___/|_| |_| |_| .__/ \___/|_|   \__|___/
//                | |                       
//                |_|                       
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.*;
import java.net.URL;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.sound.sampled.*;
public class pacman extends JPanel implements KeyListener,MouseListener{
// _   _            _       _     _          
//| | | |          (_)     | |   | |         
//| | | | __ _ _ __ _  __ _| |__ | | ___ ___ 
//| | | |/ _` | '__| |/ _` | '_ \| |/ _ | __|
//\ \_/ / (_| | |  | | (_| | |_) | |  __|__ \
// \___/ \__,_|_|  |_|\__,_|_.__/|_|\___|___/
  
  //mouse click variables
  int clickX = 0;
  int clickY = 0;
  //used for pacman movement
  boolean goup = false;
  boolean godown = false;
  boolean goright = false;
  boolean goleft = false;
  //pacmans coords + starting positions variables
  int pac_x = 11;
  int pac_y = 10;
  int x = pac_x*21;
  int y = pac_y*21;
  //varibles dealing with score
  int scoredisplay = 0;
  boolean scoreset = false;
  //general count varible
  int count = 0;
  //ghosts coords + starting location variables
  int ghost_orange_y = 9;
  int ghost_orange_x = 9;
  int ghost_teal_y = 10;
  int ghost_teal_x = 9;
  int ghost_red_y = 11;
  int ghost_red_x = 9;
  int ghost_pink_x = 7;
  int ghost_pink_y = 10;
  //used for making pacman invulnerable for a short period after dying. (to prevent loosing all lives at once)
  boolean safe = false;
  int safecount = 0;
  //movement varibles
  boolean moveright = false;
  boolean moveleft = false;
  boolean moveup = false;
  boolean movedown = false;
  //varible containing info as to whether pacman is dead or not
  boolean dead = false;
  //pacman movement variables
  boolean up = false;
  boolean down = false;
  boolean right = false;
  boolean left = false;
  int score = 0;
  int lives = 3;
  //general counting variable
  int n = 0;
  //Used to say whether or not to check if buttons should be checked
  boolean button = false;
  //checks to see if button has already been pressed.
  boolean ran1 = false;
  boolean ran2 = false;
  boolean ran3 = false;
  boolean ran11 = false;
  boolean ran22 = false;
  boolean ran33 = false;
  //Used to tell whether a score is a new high score or not.
  boolean newhighscore = false;
  boolean oldhighscore = false;
  //Varibles used to count ghost run length and to tell whether or not to start the count
  boolean ghostrun = false;
  int ghostruncount = 0;
  //Used to check if highscore check has been run
  boolean run = false;
  //Used for reading the highscore from a file
  int scorein = 0;
  //Variable used to define which level player is currently on
  int level = 1;
  //Used to make a blinking pause button.
  boolean flop = false;
  //Counter for how many dots have been picked up. If they hit 176 then next level.
  int pickup = 0;
  //Used to tell when pause button is pressed
  boolean paused = false;
  //Check if function has run
  boolean hasdone = false;
  //Whether to run main loop or not
  boolean start = true;
  //USed for telling whether high score has been writen or not.
  boolean haveyougone = false;
  //Used to check whether to draw Instructions screen or not
  boolean instructions = false;
  //Used to check whether to draw High Score screen at start of game
  boolean hss = false;
  //Used to check whether to draw High Score screen at end of game
  boolean hse = false;
  //Used to check whether to draw the Game Over screen
  boolean endscreen = false;
  //Variable for how many points you need for another life
  int lifescore=10000;
  //Counter for when to display cherry
  int cherrytickstart = 0;
  //Determines when to draw the bonus cherry
  boolean cherrygo = false;
  //Target points for ghosts
  double targetredx = pac_x;
  double targetredy = pac_y;
  int targetbluex = 0;
  int targetbluey = 0;
  int targetorangex = 0;
  int targetorangey = 0;
  //Variables for Ghost AI
  double hasgone = 0;
  double hold = 0.0;
  double a = 0.0;
  double b = 0.0;
  double c = 0.0;
  int inter = 0;
  //choosing direction
  boolean mt = true;
  boolean mr = false;
  boolean mb = false;
  boolean ml = false;
  //Variables to handle whether or not activate the random aspect of the ghost.
  boolean randomorange = true;
  boolean randomblue = false;
  boolean randompink = true;
  boolean randomred = false;
  ///////////////||||||||||||||||Board and Movement is based off the below!!!||||||||||||||||\\\\\\\\\\\\\\\\\\\\
  //Info Sector
  //0's = Walls or location not allowed to go
  //1's = Dot Spot
  //2's = Clear Path nothing on it but safe to move
  //3's = Power Dot
  //-1's = only ghosts can go through
  //5= Top entry spot
  //6= bottom entry point
  //7 = Cherry
  //(Spots = row - 1 same with columns = - 1. First # is row. Second is col
  public int board[][] =
  {{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //1
    {2, 0, 3, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 3, 0, 2}, //2
    {2, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 2}, //3
    {2,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,2}, //4
    {2,0,1,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,1,0,2}, //5
    {2,0,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,0,2}, //6
    {2,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,2}, //7
    {2,2,2,2,0,1,0,1,1,1,1,1,1,1,0,1,0,2,2,2,2}, //8
    {0,0,0,0,0,1,0,1,0,0,-1,0,0,1,0,1,0,0,0,0,0}, //9
    {5,2,2,2,2,1,1,1,0,2,2,2,0, 1 ,1,1,2,2,2,2,6}, //10 - cherry
    {0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0}, //11
    {2,2,2,2,0,1,0,1,1,1,2,1,1,1,0,1,0,2,2,2,2}, //12
    {2,0,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,2}, //13
    {2,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,2}, //14 - pacman on this row
    {2,0,1,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,1,0,2}, //15
    {2,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,2}, //16 
    {2,0,0,1,0,1,0,1,0,0,0,0,0,1,0,1,0,1,0,0,2}, //17
    {2,0,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,0,2}, //18
    {2,0,1,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,0,2}, //19
    {2,0,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,0,2}, //20
    {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2}}; //21
  //Board to copy from when there is a new game or level. 
  public int newboard[][] =
  {{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //1
    {2, 0, 3, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 3, 0, 2}, //2
    {2, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 2}, //3
    {2,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,2}, //4
    {2,0,1,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,1,0,2}, //5
    {2,0,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,0,2}, //6
    {2,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,2}, //7
    {2,2,2,2,0,1,0,1,1,1,1,1,1,1,0,1,0,2,2,2,2}, //8
    {0,0,0,0,0,1,0,1,0,0,-1,0,0,1,0,1,0,0,0,0,0}, //9
    {5,2,2,2,2,1,1,1,0,2,2,2,0,1,1,1,2,2,2,2,6}, //10
    {0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0}, //11
    {2,2,2,2,0,1,0,1,1,1,2,1,1,1,0,1,0,2,2,2,2}, //12
    {2,0,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,2}, //13
    {2,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,2}, //14 - pacman on this row
    {2,0,1,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,1,0,2}, //15
    {2,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,2}, //16 
    {2,0,0,1,0,1,0,1,0,0,0,0,0,1,0,1,0,1,0,0,2}, //17
    {2,0,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,0,2}, //18
    {2,0,1,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,0,2}, //19
    {2,0,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,0,2}, //20
    {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2}}; //21
  
// _                      _ _               _____                                
//| |                    | (_)             |_   _|                               
//| |      ___   __ _  __| |_ _ __   __ _    | |  _ __ ___   __ _  __ _  ___ ___ 
//| |     / _ \ / _` |/ _` | | '_ \ / _` |   | | | '_ ` _ \ / _` |/ _` |/ _ | __|
//| |____| (_) | (_| | (_| | | | | | (_| |  _| |_| | | | | | (_| | (_| |  __|__ \
//\_____/ \___/ \__,_|\__,_|_|_| |_|\__, |  \___/|_| |_| |_|\__,_|\__, |\___|___/
//                                   __/ |                         __/ |         
//                                  |___/                         |___/          
  Clip sound, sound2;
  
  BufferedImage pro1 = ImageHelper.loadImage("rightpacopen.png");
  BufferedImage plo1 = ImageHelper.loadImage("leftpacopen.png");
  BufferedImage puo1 = ImageHelper.loadImage("uppacopen.png");
  BufferedImage pdo1 = ImageHelper.loadImage("downpacopen.png");
  BufferedImage pro = ImageHelper.resize(pro1,19,19);
  BufferedImage pro2 = ImageHelper.resize(pro1,30,30);
  BufferedImage plo = ImageHelper.resize(plo1,19,19);
  BufferedImage puo = ImageHelper.resize(puo1,19,19);
  BufferedImage pdo = ImageHelper.resize(pdo1,19,19);
  
  BufferedImage  end = ImageHelper.loadImage("end.png");
  BufferedImage startmenu = ImageHelper.loadImage("start.png");
    
  BufferedImage loadghost = ImageHelper.loadImage("ghostsprite.png");
  BufferedImage[] ghostsprite = ImageHelper.splitImage(loadghost, 4, 1);
  
  BufferedImage loadpacright = ImageHelper.loadImage("right.png");
  BufferedImage loadpacleft = ImageHelper.loadImage("left.png");
  BufferedImage loadpacup = ImageHelper.loadImage("up.png");
  BufferedImage loadpacdown = ImageHelper.loadImage("down.png");
  
  BufferedImage loadpacdiesprite = ImageHelper.loadImage("pacdiesprite.png");
  
  BufferedImage[] pacright = ImageHelper.splitImage(loadpacright,3,1);
  BufferedImage[] pacleft = ImageHelper.splitImage(loadpacleft,3,1);
  BufferedImage[] pacup = ImageHelper.splitImage(loadpacup,3,1);
  BufferedImage[] pacdown = ImageHelper.splitImage(loadpacdown,3,1);
  BufferedImage[] pacdie = ImageHelper.splitImage(loadpacdiesprite,6,1);  
  BufferedImage curImage = pro;
  
  BufferedImage loadkillghost = ImageHelper.loadImage("killghost.png");
  BufferedImage killghost = ImageHelper.resize(loadkillghost,19,19);
  BufferedImage loadkillghostwhite = ImageHelper.loadImage("killghostwhite.png");
  BufferedImage killghostwhite = ImageHelper.resize(loadkillghostwhite,19,19);
  
  BufferedImage loadhighscorestart = ImageHelper.loadImage("highscore.png");
  BufferedImage loadhighscoreend = ImageHelper.loadImage("highscoreend.png");
  BufferedImage loadhowtoplay = ImageHelper.loadImage("howtoplay.png");
  BufferedImage highscorestart = ImageHelper.resize(loadhighscorestart,460,465);
  BufferedImage highscoreend = ImageHelper.resize(loadhighscoreend,460,465);
  BufferedImage howtoplay = ImageHelper.resize(loadhowtoplay,460,465);
  
  BufferedImage loadcherry = ImageHelper.loadImage("cherry.png");
  BufferedImage cherry = ImageHelper.resize(loadcherry,16,16);
  //Simply used to reset variables to orginal values. For Gameover >> Play Again
  public void reset()
  {
    
    for(int r=0; r < board.length; r++)
    {
      for(int c=0; c < board[0].length; c++)
      {
        board[r][c] = newboard[r][c];
      }
    }
    lives = 3;
    clickX = 0;
    clickY = 0;
    goup = false;
    godown = false;
    goright = false;
    goleft = false;
    pac_x = 11;
    pac_y = 10;
    x = pac_x*21;
    y = pac_y*21;
    scoredisplay = 0;
    scoreset = false;
    count = 0;
    ghost_orange_y = 9;
    ghost_orange_x = 9;
    ghost_teal_y = 10;
    ghost_teal_x = 9;
    ghost_red_y = 11;
    ghost_red_x = 9;
    ghost_pink_x = 7;
    ghost_pink_y = 10;
    safe = false;
    safecount = 0;
    moveright = false;
    moveleft = false;
    moveup = false;
    movedown = false;
    dead = false;
    up = false;
    down = false;
    right = false;
    left = false;
    score = 0;
    lives = 3;
    n = 0;
    button = false;
    ran1 = false;
    ran2 = false;
    ran3 = false;
    ran11 = false;
    ran22 = false;
    ran33 = false;
    newhighscore = false;
    oldhighscore = false;
    ghostrun = false;
    ghostruncount = 0;
    run = false;
    scorein = 0;
    level = 1;
    flop = false;
    pickup = 0;
    hasdone = false;
    lifescore=10000;
    cherrytickstart = 0;
    cherrygo = false;
    targetredx = pac_x;
    targetredy = pac_y;
    targetbluex = 0;
    targetbluey = 0;
    targetorangex = 0;
    targetorangey = 0;
    hasgone = 0;
  }
  //Reseting when level has been beat
  public void resetboard()
  {
    goup = false;
    godown = false;
    goright = false;
    goleft = false;
    up = false;
    down = false;
    right = false;
    left = false;
    pickup = 0;
    pac_x = 11;
    pac_y = 10;
    x = pac_x*21;
    y = pac_y*21;
    ghost_orange_y = 9;
    ghost_orange_x = 9;
    ghost_teal_y = 10;
    ghost_teal_x = 9;
    ghost_red_y = 11;
    ghost_red_x = 9;
    ghost_pink_x = 7;
    ghost_pink_y = 10;
    cherrytickstart = 0;
    cherrygo = false;
    targetredx = pac_x;
    targetredy = pac_y;
    targetbluex = 0;
    targetbluey = 0;
    targetorangex = 0;
    targetorangey = 0;
    hasgone = 0;
    for(int r=0; r < board.length; r++)
    {
      for(int c=0; c < board[0].length; c++)
      {
        board[r][c] = newboard[r][c];
      }
    }
  }
  
//______                    
//|  _  \                   
//| | | |_ __ __ ___      __
//| | | | '__/ _` \ \ /\ / /
//| |/ /| | | (_| |\ V  V / 
//|___/ |_|  \__,_| \_/\_/  
  @Override
  public void paintComponent(Graphics g){
    //when paint is re drawn it clears gfx and re paints.
    Font copyright = new Font("Arial Bold", Font.BOLD, 14);
    g.clearRect(0,0,800,600);
    //only paints all this if lives are not equal to 0 (0 means your out of lives [gameover])
    if(lives!=0){
      g.setColor(Color.black);
      g.fillRect(0,0,800,800);

      
      //Drawing walls
      for(int i =0; i < 21; i++)
      {
        for(int j =0; j < 21; j++)
        {
          if(board[i][j] == 0)
          {
            g.setColor(Color.blue);
            g.drawRect(i*21,j*21,21,21);
          }
        }
      }
      //Drawing dots
      for(int i =0; i < 21; i++)
      {
        for(int j =0; j < 21; j++)
        {
          if(board[i][j] == 1)
          {
            g.setColor(Color.white);
            g.fillOval((i*21)+6,(j*21)+6,7,7);
          }
        }
      }
                  if(cherrygo==true)
      {
       g.drawImage(cherry,191,276,null); 
      }
      //Drawing Power Dots
      for(int i =0; i < 21; i++)
      {
        for(int j =0; j < 21; j++)
        {
          if(board[i][j] == 3)
          {
            g.setColor(Color.white);
            g.fillOval((i*21)+3,(j*21)+3,16,16);
          }
        }
      }
      g.setColor(Color.gray);
      //gray area where only ghosts can enter and exit
      g.fillRect(168,210,21,21);

      //copyright text in top right
      
      g.setFont(copyright);
      g.setColor(Color.green);
      if(level<10)
      {
      g.drawString("Level: 0"+level,385,14);
      }else
      {
        g.drawString("Level: "+level,385,14);
      }
      
      //dislaying current score
      Font font1 = new Font("Verdana", Font.BOLD, 18);
      g.setFont(font1);
      g.setColor(Color.red);
      g.drawString("Score: "+score,0,460);
      //pacman
      g.drawImage(curImage,(pac_x) *21 + 2,(pac_y)*21+2,null);
      
      //draw ghosts
      if(ghostrun==false)
      {
        g.drawImage(ghostsprite[0],ghost_orange_x*21+2,ghost_orange_y*21+2, null);
        g.drawImage(ghostsprite[1],ghost_teal_x*21+2,ghost_teal_y*21+2, null);
        g.drawImage(ghostsprite[2],ghost_red_x*21+2,ghost_red_y*21+2, null);
        g.drawImage(ghostsprite[3],ghost_pink_x*21+2,ghost_pink_y*21+2, null);
      }else if(ghostrun==true)
      {
        g.drawImage(killghost,ghost_orange_x*21+2,ghost_orange_y*21+2, null);
        g.drawImage(killghost,ghost_teal_x*21+2,ghost_teal_y*21+2, null);
        g.drawImage(killghost,ghost_red_x*21+2,ghost_red_y*21+2, null);
        g.drawImage(killghost,ghost_pink_x*21+2,ghost_pink_y*21+2, null);
        if(ghostruncount>41&&ghostruncount<43||ghostruncount>45&&ghostruncount<47||ghostruncount>49&&ghostruncount<51||ghostruncount>53&&ghostruncount<55||ghostruncount>57&&ghostruncount<59||ghostruncount>61&&ghostruncount<63||ghostruncount>65&&ghostruncount<67||ghostruncount>69&&ghostruncount<71||ghostruncount>75&&ghostruncount<77)
        {
          g.drawImage(killghostwhite,ghost_orange_x*21+2,ghost_orange_y*21+2, null);
          g.drawImage(killghostwhite,ghost_teal_x*21+2,ghost_teal_y*21+2, null);
          g.drawImage(killghostwhite,ghost_red_x*21+2,ghost_red_y*21+2, null);
          g.drawImage(killghostwhite,ghost_pink_x*21+2,ghost_pink_y*21+2, null);
        }
      }
      //draw total lives
      if(lives>=4)
      {
        try
      {
        String currentDir = new File("TexasLED.ttf").getAbsolutePath();;
        URL fontUrl = new URL("file:///"+currentDir);
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        font = font.deriveFont(Font.PLAIN,25);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        g.setFont(font);
      }catch(Exception e)
      {   
      }
      g.setColor(Color.RED);
      g.drawString("CHEATER SPOTTED",245,455);
      }
      if (lives==3){
        g.drawImage(pro2,415,430,null);
        g.drawImage(pro2,382,430,null);
        g.drawImage(pro2,350,430,null);
      }
      if(lives==2){
        g.drawImage(pro2,415,430,null);
        g.drawImage(pro2,382,430,null);
      }
      if(lives==1){
        g.drawImage(pro2,415,430,null);
      }
      //if pacman is out of lifes do this
    }
    if(dead==true)
    {
      g.drawImage(pacdie[n],(pac_x)*21+2,(pac_y)*21+2,null);
      n++;
      up=false;
      down=false;
      left=false;
      right=false;
      if (n == 6)
      {
        targetredx = pac_x;
        targetredy = pac_y;
        targetbluex = 0;
        targetbluey = 0;
        targetorangex = 0;
        targetorangey = 0;
        hasgone = 0;
        n=0;
        pac_x = 11;
        pac_y = 10;
        ghost_orange_y = 9;
        ghost_orange_x = 9;
        ghost_teal_y = 10;
        ghost_teal_x = 9;
        ghost_red_y = 11;
        ghost_red_x = 9;
        ghost_pink_x = 7;
        ghost_pink_y = 10;
        dead = false; 
      }
    }
    if(paused==true)
    {
      try
      {
        String currentDir = new File("TexasLED.ttf").getAbsolutePath();;
        URL fontUrl = new URL("file:///"+currentDir);
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        font = font.deriveFont(Font.PLAIN,80);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        g.setFont(font);
      }catch(Exception e)
      {   
        e.printStackTrace();
      }
      if(flop==false)
      {
      g.setColor(Color.RED);
      g.drawString("Paused",80,200);  
      }
    }
    if(lives==0){
      if(hasdone==false)
      {
      endscreen=true;
      hasdone = true;
      }
      if(scoreset == false){
        scoredisplay = score;
        scoreset = true;
      }
      //Ending gameover score displaying.
      try
      {
        String currentDir = new File("TexasLED.ttf").getAbsolutePath();;
        URL fontUrl = new URL("file:///"+currentDir);
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        font = font.deriveFont(Font.PLAIN,26);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        g.setFont(font);
      }catch(Exception e)
      {   
        e.printStackTrace();
      }
      Color c = new Color(145,25,25);
      g.setColor(c);
      g.drawImage(end,-10,0,null);
      if(score>9999)
      {g.drawString(""+scoredisplay,184,200);}
      if(score>0&&score<10000)
      {g.drawString(""+scoredisplay,188,200);}
    }
    int finalscore = 0;
    if(scorein>score)
    {
     finalscore=scorein; 
    }else if(scorein<score)
    {
     finalscore=score; 
    }
    if(start==true)
    {
     g.drawImage(startmenu,-10,0,null); 
     if(instructions==true)
     {
      g.drawImage(howtoplay,-3,0,null); 
     }
     if(hss==true)
     {
      g.drawImage(highscorestart,-3,0,null);
            try
      {
        String currentDir = new File("TexasLED.ttf").getAbsolutePath();;
        URL fontUrl = new URL("file:///"+currentDir);
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        font = font.deriveFont(Font.PLAIN,80);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        g.setFont(font);
      }catch(Exception e)
      {   
        e.printStackTrace();
      }
      g.setColor(Color.RED);
      if(finalscore<10000)
      {
        g.drawString(""+finalscore,128,270);
      }
      if(finalscore>10000&&finalscore<100000)
      {
        g.drawString(""+finalscore,105,270);
      }
      if(finalscore>100000)
      {
        g.drawString(""+finalscore,85,270);
      }
     }
     
     }
    if(endscreen==true)
    {
    if(instructions==true)
     {
      g.drawImage(howtoplay,-3,0,null); 
     }  
    if(hse==true)
     {
      g.drawImage(highscoreend,-3,0,null);
            try
      {
        String currentDir = new File("TexasLED.ttf").getAbsolutePath();;
        URL fontUrl = new URL("file:///"+currentDir);
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        font = font.deriveFont(Font.PLAIN,80);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        g.setFont(font);
      }catch(Exception e)
      {   
        e.printStackTrace();
      }
      g.setColor(Color.RED);
      if(finalscore<10000)
      {
        g.drawString(""+finalscore,128,270);
      }
      if(finalscore>10000&&finalscore<100000)
      {
        g.drawString(""+finalscore,105,270);
      }
      if(finalscore>100000)
      {
        g.drawString(""+finalscore,85,270);
      }
    }
    }
          g.setFont(copyright);
      g.setColor(Color.green);
      g.drawString("Copyright � 2012 Justin ",0,14);
  }
//______      _   _                 
//| ___ \    | | | |                
//| |_/ /__ _| |_| |__  _   _ _ __  
//|  __// _` | __| '_ \| | | | '_ \ 
//| |  | (_| | |_| | | | |_| | |_) |
//\_|   \__,_|\__|_| |_|\__,_| .__/ 
//                           | |    
//                           |_|    
//Checks if spot above pacman is clear
  public void pathup()
  {
    if (board[pac_x][(pac_y)-(1)] >= 1) {
      pac_y = pac_y - 1;
      curImage=pacup[count];
      count++;
      if(count==3)
      {
        count = 0;
      }
    } else {
      count = 0;
      curImage=pacup[count];
      up=false;
      moveup=false;
    }
  }
//______      _   _         _                     
//| ___ \    | | | |       | |                    
//| |_/ /__ _| |_| |__   __| | _____      ___ __  
//|  __// _` | __| '_ \ / _` |/ _ \ \ /\ / / '_ \ 
//| |  | (_| | |_| | | | (_| | (_) \ V  V /| | | |
//\_|   \__,_|\__|_| |_|\__,_|\___/ \_/\_/ |_| |_|
//checks if spot below pacman is clear
  public void pathdown()
  {
    if (board[pac_x][(pac_y)+(1)] >= 1) {
      pac_y = pac_y + 1;
      curImage=pacdown[count];
      count++;
      if(count==3)
      {
        count = 0;
      }
    } else {
      count = 0;
      curImage=pacdown[count];
      down=false;
      movedown = false;
    }
  }
//______      _   _          _       _     _   
//| ___ \    | | | |        (_)     | |   | |  
//| |_/ /__ _| |_| |__  _ __ _  __ _| |__ | |_ 
//|  __// _` | __| '_ \| '__| |/ _` | '_ \| __|
//| |  | (_| | |_| | | | |  | | (_| | | | | |_ 
//\_|   \__,_|\__|_| |_|_|  |_|\__, |_| |_|\__|
//                              __/ |          
//                             |___/           
  //checks if spot to right of pacman is clear
  public void pathright()
  {
    if (board[pac_x+1][(pac_y)] >= 1) {
      pac_x = pac_x + 1;
      curImage=pacright[count];
      count++;
      if(count==3)
      {
        count = 0;
      }
    } else {
      count = 0;
      curImage=pacright[count];
      right=false;
      moveright = false;
    }
  }
//______      _   _     _       __ _   
//| ___ \    | | | |   | |     / _| |  
//| |_/ /__ _| |_| |__ | | ___| |_| |_ 
//|  __// _` | __| '_ \| |/ _ \  _| __|
//| |  | (_| | |_| | | | |  __/ | | |_ 
//\_|   \__,_|\__|_| |_|_|\___|_|  \__|                             
//checks if spot to left of pacman is clear
  public void pathleft()
  {
    if (board[(pac_x)-(1)][(pac_y)] >= 1) {
      
      pac_x = pac_x - 1;
      curImage=pacleft[count];
      count++;
      if(count==3)
      {
        count = 0;
      }
    } else {
      count = 0;
      curImage=pacleft[count];
      left=false;
      moveleft = false;
    }
  }
//___  ___                                    _   
//|  \/  |                                   | |  
//| .  . | _____   _____ _ __ ___   ___ _ __ | |_ 
//| |\/| |/ _ \ \ / / _ \ '_ ` _ \ / _ \ '_ \| __|
//| |  | | (_) \ V /  __/ | | | | |  __/ | | | |_ 
//\_|  |_/\___/ \_/ \___|_| |_| |_|\___|_| |_|\__|                                   
//handles directing which way pacman is going and making sure only one key can be down at once.
  public void movement()
  {
    if(up==true)
    {
      pathup();
      down = false;
      right = false;
      left = false;
    }
    if(down==true)
    {
      pathdown();
      up = false;
      right = false;
      left = false;
      
    }
    if(right==true)
    {
      pathright(); 
      up = false;
      down = false;
      left = false;
    }
    if(left==true)
    {
      pathleft(); 
      down = false;
      right = false;
      up = false;
    }
    
  }
// _____ _               _     ___  ___                                    _   
///  __ \ |             | |    |  \/  |                                   | |  
//| /  \/ |__   ___  ___| | __ | .  . | _____   _____ _ __ ___   ___ _ __ | |_ 
//| |   | '_ \ / _ \/ __| |/ / | |\/| |/ _ \ \ / / _ \ '_ ` _ \ / _ \ '_ \| __|
//| \__/\ | | |  __/ (__|   <  | |  | | (_) \ V /  __/ | | | | |  __/ | | | |_ 
// \____/_| |_|\___|\___|_|\_\ \_|  |_/\___/ \_/ \___|_| |_| |_|\___|_| |_|\__|
  
//Whole class checks before a move is exicuted to see if clear.
  public void checkMovement()
  {
    
    if(goup == true&& ( pac_y -1 != -1))
    {
      if (board[pac_x][(pac_y)-(1)] >= 1) {
        down = false;
        right = false;
        left = false;
        up = true;
        goright= false;
        goup = false;
        godown = false;
        goleft = false;
      }
    }
    
    if(godown== true && !( pac_y == 20 && pac_x == 9))
    {
      if (board[pac_x][(pac_y)+(1)] >= 1) {
        down = true;
        right = false;
        left = false;
        up = false;
        goright= false;
        goup = false;
        godown = false;
        goleft = false;
      }
    }
    if(goleft == true)
    {
      if (board[(pac_x)-(1)][(pac_y)] >= 1) {
        down = false;
        right = false;
        up = false;
        left = true;
        goright= false;
        goup = false;
        godown = false;
        goleft = false;
      }
    }
    
    if(goright == true)
    {
      if (board[pac_x+1][(pac_y)] >= 1) {
        right = true;
        down = false;
        left = false;
        up = false;
        goright= false;
        goup = false;
        godown = false;
        goleft = false;
      }
    }
  }
// _____ _               _      _____             _   
///  __ \ |             | |    /  ___|           | |  
//| /  \/ |__   ___  ___| | __ \ `--. _ __   ___ | |_ 
//| |   | '_ \ / _ \/ __| |/ /  `--. \ '_ \ / _ \| __|
//| \__/\ | | |  __/ (__|   <  /\__/ / |_) | (_) | |_ 
// \____/_| |_|\___|\___|_|\_\ \____/| .__/ \___/ \__|
//                                   | |              
//                                   |_|              
  //Class checks to see if current spot is equal to something in the board array.
  public void checkSpot()
  {
    //checks if there is a dot and adds 50 points to score if there is
    if (board[pac_x][(pac_y)] == 1) {
      board[pac_x][pac_y] = 2;
      playMoveSound();
      score = score + 10;
      pickup++;
    }
    if(board[pac_x][pac_y]==2){
      //playSound(".\\Sounds\\Pacman_Siren.wav");
    }
    //checks if spot is a power pellet spot. If so adds 2000 to points.
    if(board[pac_x][(pac_y)]==3){
      board[pac_x][pac_y] = 2;
      ghostrun = true;
      ghostruncount = 0;
      score = score + 200;
      pickup++;
    }
    //Checks spot to see if pacman has entered top tunnel. If so moves pac to bottom
    if(board[pac_x][pac_y] == 5)
    {
      pac_x = 9;
      pac_y = 19;
    }
    //Checks spot to see if pacman has entered bottom tunnel, if so moves pac to top
    if(board[pac_x][pac_y] == 6)
    {
      pac_x = 9;
      pac_y = 2;
    }
    if(board[pac_x][pac_y] == 7)
    {
      cherrygo = false;
      score = score + 200;
    }
    //checks score and adds lives if score is greater then 9999 and if lives is less then 3 (can't have more then 3 lives)
    if(score>=lifescore)
    {
      if(lives<=2)
      {
        lives++;
        lifescore = lifescore+10000;
        playSound(".\\Sounds\\Pacman_Extra_Live.wav");
      }
    }
    if(pickup>175)
      {
       level++;
       resetboard();
      }
  }
  //Get ghost target point
  public void target()
  {
    targetbluex = 0;
    targetbluey = 0;
    targetorangex = 0;
    targetorangey = 0;
    
    if(up==true){
      targetbluex = pac_y + 2;
      targetbluey = pac_x;
      targetorangex = pac_y + 1;
      targetorangey = pac_x;
    }else if(down==true){
      targetbluex = pac_y - 2;
      targetbluey = pac_x;
      targetorangex = pac_y - 1;
      targetorangey = pac_x;
    }else if(left==true){
      targetbluex = pac_y;
      targetbluey = pac_x - 2;
      targetorangex = pac_y;
      targetorangey = pac_x - 1;
    }else if(right==true){
      targetbluex = pac_y;
      targetbluey = pac_x + 2;
      targetorangex = pac_y;
      targetorangey = pac_x + 1;
    }
  }
  //Red Ghost AI
  public void redghost()
  {
    if(randomred==false){
    if(pac_x>ghost_red_x || pac_y>ghost_red_y){
      if(board[ghost_red_x+1][ghost_red_y]!=0&&board[ghost_red_x+1][ghost_red_y]!=-1){
        ghost_red_x++;
      }else if(board[ghost_red_x+1][ghost_red_y]==0||board[ghost_red_x+1][ghost_red_y]==-1){
        if(pac_y>ghost_red_y&&board[ghost_red_x][ghost_red_y+1]!=0&&board[ghost_red_x][ghost_red_y+1]!=-1){
         ghost_red_y++; 
        }else if(pac_y<ghost_red_y&&board[ghost_red_x][ghost_red_y-1]!=0&&board[ghost_red_x][ghost_red_y-1]!=-1){
         ghost_red_y--; 
        }
      }
    }else if(pac_x<ghost_red_x|| pac_y<ghost_red_y){
      if(board[ghost_red_x-1][ghost_red_y]!=0&&board[ghost_red_x-1][ghost_red_y]!=-1){
        ghost_red_x--;
      }else if(board[ghost_red_x-1][ghost_red_y]==0||board[ghost_red_x+1][ghost_red_y]==-1){
        if(pac_y>ghost_red_y&&board[ghost_red_x][ghost_red_y+1]!=0&&board[ghost_red_x][ghost_red_y+1]!=-1){
          ghost_red_y++; 
        }else if(pac_y<ghost_red_y&&board[ghost_red_x][ghost_red_y-1]!=0&&board[ghost_red_x][ghost_red_y-1]!=-1){
          ghost_red_y--; 
        }
      }
    }
    }
    //red ghost random movement
    if(randomred==true){
Random generator = new Random();
    int r3 = generator.nextInt(4);
    if(board[(ghost_red_x)][(ghost_red_y)-(1)] != 5&& board[(ghost_red_x)][(ghost_red_y)+(1)] != 6){
      if (board[(ghost_red_x)+(1)][(ghost_red_y)] >= 1||board[(ghost_red_x)+(1)][(ghost_red_y)] == -1){
        if(r3 == 0)
        {
          ghost_red_x++; 
        }
      }
      if (board[(ghost_red_x)-(1)][(ghost_red_y)] >= 1||board[(ghost_red_x)-(1)][(ghost_red_y)] == -1){
        if(r3 == 1)
        {
          ghost_red_x--;
        }
      }
      if (board[(ghost_red_x)][(ghost_red_y)-(1)] >= 1||board[(ghost_red_x)][(ghost_red_y)-(1)] == -1){
        if(r3 == 2)
        {
          ghost_red_y--;
        }
      }
      if (board[(ghost_red_x)][(ghost_red_y)+(1)] >= 1||board[(ghost_red_x)][(ghost_red_y)+(1)] == -1){
        if(r3 == 3)
        {
          ghost_red_y++;
        }
      }
    }else if(board[(ghost_red_x)][(ghost_red_y)-(1)] == 5){
      ghost_red_y=19;
      ghost_red_x=9;
    }else if(board[(ghost_red_x)][(ghost_red_y)+(1)] == 6)
    {
      ghost_red_y=2;
      ghost_red_x=9;
    }
    }
    }
  //Blue Ghost AI
  public void blueghost()
  {
    if(randomblue == false){
    if(targetbluex>ghost_teal_x || targetbluey>ghost_teal_y){
      if(board[ghost_teal_x+1][ghost_teal_y]!=0&&board[ghost_teal_x+1][ghost_teal_y]!=-1){
        ghost_teal_x++;
      }else if(board[ghost_teal_x+1][ghost_teal_y]==0||board[ghost_teal_x+1][ghost_teal_y]==-1){
        if(targetbluey>ghost_teal_y&&board[ghost_teal_x][ghost_teal_y+1]!=0&&board[ghost_teal_x][ghost_teal_y+1]!=-1){
          ghost_teal_y++; 
        }else if(targetbluey<ghost_teal_y&&board[ghost_teal_x][ghost_teal_y-1]!=0&&board[ghost_teal_x][ghost_teal_y-1]!=-1){
          ghost_teal_y--; 
        }
      }
    }else if(targetbluex<ghost_teal_x || targetbluey<ghost_teal_y){
      if(board[ghost_teal_x-1][ghost_teal_y]!=0&&board[ghost_teal_x-1][ghost_teal_y]!=-1){
        ghost_teal_x--;
      }else if(board[ghost_teal_x-1][ghost_teal_y]==0||board[ghost_teal_x+1][ghost_teal_y]==-1){
        if(targetbluey>ghost_teal_y&&board[ghost_teal_x][ghost_teal_y+1]!=0&&board[ghost_teal_x][ghost_teal_y+1]!=-1){
          ghost_teal_y++; 
        }else if(targetbluey<ghost_teal_y&&board[ghost_teal_x][ghost_teal_y-1]!=0&&board[ghost_teal_x][ghost_teal_y-1]!=-1){
          ghost_teal_y--; 
        }
      }
    }
    }
    //Teal ghost random movement
    if(randomblue == true){
      Random generator = new Random();
    int r2 = generator.nextInt(4);
    if(board[(ghost_teal_x)][(ghost_teal_y)-(1)] != 5&& board[(ghost_teal_x)][(ghost_teal_y)+(1)] != 6){
      if (board[(ghost_teal_x)+(1)][(ghost_teal_y)] >= 1||board[(ghost_teal_x)+(1)][(ghost_teal_y)] == -1){
        if(r2 == 0)
        {
          ghost_teal_x++; 
        }
      }
      if (board[(ghost_teal_x)-(1)][(ghost_teal_y)] >= 1||board[(ghost_teal_x)-(1)][(ghost_teal_y)] == -1){
        if(r2 == 1)
        {
          ghost_teal_x--;
        }
      }
      if (board[(ghost_teal_x)][(ghost_teal_y)-(1)] >= 1||board[(ghost_teal_x)][(ghost_teal_y)-(1)] == -1){
        if(r2 == 2)
        {
          ghost_teal_y--;
        }
      }
      if (board[(ghost_teal_x)][(ghost_teal_y)+(1)] >= 1||board[(ghost_teal_x)][(ghost_teal_y)+(1)] == -1){
        if(r2 == 3)
        {
          ghost_teal_y++;
        }
      }
    }else if(board[(ghost_teal_x)][(ghost_teal_y)-(1)] == 5 ){
      ghost_teal_y=19;
      ghost_teal_x=9;
    }else if(board[(ghost_teal_x)][(ghost_teal_y)+(1)] == 6)
    {
      ghost_teal_y=2;
      ghost_teal_x=9;
    }
    }
  }
  //Orange Ghost AI (Curremtly only random)
  public void orangeghost()
  {
    if(randomorange==false){
      
      
    }
    if(randomorange==true){
    Random generator = new Random();
    int r1 = generator.nextInt(4);
    if(board[(ghost_orange_x)][(ghost_orange_y)-(1)] != 5&& board[(ghost_orange_x)][(ghost_orange_y)+(1)] != 6){
      if (board[(ghost_orange_x)+(1)][(ghost_orange_y)] >= 1){
        if(r1 == 0)
        {
          ghost_orange_x++; 
        }
      }
      if (board[(ghost_orange_x)-(1)][(ghost_orange_y)] >= 1){
        if(r1 == 1)
        {
          ghost_orange_x--;
        }
      }
      if (board[(ghost_orange_x)][(ghost_orange_y)-(1)] >= 1){
        if(r1 == 2)
        {
          ghost_orange_y--;
        }
      }
      if (board[(ghost_orange_x)][(ghost_orange_y)+(1)] >= 1){
        if(r1 == 3)
        {
          ghost_orange_y++;
        }
      }
    }else if(board[(ghost_orange_x)][(ghost_orange_y)-(1)] == 5){
      ghost_orange_x = 9;
      ghost_orange_y = 19;
    }else if(board[(ghost_orange_x)][(ghost_orange_y)+(1)] == 6)
    {
      ghost_orange_x = 9;
      ghost_orange_y = 2;
    }
    }
  }
  //Pink Ghost only random currently
  public void pinkghost()
  {
    if(randompink==false){
      
    }
    
    if(randompink==true){
    Random generator = new Random();
    int r4 = generator.nextInt(4);
    //pink ghost movement
    if(board[(ghost_pink_x)][(ghost_pink_y)-(1)] != 5&& board[(ghost_pink_x)][(ghost_pink_y)+(1)] != 6){
      if (board[(ghost_pink_x)+(1)][(ghost_pink_y)] >= 1){
        if(r4 == 0)
        {
          ghost_pink_x++; 
        }
      }
      if (board[(ghost_pink_x)-(1)][(ghost_pink_y)] >= 1){
        if(r4 == 1)
        {
          ghost_pink_x--;
        }
      }
      if (board[(ghost_pink_x)][(ghost_pink_y)-(1)] >= 1){
        if(r4 == 2)
        {
          ghost_pink_y--;
        }
      }
      if (board[(ghost_pink_x)][(ghost_pink_y)+(1)] >= 1||board[(ghost_pink_x)][(ghost_pink_y)+(1)] == -1){
        if(r4 == 3)
        {
          ghost_pink_y++;
        }
      }
    }else if(board[(ghost_pink_x)][(ghost_pink_y)-(1)] == 5){
      ghost_pink_y=19;
      ghost_pink_x=9;
    }else if(board[(ghost_pink_x)][(ghost_pink_y)+(1)] == 6)
    {
      ghost_pink_y=2;
      ghost_pink_x=9;
    }
    }
  }
  //Handles game start for making ghosts exit start home
  public void redghostout()
  {
   if(hasgone==0)
   {
    ghost_red_y--; 
   }else if(hasgone==1)
    {
     ghost_red_x--; 
    }else if(hasgone==2)
    {
     ghost_red_x--;
    }
  }
  //Handles game start for making ghosts exit start home
    public void blueghostout()
    {
     if(hasgone==0)
     {
      ghost_teal_y++; 
     }else if(hasgone==1)
     {
      ghost_teal_y--; 
     }else if(hasgone==2)
     {
      ghost_teal_y--; 
     }else if(hasgone==3)
     {
      ghost_teal_y++; 
     }else if(hasgone==4)
     {
      ghost_teal_y++; 
     }else if(hasgone==5)
     {
      ghost_teal_y--; 
     }else if(hasgone==6)
     {
      ghost_teal_x--; 
     }else if(hasgone==7)
     {
      ghost_teal_x--; 
     }
    }
    //Handles game start for making ghosts exit start home
    public void orangeghostout()
    {
      if(hasgone==0)
     {
      ghost_orange_y++; 
     }else if(hasgone==1)
     {
      ghost_orange_y++; 
     }else if(hasgone==2)
     {
      ghost_orange_y--; 
     }else if(hasgone==3)
     {
      ghost_orange_y--; 
     }else if(hasgone==4)
     {
      ghost_orange_y++; 
     }else if(hasgone==5)
     {
      ghost_orange_y++; 
     }else if(hasgone==6)
     {
      ghost_orange_y--; 
     }else if(hasgone==7)
     {
      ghost_orange_y--; 
     }else if(hasgone==8)
     {
      ghost_orange_y++; 
     }else if(hasgone==9)
     {
      ghost_orange_y++; 
     }else if(hasgone==10)
     {
      ghost_orange_y--; 
     }else if(hasgone==11)
     {
      ghost_orange_y--; 
     }else if(hasgone==12)
     {
      ghost_orange_y++; 
     }else if(hasgone==13)
     {
      ghost_orange_y++; 
     }else if(hasgone==14)
     {
      ghost_orange_y--; 
     }else if(hasgone==15)
     {
      ghost_orange_y--;
     }else if(hasgone==16)
     {
      ghost_orange_y++; 
     }else if(hasgone==17)
     {
      ghost_orange_y++; 
     }else if(hasgone==18)
     {
      ghost_orange_y--; 
     }else if(hasgone==19)
     {
      ghost_orange_y--; 
     }else if(hasgone==20)
     {
      ghost_orange_y++; 
     }else if(hasgone==21)
     {
      ghost_orange_x--; 
     }else if(hasgone==22)
     {
      ghost_orange_x--; 
     }
    }
  
//______       _   _                 _____ _               _    
//| ___ \     | | | |               /  __ \ |             | |   
//| |_/ /_   _| |_| |_  ___  _ __   | /  \/ |__   ___  ___| | __
//| ___ \ | | | __| __|/ _ \| '_ \  | |   | '_ \ / _ \/ __| |/ /
//| |_/ / |_| | |_| |_| (_) | | | | | \__/\ | | |  __/ (__|   < 
//\____/ \__,_|\__|\__|\___/|_| |_|  \____/_| |_|\___|\___|_|\_\
//Used in gameover screen to check if buttons are pressed
  public void buttoncheck()
  {
//      93,218 
//      363,289 
//      95,299 
//      360,364 
//      96,381 
//      361,445
    if(run==false)
    {
      endscreen = true;
      scorein = 0;
      try
      {
        FileReader file = new FileReader("highscores.txt");
        Scanner s = new Scanner(file);
        scorein = s.nextInt();
        System.out.println(scorein);
        
      }catch(Exception e)
      {
        e.printStackTrace();
      }
      
      if(scorein<score){
        try
        {
          FileWriter file = new FileWriter("highscores.txt");
          PrintWriter out = new PrintWriter(file);
          
          int scorewrite = score;
          out.println(scorewrite);
          
          out.close();
        }catch(Exception e)
        {
          e.printStackTrace();
        }
        button=false;
        newhighscore=true;
      }else if(scorein>score){
        oldhighscore=true;
      }
      run=true;
    }
    
      if(ran1==false){
        if(clickX>93&&clickX<363&&clickY>218&&clickY<289)
        {
          System.out.println("Play Again Button Clicked");
          endscreen = false;
          ran1 = true;
          ran2 = true;
          ran3 = true;
          clickX=0;
          clickY=0;
          reset();
        }
      }
      if(ran2==false){
        if(clickX>93&&clickX<363&&clickY>299&&clickY<364)
        {
          System.out.println("Instructions Button Clicked");
          instructions=true;
          ran1 = true;
          ran2 = true;
          ran3 = true;
          clickX=0;
          clickY=0;
        }
      }
      if(ran3==false){
        if(clickX>93&&clickX<363&&clickY>291&&clickY<445)
        {
          System.out.println("High Scores Button Clicked");
          hse = true;
          ran1 = true;
          ran2 = true;
          ran3 = true;
          clickX=0;
          clickY=0;
        }
      }
    
  }
  public void startcheck()
  {
    if(haveyougone==false)
    {
      try
      {
        FileReader file = new FileReader("highscores.txt");
        Scanner s = new Scanner(file);
        scorein = s.nextInt();
        System.out.println(scorein);
        
      }catch(Exception e)
      {
        e.printStackTrace();
      }
      haveyougone = true;
    } 
    if(ran11==false)
    {
        if(clickX>93&&clickX<363&&clickY>218&&clickY<289)
        {
          start = false;
          ran11 = true;
          ran22 = true;
          ran33 = true;
          clickX=0;
          clickY=0;
        }
    }
    if(ran22==false)
    {
        if(clickX>93&&clickX<363&&clickY>299&&clickY<364)
        {
          instructions=true;
          ran11 = true;
          ran22 = true;
          ran33 = true;
        }
    }
    if(ran33==false)
    {
        if(clickX>93&&clickX<363&&clickY>291&&clickY<445)
        {
          hss = true;
          ran11 = true;
          ran22 = true;
          ran33 = true;
        }
    }
  }
  
  
// _____                       _ 
///  ___|                     | |
//\ `--.  ___  _   _ _ __   __| |
// `--. \/ _ \| | | | '_ \ / _` |
///\__/ / (_) | |_| | | | | (_| |
//\____/ \___/ \__,_|_| |_|\__,_|
  private void playSound(String file) {  
    try {   
      Clip sound = AudioSystem.getClip();   
      sound.open(AudioSystem.getAudioInputStream(getClass().getResource(file)));     
      sound.start();  
    } catch (UnsupportedAudioFileException e1) { }  
    catch (IOException e2) { }   
    catch (LineUnavailableException e3) { } 
  }
  
  
  private void playSirenSound() {  
    
    if(!sound2.isRunning())
    {
      sound2.start();  
    }
    if(sound2.getFramePosition() == sound2.getFrameLength())
    {
      sound2.setFramePosition(0);
    }
  }
  
  private void playMoveSound() {  
    
    if(!sound.isRunning())
    {
      sound.start();  
    }
    if(sound.getFramePosition() == sound.getFrameLength())
    {
      sound.setFramePosition(0);
    }
  }
  
  
  
  
//______             
//| ___ \            
//| |_/ /_   _ _ __  
//|    /| | | | '_ \ 
//| |\ \| |_| | | | |
//\_| \_|\__,_|_| |_|
  public void run()
  {
    
    //resizes pacmans and ghosts
       Random generator = new Random();
       int cherrytick = generator.nextInt(250)+100;
    for(int i=0; i < 4; i++)
    {
      ghostsprite[i] = ImageHelper.resize(ghostsprite[i],18,18);
    }
    for(int i=0; i < 3; i++)
    {
      pacright[i] = ImageHelper.resize(pacright[i],19,19);
    }
    for(int i=0; i < 3; i++)
    {
      pacleft[i] = ImageHelper.resize(pacleft[i],19,19);
    }
    for(int i=0; i < 3; i++)
    {
      pacup[i] = ImageHelper.resize(pacup[i],19,19);
    }
    for(int i=0; i < 3; i++)
    {
      pacdown[i] = ImageHelper.resize(pacdown[i],19,19);
    }
    while(true){    
      while(start==true)
      {
        startcheck();
        if(instructions==true)
        {
          if(clickX>9&&clickX<152&&clickY>414&&clickY<453)
          {
            start=true;
            instructions=false;
            ran11 = false;
            ran22 = false;
            ran33 = false;
            clickX=0;
            clickY=0;
          }
          if(clickX>296&&clickX<440&&clickY>414&&clickY<453)
          {
            start=false;
            instructions=false;
          }
        }
        
        if(hss==true)
        {
          if(clickX>9&&clickX<152&&clickY>414&&clickY<453)
          {
            start=true;
            hss=false;
            ran11 = false;
            ran22 = false;
            ran33 = false;
            clickX=0;
            clickY=0;
          }
          if(clickX>296&&clickX<440&&clickY>414&&clickY<453)
          {
            start=false;
            hss=false;
          }
        }
        repaint(); 
      }
      while(endscreen==true)
      {
        buttoncheck();
        if(instructions==true)
        {
          if(clickX>9&&clickX<152&&clickY>414&&clickY<453)
          {
            endscreen=true;
            instructions=false;
            ran1 = false;
            ran2 = false;
            ran3 = false;
            clickX=0;
            clickY=0;
          }
          if(clickX>296&&clickX<440&&clickY>414&&clickY<453)
          {
            start=false;
            endscreen = false;
            instructions=false;
          }
        }
        
        if(hse==true)
        {
          if(clickX>9&&clickX<152&&clickY>414&&clickY<453)
          {
            endscreen=true;
            hse=false;
            ran1 = false;
            ran2 = false;
            ran3 = false;
            clickX=0;
            clickY=0;
          }
          if(clickX>296&&clickX<440&&clickY>414&&clickY<453)
          {
            start=false;
            endscreen = false;
            hse=false;
          }
        }
        repaint();
      }
      try {   
        sound = AudioSystem.getClip();   
        sound.open(AudioSystem.getAudioInputStream(getClass().getResource(".\\Sounds\\pac_chomp.wav")));     
        sound2 = AudioSystem.getClip();   
        sound2.open(AudioSystem.getAudioInputStream(getClass().getResource(".\\Sounds\\Pacman_Siren.wav")));     
      } catch (UnsupportedAudioFileException e1) { }  
      catch (IOException e2) { }   
      catch (LineUnavailableException e3) { } 
      playSound(".\\Sounds\\Pacman_Opening.wav");
      
      while(start==false&&endscreen == false)
      {
        //Handling all the calls for various functions
        playSirenSound();
        //calls
        movement();
        checkMovement();
        checkSpot();
        target();
        if(hasgone>=3){
        redghost();
        }else if(hasgone<3)
        {
         redghostout(); 
        }
        if(hasgone>=8){
          blueghost();
        }else if(hasgone<8)
        {
         blueghostout(); 
        }
        if(hasgone>=23){
          orangeghost();
        }else if(hasgone<23){
          orangeghostout();
        }
        pinkghost();
        hasgone = hasgone + 0.5;

//For Pause Key
        while(paused == true)
        {
          try
          {
            Thread.sleep(500);
          }catch(Exception e)
          {
          }
          flop=!flop;
          repaint();
        }
        
        try
        {
          Thread.sleep(100);
        }catch(Exception e)
        {
        }
        //handles images animation for each direction
        if(moveup==true)
        {
          curImage=pacup[count];
          count++;
          if(count==3)
          {
            count = 0;
          }
        }else if(movedown==true)
        {
          curImage=pacdown[count];
          count++;
          if(count==3)
          {
            count = 0;
          }
        }else if(moveright==true)
        {
          curImage=pacright[count];
        }else if(moveleft==true)
        {
          curImage=pacleft[count];
        }
        //Checks if pacmans current postion is equal to any of the ghosts positions. From there handles the losse of a life
        if(ghostrun==false){
          if(safe==false){
            if(pac_x == ghost_orange_x && pac_y == ghost_orange_y || pac_x == ghost_teal_x &&pac_y == ghost_teal_y || pac_x == ghost_red_x && pac_y == ghost_red_y || pac_x == ghost_pink_x && pac_y == ghost_pink_y)
            {
              if(lives>0)
              {
                safe=true;
                playSound(".\\Sounds\\Pacman_Dies.wav");
                up=false;
                down=false;
                left=false;
                right=false;
                lives--;
                dead = true;
              }
            }
          }
        }else if(ghostrun==true){
          if(pac_x == ghost_orange_x && pac_y == ghost_orange_y)
          {
            ghost_orange_y = 9;
            ghost_orange_x = 7;
            score=score+400;
          }
          if(pac_x == ghost_teal_x &&pac_y == ghost_teal_y)
          {
            score=score+400;
            ghost_teal_y = 10;
            ghost_teal_x = 7;
          }
          if(pac_x == ghost_red_x && pac_y == ghost_red_y)
          {
            score=score+400;
            ghost_red_y = 11;
            ghost_red_x = 7;
          }
          if(pac_x == ghost_pink_x && pac_y == ghost_pink_y)
          {
            score=score+400;
            ghost_pink_x = 7;
            ghost_pink_y = 10;
          }
        }
        if(safe==true)
        {
          safecount++;
          if(safecount>8)
          {
            safe=false;
            safecount=0;
          }
        }
        if(ghostrun==true){
          ghostruncount++;
          randomred=true;
          randomblue=true;
          if(ghostruncount>80){
            ghostrun=false;
            randomred=false;
            randomblue=false;
            ghostruncount = 0;
          }
        }
        cherrytickstart++;
        if(cherrytickstart==cherrytick)
        {
          cherrygo=true;  
        }
        if(cherrygo==true)
        {
          if(board[9][13] == 1)
          {
            pickup = pickup + 1;
          }
          board[9][13] = 7;
        }
        repaint();
      }
    }
  }
// _   __             _____                _       
//| | / /            |  ___|              | |      
//| |/ /  ___ _   _  | |____   _____ _ __ | |_ ___ 
//|    \ / _ \ | | | |  __\ \ / / _ \ '_ \| __/ __|
//| |\  \  __/ |_| | | |___\ V /  __/ | | | |_\__ \
//\_| \_/\___|\__, | \____/ \_/ \___|_| |_|\__|___/
//             __/ |                               
//            |___/                                  
//key listener. Simple sets a boolean to true if specific key is pressed.
  public void keyPressed(KeyEvent e) {  
    int keyCode = e.getKeyCode();
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
    switch( keyCode ) 
    {     
      case KeyEvent.VK_UP:
        goup =true;
        break;     
      case KeyEvent.VK_DOWN:
        godown  =true;
        break;     
      case KeyEvent.VK_LEFT:
        goleft = true;
        break;   
      case KeyEvent.VK_RIGHT:
        goright =true;
        break;      
      case KeyEvent.VK_W:
        goup = true;
        break;
      case KeyEvent.VK_S:
        godown = true;
        break;
      case KeyEvent.VK_A:
        goleft = true;
        break;
      case KeyEvent.VK_D:
        goright = true;
        break;
      case KeyEvent.VK_P:
        paused= !paused;
        repaint();
        break;
    } 
  }  
  //simply sets boolean to false if specific key is released.
  public void keyReleased(KeyEvent e) {
    int keyCode = e.getKeyCode();
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
    switch( keyCode ) 
    {     
      case KeyEvent.VK_UP:
        goup =false;
        break;     
      case KeyEvent.VK_DOWN:
        godown  =false;
        break;     
      case KeyEvent.VK_LEFT:
        goleft = false;
        break;   
      case KeyEvent.VK_RIGHT:
        goright =false;
        break;      
      case KeyEvent.VK_W:
        goup = false;
        break;
      case KeyEvent.VK_S:
        godown = false;
        break;
      case KeyEvent.VK_A:
        goleft = false;
        break;
      case KeyEvent.VK_D:
        goright = false;
        break;
      case KeyEvent.VK_L:
        lives--;
        break;
      case KeyEvent.VK_K:
        lives++;
        break;
        
    } 
  }
  
  public void keyTyped(KeyEvent e) {
  }
//___  ___                       _____                _       
//|  \/  |                      |  ___|              | |      
//| .  . | ___  _   _ ___  ___  | |____   _____ _ __ | |_ ___ 
//| |\/| |/ _ \| | | / __|/ _ \ |  __\ \ / / _ \ '_ \| __/ __|
//| |  | | (_) | |_| \__ \  __/ | |___\ V /  __/ | | | |_\__ \
//\_|  |_/\___/ \__,_|___/\___| \____/ \_/ \___|_| |_|\__|___/
//Handles mouse events                                                            
  public void mouseClicked(MouseEvent paramMouseEvent){
    clickX = (int)paramMouseEvent.getPoint().getX();
    clickY = (int)paramMouseEvent.getPoint().getY();
    repaint(); // repaint the changed made to our picture
  }
  
  // the mouse has entered the screen
  public void mouseEntered(MouseEvent paramMouseEvent) {
  }
  // the mouse has left the screen
  public void mouseExited(MouseEvent paramMouseEvent) {
  }
  // a mouse button has been pressed down
  public void mousePressed(MouseEvent paramMouseEvent) {
  }
  // a mouse button has been released from being pressed
  public void mouseReleased(MouseEvent paramMouseEvent) {
  }
  // the mouse has changed position
  public void mouseMoved(MouseEvent paramMouseEvent) {
    // get the X and Y of where the mouse was moved 
  }
  // the mouse has clicked, moved, and released
  public void mouseDragged(MouseEvent paramMouseEvent) {
  }  
  public static void main(String[]args)throws Exception{ 
    pacman panel = new pacman();
    JFrame frame = new JFrame("Pacman");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.addKeyListener(panel);
    panel.addMouseListener(panel);
    //set window size
    frame.setSize(458,500);
    frame.setLocationRelativeTo(null);
    frame.getContentPane().add(panel);
    frame.setVisible(true);
    frame.setResizable(false);
    panel.run();
  }
}