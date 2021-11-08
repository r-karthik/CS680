package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State {

    private static DrawerClosedPlaying drawerClosedPlaying;
    private DvdPlayer dvdplayer;

    private DrawerClosedPlaying() {
        dvdplayer = DvdPlayer.getInstance();
    }

    static DrawerClosedPlaying getInstance() {
        if (drawerClosedPlaying == null)
            drawerClosedPlaying = new DrawerClosedPlaying();
        return drawerClosedPlaying;
    }

    @Override
    public void playButtonPushed() {
        System.out.println("DVD Player is playing");
    }

    @Override
    public void openCloseButtonPushed() {
        System.out.print("Start Playing");
        dvdplayer.stop();
        dvdplayer.open();
        dvdplayer.changeState(DrawerOpen.getInstance());
    }

    @Override
    public void stopButtonPushed() {
        dvdplayer.stop();
        dvdplayer.changeState(DrawerClosedNotPlaying.getInstance());
        System.out.print("DVD Player is Stopped");

    }
}


