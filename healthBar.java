import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class healthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class healthBar extends Actor
{
    /**
     * Act - do whatever the healthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health = 100;
    int time = 0;
    public healthBar()
    {
        setImage(new GreenfootImage(102,12));
        getImage().drawRect(0,0,101,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
    }
    public void act()
    {
        setImage(new GreenfootImage(102,12));
        getImage().drawRect(0,0,101,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        stickToPlayer();
        time++;
        loseHealth();
    }
    public void loseHealth()
    {
        World world = getWorld();
        scrollingWorld myWorld = (scrollingWorld)world;
        if(myWorld.getPlayer().hitByPeroro())
        {
            health--;
        }
        if (health<=0)
        {
            GreenfootImage dead = new GreenfootImage("ARIS ERROR!!", 40, Color.RED, new Color(0, 0, 0, 0));
            getWorld().getBackground().drawImage(dead, (getWorld().getWidth()-dead.getWidth())/2, (getWorld().getHeight()-dead.getHeight())/8);
            GreenfootImage status = new GreenfootImage("Sensei Bertahan Selama "+(time/60)+" Detik", 20, Color.WHITE, new Color(0, 0, 0, 0));
            getWorld().getBackground().drawImage(status, (getWorld().getWidth()-status.getWidth())/2, (getWorld().getHeight()-status.getHeight())/5);
            
            GreenfootImage play = new GreenfootImage("Tekan [Enter] Untuk Bermain Kembali\nTekan[Escape] untuk kembali ke main menu", 20, Color.GREEN, new Color(0, 0, 0, 0));
            getWorld().getBackground().drawImage(play, (getWorld().getWidth()-play.getWidth())/2, (getWorld().getHeight()-play.getHeight())/2);
            
            Greenfoot.delay(1000);
            
            if (Greenfoot.isKeyDown("enter"))
            {
                Greenfoot.setWorld(new scrollingWorld());
            }
            else if (Greenfoot.isKeyDown("escape"))
            {
                Greenfoot.setWorld(new StartScreen());
            }
            
        }
    }
    public void stickToPlayer()
    {
        World world = getWorld();
        scrollingWorld myWorld = (scrollingWorld)world;
        setLocation(myWorld.getPlayer().getX(), myWorld.getPlayer().getY()-70);
    }
}
