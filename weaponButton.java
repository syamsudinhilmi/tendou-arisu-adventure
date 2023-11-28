import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class upgradeWeapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class weaponButton extends Actor
{
    /**
     * Act - do whatever the upgradeWeapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    counter Counter;
    int weaponUpgrade = 1;
    public weaponButton(counter Counter)
    {
        this.Counter = Counter;
        setImage(new GreenfootImage("Tekan [Q] untuk \nUPGRADE WEAPON", 20, Color.WHITE, new Color(0,0,0,0)));
    }
    public void act()
    {
        stickToPlayer();
        if (Greenfoot.isKeyDown("q") && Counter.gold > 99)
        {
            Counter.gold = Counter.gold -= 100;
            weaponUpgrade++;
        }
    }
    public void stickToPlayer()
    {
        World world = getWorld();
        scrollingWorld myWorld = (scrollingWorld)world;
        setLocation(myWorld.getPlayer().getX()+600, myWorld.getPlayer().getX()-640);
    }
}
