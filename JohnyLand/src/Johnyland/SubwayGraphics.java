package Johnyland;

import java.awt.*;
import javax.swing.*;

public class SubwayGraphics extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = -405069827669222056L;
    // private static final Font LABEL_FONT = new Font(Font.DIALOG, Font.PLAIN, 24);
    JPanel mapPanel;

    public SubwayGraphics(int height,int width,char[][] subwaymap) {
        setTitle("SUBWAY");
        setSize(600,500);
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        mapPanel = new JPanel(new GridLayout(height, width,0,0));
        
        //mapPanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1,1));
        
        mapPanel.setBackground(Color.BLACK);
        JLabel[][] grid = new JLabel[height][width];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                
                if(subwaymap[row][col]=='↑'){     
                    grid[row][col] = new JLabel("↑", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(255, 0, 200));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }if(subwaymap[row][col]=='↗'){
                    grid[row][col] = new JLabel("↗", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(255, 0, 200));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(subwaymap[row][col]=='→'){
                    grid[row][col] = new JLabel("→", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(255, 0, 200));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(subwaymap[row][col]=='↘'){     
                    grid[row][col] = new JLabel("↘", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(255, 0, 200));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }if(subwaymap[row][col]=='↓'){
                    grid[row][col] = new JLabel("↓", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(255, 0, 200));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(subwaymap[row][col]=='↙'){
                    grid[row][col] = new JLabel("↙", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(255, 0, 200));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(subwaymap[row][col]=='←'){
                    grid[row][col] = new JLabel("←", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(255, 0, 200));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(subwaymap[row][col]=='↖'){
                    grid[row][col] = new JLabel("↖", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(255, 0, 200));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(subwaymap[row][col]=='Z'){
                    grid[row][col] = new JLabel(" ", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(31, 222, 37));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                grid[row][col] = new JLabel(" ", SwingConstants.CENTER);
                //grid[row][col].setFont(LABEL_FONT); // make it big
                grid[row][col].setOpaque(true);
                grid[row][col].setBackground(new java.awt.Color(0, 0, 0));
                grid[row][col].setVisible(true);
                mapPanel.add(grid[row][col]);
                
            }
        }

        add(mapPanel,BorderLayout.CENTER);
    }
    /*public MapGraphics(int height, int width){

    }*/
}
