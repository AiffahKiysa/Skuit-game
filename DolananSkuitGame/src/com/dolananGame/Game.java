package com.dolananGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class Game extends State{
    private Player player;
    private Background bg;
    private Robot robot;
    private Button home, replay;
    private BufferedImage homeImage, replayImage, gameOver;

    private boolean isLose;
    int Timer = 20;     // random timer
    int time = 0;

    ArrayList<PlayerBullet> playerBullets = new ArrayList<PlayerBullet>();
    ArrayList<EnemyBullet> enemyBullets = new ArrayList<EnemyBullet>();
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    ArrayList<Explosion> explosions = new ArrayList<Explosion>();

    int[] level = new int[] {5, 10, 15};
    private int enemyCounter;
    private Score score;
    private HP healthPoint;
    boolean isHold;

    public Game(Manager sm) {
        this.sm = sm;
        this.isLose = false;

        int x = (WIDTH/2) + (27/2);
        int y = (HEIGHT/2) + (27/2);

        player = new Player(Color.BLUE, 0,0);
        bg = new Background(0,0, WIDTH, HEIGHT, Color.BLACK);
        score = new Score();
        healthPoint = new HP();

        try{
            homeImage = ImageIO.read(new File("resource/home.png"));
            replayImage = ImageIO.read(new File("resource/replay.png"));
            gameOver = ImageIO.read(new File("resource/game-over.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        home = new Button(homeImage, WIDTH - 100, 25, 50, 50, 0);
        this.isHold = false;
        try{
            this.robot = new Robot();
            robot.mouseMove(x,y);
        }catch (Exception e){
            e.printStackTrace();
        }
        replay = new Button(replayImage, WIDTH/2 - 50, HEIGHT/2 + 20, 100, 100, 0);
    }

    @Override
    public void update() {
        if (!isLose){
            Random rand = new Random();
            for (int i = 0; i < explosions.size(); i++){
                if (explosions.get(i).counter != 0) {
                	explosions.remove(i);
                }
            }
            for (int i = 0; i < playerBullets.size(); i++){
                boolean tag = false;
                Bullet b = playerBullets.get(i);
                if (b.y + 40 < 0){
                    playerBullets.remove(i);
                }else {
                    for (int j = 0; j < enemies.size() && tag == false; j++){
                        Enemy e = enemies.get(j);
                        if (e.bulletHit(playerBullets.get(i))){
                            explosions.add(new Explosion(e.x + e.width/2, e.y + e.height/2));
                            enemies.remove(j);
                            playerBullets.remove(i);
                            tag = true;
                            score.addValue();
                            enemyCounter--;
                            healthPoint.increase(2);
                        }
                    }
                }
                b.move();
            }
            if (time >= Timer && enemyCounter < level[0]){
                enemies.add(new Enemy(Color.RED, WIDTH));
                time = 0;
                Timer = rand.nextInt(30 + 1) + 10;
                enemyCounter++;
            }

            for (int i = 0; i < enemies.size(); i++){
                Enemy e = enemies.get(i);
                e.move();
                e.shootTimer++;
                if (e.y > HEIGHT){
                    enemies.remove(i);
                    healthPoint.decrease(5);
                    enemyCounter--;
                }
                if (e.shootTimer >= 70){
                    enemyBullets.add(new EnemyBullet(e.x + e.width/2 - 2, e.y + e.height/2 , -15));
                    e.shootTimer = 0;
                }
            }

            for (int i = 0; i < enemyBullets.size(); i++){
                Bullet b = enemyBullets.get(i);
                if (b.y > HEIGHT){
                    enemyBullets.remove(i);
                }
                if (player.bulletHit(b)){
                    healthPoint.decrease(10);
                    if (enemyBullets.get(i) != null){
                        enemyBullets.remove(i);
                    }
                }
                b.move();
            }

            time++;
            if(healthPoint.getHealthPoint() == 0) this.isLose = true;
        }
    }

    @Override
    public void draw(Graphics g) {
        bg.draw(g);
        player.draw(g);
        for (Bullet b : playerBullets){
            b.draw(g);
        }
        for (Bullet b : enemyBullets){
            b.draw(g);
        }
        for (Enemy e : enemies){
            e.paint(g);
        }
        for (Explosion e : explosions){
            e.paint(g);
        }
        if (!isLose) home.draw(g);

        healthPoint.paint(g);
        score.paint(g);
        if (isLose){
            Color c = new Color(0,0,0,230);
            Font font = new Font("Minecraft", Font.PLAIN, 30);
            g.setColor(c);
            g.fillRect(0,0,WIDTH, HEIGHT);
            g.drawImage(gameOver, WIDTH/2 - 597/2, 100, 597, 103, null);
            g.setColor(Color.WHITE);
            g.setFont(font);
            g.drawString("Final score " + score.getValue(), WIDTH/2 - 100, 250);
            replay.draw(g);
        }
    }

    @Override
    public void Dragged(MouseEvent e) {
        if (!isLose) {
            int x = e.getX();
            int y = e.getY();
            player.x = x;
            player.y = y;
            player.minX = x - player.width / 2;
            player.minY = y - player.height / 2;
        }
    }

    @Override
    public void Moved(MouseEvent e) {
        if (!isLose) {
            // TODO Auto-generated method stub
            int x = e.getX();
            int y = e.getY();
            player.x = x;
            player.y = y;
            player.minX = x - player.width / 2;
            player.minY = y - player.height / 2;
        }
    }

    @Override
    public void Clicked(MouseEvent e) {

    }

    @Override
    public void Pressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        this.isHold = true;
        if(!isLose) this.playerBullets.add(new PlayerBullet(x - 2, y, 25));
        home.Clicked(x, y, sm);
        if(isLose) replay.Clicked(x, y, sm);
    }

    @Override
    public void Released(MouseEvent e) {
        this.isHold = false;
    }

    @Override
    public void Entered(MouseEvent e) {

    }

    @Override
    public void Exited(MouseEvent e) {

    }
}
