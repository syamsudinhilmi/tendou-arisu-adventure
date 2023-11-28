import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class peroro extends enemy
{
    int health = 10;
    alice player;
    counter Counter;
    public peroro(alice mainPlayer, counter Counter)
    {
        this.Counter = Counter;
        player = mainPlayer;
        setImage("perorosama01.png");
    }
    public void act()
    {
        moveAround();
        hitByBullet();
    }
    public void moveAround()
    {
        move(2);
        turnTowards(player.getX(), player.getX());
    }
    public void hitByBullet()
    {
        Actor bullet = getOneIntersectingObject(playerBullet.class);
        if (bullet != null)
        {
            health--;
            getWorld().removeObject(bullet);
        }
        if (health == 0)
        {
            Counter.pyro++;
            Counter.gold+=15;
            Greenfoot.playSound("kill.wav");
            getWorld().removeObject(this);
        }
    }
}
