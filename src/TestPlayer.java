import javax.swing.*;

import model.MusicPlayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class TestPlayer {
    String[] musicsList = {"Let's Go!", "Turn The Lights off", "Break it Down", "Freaks", "MangueTown", "Sinhá"};
    ArrayList<String> musicsArrayList = new ArrayList<>(Arrays.asList(musicsList));
    MusicPlayer musicPlayer = new MusicPlayer(false,musicsArrayList);

    
    public static void main(String[] args) {
        new TestPlayer().createAndShowGUI(); 
    }

    private void createAndShowGUI() {

        // Cria o frame principal
        JFrame frame = new JFrame("Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 

        // Cria os botões
        
        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicPlayer.play(); 
            }

        });
        
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicPlayer.stop(); 
            }

        });

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicPlayer.next(); 
            }

        });
        JButton prevButton = new JButton("Prev");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicPlayer.previous(); 
            }

        });
        // Adiciona os botões ao painel
        buttonPanel.add(playButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(prevButton);

        // Adiciona o painel de botões ao frame
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

        // Torna o frame visível
        frame.setVisible(true);
    }

    
}
