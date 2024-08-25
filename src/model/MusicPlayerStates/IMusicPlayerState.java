package model.MusicPlayerStates;

public interface IMusicPlayerState {
    
    public void play();
    public void stop();
    public void next();
    public void previous();

    public String toString();

}
