package model.MusicPlayerStates;

import model.MusicPlayer;

public class ReadyState implements IMusicPlayerState{
    MusicPlayer mPlayer;

    public ReadyState(MusicPlayer mPlayer){
        this.mPlayer = mPlayer;
    }

    public void play() {
        // Se receber o evento play, muda para o estado de playing e inicia o playback; 
        this.mPlayer.setState(new PlayingState(mPlayer));
        this.mPlayer.setIsPlayingMusic(true);
    }
    
    public void stop() {
        // Se receber o evento stop, muda para o estado de locked; 
        this.mPlayer.setState(new LockedState(mPlayer));
    }

    public void next() {
        // Se receber o evento next, não faz nada, pois está travado;

        System.out.println("Irei fazer nada, pois está travado");
    }

    public void previous() {
        // Se receber o evento previous, não faz nada, pois está travado 
        System.out.println("Irei fazer nada, pois está travado");
    }

    @Override
    public String toString(){
        return " Player Ready";
    }
}
