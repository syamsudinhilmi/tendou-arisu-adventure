import greenfoot.*; 

/**
 * Write a description of class counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class counter extends Actor 
{
    int pyro;
    int gold;
    public counter()
    {
        setImage("Pyroxene.png");
        //getImage().scale(300,50);
    }

    public void act()
    {
        stickToPlayer();
        score();
        if (pyro == 100000)
        {
            Greenfoot.stop();
        }
    }

    public void stickToPlayer()
    {
        World world = getWorld();
        scrollingWorld myWorld = (scrollingWorld)world;
        setLocation(myWorld.getPlayer().getX()-500, myWorld.getPlayer().getX()-645);
    }
    public void score()
    {
        World world = getWorld();
        getWorld().showText(""+pyro ,getX()-80, getY());
        
        getWorld().showText(""+gold ,getX()+90, getY());        
        //GreenfootImage score = new GreenfootImage(""+gold, 25, Color.GREEN, new Color(0, 0, 0, 0));
        //getWorld().getBackground().drawImage(score, (getWorld().getWidth()-score.getWidth())/10, (getWorld().getHeight()-score.getHeight())/10);
    }
}
