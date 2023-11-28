import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playerBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playerBullet extends Actor
{
    /**
     * Act - do whatever the playerBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public playerBullet()
    {
        setImage("pBullet.png");
    }
    public void act()
    {
        move(25);
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
