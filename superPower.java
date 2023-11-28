import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class superPower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class superPower extends Actor
{
    /**
     * Act - do whatever the superPower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    final int Super_Power_Limit = 100;
    int superCount;
    int count;
    public superPower()
    {
        setImage(new GreenfootImage(Super_Power_Limit + 2,12));
        getImage().drawRect(0,0,Super_Power_Limit + 1,11);
        getImage().setColor(Color.CYAN);
        getImage().fillRect(1,1,superCount,10);
    }
    public void act()
    {
        setImage(new GreenfootImage(Super_Power_Limit + 2,12));
        getImage().drawRect(0,0,Super_Power_Limit + 1,11);
        getImage().setColor(Color.CYAN);
        getImage().fillRect(1,1,superCount,10);
        stickToPlayer();
        useSuper();

    }
    public void stickToPlayer()
    {
        World world = getWorld();
        scrollingWorld myWorld = (scrollingWorld)world;
        setLocation(myWorld.getPlayer().getX()-605, myWorld.getPlayer().getX()-600);
    }
    public void useSuper()
    {
        count++;
        if(count %5 == 0)
        superCount++;
    }
}
