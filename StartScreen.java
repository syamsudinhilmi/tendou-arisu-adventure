import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    GreenfootImage background;
    public StartScreen()
    {    
        super(1366, 768, 1); 
        background = new GreenfootImage("endlessbg.png");
        this.getBackground().drawImage(background,0, 0);
        prepare();
    }
    
    private void prepare()
    {
        startOrnament startOrnament = new startOrnament();
        addObject(startOrnament,683,384);
        
        button playButton = new button("mulai.png", new scrollingWorld());
        addObject(playButton, 683, 384);
        
        button optButton = new button("kontrol.png", new setting());
        addObject(optButton, 683, 384+50);
        
        
        
    }
}
