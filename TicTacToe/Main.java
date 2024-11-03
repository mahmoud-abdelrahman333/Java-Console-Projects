
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);

		TicTacToe();

	}
	public static void TicTacToe(){
		Scanner in =new Scanner(System.in);

		char [][] board=new char[3][3];
		for (int row=0 ; row<board.length ; row++){
			for (int col=0 ; col<board[row].length ; col++){
				board[row][col]=' ';
			}
		}
		System.out.println("Who will start X or Y ?");
		char player=in.next().charAt(0);
		if((int)player>=97){
			player-=32;
		}
		boolean gameOver=false;

		while(!gameOver){
			printBoard(board);
			System.out.println("Player "+ player +" enter: ");
			int row=in.nextInt();
			int col=in.nextInt();
			if(row>=3 || col >=3){
				System.out.println("Error: numbers out of range please try again.");
				continue;
			}
			if(board[row][col]==' '){
				board[row][col]=player;
				gameOver=haveWon(board,player);
				if(gameOver){
					System.out.println("Player"+ player +" has Won: ");
				}
				else {
					player =(player=='X') ? 'O' : 'X';
				}
			}
			else {
				System.out.println("The position is Already Taken, Enter another position.");

			}
			if(BoardIsFull(board)){
				System.out.println("Draw");
				break;
			}
		}

	}
	public static boolean haveWon(char [][]board,char player){
		// chech the rows
		for (int row=0 ; row<board.length ; row++){
			if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
				return true;
			}
		}
		// chech the columns
		for (int col=0 ; col<board.length ; col++){
			if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
				return true;
			}
		}
		// check the diagonals
		if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
			return true;
		}
		if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
			return true;
		}
		return false;

	}
	public static void printBoard(char [][] board){
		for (int row=0 ; row<board.length ; row++){
			for (int col=0 ; col<board[row].length ; col++){
				System.out.print(board[row][col]);
				if(col!=board[row].length-1){
					System.out.print(" | ");
				}
			}
			System.out.println();
		}
	}
	public static boolean BoardIsFull(char board[][]){
		for (int row=0 ; row<board.length ; row++){
			for(int col=0 ; col <board[row].length ; col++){
				if(board[row][col]==' '){
					return false;
				}
			}
		}
		return true;
	}


}

