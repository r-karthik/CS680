package edu.umb.cs680.hw06;

public class DvdPlayer {

    private static DvdPlayer dvdplayer;
    private static State state;

    private DvdPlayer() {}

    public static DvdPlayer getInstance() {
        if (dvdplayer == null) {
            dvdplayer = new DvdPlayer();
            state = DrawerClosedNotPlaying.getInstance();
        }
        return dvdplayer;
    }

    public void changeState(State state) {
        DvdPlayer.state = state;
    }

    public void openCloseButtonPushed() {
        state.openCloseButtonPushed();
    }

    public void playButtonPushed() {
        state.playButtonPushed();

    }

    public void stopButtonPushed() {
        state.stopButtonPushed();

    }

    public void play() {
        System.out.println("Play");

    }

    public void open() {
        System.out.println("Open");

    }

    public void close() {
        System.out.println("Close");

    }

    public void stop() {
        System.out.println("Stop");

    }

    public static void main (String[] args) {
        DvdPlayer dvdplayer = DvdPlayer.getInstance();
        dvdplayer.openCloseButtonPushed();
        dvdplayer.playButtonPushed();
        dvdplayer.stopButtonPushed();
    }

    public State getState() {
        return this.state;
    }
}

