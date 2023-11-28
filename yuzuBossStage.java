import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class yuzuBossStage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class yuzuBossStage extends World
{
    GreenfootImage background;
    int count = 0;
    int backgroundX;

    int spawnSpeed = 50;
    int randSpawn;

    weapon Weapon = new weapon();
    counter Counter = new counter();
    healthBar HealthBar = new healthBar();
    public yuzuBossStage()
    {    
        super(1366, 768, 1, false);
        background = new GreenfootImage("endlessbgBoss.png");
        this.getBackground().drawImage(background,0, 0);
    }

    public void act()
    {
        drawBackground();
        count++;
    }

    public void drawBackground()
    {
        getBackground().drawImage(background, backgroundX, 0);
    }

    public void changeBackgroundX(int changeX)
    {
        backgroundX = backgroundX - changeX;

        for (int counter = 0; counter < giveMeAllActors().size(); counter++)
        {
            if (giveMeAllActors().get(counter).getClass() !=alice.class)
            {
                this.giveMeAllActors().get(counter).setLocation(
                    this.giveMeAllActors().get(counter).getX() - changeX,
                    this.giveMeAllActors().get(counter).getY());
            }
        }

    }

    public List<Actor> giveMeAllActors()
    {
        List<Actor> allActors;
        allActors = this.getObjects(Actor.class);
        return allActors;
    }
}
