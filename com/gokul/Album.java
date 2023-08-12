package com.gokul;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public Album() {
    }
    //To find song in the Songs list
    public Song findSong(String title) {
        if (songs != null) {
            for (Song checkedSong : songs) {

                if (checkedSong.getTitle().equals(title)) return checkedSong;

            }
        }
            return null;

    }
    //add songs on the album
    public boolean addSong(String title, double duration){
        if(findSong(title) == null) {
            songs.add(new Song(title, duration));
            System.out.println(title + " successfully added to the list");
            return true;
        }
            System.out.println("Song with name "+title+" already exist in the list");
            return false;
    }
    //overloading to add song to playlist from album with trackNumber
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> PlayList){
        int index = trackNumber - 1;

        if(index > 0 && index <= this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }
        System.out.println("this album does not have song with tracknumber"+trackNumber);
        return false;
    }
    //overloading to add song to playlist from album with title
    public boolean addToPlayList(String title, LinkedList<Song> PlayList){
        for(Song checkedSong : this.songs){
            if(checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
        System.out.println(title+"there is no such song in the album");
        return false;
    }
}
