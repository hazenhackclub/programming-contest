package ivan_pegs_ver2;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class challange6_2020_PLU {
    static Scanner scan;
    static boolean isSolvable;
    public static  void main(String[] args){

        try {
            File file = new File(".\\src\\ivan_pegs_ver2\\challange6-ver2.dat");
            scan = new Scanner(file);    
        } 
        catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND !!!.");
            e.printStackTrace(); 
        }

        int number_of_games = Integer.parseInt(scan.nextLine());

        int game_tracker = 0;
        while(game_tracker < number_of_games){
            isSolvable = false;
            String[] board_dimensions = scan.nextLine().split(" ");

            Character[][] grid = new Character[Integer.parseInt(board_dimensions[0])][Integer.parseInt(board_dimensions[0])];
            


            int board_line_tracker = 0;
            while(board_line_tracker < Integer.parseInt(board_dimensions[0])){
                
                String[] line = scan.nextLine().split("");
                
                int index_tracker = 0;
                while(index_tracker < line.length){
                    grid[board_line_tracker][index_tracker] = line[index_tracker].charAt(0);
                    index_tracker++;
                    
                    }
                    while(index_tracker <  Integer.parseInt(board_dimensions[0])){
                        
                        grid[board_line_tracker][index_tracker] = ' ';  
                        index_tracker++;  
                }

                board_line_tracker++;
            }



            game_tracker++;

            solveThisBoard(grid);

            if(isSolvable){
                System.out.println("SOLVEABLE!");
            }
            else{
                System.out.println("Imposible.");
            }
        }

    }
    private static void solveThisBoard(Character[][] grid) {
        //System.out.println();
        for(Character[] line: grid){
            for(Character char1: line){
                //System.out.print(char1 + " ");
            }
        }

        int num_of_pegs = 0;
        for(Character[] line: grid){
            for(Character char1: line){
                if(char1 == '@'){
                    num_of_pegs++;
                }
            }
        }

        Integer[][] pegs = new Integer[num_of_pegs][2];
        num_of_pegs = 0;
        int row = 0;
        for(Character[] line: grid){
            int col = 0;
            for(Character char1: line){
                if(char1 == '@'){
                    pegs[num_of_pegs][0] = row;
                    pegs[num_of_pegs][1] = col;
                    num_of_pegs++;
                }
                col++;
            }
            row++;
        }

        if(num_of_pegs == 1){
            isSolvable = true;
        }
        //System.out.println("Num of pegs: " + num_of_pegs);

        for(Integer[] location: pegs){
            try{
                //check up
                if(grid[location[0]-1][location[1]] == '@' && grid[location[0]-2][location[1]] == '.'){
                    grid[location[0]][location[1]] = '.';
                    grid[location[0]-1][location[1]] = '.';
                    grid[location[0]-2][location[1]] = '@';
                    solveThisBoard(grid);
                    grid[location[0]][location[1]] = '@';
                    grid[location[0]-1][location[1]] = '@';
                    grid[location[0]-2][location[1]] = '.';
                }
            }
            catch(IndexOutOfBoundsException e){
                //System.out.println("ERROR: " + e);
            }
                //check down
            try{
                if(grid[location[0]+1][location[1]] == '@' && grid[location[0]+2][location[1]] == '.'){
                    grid[location[0]][location[1]] = '.';
                    grid[location[0]+1][location[1]] = '.';
                    grid[location[0]+2][location[1]] = '@';
                    solveThisBoard(grid);
                    grid[location[0]][location[1]] = '@';
                    grid[location[0]+1][location[1]] = '@';
                    grid[location[0]+2][location[1]] = '.';
                }
            }
            catch(IndexOutOfBoundsException e){
                //System.out.println("ERROR: " + e);
            }
            try{
                //check left
                if(grid[location[0]][location[1]-1] == '@' && grid[location[0]][location[1]-2] == '.'){
                    grid[location[0]][location[1]] = '.';
                    grid[location[0]][location[1]-1] = '.';
                    grid[location[0]][location[1]-2] = '@';
                    solveThisBoard(grid);
                    grid[location[0]][location[1]] = '@';
                    grid[location[0]][location[1]-1] = '@';
                    grid[location[0]][location[1]-2] = '.';
                }
            }
            catch(IndexOutOfBoundsException e){
                //System.out.println("ERROR: " + e);
            }
            try{
                //check right
                if(grid[location[0]][location[1]+1] == '@' && grid[location[0]][location[1]+2] == '.'){
                    grid[location[0]][location[1]] = '.';
                    grid[location[0]][location[1]+1] = '.';
                    grid[location[0]][location[1]+2] = '@';
                    solveThisBoard(grid);
                    grid[location[0]][location[1]] = '@';
                    grid[location[0]][location[1]+1] = '@';
                    grid[location[0]][location[1]+2] = '.';
                }
            }
            catch(IndexOutOfBoundsException e){
                //System.out.println("ERROR: " + e);
                }
            }         
    }
}
