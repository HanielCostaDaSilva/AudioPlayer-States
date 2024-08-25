package model;

import java.util.List;

import model.MusicPlayerStates.IMusicPlayerState;
import model.MusicPlayerStates.ReadyState;

public class MusicPlayer {

    private Boolean isPlayingmusic;
    private IMusicPlayerState state;
    private List<String> musicsToPlay;
    private int musicPlayingIndex = 0;

    public MusicPlayer(Boolean isPlayingmusic, List<String> musicList) {
        this.state = new ReadyState(this);
        this.isPlayingmusic = isPlayingmusic;
        this.musicsToPlay = musicList;
    }

    public void startPlayback() {
        String music = this.musicsToPlay.get(musicPlayingIndex);
        System.out.println(String.format("Agora Tocando: %s",music));
    }

    public void play() {
        this.state.play();
    }

    public void stop() {
        this.state.stop();
    }

    public void next() {
        this.state.next();
    }

    public void previous() {
        this.state.previous();
    }

    public boolean isPlaying() {
        return this.isPlayingmusic;
    }

    public boolean setIsPlayingMusic(Boolean isPlaying) {
        return this.isPlayingmusic = isPlaying;
    }

    /**
     * @return List<String> return the musicsToPlay
     */
    public List<String> getMusicsToPlay() {
        return musicsToPlay;
    }

    /**
     * @param musicsToPlay the musicsToPlay to set
     */
    public void setMusicsToPlay(List<String> musicsToPlay) {
        this.musicsToPlay = musicsToPlay;
    }

    /**
     * @return int return the musicPlayingIndex
     */
    public int getMusicPlayingIndex() {
        return musicPlayingIndex;
    }

    /**
     * @param musicPlayingIndex the musicPlayingIndex to set
     */

    public void setMusicPlayingIndex(int musicPlayingIndex) {

        this.musicPlayingIndex = musicPlayingIndex;
        this.startPlayback();

    }

    public void setState(IMusicPlayerState newState) {
        System.out.println(String.format("Mudando o estado de %s para %s", this.state, newState));
        this.state = newState;
    }

    public IMusicPlayerState getState() {
        return this.state;
    }

    public String getMusicPlaying() {
        return this.musicsToPlay.get(musicPlayingIndex);
    }
}
