package edu.umb.cs680.hw06;

public class DrawerClosedNotPlaying implements State {

    private static DrawerClosedNotPlaying drawerClosedNotPlaying;
    private DvdPlayer dvdplayer;

    private DrawerClosedNotPlaying() {
        dvdplayer = DvdPlayer.getInstance();
    }

    public static DrawerClosedNotPlaying getInstance() {
        if (drawerClosedNotPlaying == null)
            drawerClosedNotPlaying = new DrawerClosedNotPlaying();

        return drawerClosedNotPlaying;
    }

    @Override
    public void playButtonPushed() {
        System.out.print("DVD Player Closed");
        dvdplayer.play();
        dvdplayer.changeState(DrawerClosedPlaying.getInstance());
    }

    @Override
    public void openCloseButtonPushed() {
        dvdplayer.open();
        dvdplayer.changeState(DrawerOpen.getInstance());
        System.out.print("DVD PLayer Opened");
    }

    @Override
    public void stopButtonPushed() {
        System.out.print("DVD Player stopped");

    }
}