package model.MusicPlayerStates;

import model.MusicPlayer;

public class PlayingState implements IMusicPlayerState{
    MusicPlayer mPlayer;

    public PlayingState(MusicPlayer mPlayer){
        this.mPlayer = mPlayer;
    }

    @Override
    public void play() {
        // Se receber o evento play, muda para o estado de ready e pausa a reprodução; 
        this.mPlayer.setState(new ReadyState(mPlayer));
        System.out.println(String.format("Trilha Sonora %s parada... ",
        this.mPlayer.getMusicPlaying()));

        this.mPlayer.setIsPlayingMusic(false);
    }

    @Override
    public void stop() {
        // Se receber o evento stop, muda para o estado de locked e para a reprodução. Além disso, armazena a trilha corrente que estava sendo reproduzida;
        this.mPlayer.setState(new LockedState(mPlayer));
        System.out.println(String.format("Trilha Sonora %s parada... ",
        this.mPlayer.getMusicPlaying()));

        this.mPlayer.setIsPlayingMusic(false);
    }

    @Override
    public void next() {
        //   Se receber o evento next, avança para a próxima música; 
        System.out.println("Indo para a próxima música...");
        int index = (this.mPlayer.getMusicPlayingIndex() + 1) % this.mPlayer.getMusicsToPlay().size();
        this.mPlayer.setMusicPlayingIndex(index);

    }

    @Override
    public void previous() {
        // Se receber o evento previous, retorna à música anterior 
        System.out.println("Indo para a música anterior...");
        int limite = this.mPlayer.getMusicsToPlay().size();
        int index = (this.mPlayer.getMusicPlayingIndex() - 1) % this.mPlayer.getMusicsToPlay().size();
        index = (index<0? limite - 1: index);
         
        this.mPlayer.setMusicPlayingIndex(index);
    }

    @Override
    public String toString(){
        return "Player Playing";
    }
    
}
