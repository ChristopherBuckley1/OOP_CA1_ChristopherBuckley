package assessment;

import javax.swing.*;
import java.awt.*;

public class TestAlbum {
    public static void main(String[] args) {
        Song s1 = new Song("Sugar Baby Love", "Rubettes", "Pop", 136, 1977);
        Song s2 = new Song("Living on a Prayer", "Bon Jovi", "Rock", 184, 1985);
        Song s3 = new Song("Blue Suede Shoes","Elvis Presley","Pop",157,1963);
        Song s4 = new Song("Someone Like You", "Adele","Pop", 223, 2013);
        Song s5 = new Song("House of Fun", "Madness", "Pop", 178, 1984 );

        Song songs[] = new Song[5];

        songs[0] = s1;
        songs[1] = s2;
        songs[2] = s3;
        songs[3] = s4;
        songs[4] = s5;


        TextArea textArea = new TextArea(35,70);
        Font font = new Font("monospaced",Font.PLAIN,11);
        textArea.setFont(font);

        String text="";


        Album a1 = new Album("Now that's what I call music 98",songs,"Universal Music",2016);

        text += a1.toString();
        textArea.append(text);

        JOptionPane.showMessageDialog(null,textArea,"Album Information",JOptionPane.INFORMATION_MESSAGE);
        String choiceAsString = JOptionPane.showInputDialog(null,"Which track number would you like to play?");
        int choice = Integer.parseInt(choiceAsString);
        a1.playTrack(choice);
        String choice2 = JOptionPane.showInputDialog(null,"Would you like to shuffle the playlist?",JOptionPane.INFORMATION_MESSAGE);
        if(choice2.equalsIgnoreCase("No"))
        {
            System.exit(0);
        }
        else
        {
            a1.shuffle(a1.getTracks());
        }

    }
}
