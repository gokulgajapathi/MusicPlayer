package com.gokul;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {



        Album album = new Album("Remo","Ani");
        album.addSong("Come Closer (Sirikkadhey -Reprise)",4.5);
        album.addSong("Daavuya Oviya No Venamya",5.6);
        album.addSong("Meesa Beauty Iva Thillalangadi Party",4.8);
        albums.add(album);

        album = new Album("Album2","Eminem");
        album.addSong("Rap god",4.5);
        album.addSong("Not Afraid",5.6);
        album.addSong("Lose Yourself",4.8);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlayList("Come Closer (Sirikkadhey -Reprise)",playList_1);
        albums.get(0).addToPlayList("Daavuya Oviya No Venamya",playList_1);
        albums.get(1).addToPlayList("Not Afraid",playList_1);
        albums.get(1).addToPlayList("Lose Yourself",playList_1);
        
        play(playList_1);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This Playlist have no song");
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = sc.nextInt();//user input
            sc.nextLine();

            switch (action){

                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    } else {
                        System.out.println("No song available, reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    } else {
                        System.out.println("We are the first song ");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing" +listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("we are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()){
                            System.out.println("Now playing"+listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached to the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() >0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing"+ listIterator.next().toString());
                        } else {
                            if (listIterator.hasPrevious())
                                System.out.println("Now playing"+ listIterator.previous().toString());
                        }
                    }
            }
        }
    }
    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0- to quit\n"+
                "1- to play next song\n"+
                "2- to play previous song\n"+
                "3- to replace the current song\n"+
                "4- list of all songs\n"+
                "5- print all the available options\n"+
                "6- delete current song");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("---------------------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("---------------------------");
    }
}
