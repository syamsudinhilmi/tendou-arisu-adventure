import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class alice extends Actor
{
    private final int gravitasi = 1;
    private int kecepatan;
    weaponButton Upgrade;

    public alice()
    {
        setImage("rAlice.png");
    }
    
    public void act()
    {
        jatuh();
        hitByPeroro();
        move();
        yuzuBoss();
    }

    public void move()
    {
        scrollingWorld myWorld;
        myWorld = (scrollingWorld)getWorld();

        if (Greenfoot.isKeyDown("a"))
        {
            myWorld.changeBackgroundX(-7);
            setImage("lAlice.png");
        } else if (Greenfoot.isKeyDown("d"))
        {
            myWorld.changeBackgroundX(7);
            setImage("rAlice.png");
        }
        if (Greenfoot.isKeyDown("space") && getY()>getWorld().getHeight() - 95)lompat();
    }

    public void jatuh()
    {
        setLocation(getX(),getY()+kecepatan);
        if (getY()>getWorld().getHeight() - 95) kecepatan =0;
        else kecepatan +=gravitasi;
    }

    public void lompat() 
    {
        kecepatan = -30;
    }

    public boolean hitByPeroro()
    {
        Actor Peroro = getOneObjectAtOffset(0,0, peroro.class);
        if (Peroro!=null)
        {
            return true;
            
        }
        else 
        return false;
    }
    public void yuzuBoss()
    {
        Actor yuzu = getOneIntersectingObject(yuzu.class);
        if (yuzu!=null)
        {
            Greenfoot.setWorld(new yuzuBossStage());
        }
        
    }
}
