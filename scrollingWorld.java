import greenfoot.*;

import java.util.*;

public class scrollingWorld extends World
{
    GreenfootImage background;
    int count = 0;
    int backgroundX;

    int spawnSpeed = 50;
    int randSpawn;

    public alice mainPlayer = new alice();
    public weapon Weapon = new weapon();
    counter Counter = new counter();
    healthBar HealthBar = new healthBar();
    weaponButton Upgrade = new weaponButton(Counter);
    superPower Power = new superPower();
    public scrollingWorld()
    {    
        super(1366, 768, 1, false);
        background = new GreenfootImage("endlessbg.png");
        this.getBackground().drawImage(background,0, 0);
        this.fillWorld();
        
        Weapon = new weapon(Upgrade, Power);
        addObject(Weapon, mainPlayer.getX()+5, mainPlayer.getY()+27);
        addObject(Counter, mainPlayer.getX()-500, mainPlayer.getX()-645);
        addObject(HealthBar, mainPlayer.getX(), mainPlayer.getY()-70);
        addObject(Upgrade, mainPlayer.getX()+600, mainPlayer.getX()-640);
        addObject(Power, mainPlayer.getX()-605, mainPlayer.getX()-600);
    }

    public alice getPlayer()
    {
        return mainPlayer;
    }

    public void act()
    {
        drawBackground();
        count++;
        spawnPeroro();
        if(Greenfoot.isKeyDown("backspace"))
        {
            Greenfoot.setWorld(new StartScreen());
        }
    }

    public void spawnPeroro()
    {
        if (count % spawnSpeed == 0)
        {
            randSpawn = Greenfoot.getRandomNumber(4);
            switch(randSpawn) 
            {
                case 0 : addObject(new peroro(mainPlayer, Counter),100,680); break; 
                case 1 : addObject(new peroro(mainPlayer, Counter),1266,680);break;
                case 2 : addObject(new peroro(mainPlayer, Counter),100,300);break;
                case 3 : addObject(new peroro(mainPlayer, Counter),1266,300);break;
            }
        }
    }

    private void fillWorld()
    {
        alice alice = new alice();
        addObject(mainPlayer,683,677);

        yuzu yuzu = new yuzu();
        addObject(yuzu,15000,677);
    }

    public void drawBackground()
    {
        getBackground().drawImage(background, backgroundX, 0);
    }

    public void changeBackgroundX(int changeX)
    {
        backgroundX = backgroundX - changeX;

        for (int counter = 0; counter < giveMeAllActors().size(); counter++)
        {
            if (giveMeAllActors().get(counter).getClass() !=alice.class)
            {
                this.giveMeAllActors().get(counter).setLocation(
                this.giveMeAllActors().get(counter).getX() - changeX,
                this.giveMeAllActors().get(counter).getY());
            }
       }

    }

    public List<Actor> giveMeAllActors()
    {
        List<Actor> allActors;
        allActors = this.getObjects(Actor.class);
        return allActors;
    }

}
