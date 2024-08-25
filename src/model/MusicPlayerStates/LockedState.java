package model.MusicPlayerStates;

import model.MusicPlayer;

public class LockedState implements IMusicPlayerState{
    MusicPlayer mPlayer;

    public LockedState(MusicPlayer mPlayer){
        this.mPlayer = mPlayer;
    }
    @Override
    public void play() {
        this.mPlayer.setState(new ReadyState(mPlayer));
    }

    @Override
    public void stop() {
        if (this.mPlayer.isPlaying()) {
            this.mPlayer.setIsPlayingMusic(false);
            this.mPlayer.setState(new ReadyState(mPlayer));
        }
        else{
            System.out.println("Travado");
        }
    }

    @Override
    public void next() {
        System.out.println("Irei fazer nada, pois está travado");
       
    }

    @Override
    public void previous() {
        System.out.println("Irei fazer nada, pois está travado");
    
    }

    @Override
    public String toString(){
        return "Player Locked";
    }

}
