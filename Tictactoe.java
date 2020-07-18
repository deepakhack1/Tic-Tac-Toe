package Tic_tac_toe;

import java.util.Scanner;

public class Tictactoe {

	private Player player1,player2;
	private Board board;

	public static void main(String a[])
	{
		Tictactoe t = new Tictactoe();
		t.startGame();
	}
	
	
	
	public void startGame()
	{
		player1 = takeInput(1);
		player2 =  takeInput(2);
		
		Scanner s = new Scanner(System.in);
		
		while(player1.getSymbol() == player2.getSymbol())
		{
			System.out.println("symbol already taken || pick another symbol");
			
			char symbol = s.next().charAt(0);
			
			player2.setSymbol(symbol);
			
		}
		
		
		board = new Board(player1.getSymbol(),player2.getSymbol());		
	
		boolean player1Turn = true;
		
		int status = Board.incomplete;
		
		while(status == Board.incomplete || status == Board.invalid )
		{
			if(player1Turn)
			{
				System.out.println("player1"+player1.getName()+"'sturn");
				System.out.println("enter x : ");
				int x = s.nextInt();
				System.out.println("enter y : ");
				int y = s.nextInt();
				
				 status = board.move(player1.getSymbol(),x,y);
				
				if(status != board.invalid)
				{
					player1Turn = false;
					board.print();

				}
				else
				{
					System.out.println("invalid move try again");
				}

				
			}
			
			else
			{
				System.out.println("player2"+player2.getName()+"'sturn");
				System.out.println("enter x : ");
				int x = s.nextInt();
				System.out.println("enter y : ");
				int y = s.nextInt();
				
			    status = board.move(player2.getSymbol(),x,y);
				
				if(status != board.invalid)
				{
					player1Turn = true;
					board.print();
				}
				else
				{
					System.out.println("invalid move try again");
				}
				
			}
			
			
		}
		
		if(status == Board.player1_win)
		{
			System.out.println("----------------player1 win--------------------");
		}
		
		else if(status == Board.player2_win)
		{
			System.out.println("----------------player2 win--------------------");
		}
		
		else
		{
			System.out.println("----------------DRAW-----------------------------");
		}
	
	}
	

	
	
	
	private Player takeInput(int num)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter player "+num+"name ");
		String name = sc.nextLine();
		System.out.println("Enter player "+num+"symbol ");
		char symbol = sc.next().charAt(0);
		
		Player p = new Player(name,symbol);
		return p;
	
	}
	
}
