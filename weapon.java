import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class weapon extends Actor
{
    /**
     * Act - do whatever the weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    weaponButton Upgrade;
    superPower Power;
    int superTimer;
    public weapon()
    {
        setImage("weapon.png");
        getImage().scale(110,25);
    }
    public weapon(weaponButton Upgrade, superPower Power)
    {
        this.Power = Power;
        this.Upgrade = Upgrade;
        setImage("weapon.png");
        getImage().scale(110,25);
    }
    public void act()
    {
        turnAround();
        playerBullet();
        stickToPlayer();
        PowerUsed();
    }
    public void turnAround()
    {
        if (Greenfoot.getMouseInfo() != null)
        turnTowards(Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
    }
    public void playerBullet()
    {
        if (Greenfoot.mousePressed(null) && Upgrade.weaponUpgrade == 1)
        {
            playerBullet bullet = new playerBullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation());
            Greenfoot.playSound("ammo.wav");
            bullet.move(25);
        }
        if (Greenfoot.mousePressed(null) && Upgrade.weaponUpgrade == 2)
        {
            playerBullet bullet = new playerBullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation()-5);
            Greenfoot.playSound("ammo.wav");
            bullet.move(20);
            
            playerBullet bullet2 = new playerBullet();
            getWorld().addObject(bullet2, getX(), getY());
            bullet2.setRotation(getRotation()+5);
            bullet2.move(20);
        }
        if (Greenfoot.mousePressed(null) && Upgrade.weaponUpgrade == 3)
        {
            playerBullet bullet = new playerBullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation()-5);
            Greenfoot.playSound("ammo.wav");
            bullet.move(20);
            
            playerBullet bullet2 = new playerBullet();
            getWorld().addObject(bullet2, getX(), getY());
            bullet2.setRotation(getRotation()+5);
            bullet2.move(20);
            
            playerBullet bullet3 = new playerBullet();
            getWorld().addObject(bullet3, getX(), getY());
            bullet3.setRotation(getRotation());
            bullet3.move(20);
        }
    }
    public void PowerUsed()
    {
        if(Power.superCount>99 && superTimer <30)
        {
            playerBullet bullet = new playerBullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation()-60);
            bullet.move(20);
            
            playerBullet bullet2 = new playerBullet();
            getWorld().addObject(bullet2, getX(), getY());
            bullet2.setRotation(getRotation()+60);
            bullet2.move(20);
            
            playerBullet bullet3 = new playerBullet();
            getWorld().addObject(bullet3, getX(), getY());
            bullet3.setRotation(getRotation());

            bullet3.move(20);
            
            playerBullet bullet4 = new playerBullet();
            getWorld().addObject(bullet4, getX(), getY());
            bullet4.setRotation(getRotation()-180);
            bullet4.move(20);
            
            playerBullet bullet5 = new playerBullet();
            getWorld().addObject(bullet5, getX(), getY());
            bullet5.setRotation(getRotation()+120);
            bullet5.move(20);
            
            playerBullet bullet6 = new playerBullet();
            getWorld().addObject(bullet6, getX(), getY());
            bullet6.setRotation(getRotation()-120);
            bullet6.move(20);
            superTimer++;
        }
        if(superTimer>29)
        {
            Power.superCount = 0;
            superTimer =0;
        }
    }
    public void stickToPlayer()
    {
        World world = getWorld();
        scrollingWorld myWorld = (scrollingWorld)world;
        setLocation(myWorld.getPlayer().getX()+5, myWorld.getPlayer().getY()+27);
    }
}
