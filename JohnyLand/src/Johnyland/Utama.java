package Johnyland;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;



public class Utama{

    public static void main(String[] args)
    {
        
        NewJFrame Form = new NewJFrame();
        Form.setVisible(true);
        
        //MapGraphics lol = new MapGraphics();
        //lol.setVisible(true);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void generateMainRoad(int height, int width, char[][] backg)
    {
        //random main highway masuk bandar
        Random R = new Random();
        int exit = R.nextInt(4), tolakwidth = width * 4 / 5, addwidth = width * 4 / 10, tolakheight = height * 4 / 5, addheight = height * 4 / 10, l = 0, r = 0, x = 0, stop1, stop2;

        for (x = 0; x < height; x++)
        {
            for (int y = 0; y < width; y++)
            {
                backg[x][y] = '0';
            }
        }

        switch (exit)
        {
            case 0:     
                l = 0;
                r = R.nextInt(width - tolakwidth) + addwidth;//atah
                stop1 = R.nextInt(height - tolakheight) + addheight;
                stop2 = R.nextInt(height - tolakheight) + addheight;

                while (stop1 == stop2)
                {
                    stop2 = R.nextInt(height - tolakheight) + addheight;
                }

                for (; l < height; l++)
                {  //from top to bottom
                    backg[l][r] = '↓';        //left lane
                    backg[l][r + 1] = '↓';
                    backg[l][r - 2] = '↑';    //right lane
                    backg[l][r - 1] = '↑';
                    if (l == stop1 - 3 || l == stop1 - 2 || l == stop1 - 1 || l == stop1 || l == stop1 + 1 || l == stop1 + 2)
                    {
                        backg[l][r - 2] = '*';
                        backg[l][r - 1] = '↑';
                    }
                    if (l == stop2 - 3 || l == stop2 - 2 || l == stop2 - 1 || l == stop2 || l == stop2 + 1 || l == stop2 + 2)
                    {
                        backg[l][r] = '↓';
                        backg[l][r + 1] = '*';
                    }
                }
                for (x = 0; x < r - 2; x++)
                {
                    backg[stop1 - 2][x] = '→';    //left lane
                    backg[stop1 - 1][x] = '→';
                    backg[stop1][x] = '←';    //right lane
                    backg[stop1 + 1][x] = '←';

                    if (x == r - 3)
                    {
                        backg[stop1 - 3][x] = '↗';
                        backg[stop1 - 2][x] = '*';
                        backg[stop1 - 1][x] = '↘';
                        backg[stop1][x] = '*';    //right lane
                        backg[stop1 + 1][x] = '*';
                        backg[stop1 + 2][x] = '↖';
                    }
                }
                for (x = x + 4; x < width; x++)
                {

                    backg[stop2 - 2][x] = '→';    //left lane
                    backg[stop2 - 1][x] = '→';
                    backg[stop2][x] = '←';    //right lane
                    backg[stop2 + 1][x] = '←';
                    if (x == r + 2)
                    {
                        backg[stop2 - 3][x] = '↘';
                        backg[stop2 - 2][x] = '*';
                        backg[stop2 - 1][x] = '*';
                        backg[stop2][x] = '↖';
                        backg[stop2 + 1][x] = '*';
                        backg[stop2 + 2][x] = '↙';
                    }
                }
                break;

            case 1: 
                l = height - 1;
                r = R.nextInt(width - tolakwidth) + addwidth;//bawah
                stop1 = R.nextInt(height - tolakheight) + addheight;
                stop2 = R.nextInt(height - tolakheight) + addheight;

                while (stop1 == stop2)
                {
                    stop2 = R.nextInt(height - tolakheight) + addheight;
                }

                for (; l >= 0; l--)
                {     //from bottom to top
                    backg[l][r - 2] = '↑';  //left lane
                    backg[l][r - 1] = '↑';
                    backg[l][r] = '↓';    //right lane
                    backg[l][r + 1] = '↓';
                    if (l == stop1 - 3 || l == stop1 - 2 || l == stop1 - 1 || l == stop1 || l == stop1 + 1 || l == stop1 + 2)
                    {
                        backg[l][r - 2] = '*';
                        backg[l][r - 1] = '↑';
                    }
                    if (l == stop2 - 3 || l == stop2 - 2 || l == stop2 - 1 || l == stop2 || l == stop2 + 1 || l == stop2 + 2)
                    {
                        backg[l][r] = '↓';
                        backg[l][r + 1] = '*';
                    }

                }
                for (x = 0; x < r - 2; x++)
                {
                    backg[stop1 - 2][x] = '→';    //left lane
                    backg[stop1 - 1][x] = '→';
                    backg[stop1][x] = '←';    //right lane
                    backg[stop1 + 1][x] = '←';
                    if (x == r - 3)
                    {
                        backg[stop1 - 3][x] = '↗';
                        backg[stop1 - 2][x] = '*';
                        backg[stop1 - 1][x] = '↘';
                        backg[stop1][x] = '*';    //right lane
                        backg[stop1 + 1][x] = '*';
                        backg[stop1 + 2][x] = '↖';
                    }
                }

                for (x += 4; x < width; x++)
                {
                    backg[stop2 - 2][x] = '→';  //right lane
                    backg[stop2 - 1][x] = '→';
                    backg[stop2][x] = '←';    //left lane
                    backg[stop2 + 1][x] = '←';
                    if (x == r + 2)
                    {
                        backg[stop2 - 3][x] = '↘';
                        backg[stop2 - 2][x] = '*';
                        backg[stop2 - 1][x] = '*';
                        backg[stop2][x] = '↖';
                        backg[stop2 + 1][x] = '*';
                        backg[stop2 + 2][x] = '↙';
                    }
                }
                break;

            case 2: //kiri ke kanan //dah
                l = R.nextInt(height - tolakheight) + addheight;
                r = 0;
                stop1 = R.nextInt(width - tolakwidth) + addwidth;
                stop2 = R.nextInt(width - tolakwidth) + addwidth;

                while (stop1 == stop2)
                {
                    stop2 = R.nextInt(height - tolakheight) + addheight;
                }

                for (; r < width; r++)
                {
                    backg[l - 2][r] = '→';  //left lane
                    backg[l - 1][r] = '→';
                    backg[l][r] = '←';    //right lane
                    backg[l + 1][r] = '←';
                    if (r == stop1 - 3 || r == stop1 - 2 || r == stop1 - 1 || r == stop1 || r == stop1 + 1 || r == stop1 + 2)
                    {
                        backg[l - 2][r] = '*';
                        backg[l - 1][r] = '→';
                    }
                    if (r == stop2 - 3 || r == stop2 - 2 || r == stop2 - 1 || r == stop2 || r == stop2 + 1 || r == stop2 + 2)
                    {
                        backg[l][r] = '←';
                        backg[l + 1][r] = '*';
                    }
                }

                for (x = 0; x < l - 2; x++)
                {
                    backg[x][stop1 - 2] = '↑';  //left lane
                    backg[x][stop1 - 1] = '↑';
                    backg[x][stop1] = '↓';    //right lane
                    backg[x][stop1 + 1] = '↓';
                    if (x == l - 3)
                    {
                        backg[x][stop1 - 3] = '↗';
                        backg[x][stop1 - 2] = '*';
                        backg[x][stop1 - 1] = '*';
                        backg[x][stop1] = '↙';    //right lane
                        backg[x][stop1 + 1] = '*';
                        backg[x][stop1 + 2] = '↘';
                    }
                }

                for (x += 4; x < height; x++)
                {
                    backg[x][stop2 - 2] = '↑';  //left lane
                    backg[x][stop2 - 1] = '↑';
                    backg[x][stop2] = '↓';    //right lane
                    backg[x][stop2 + 1] = '↓';
                    if (x == l + 2)
                    {
                        backg[x][stop2 - 3] = '↖';
                        backg[x][stop2 - 2] = '*';
                        backg[x][stop2 - 1] = '↗';
                        backg[x][stop2] = '*';
                        backg[x][stop2 + 1] = '*';
                        backg[x][stop2 + 2] = '↙';
                    }
                }
                break;

            case 3:
                l = R.nextInt(height - tolakheight) + addheight;
                r = width - 1;//kanan
                stop1 = R.nextInt(width - tolakwidth) + addwidth;//from right to left
                stop2 = R.nextInt(width - tolakwidth) + addwidth;

                while (stop1 == stop2)
                {
                    stop2 = R.nextInt(height - tolakheight) + addheight;
                }

                for (; r >= 0; r--)
                {

                    backg[l - 2][r] = '→';  //left lane
                    backg[l - 1][r] = '→';
                    backg[l][r] = '←';    //right lane
                    backg[l + 1][r] = '←';
                    if (r == stop1 - 3 || r == stop1 - 2 || r == stop1 - 1 || r == stop1 || r == stop1 + 1 || r == stop1 + 2)
                    {
                        backg[l - 2][r] = '*';
                        backg[l - 1][r] = '→';
                    }
                    if (r == stop2 - 3 || r == stop2 - 2 || r == stop2 - 1 || r == stop2 || r == stop2 + 1 || r == stop2 + 2)
                    {
                        backg[l][r] = '←';
                        backg[l + 1][r] = '*';
                    }
                }

                for (x = 0; x < l - 2; x++)
                {
                    backg[x][stop1 - 2] = '↑';   //left lane
                    backg[x][stop1 - 1] = '↑';
                    backg[x][stop1] = '↓';    //right lane
                    backg[x][stop1 + 1] = '↓';
                    if (x == l - 3)
                    {
                        backg[x][stop1 - 3] = '↗';
                        backg[x][stop1 - 2] = '*';
                        backg[x][stop1 - 1] = '*';
                        backg[x][stop1] = '↙';    //right lane
                        backg[x][stop1 + 1] = '*';
                        backg[x][stop1 + 2] = '↘';
                    }
                }

                for (x += 4; x < height; x++)
                {
                    backg[x][stop2 - 2] = '↑';
                    backg[x][stop2 - 1] = '↑';
                    backg[x][stop2] = '↓';
                    backg[x][stop2 + 1] = '↓';
                    if (x == l + 2)
                    {
                        backg[x][stop2 - 3] = '↖';
                        backg[x][stop2 - 2] = '*';
                        backg[x][stop2 - 1] = '↗';
                        backg[x][stop2] = '*';
                        backg[x][stop2 + 1] = '*';
                        backg[x][stop2 + 2] = '↙';
                    }
                }
                break;

            default:
                break;
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //find zone area;
    public static int totalArea(char[][] backg, int height, int width, char a)
    {
        int size = 0;
        for (int x = 0; x < height; x++)
        {
            for (int y = 0; y < width; y++)
            {
                if (backg[x][y] == a)
                {
                    size++;
                }
            }
        }
        return size;
    }

    public static int[][] generateBuilding(char[][] backg, int height, int width, int[] min, int[] max, int[] freq, char[] symbol)
    {
        Random R = new Random();
        //store in arrays based on zone number;
        int area[] = new int[10];
        int ix[] = new int[10];
        int fx[] = new int[10];
        int iy[] = new int[10];
        int fy[] = new int[10];
        char in[] ={'0', '1', '2', '3', '4', '5', '6'};

        for (int i = 3; i <= 6; i++)
        {
            //to measure area of zone;
            //area[i] = totalArea(backg, height, width, in[i]);

            //iy: initial column; fy: final column;
            iy[i] = findareaiwidth(backg, height, width, in[i]);
            fy[i] = findareafwidth(backg, height, width, in[i]);

            //ix: initial row; fx: final row;
            ix[i] = findareaiheight(backg, height, width, in[i]);
            fx[i] = findareafheight(backg, height, width, in[i]);

        }

        /*
        A,  8, 24, Airport
        H,  4,  8, Hospitals
        G,  6, 12, Office
        S,  6, 12, School
        U, 12, 24, University 
        C,  4, 16, Condominiums
        R,  4,  6, Houses;
        F,  4, 12, Aparments;
        Q,  6, 16, Factory;
        W,  6, 16, Warehouse;
        E,  6, 16, Flex Space;
         */
        int no_of_buildings = 11; //no of buildings;
        int building[] = new int[no_of_buildings]; //Randomized area for building
        int buildingWidth[] = new int[no_of_buildings];
        int buildingHeight[] = new int[no_of_buildings];
        
        //Randomized building area;
        for(int i = 0; i < building.length; i++) {
            building[i] = R.nextInt(max[i]+1-min[i])+min[i];
            
            buildingWidth[i] = (int) Math.ceil(Math.sqrt(building[i]));
            try{
            
                buildingHeight[i] = building[i]/buildingWidth[i];
            
                }
        catch (Exception e){}
            
            while(buildingWidth[i]*buildingHeight[i] < building[i]) {
                buildingHeight[i]++;
            }
        }
        
        int[][] subCoordinate = new int[4][2];

        //Subway stations
        for (int i = 3; i <= 6; i++)
        {
            int xsub = iy[i] + (fy[i] - iy[i]) / 2 - 2;
            int ysub = ix[i] + (fx[i] - ix[i]) / 2 - 2;
            subCoordinate[i - 3][0] = xsub;
            subCoordinate[i - 3][1] = ysub;
            backg[xsub][ysub] = 'Z';
            backg[xsub + 1][ysub] = 'Z';
            backg[xsub][ysub + 1] = 'Z';
            backg[xsub + 1][ysub + 1] = 'Z';
        }
       
        char subwaysymbol[] = {'Z'};
        generateMinorRoads(backg,height,width,subwaysymbol);
        char allsymbols[] = { 'O', 'I', 'E', 'U', 'P', 'H', 'C', 'A', 'F', 'W', 'S', 'Z' };
        int X=0,Y=0;
        alongtheroad(backg,building,buildingWidth,buildingHeight,symbol,freq,fy,iy,fx,ix,0,width,height);
        alongtheroad(backg,building,buildingWidth,buildingHeight,symbol,freq,fy,iy,fx,ix,1,width,height);
        residentialcommercialBuilding(backg, building, buildingWidth, buildingHeight, symbol, freq, fy, iy, fx, ix);
        industrialBuilding(backg, building, buildingWidth, buildingHeight, symbol, freq, fy[6], iy[6], fx[6], ix[6]);
        
        for (int wow = 0 ;wow<allsymbols.length;wow++) {
            for (int lol = 0; lol < height; lol++) {
                for (int lol2 = 0; lol2 < width; lol2++) {
                    if (backg[lol][lol2] == allsymbols[wow] && backg[lol+1][lol2] != allsymbols[wow] && backg[lol][lol2+1] != allsymbols[wow] && backg[lol-1][lol2+1] != allsymbols[wow]) {
                        X = lol2;
                        Y = lol;
                        canbuild(backg,allsymbols,wow,X,Y,width,height);
                    }
                }
            }
        }
        clear(backg, height, width);
        
        MapGraphics hello = new MapGraphics(height,width,backg);
        hello.setVisible(true);
        hello.setLocation(30, 30);

        return subCoordinate;
    }

    public static boolean isNotEmpty(char backg[][],int x_coordinate,int y_coordinate,int building,int width,int height,char tag) {
        for (int w = y_coordinate - 1; w < y_coordinate+height+1; w++) {
            for (int z = x_coordinate - 1; z < x_coordinate+width+1; z++) {
                if (backg[w][z] != tag) { return true;}
        }
    } 
return false;
}

public static void alongtheroad(char backg[][],int building[],int buildingWidth[],int buildingHeight[],char symbol[],int freq[],int fy[], int iy[], int fx[], int ix[],int i,int fat, int tall) {
Random R = new Random();
int x, y, width = buildingWidth[i], height = buildingHeight[i],r = R.nextInt(3);
char d[] = {'3','4','5'};
int  e[] = { 3, 4, 5 };
boolean flag;
int sw1 = R.nextInt(2);
for(int w = 1; w <=freq[i]; w++) {

//Top left
if(ix[e[r]]==0 && iy[e[r]]==0) {

switch(sw1) {
case 0:
//horizontal along road
x = fy[e[r]]-width+1;
y = fx[e[r]]-height+1;           

flag = isNotEmpty(backg,x,y,building[i],width,height,d[r]);
while(flag) {
if(x>iy[e[r]]+1) {
x = x-1; }   
else {
break; }
flag = isNotEmpty(backg,x,y,building[i],width,height,d[r]);
}

if(!flag) {
printalongtheroadH(backg,x,y,building[i],width,height,symbol[i]);

//jalan kebawah x+width-1
    int X = x + width - 1;
    int Y = y;
    int stopsearch = 0;
    boolean thereisstuffthere = false;
    for (int lol = Y; lol < tall; lol++) {
        if (backg[lol][X] == '→' || backg[lol][X] == '←') {
            thereisstuffthere = true;
            stopsearch = lol;
            System.out.println(stopsearch);
            break;
        }
    }
    if (thereisstuffthere) {
        for (int lol = Y; lol < stopsearch; lol++) {
            if (backg[lol][X] == symbol[i]) {
                continue;
            }
            backg[lol][X] = '↓';
        }
        for (int lol = Y; lol < stopsearch; lol++) {
            if (backg[lol][X - 1] == symbol[i]) {
                continue;
            }
            backg[lol][X - 1] = '↑';
        }
    }
    thereisstuffthere = false;
    


} else {
            System.out.println(symbol[i]+" "+w+" is not doable");
}
break;

case 1:
//vertical along road
x = fy[e[r]]-height;  
y = fx[e[r]]-width+1; 

flag = isNotEmpty(backg,x,y,building[i],height,width,d[r]);
while(flag) { 
if(y>ix[e[r]]+1) {
y = y-1; }   
else {
break; }   
flag = isNotEmpty(backg,x,y,building[i],height,width,d[r]);
}

if(!flag) {
printalongtheroadV(backg,x,y,building[i],width,height,symbol[i]);
//x+height-1
int X = x + height - 1;
int Y = y;
int stopsearch = 0;
boolean thereisstuffthere=false;
    for (int lol = X; lol < fat-X; lol++) {
        if (backg[Y][lol] == '↓' || backg[Y][lol] == '↑') {
            thereisstuffthere = true;
            stopsearch = lol;
            break;
        }

    }
    if (thereisstuffthere) {
        for (int lol = X + 1; lol < stopsearch; lol++) {
            if (backg[Y][lol] == symbol[i]) {
                continue;
            }
            backg[Y][lol] = '→';
        }
        
        if(backg[Y+1][X] == symbol[i])
        for (int lol = X + 1; lol < stopsearch; lol++) {
            if (backg[Y][lol] == symbol[i]) {
                continue;
            }
            backg[Y+1][lol] = '←';
        }
        else 
          for (int lol = X + 1; lol < stopsearch; lol++) {
            if (backg[Y][lol] == symbol[i]) {
                continue;
            }
            backg[Y][lol] = '⇄';
        }  
            
    }
    thereisstuffthere = false;

} else {
            System.out.println(symbol[i]+" "+w+" is not doable");
}
break;
}

}

//Top right
else if(ix[e[r]]==0 && iy[e[r]]!=0) {

switch(sw1) {
case 0:
//horizontal along road
x = iy[e[r]]+1;
y = fx[e[r]]-height+1;       

flag = isNotEmpty(backg,x,y,building[i],width,height,d[r]);
while(flag) {
if(x<fy[e[r]]-1) {
x = x+1; }  
else {
break; }   
flag = isNotEmpty(backg,x,y,building[i],width,height,d[r]);
}

if(!flag) {
printalongtheroadH(backg,x,y,building[i],width,height,symbol[i]);

    int X = x + width - 1;
    int Y = y;
    int stopsearch = 0;
    boolean thereisstuffthere = false;
    for (int lol = Y; lol < tall; lol++) {
        if (backg[lol][X] == '→' || backg[lol][X] == '←') {
            thereisstuffthere = true;
            stopsearch = lol;
            System.out.println(stopsearch);
            break;
        }
    }
    if (thereisstuffthere) {
        for (int lol = Y; lol < stopsearch; lol++) {
            if (backg[lol][X] == symbol[i]) {
                continue;
            }
            backg[lol][X] = '↓';
        }
        for (int lol = Y; lol < stopsearch; lol++) {
            if (backg[lol][X - 1] == symbol[i]) {
                continue;
            }
            backg[lol][X - 1] = '↑';
        }
    }
    thereisstuffthere = false;

} else {
            System.out.println(symbol[i]+" "+w+" is not doable");
}
break;

case 1:
//vertical along road
x = iy[e[r]]+1;       
y = fx[e[r]]-width; 

flag = isNotEmpty(backg,x,y,building[i],height,width,d[r]);
while(flag) {       
if(y>ix[e[r]]+1) {
y = y-1; }   
else {
break; }   
flag = isNotEmpty(backg,x,y,building[i],height,width,d[r]);
}

if(!flag) {
printalongtheroadV(backg,x,y,building[i],width,height,symbol[i]);

int X = x;
int Y = y;
int stopsearch = 0;
boolean thereisstuffthere = false;
    for (int lol = X - 1; lol > 0; lol--) {
            if (backg[Y][lol] == '↓' || backg[Y][lol] == '↑') {
            thereisstuffthere = true;
            stopsearch = lol;
            break;
        }
    }
    if (thereisstuffthere) {
        for (int lol = X-1; lol > stopsearch; lol--) {

            if (backg[Y][lol] == symbol[i]) {
                continue;
            }
            backg[Y][lol] = '→';
        }
        for (int lol = X-1; lol > stopsearch; lol--) {

            if (backg[Y][lol] == symbol[i]) {
                continue;
            }
            backg[Y+1][lol] = '←';
        }
        
    }
    thereisstuffthere = false;



} else {
            System.out.println(symbol[i]+" "+w+" is not doable");
}
break;
}

}

//Bottom left
else if(ix[e[r]]!=0 && iy[e[r]]==0) {

switch(sw1) {
case 0:
//horizontal along road
x = fy[e[r]]-width+1;
y = ix[e[r]]+1;  

flag = isNotEmpty(backg,x,y,building[i],width,height,d[r]);
while(flag) {
if(x>iy[e[r]]+1) {
x = x-1; }   
else {
break; }
flag = isNotEmpty(backg,x,y,building[i],width,height,d[r]);
}

if(!flag) {
printalongtheroadH(backg,x,y,building[i],width,height,symbol[i]);

int X = x;
int Y = y;
int stopsearch = 0;
boolean thereisstuffthere=false;
    for (int lol = Y - 1; lol > 0; lol--) {
        if (backg[lol][X] == '→' || backg[lol][X] == '←' || backg[lol][X] == '=') {
            thereisstuffthere = true;
            stopsearch = lol;
            break;
        }
    }
    if (thereisstuffthere) {
        for (int lol = Y - 1; lol > stopsearch; lol--) {

            if (backg[lol][X] == symbol[i]) {
                continue;
            }
            backg[lol][X] = '↑';
        }
        for (int lol = Y - 1; lol > stopsearch; lol--) {

            if (backg[lol][X] == symbol[i]) {
                continue;
            }
            backg[lol][X+1] = '↓';
        }
        
    }
    thereisstuffthere = false;



} else {
            System.out.println(symbol[i]+" "+w+" is not doable");
}
break;

case 1:
//vertical along road
x = fy[e[r]]-height+1;
y = ix[e[r]]+1; 

flag = isNotEmpty(backg,x,y,building[i],height,width,d[r]);
while(flag) {
if(y<fx[e[r]]-1) {
y = y+1; }   
else {
break; }   
flag = isNotEmpty(backg,x,y,building[i],height,width,d[r]);
}

if(!flag) {
printalongtheroadV(backg,x,y,building[i],width,height,symbol[i]);

int X = x + height - 1;
int Y = y;
int stopsearch = 0;
boolean thereisstuffthere=false;
    for (int lol = X; lol < fat-X; lol++) {
        if (backg[Y][lol] == '↓' || backg[Y][lol] == '↑') {
            thereisstuffthere = true;
            stopsearch = lol;
            break;
        }

    }
    if (thereisstuffthere) {
        for (int lol = X + 1; lol < stopsearch; lol++) {
            if (backg[Y][lol] == symbol[i]) {
                continue;
            }
            backg[Y][lol] = '→';
        }
        
        if(backg[Y+1][X] == symbol[i])
        for (int lol = X + 1; lol < stopsearch; lol++) {
            if (backg[Y][lol] == symbol[i]) {
                continue;
            }
            backg[Y+1][lol] = '←';
        }
        else 
          for (int lol = X + 1; lol < stopsearch; lol++) {
            if (backg[Y][lol] == symbol[i]) {
                continue;
            }
            backg[Y][lol] = '⇄';
        }  
            
    }
    thereisstuffthere = false;


} else {
            System.out.println(symbol[i]+" "+w+" is not doable");
}
break;
}

}

//Bottom right
else if(ix[e[r]]!=0 && iy[e[r]]!=0) {

switch(sw1) {
case 0:
//horizontal along road
x = iy[e[r]]+1;
y = ix[e[r]]+1; 

flag = isNotEmpty(backg,x,y,building[i],width,height,d[r]);
while(flag) {
if(x<fy[e[r]]-1) {
x = x+1; }  
else {
break; }   
flag = isNotEmpty(backg,x,y,building[i],width,height,d[r]);
} 

if(!flag) {
printalongtheroadH(backg,x,y,building[i],width,height,symbol[i]);

int X = x;
int Y = y;
int stopsearch = 0;
boolean thereisstuffthere=false;
    for (int lol = Y - 1; lol > 0; lol--) {
        if (backg[lol][X] == '→' || backg[lol][X] == '←' || backg[lol][X] == '=') {
            thereisstuffthere = true;
            stopsearch = lol;
            break;
        }
    }
    if (thereisstuffthere) {
        for (int lol = Y - 1; lol > stopsearch; lol--) {

            if (backg[lol][X] == symbol[i]) {
                continue;
            }
            backg[lol][X] = '↑';
        }
        for (int lol = Y - 1; lol > stopsearch; lol--) {

            if (backg[lol][X] == symbol[i]) {
                continue;
            }
            backg[lol][X+1] = '↓';
        }
        
    }
    thereisstuffthere = false;

} else {
            System.out.println(symbol[i]+" "+w+" is not doable");
}
break;

case 1:
//vertical along road
x = iy[e[r]];
y = ix[e[r]]+1; 

flag = isNotEmpty(backg,x,y,building[i],height,width,d[r]);
while(flag) {
if(y<fx[e[r]]-1) {
y = y+1; }   
else {
break; }   
flag = isNotEmpty(backg,x,y,building[i],height,width,d[r]);
}

if(!flag) {
printalongtheroadV(backg,x,y,building[i],width,height,symbol[i]);

int X = x;
int Y = y;
int stopsearch = 0;
boolean thereisstuffthere = false;
    for (int lol = X - 1; lol > 0; lol--) {
            if (backg[Y][lol] == '↓' || backg[Y][lol] == '↑') {
            thereisstuffthere = true;
            stopsearch = lol;
            break;
        }
    }
    if (thereisstuffthere) {
        for (int lol = X-1; lol > stopsearch; lol--) {

            if (backg[Y][lol] == symbol[i]) {
                continue;
            }
            backg[Y][lol] = '→';
        }
        for (int lol = X-1; lol > stopsearch; lol--) {

            if (backg[Y][lol] == symbol[i]) {
                continue;
            }
            backg[Y+1][lol] = '←';
        }
        
    }
    thereisstuffthere = false;

} else {
            System.out.println(symbol[i]+" "+w+" is not doable");
}
break;
}

}
    r++;
    if(r==3) { r = 0; }
    sw1++;
    if(sw1==2) { sw1 = 0; }
}
}

public static void printalongtheroadH(char backg[][],int x_coordinate,int y_coordinate,int building,int width,int height,char symbol) {
int counter = 0;
    label : {
        for (int x = y_coordinate; x < y_coordinate+height; x++) {
            for (int y = x_coordinate; y < x_coordinate+width; y++) {
                backg[x][y] = symbol; 
                counter++;
                if(counter==building) { break label; }
            }
        }
    }
}

public static void printalongtheroadV(char backg[][],int x_coordinate,int y_coordinate,int building,int width,int height,char symbol) {
int counter = 0;
    label : {
        for(int x = y_coordinate; x < y_coordinate+width; x++) {
                for(int y = x_coordinate; y < x_coordinate+height; y++) {
                    backg[x][y] = symbol;
                    counter++;
                    if(counter==building) { break label; }
                }
            }
    }
}

public static void residentialcommercialBuilding(char backg[][],int building[],int buildingWidth[],int buildingHeight[],char symbol[],int freq[],int fy[], int iy[], int fx[], int ix[]) {
Random R = new Random();
int x , y , width, height, r = R.nextInt(3);
char d[] = {'3','4','5'};
int  e[] = { 3, 4, 5 };
boolean flag;
for(int i = 2; i <= 7; i++) {
width = buildingWidth[i];
height = buildingHeight[i];
for(int j = 1; j <=freq[i]; j++) {

    x = iy[e[r]]+1;
    y = ix[e[r]]+1;
    
    flag = isNotEmpty(backg,x,y,building[i],width,height,d[r]);
    while(flag) {
        if(x < fy[e[r]]-width) { x++; }
        else{ x= iy[e[r]]+1; y++; }
        
        flag = isNotEmpty(backg,x,y,building[i],width,height,d[r]);
    }
    
    if(flag==false) {
        int counter = 0;
        label1 : {
            for (int w = y; w < y+height; w++) {
                for (int z = x; z < x+width; z++) {
                    backg[w][z] = symbol[i]; 
                    counter++;
                    if(counter==building[i]) { break label1; }
                }
            }
        }
        
        
        
    } else {
            System.out.println(symbol[i]+" "+j+" is not doable");
    }
    r++;
    if(r==3) { r = 0; }

}
}
}


public static void industrialBuilding(char backg[][],int building[],int buildingWidth[],int buildingHeight[],char symbol[],int freq[],int fy, int iy, int fx, int ix) {
Random R = new Random();
int x ,y ,width, height;
boolean flag = true;
for(int i = 8; i <= 10; i++) {
width = buildingWidth[i];
height = buildingHeight[i];
for(int j = 1; j <=freq[i]; j++) {
   
    x = iy+1;
    y = ix+1;
    
    label1: {
    for(int q = ix+1;q < fx - height ; q++) {
        for(int w = iy+1; w < fy - width; w++) {
            x = w;
            y = q;
            flag = isNotEmpty(backg,x,y,building[i],width,height,'6');
            if(flag==false) {
                break label1;
            }
        }
    }    
    }


    if(flag==false) {
        int counter = 0;
        label1 : {
            for (int w = y; w < y+height; w++) {
                for (int z = x; z < x+width; z++) {
                    backg[w][z] = symbol[i]; 
                    counter++;
                    if(counter==building[i]) { break label1; }
                }
            }
        } 
    } else {
        System.out.println(symbol[i]+" "+j+" is not doable");
    }
}
}
}

    

    public static void generateMinorRoads(char[][] backg, int height, int width, char[] a)
    {

        int buggyi = 1;
        int buggyj = 1;
        int buggybehind1 = 2;
        int buggybehind2 = 3;
        int buggytop = 2;

        if ((width == 20 && height == 20) || (width == 25 && height == 25) || (width == 60 && height == 60) || (width == 50 && height == 50))
        {
            buggyi = 1;
            buggyj = 1;
            buggybehind1 = 0;
            buggybehind2 = 0;
            buggytop = 0;
        }

        for (int irfan = 1; irfan < 2; irfan++)
        {
            for (int wow = 0; wow < a.length; wow++)
            {
                int X = 0, Y = 0;
                for (int i = buggyi+1; i < height-3; i++)
                {
                    for (int j = buggyj+1; j < width-3; j++)
                    {
                        if ((backg[i][j] == a[wow]) && (backg[i + 1][j] != a[wow]) && (backg[i][j + 1] != a[wow]) && (backg[i-1][j + 1] != a[wow]) && (backg[i][j + 1] != '←') && (backg[i][j - buggybehind1] != '←') && (backg[i][j - buggybehind2] != '←'))
                        {
                            if(backg[i-1][j+1] != a[wow] && (backg[i-1][j] == a[wow])) {
                            X = j;
                            Y = i;
                            canbuild(backg, a, wow, X, Y, width, height);
                            }
                            
 
                        }
                        if ((backg[i][j] == a[wow]) && (backg[i + 1][j] != a[wow]) && (backg[i][j + 1] != a[wow]) && (backg[i][j + 1] == '←')&& (backg[i-1][j + 1] != a[wow]) )
                        {
                            if(backg[i-1][j+1] != a[wow] && (backg[i-1][j] == a[wow])) {
                            X = j;
                            Y = i;
                            int Ytoprange = Y - 1;
                            int Ybottomrange = height - 1;
                            boolean thereisstuffthere = false;
                            straightRoadTop(backg, a, thereisstuffthere, X, Y, Ytoprange, wow);
                            straightRoadBottom(backg, a, thereisstuffthere, X, Y, Ybottomrange, wow);
                            }
                        }
                        if ((backg[i][j] == a[wow]) && (backg[i + 1][j] != a[wow]) && (backg[i][j + 1] != a[wow]) && (backg[i + 1][j] == '↑')&& (backg[i-1][j + 1] != a[wow]) )
                        {
                            if(backg[i-1][j+1] != a[wow] && (backg[i-1][j] == a[wow])) {
                            X = j;
                            Y = i;
                            int Ybottomrange = height - 1;
                            boolean thereisstuffthere = false;
                            straightRoadBottom(backg, a, thereisstuffthere, X, Y, Ybottomrange, wow);
                            }
                        }
//                        if ((backg[i][j] == a[wow]) && (backg[i + 1][j] != a[wow]) && (backg[i][j + 1] != a[wow]) && (backg[i - buggytop][j] == '↑'))
//                        {
//                            X = j;
//                            Y = i;
//                            int Ytoprange = Y - 1;
//                            boolean thereisstuffthere = false;
//                            straightRoadTop(backg, a, thereisstuffthere, X, Y, Ytoprange, wow);
//                        }
                        if ((backg[i][j] == a[wow]) && (backg[i + 1][j] != a[wow]) && (backg[i][j + 1] != a[wow]) && (backg[i][j + 1] == ' ')&& (backg[i-1][j + 1] != a[wow]) )
                        {
                            if(backg[i-1][j+1] != a[wow] && (backg[i-1][j] == a[wow])) {
                            X = j;
                            Y = i;
                            int Xrightrange = width - X;
                            boolean thereisstuffthere = false;
                            straightRoadRight(backg, a, thereisstuffthere, X, Y, Xrightrange, wow); 
                            }
                        }
                        if ((backg[i][j] == a[wow]) && (backg[i + 1][j] != a[wow]) && (backg[i][j + 1] != a[wow]) && (backg[i][j + 1] == ' ' && backg[i][j - 2] == ' ' && backg[i + 1][j] == ' ' && backg[i - 2][j] == ' ')&& (backg[i-1][j + 1] != a[wow]) )
                        {
                            if(backg[i-1][j+1] != a[wow] && (backg[i-1][j] == a[wow])) {
                            X = j;
                            Y = i;
                            canbuild(backg, a, wow, X, Y, width, height);
                            }
                        }
                    }
                }
            }
        }
    }

    public static
            void canbuild(char[][] backg, char[] a, int wow, int X, int Y, int width, int height)
    {
        int Xrightrange = width - X;
        int Xleftrange = X - 1;
        int Ytoprange = Y - 1;
        int Ybottomrange = height - 1;
        boolean thereisstuffthere = false;
        //Making straight road to the right 
        straightRoadRight(backg, a, thereisstuffthere, X, Y, Xrightrange, wow);
        //Making straight road to the left
        straightRoadLeft(backg, a, thereisstuffthere, X, Y, Xleftrange, wow);
        //Making Straight road to the top
        straightRoadTop(backg, a, thereisstuffthere, X, Y, Ytoprange, wow);
        //Making Straight road to the bottom
        straightRoadBottom(backg, a, thereisstuffthere, X, Y, Ybottomrange, wow);
    }

    public static
            void straightRoadRight(char[][] backg, char[] a, boolean thereisstuffthere, int X, int Y, int Xrightrange, int wow)
    {
        int stopeh = 0;
        for (int i = X; i < Xrightrange; i++)
        {
            for (int lol = 0; lol < a.length; lol++)
            {
                if ((backg[Y][i] == a[lol] || backg[Y][i] == 'H' || backg[Y][i] == 'A' || backg[Y][i] == 'X')&& backg[Y][i] != a[wow])
                {
                    thereisstuffthere = true;
                    stopeh = i;
                    break;
                }
            }
            if (thereisstuffthere)
            {
                break;
            }

            if (backg[Y][i] == '↓' || backg[Y][i] == '↑')
            {
                thereisstuffthere = true;
                stopeh = i;

                //  if(backg[Y][i] == '⇅')
                //   backg[Y][i] = '↕';
                // if(backg[Y][i]=='↓')
                //     backg[Y][i] = '⮧';
                //  if(backg[Y][i]=='↑')
                //    backg[Y][i] = '⮥';
                break;
            }

        }
        if (thereisstuffthere)
        {
            for (int i = X + 1; i < stopeh; i++)
            {
                if (backg[Y][i] == a[wow])
                {
                    continue;
                }
                backg[Y][i] = '←';
            }
        }
        thereisstuffthere = false;
        
        if(backg[Y-1][X] == a[wow]) {
        for (int i = X; i < Xrightrange; i++)
        {
            for (int lol = 0; lol < a.length; lol++)
            {
                if ((backg[Y - 1][i] == a[lol] || backg[Y-1][i] == 'H' || backg[Y-1][i] == 'A'|| backg[Y-1][i] == 'X') && backg[Y - 1][i] != a[wow])
                {
                    thereisstuffthere = false;
                    stopeh = i;
                    break;
                }
            }
            if (thereisstuffthere)
            {
                break;
            }

            if (backg[Y - 1][i] == '↓' || backg[Y - 1][i] == '↑')
            {
                thereisstuffthere = true;
                stopeh = i;

                //  if(backg[Y][i] == '⇅')
                //   backg[Y][i] = '↕';
                // if(backg[Y][i]=='↓')
                //     backg[Y][i] = '⮧';
                //  if(backg[Y][i]=='↑')
                //    backg[Y][i] = '⮥';
                break;
            }

        }
        if (thereisstuffthere)
        {
            for (int i = X + 1; i < stopeh; i++)
            {
                if (backg[Y - 1][i] == a[wow] )
                {
                    continue;
                }
                backg[Y - 1][i] = '→';
            }
        }
        thereisstuffthere = false;
        }
    }

    public static
            void straightRoadLeft(char[][] backg, char[] a, boolean thereisstuffthere, int X, int Y, int Xleftrange, int wow)
    {
        int stopeh = 0;
        for (int i = Xleftrange; i > 0; i--)
        {
            for (int lol = 0; lol < a.length; lol++)
            {
                if ((backg[Y][i] == a[lol]|| backg[Y][i] == 'H' || backg[Y][i] == 'A'|| backg[Y][i] == 'X' ) && backg[Y][i] != a[wow])
                {
                    thereisstuffthere = true;
                    stopeh = i;
                    break;
                }
            }
            if (thereisstuffthere)
            {
                break;
            }

            if (backg[Y][i] == '↓' || backg[Y][i] == '↑')
            {
                thereisstuffthere = true;
                stopeh = i;

                //    if(backg[Y][i] == '⇅')
                //     backg[Y][i] = '↕';
                //    if(backg[Y][i]=='↑')
                //      backg[Y][i] = '⮤';
                //    if(backg[Y][i]=='↓')
                //     backg[Y][i] = '⮦';
                break;
            }
        }
        if (thereisstuffthere)
        {
            for (int i = Xleftrange; i > stopeh; i--)
            {

                if (backg[Y][i] == a[wow])
                {
                    continue;
                }
                backg[Y][i] = '←';
            }
        }
        thereisstuffthere = false;
        
        if(backg[Y-1][X] == a[wow])
        for (int i = Xleftrange; i > 0; i--)
        {
            for (int lol = 0; lol < a.length; lol++)
            {
                if ((backg[Y - 1][i] == a[lol]|| backg[Y-1][i] == 'H' || backg[Y-1][i] == 'A'|| backg[Y-1][i] == 'X' ) && backg[Y - 1][i] != a[wow])
                {
                    thereisstuffthere = true;
                    stopeh = i;
                    break;
                }
            }
            if (thereisstuffthere)
            {
                break;
            }

            if (backg[Y - 1][i] == '↓' || backg[Y - 1][i] == '↑')
            {
                thereisstuffthere = true;
                stopeh = i;
                break;
            }
        }
        if (thereisstuffthere)
        {
            for (int i = Xleftrange; i > stopeh; i--)
            {

                if (backg[Y - 1][i] == a[wow])
                {
                    continue;
                }
                backg[Y - 1][i] = '→';
            }
        }
        thereisstuffthere = false;

    }

    public static
            void straightRoadTop(char[][] backg, char[] a, boolean thereisstuffthere, int X, int Y, int Ytoprange, int wow)
    {
        int stopeh = 0;
        for (int i = Ytoprange; i > 0; i--)
        {
            for (int lol = 0; lol < a.length; lol++)
            {
                if ((backg[i][X] == a[lol]|| backg[i][X] == 'H' || backg[i][X] == 'A'|| backg[i][X] == 'X') && backg[i][X] != a[wow])
                {
                    thereisstuffthere = true;
                    stopeh = i;
                    break;
                }
            }
            if (thereisstuffthere)
            {
                break;
            }

            if (backg[i][X] == '→' || backg[i][X] == '←' || backg[i][X] == '=')
            {
                thereisstuffthere = true;
                stopeh = i;
                //     if(backg[i][X] == '←')
                //       backg[i][X] = '↰';
                //     if(backg[i][X] == '→')
                //       backg[i][X] = '↱'; 
                break;
            }
        }
        if (thereisstuffthere)
        {
            for (int i = Ytoprange; i > stopeh; i--)
            {

                if (backg[i][X] == a[wow])
                {
                    continue;
                }
                backg[i][X] = '↓';
            }
        }
        thereisstuffthere = false;

        for (int i = Ytoprange; i > 0; i--)
        {
            for (int lol = 0; lol < a.length; lol++)
            {
                if ((backg[i][X - 1] == a[lol]|| backg[i][X-1] == 'H' || backg[i][X-1] == 'A'|| backg[i][X-1] == 'X' ) && backg[i][X - 1] != a[wow])
                {
                    thereisstuffthere = true;
                    stopeh = i;
                    break;
                }
            }
            if (thereisstuffthere)
            {
                break;
            }

            if (backg[i][X - 1] == '→' || backg[i][X - 1] == '←' || backg[i][X - 1] == '=')
            {
                thereisstuffthere = true;
                stopeh = i;
                //     if(backg[i][X] == '←')
                //       backg[i][X] = '↰';
                //     if(backg[i][X] == '→')
                //       backg[i][X] = '↱'; 
                break;
            }
        }
        if (thereisstuffthere)
        {
            for (int i = Ytoprange; i > stopeh; i--)
            {

                if (backg[i][X - 1] == a[wow])
                {
                    continue;
                }
                backg[i][X - 1] = '↑';
            }
        }
        thereisstuffthere = false;
    }

    public static
            void straightRoadBottom(char[][] backg, char[] a, boolean thereisstuffthere, int X, int Y, int Ybottomrange, int wow)
    {
        int stopeh = 0;
        for (int i = Y; i < Ybottomrange; i++)
        {
            for (int lol = 0; lol < a.length; lol++)
            {
                if ((backg[i][X] == a[lol]|| backg[i][X] == 'H' || backg[i][X] == 'A'|| backg[i][X] == 'X' ) && backg[i][X] != a[wow])
                {
                    thereisstuffthere = true;
                    stopeh = i;
                    break;
                }
            }
            if (thereisstuffthere)
            {
                break;
            }

            if (backg[i][X] == '→' || backg[i][X] == '←' || backg[i][X] == '=')
            {
                thereisstuffthere = true;
                stopeh = i;
                break;
            }

        }
        if (thereisstuffthere)
        {
            for (int i = Y + 1; i < stopeh; i++)
            {
                if (backg[i][X] == a[wow])
                {
                    continue;
                }
                backg[i][X] = '↓';
            }
        }
        thereisstuffthere = false;

        for (int i = Y; i < Ybottomrange; i++)
        {
            for (int lol = 0; lol < a.length; lol++)
            {
                if ((backg[i][X - 1] == a[lol]|| backg[i][X-1] == 'H' || backg[i][X-1] == 'A'|| backg[i][X-1] == 'X' ) && backg[i][X - 1] != a[wow])
                {
                    thereisstuffthere = true;
                    stopeh = i;
                    break;
                }
            }
            if (thereisstuffthere)
            {
                break;
            }

            if (backg[i][X - 1] == '→' || backg[i][X - 1] == '←' || backg[i][X - 1] == '=')
            {
                thereisstuffthere = true;
                stopeh = i;
                //      if(backg[i][X] == '←')
                //        backg[i][X] = '↲';
                //      if(backg[i][X] == '→')
                //        backg[i][X] = '↳';  
                break;
            }

        }
        if (thereisstuffthere)
        {
            for (int i = Y + 1; i < stopeh; i++)
            {
                if (backg[i][X - 1] == a[wow])
                {
                    continue;
                }
                backg[i][X - 1] = '↑';
            }
        }
        thereisstuffthere = false;
    }
    
    // //find zone area;
    // public static int totalArea(char[][]backg, int height, int width, char a) {
    //     int size = 0;   
    //        for(int x=0;x<height;x++){
    //            for(int y=0;y<width;y++) {
    //                if(backg[x][y]==a) { size++; }
    //        }
    //        }
    //     return size; 
    //    }

    // Find final column
    public static
            int findareafwidth(char[][] backg, int height, int width, char a)
    {
        for (int x = 0; x < height; x++)
        {
            for (int y = 0; y < width - 1; y++)
            {
                if (backg[x][y] == a && backg[x][y + 1] != a)
                {
                    return y;
                }
                else if (backg[x][width - 1] == a)
                {
                    return width - 1;
                }
            }
        }
        return width - 1;
    }

    // Find final row
    public static int findareafheight(char[][] backg, int height, int width, char a)
    {
        for (int x = 0; x < height - 1; x++)
        {
            for (int y = 0; y < width - 1; y++)
            {
                if (backg[x][y] == a && backg[x + 1][y] != a)
                {
                    return x;
                }
                else if (backg[height - 1][y] == a)
                {
                    return width - 1;
                }
            }
        }
        return height - 1;
    }

    // Find the initial column
    public static int findareaiwidth(char[][] backg, int height, int width, char a)
    {
        for (int x = 0; x < height; x++)
        {
            for (int y = 0; y < width; y++)
            {
                if (backg[x][y] == a)
                {
                    return y;
                }
            }
        }
        return width - 1;
    }

    // Find initial row
    public static int findareaiheight(char[][] backg, int height, int width, char a)
    {
        for (int x = 0; x < height; x++)
        {
            for (int y = 0; y < width - 1; y++)
            {
                if (backg[x][y] == a)
                {
                    return x;
                }
            }
        }
        return height - 1;
    }

    static void divideArea(char backg[][], int height, int width)
    {
        //random pick a point to divide area
        char[] areanum =
        {
            '3', '4', '5', '6'
        };
        int w = 0, j = 0, x, distancex = 0, distancey = 0;
        Random R = new Random();
        int[] Cubepoint = new int[4];

        while (w < 4)
        {
            Cubepoint[w] = R.nextInt(4);
            while (j < w)
            {
                if (Cubepoint[w] == Cubepoint[j])
                {
                    Cubepoint[w] = R.nextInt(4);
                    j = 0;
                }
                else
                {
                    j++;
                }
            }
            j = 0;
            switch (Cubepoint[w])
            {
                case 0://atah kiri
                    if (backg[0][0] != '0')
                    {
                        break;
                    }
                    for (x = 0; x < width; x++)
                    {
                        if (backg[0][x] != '0')
                        {
                            break;
                        }
                        distancex++;
                    }
                    for (x = 0; x < height; x++)
                    {
                        if (backg[x][0] != '0')
                        {
                            break;
                        }
                        distancey++;
                    }
                    for (x = 0; x < distancey; x++)
                    {
                        for (int i = 0; i < distancex; i++)
                        {
                            if (x == distancey - 1 && i == distancex - 1)
                            {
                                continue;
                            }
                            backg[x][i] = areanum[w];//alert
                        }
                    }
                    break;

                case 1://atah kanan
                    if (backg[0][width - 1] != '0')
                    {
                        break;
                    }
                    for (x = width - 1; x > 0; x--)
                    {
                        if (backg[0][x] != '0')
                        {
                            break;
                        }
                        distancex++;
                    }
                    for (x = 0; x < height; x++)
                    {
                        if (backg[x][width - 1] != '0')
                        {
                            break;
                        }
                        distancey++;
                    }
                    for (x = 0; x < distancey; x++)
                    {
                        for (int i = width - 1; i > width - 1 - distancex; i--)
                        {
                            if (x == distancey - 1 && i == width - distancex)
                            {
                                continue;
                            }
                            backg[x][i] = areanum[w];
                        }
                    }
                    break;

                case 2://bawah kanan
                    if (backg[height - 1][width - 1] != '0')
                    {
                        break;
                    }
                    for (x = width - 1; x > 0; x--)
                    {
                        if (backg[height - 1][x] != '0')
                        {
                            break;
                        }
                        distancex++;
                    }
                    for (x = height - 1; x > 0; x--)
                    {
                        if (backg[x][width - 1] != '0')
                        {
                            break;
                        }
                        distancey++;
                    }
                    for (x = height - 1; x > height - 1 - distancey; x--)
                    {
                        for (int i = width - 1; i > width - 1 - distancex; i--)
                        {
                            if (x == height - distancey && i == width - distancex)
                            {
                                continue;
                            }
                            backg[x][i] = areanum[w];
                        }
                    }

                    break;
                case 3://bawah kiri
                    if (backg[height - 1][0] != '0')
                    {
                        break;
                    }
                    for (x = 0; x < width - 1; x++)
                    {
                        if (backg[height - 1][x] != '0')
                        {
                            break;
                        }
                        distancex++;
                    }
                    for (x = height - 1; x > 0; x--)
                    {
                        if (backg[x][0] != '0')
                        {
                            break;
                        }
                        distancey++;
                    }
                    for (x = height - 1; x > width - 1 - distancey; x--)
                    {
                        for (int i = 0; i < distancex; i++)
                        {
                            if (x == height - distancey && i == distancex - 1)
                            {
                                continue;
                            }
                            backg[x][i] = areanum[w];
                        }
                    }
                    break;
                default:
                    break;
            }
            distancex = 0;
            distancey = 0;
            w++;
        }
    }

    public static void clear(char[][] backg, int height, int width)
    {
        for (int x = 0; x < height; x++)
        {
            for (int y = 0; y < width; y++)
            {
                if (backg[x][y] == '3' || backg[x][y] == '4' || backg[x][y] == '5' || backg[x][y] == '6')
                {
                    backg[x][y] = ' ';
                }
            }
        }
       
    }

    // Search the index where the value is minimum
    public static int minIndex(int[] array)
    {
        int minimum = array[0];
        int position = 0;
        for (int i = 1; i < array.length; i++)
        {
            if (minimum > array[i])
            {
                minimum = array[i];
                position = i;
            }
        }
        return position;
    }

    public static int iValue(int position)
    {
        if (position >= 0 && position < 4)
        {
            return 1;
        }
        else if (position >= 6 && position < 9)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

    public static void constructHub(int[][] points, char[][] map)
    {
        for (int i = 0; i < points.length; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                for (int k = 0; k < 2; k++)
                {
                    map[points[i][1] + j][points[i][0] + k] = 'Z';
                }
            }
        }
    }

    public static void generateSubwaySystem(int[][] points, int height, int width)
    {
        int counter;
        char[][] map = new char[height][width];

        
        int[] dValue = new int[9], currentNode = new int[2];
        int[][] otherNodes = new int[9][2];
        final char[] DIRECTION =
                {
                    '↖', '↑', '↗', '←', 'n', '→', '↙', '↓', '↘'
                };
        final int NUMSYMBOL = 8;
        for (int index = 0; index < 2; index++)
        {
            for (int i = 0; i < 3 - index; i++)
            {
                // Initialize and re-initialize at the beginning, this fixed position
                currentNode[0] = points[index * 3][0];
                currentNode[1] = points[index * 3][1];

                // Search until you've found the destination node
                while (true)
                {
                    counter = 0;
                    // For each surrounding node
                    for (int j = 0; j < 3; j++)
                    {
                        for (int k = 0; k < 3; k++)
                        {
                            otherNodes[counter][0] = currentNode[0] + k - 1;
                            otherNodes[counter][1] = currentNode[1] + j - 1;
                            dValue[counter] = Math.abs(points[i + 1][0] - otherNodes[counter][0]) + Math.abs(points[i + 1][1] - otherNodes[counter][1]);
                            counter++;
                        }
                    }

                    //  Find the surrounding node with the lowest dValue
                    int position = minIndex(dValue);

                    // Make that node the current node
                    currentNode[0] = otherNodes[position][0];
                    currentNode[1] = otherNodes[position][1];

                    // Map it
                    if (currentNode[0] == points[i + 1][0] && currentNode[1] == points[i + 1][1])
                    {
                        break;
                    }
                    map[currentNode[1]][currentNode[0]] = DIRECTION[position];

                    // This can be prettier
                    if (position == 0)
                    {
                        map[currentNode[1] + 1][Math.abs(currentNode[0] - 1)] = DIRECTION[(NUMSYMBOL - position)];
                    }
                    else if (position == 1)
                    {
                        map[currentNode[1]][Math.abs(currentNode[0] - 1)] = DIRECTION[(NUMSYMBOL - position)];
                    }
                    else if (position == 2)
                    {
                        map[Math.abs(currentNode[1] - 1)][Math.abs(currentNode[0] - 1)] = DIRECTION[(NUMSYMBOL - position)];
                    }
                    else if (position == 3)
                    {
                        map[currentNode[1] + 1][currentNode[0]] = DIRECTION[(NUMSYMBOL - position)];
                    }
                    else if (position == 5)
                    {
                        map[Math.abs(currentNode[1] - 1)][currentNode[0]] = DIRECTION[(NUMSYMBOL - position)];
                    }
                    else if (position == 6)
                    {
                        map[currentNode[1] + 1][currentNode[0] + 1] = DIRECTION[(NUMSYMBOL - position)];
                    }
                    else if (position == 7)
                    {
                        map[currentNode[1]][currentNode[0] + 1] = DIRECTION[(NUMSYMBOL - position)];
                    }
                    else if (position == 8)
                    {
                        map[Math.abs(currentNode[1] - 1)][currentNode[0] + 1] = DIRECTION[(NUMSYMBOL - position)];
                    }
                }
            }
        }

        // Put the hub for subway stations
        constructHub(points, map);
        
        SubwayGraphics subphic = new SubwayGraphics(height,width,map);
        subphic.setVisible(true);
        subphic.setLocation(600, 20);
       
    }
}