package assessment;

import javax.swing.*;

public class Album {
    private String name;
    private Song[] tracks;
    private String producer;
    private int releaseYear;

    public Album(String name, Song[] tracks,String producer,int releaseYear){
        setTracks(tracks);
        setName(name);
        setProducer(producer);
        setReleaseYear(releaseYear);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Song[] getTracks() {

            return tracks;

    }

    public void setTracks(Song[] tracks) {
        this.tracks = tracks;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getNumberOfTracks(){
        int num=0;
        for(int i=0;i<getTracks().length;i++)
        {
            num++;
        }
        return num;
    }

    public int getPlayingTime(){
        int num=0;
        for(int i=0;i<tracks.length;i++)
        {
            num += getTracks()[i].getDuration();
        }


        return num;
    }

    public void playTrack(int choice)
    {
        JOptionPane.showMessageDialog(null,"Now playing track - details are as follows\n"+getTracks()[choice-1]);

    }

    public void shuffle(Song[] songs){
        Song[] songHolder = new Song[songs.length];
        int lowerBound = 1;
        int upperBound = songs.length;
        int randomNum;
        for(int i=0;i<songs.length;)
        {
            randomNum = lowerBound+(int)(Math.random()*((upperBound-lowerBound)-1));
            if(songHolder[randomNum]==null)
            {
                songs[i] = songHolder[randomNum];
                i++;
            }
        }
        String str="";
        for(int i=0;i<songHolder.length;i++)
        {
             str += songHolder[i].toString();
        }

        JOptionPane.showMessageDialog(null,"Shuffled playlist is as follows: \n"+str,"Shuffled playlist",JOptionPane.INFORMATION_MESSAGE);

    }

    public String toString(){
        String str = "Name: " + getName() + "\n\nYear: "+getReleaseYear()+"\n\nProducer: "+getProducer()
                +"\n\nNumber of tracks: "+getNumberOfTracks()+"\n\nTotal playing time: "+getPlayingTime()+" seconds\n\n";

        str += String.format("%35s","Album tracks\n\n");
        str += String.format("%-20s%-25s%-20s","Track number","Title","Artist\n");
        for(int i=0;i<tracks.length;i++)
        {
            str += "\n"+String.format("%-20d%-25s%-20s",tracks[i].getTrackNumber(),tracks[i].getTitle(),tracks[i].getArtist())+"\n";
        }
        return str;
    }

}
