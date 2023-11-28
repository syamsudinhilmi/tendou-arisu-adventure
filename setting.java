import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class setting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class setting extends World
{

    GreenfootImage background;
    public setting()
    {    
        super(1366, 768, 1);
        background = new GreenfootImage("setting.png");
        this.getBackground().drawImage(background,0, 0);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("backspace"))
        {
            Greenfoot.setWorld(new StartScreen());
        }
    }
    
}
