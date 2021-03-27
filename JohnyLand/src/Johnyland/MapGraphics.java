package Johnyland;
import java.awt.*;
import javax.swing.*;

public class MapGraphics extends JFrame {
    
    /**
     *
     */
    private static final long serialVersionUID = 385496497732981681L;
    // private static final Font LABEL_FONT = new Font(Font.DIALOG, Font.PLAIN, 24);
    JPanel mapPanel;

    public MapGraphics(int height,int width,char[][] backg) {
        setTitle("MAP");
        setSize(600,500);
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        mapPanel = new JPanel(new GridLayout(height, width,0,0));
        
        //mapPanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1,1));
        
        mapPanel.setBackground(Color.BLACK);
        JLabel[][] grid = new JLabel[height][width];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                
                if(backg[row][col]==' '){           //tanah
                    grid[row][col] = new JLabel(" ", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(24, 119, 27));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                //Residential
                if(backg[row][col]=='H'){           //rumah
                    grid[row][col] = new JLabel(" ", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(255, 119, 27));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }if(backg[row][col]=='C'){          //kondominium purple light
                    grid[row][col] = new JLabel(" ", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(160, 77, 147));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(backg[row][col]=='A'){           //Apartment hijau muda
                    grid[row][col] = new JLabel(" ", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(160, 255, 147));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                //Industrial
                if(backg[row][col]=='F'){           //Factory kelabu cerah
                    grid[row][col] = new JLabel(" ", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(128, 128, 128));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(backg[row][col]=='W'){           //Gudang brown
                    grid[row][col] = new JLabel(" ", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(107, 50, 24));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }if(backg[row][col]=='S'){          //Flex Space putih silver
                    grid[row][col] = new JLabel(" ", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(212, 212, 212));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                // Commercial
                if(backg[row][col]=='O'){           //School peachy light
                    grid[row][col] = new JLabel(" ", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(212, 157, 99));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(backg[row][col]=='I'){           //Airport biru
                    grid[row][col] = new JLabel(" ", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(29, 98, 194));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                //Residential
                if(backg[row][col]=='E'){           //Office
                    grid[row][col] = new JLabel(" ", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(0, 0, 0));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }if(backg[row][col]=='U'){          //University pink 
                    grid[row][col] = new JLabel(" ", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(194, 29, 109));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(backg[row][col]=='P'){           //Hospital merah
                    grid[row][col] = new JLabel("+", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(184, 42, 42));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                //main road
                if(backg[row][col]=='↑'){     
                    grid[row][col] = new JLabel("↑", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(145, 145, 145));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }if(backg[row][col]=='↗'){
                    grid[row][col] = new JLabel("↗", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(145, 145, 145));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(backg[row][col]=='→'){
                    grid[row][col] = new JLabel("→", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(145, 145, 145));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(backg[row][col]=='↘'){     
                    grid[row][col] = new JLabel("↘", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(145, 145, 145));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }if(backg[row][col]=='↓'){
                    grid[row][col] = new JLabel("↓", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(145, 145, 145));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(backg[row][col]=='↙'){
                    grid[row][col] = new JLabel("↙", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(145, 145, 145));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(backg[row][col]=='←'){
                    grid[row][col] = new JLabel("←", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(145, 145, 145));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(backg[row][col]=='↖'){
                    grid[row][col] = new JLabel("↖", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(145, 145, 145));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                if(backg[row][col]=='Z'){
                    grid[row][col] = new JLabel(" ", SwingConstants.CENTER);
                    grid[row][col].setBackground(new java.awt.Color(31, 222, 37));
                    mapPanel.add(grid[row][col]);
                    grid[row][col].setOpaque(true);
                    continue;
                }
                grid[row][col] = new JLabel(" ", SwingConstants.CENTER);
                //grid[row][col].setFont(LABEL_FONT); // make it big
                grid[row][col].setOpaque(true);
                grid[row][col].setBackground(new java.awt.Color(145, 145, 145));
                grid[row][col].setVisible(true);
                mapPanel.add(grid[row][col]);
                
            }
        }

        add(mapPanel,BorderLayout.CENTER);
    }
    /*public MapGraphics(int height, int width){

    }*/
}
