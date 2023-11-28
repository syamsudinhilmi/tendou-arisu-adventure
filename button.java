import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class button extends Actor
{
    private World link;
    public button(String image, World link)
    {
        setImage(new GreenfootImage(image));
        this.link = link;
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(this.link);
            Greenfoot.playSound("RE Aoharu 8bit ver.wav");
        }
    }
}
