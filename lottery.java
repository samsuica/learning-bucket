package lottery;

import javax.swing.JOptionPane;
import java.util.Random;

public class lottery {

	public static void main(String[] args)
	{
		int selection;
		
		play_lottery pickfour = new play_lottery();
		selection = pickfour.menu();
		while(selection !=3)
		{
			if (selection == 1)
			{
	
				pickfour.get_numbers();
			}
			if (selection == 2)
			{
				pickfour.print_winners();
			}
		
		selection = pickfour.menu();
		}
		System.exit(0);
	}
	

}

class play_lottery
{
	int[] firstnumber = new int[100];
	int[] secondnumber = new int[100];
	int[] thirdnumber = new int[100];
	int[] fourthnumber = new int[100];
	int winningnumber1 = 0, winningnumber2 = 0, winningnumber3 = 0, winningnumber4 = 0, winningnumbercount = 0, totalgames, totalwinnings = 0, winner1 = 0, winner2 = 0, winner3 = 0, winner4 = 0;
	int nothingwon = 0, onewon = 0, twowon = 0, threewon = 0, fourwon = 0;
	int count = -1;
	int x = 1;
	
	Random choosewinningnumber = new Random();
	
	
	
	int menu()
	{
		int selection;
		String value;
		String output="Sam's Pick Four Lottery"+"\n"+
			"1.  Play Pick Four Lottery"+"\n"+
			"2.  Print Winnings Results "+"\n"+
			"3.  EXIT "+"\n"+
			"Enter your selection >";
			 value =JOptionPane.showInputDialog(null,
				        output,"Input Data",JOptionPane.QUESTION_MESSAGE);
	         selection =Integer.parseInt(value);
		
		return selection;
	}
	
	void get_numbers()
	{
		String value, playagain = "yes";
		int i;
		
		
		while(playagain.equals("yes"))
		{
		create_winning_numbers();
		count = count +1;
		
	//INPUT FOR FIRST NUMBER
		x = 1;
		while(x == 1) {		
	try {
		value = JOptionPane.showInputDialog(null, "Enter First Number", "Pick 4 Lottery", JOptionPane.QUESTION_MESSAGE);
		firstnumber[count] = Integer.parseInt(value);
		
		if((firstnumber[count] < 1) || (firstnumber[count] > 40))
		{
			JOptionPane.showMessageDialog(null, "NUMBER MUST BE BETWEEN 0 AND 41", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);	
			x = 1;
			
		}
		else {
			x =2;
		}
	
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "NUMBER MUST BE AN INTEGER", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
					
		}
		}
	// END OF INPUT FOR FIRST NUMBER	
		
			
	//INPUT FOR SECOND NUMBER	
		x = 1;
		while(x == 1)
		try {
			value = JOptionPane.showInputDialog(null, "Enter Second Number", "Pick 4 Lottery", JOptionPane.QUESTION_MESSAGE);
			secondnumber[count] = Integer.parseInt(value);
			
			if((secondnumber[count] < 1) || (secondnumber[count] > 40))
			{
				JOptionPane.showMessageDialog(null, "NUMBER MUST BE BETWEEN 0 AND 41", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
				x = 1;
			}
			else if(secondnumber[count] == firstnumber[count])
			{
				JOptionPane.showMessageDialog(null, "ALL NUMBERS MUST BE UNIQUE"+"\n"+"Pick a number that is different from previously entered", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
			
				x = 1;			
			}
			else 
				x = 2;		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "NUMBER MUST BE AN INTEGER", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
		}
	// END OF INPUT FOR SECOND NUMBER
		
	// INPUT FOR THIRD NUMBER
		x = 1;
		while(x == 1)
		{
		try {
			value = JOptionPane.showInputDialog(null, "Enter Third Number", "Pick 4 Lottery", JOptionPane.QUESTION_MESSAGE);
			thirdnumber[count] = Integer.parseInt(value);
			if((thirdnumber[count] < 1) || (thirdnumber[count] > 40))
			{
				JOptionPane.showMessageDialog(null, "NUMBER MUST BE BETWEEN 0 AND 41", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
				x = 1;
			}
			else if(thirdnumber[count] == firstnumber[count])
			{
				JOptionPane.showMessageDialog(null, "ALL NUMBERS MUST BE UNIQUE"+"\n"+"Pick a number that is different from previously entered", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
				x = 1;
			}
			else if(thirdnumber[count] == secondnumber[count])
			{
				JOptionPane.showMessageDialog(null, "ALL NUMBERS MUST BE UNIQUE"+"\n"+"Pick a number that is different from previously entered", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
				x = 1;
			}
			else 
				x = 2;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "NUMBER MUST BE AN INTEGER", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
				
		}
		}
	// END INPUT FOR THIRD NUMBER 
	
	// INPUT FOR FOURTH NUMBER
		x = 1;
		while(x == 1)
		{
		try {
			value = JOptionPane.showInputDialog(null, "Enter Fourth Number", "Pick 4 Lottery", JOptionPane.QUESTION_MESSAGE);
			fourthnumber[count] = Integer.parseInt(value);
			if((fourthnumber[count] < 1) || (fourthnumber[count] > 40))
			{
				JOptionPane.showMessageDialog(null, "NUMBER MUST BE BETWEEN 0 AND 41", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
				x = 1;
			}
			else if(fourthnumber[count] == firstnumber[count])
			{
				JOptionPane.showMessageDialog(null, "ALL NUMBERS MUST BE UNIQUE"+"\n"+"Pick a number that is different from previously entered", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
				x = 1;
			}
			else if(fourthnumber[count] == secondnumber[count])
			{
				JOptionPane.showMessageDialog(null, "ALL NUMBERS MUST BE UNIQUE"+"\n"+"Pick a number that is different from previously entered", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
				x = 1;
			}
			else if(fourthnumber[count] == thirdnumber[count])
			{
				JOptionPane.showMessageDialog(null, "ALL NUMBERS MUST BE UNIQUE"+"\n"+"Pick a number that is different from previously entered", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
				x = 1;
			}
			else 
				x = 2;
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "NUMBER MUST BE AN INTEGER", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);	
		}
		
		}
		// END INPUT FOR FOURTH NUMBER	
		
		//determines winnings and matches
				
				if((firstnumber[count] == winningnumber1) ||(firstnumber[count] == winningnumber2) ||(firstnumber[count] == winningnumber3) ||(firstnumber[count] == winningnumber4))
				{
					winningnumbercount = winningnumbercount + 1;	
					winner1 = firstnumber[count];
				}
				
				if((secondnumber[count] == winningnumber1) ||(secondnumber[count] == winningnumber2) ||(secondnumber[count] == winningnumber3) ||(secondnumber[count] == winningnumber4))
				{
					winningnumbercount = winningnumbercount + 1;
					winner2 = secondnumber[count];
				}

				if((thirdnumber[count] == winningnumber1) ||(thirdnumber[count] == winningnumber2) ||(thirdnumber[count] == winningnumber3) ||(thirdnumber[count] == winningnumber4))
				{
					winningnumbercount = winningnumbercount + 1;	
					winner3 = thirdnumber[count];
				}
					
				if((fourthnumber[count] == winningnumber1) ||(fourthnumber[count] == winningnumber2) ||(fourthnumber[count] == winningnumber3) ||(fourthnumber[count] == winningnumber4))
				{
					winningnumbercount = winningnumbercount + 1;	
					winner4 = fourthnumber[count];
				}
				
				
				
					if(winningnumbercount == 1)
					{
						totalwinnings = totalwinnings + 100;
						onewon = onewon +1;
						JOptionPane.showMessageDialog(null, "CONGRATULATIONS"+"\n"+"You have matched one number. $100 has been added to your winnings!", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
						
					}
					if(winningnumbercount == 2)
					{
						totalwinnings = totalwinnings + 1000;
						twowon = twowon +1;
						JOptionPane.showMessageDialog(null, "CONGRATULATIONS"+"\n"+"You have matched two numbers. $1,000 has been added to your winnings!", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
						
					}
					if(winningnumbercount == 3)
					{
						totalwinnings = totalwinnings + 50000;
						threewon = threewon +1;
						JOptionPane.showMessageDialog(null, "CONGRATULATIONS"+"\n"+"You have matched three numbers. $50,000 has been added to your winnings!", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
					}
					if(winningnumbercount == 4)
					{
						totalwinnings = totalwinnings + 500000;
						fourwon = fourwon +1;
						JOptionPane.showMessageDialog(null, "CONGRATULATIONS"+"\n"+"You have matched four numbers. $500,000 has been added to your winnings!", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
						
					}
					
					
				
				
				if(winningnumbercount == 0)
				{
					nothingwon = nothingwon + 1;
					JOptionPane.showMessageDialog(null, "Sorry! You did not win. Better luck next time", "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
				}
				
				//end determines winnings and matches
				winningnumbercount = 0;		
				
				JOptionPane.showMessageDialog(null, "Winning Numbers: "+winningnumber1+" "+winningnumber2+" "+winningnumber3+" "+winningnumber4+"\n"+"\n"+"Your numbers: "+firstnumber[count]+" "+secondnumber[count]+" "+thirdnumber[count]+" "+fourthnumber[count], "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
				
		playagain = JOptionPane.showInputDialog(null, "Do You Want To Play Again?"+"\n" +"Enter Yes or No", "", JOptionPane.QUESTION_MESSAGE);
		playagain.toLowerCase();
		
		}
		
		
		totalgames = count;
		
		
	}
	void create_winning_numbers()
	{
	
		int x = 1;
		
		//Ensures the computer chooses 4 unique numbers
		while(x == 1)
		{
		winningnumber1 = 1+ choosewinningnumber.nextInt(40);
		winningnumber2 = 1+ choosewinningnumber.nextInt(40);
		winningnumber3 = 1 + choosewinningnumber.nextInt(40);
		winningnumber4 = 1+ choosewinningnumber.nextInt(40);
		if(winningnumber2 == winningnumber1)
		{
			x = 1;
		}
		else if(winningnumber3 == winningnumber1)
		{
			x = 1;
		}
		else if(winningnumber3 == winningnumber2)
		{
			x = 1;
		}
		else if(winningnumber4 == winningnumber1)
		{
			x = 1;
		}
		else if(winningnumber4 == winningnumber2)
		{
			x = 1;
		}
		else if(winningnumber4 == winningnumber3)
		{
			x = 1;
		}
		else 
			x = 2;
		
		}
		
		System.out.println(winningnumber1+" "+winningnumber2+" "+winningnumber3+" "+winningnumber4);
		
}
	void print_winners()
	{
		double zeropercent, onepercent, twopercent, threepercent, fourpercent;
		
		zeropercent = ((nothingwon * 1.00) / (count +1)) *100 ;
		onepercent = ((onewon * 1.00) / (count +1)) * 100  ;
		twopercent = ((twowon * 1.00) / (count +1)) * 100 ;
		threepercent = ((threewon * 1.00) / (count +1)) * 100 ;
		fourpercent = ((fourwon * 1.00) / (count +1)) * 100 ;
		
		JOptionPane.showMessageDialog(null,"Total Games Played: "+(count+1)+"\n"+"\n"+"0 numbers matched: "+nothingwon+"\n"+"1 number matched: "+onewon+"\n"+"2 numbers matched: "+twowon+"\n"+"3 numbers matched: "+threewon+"\n"+"4 numbers matched: "+fourwon+"\n"+"\n"+"Percent of times 0 numbers matched: "+zeropercent+"%"+"\n"+"Percent of times 1 number matched: "+onepercent+"%"+"\n"+"Percent of times 2 numbers matched: "+twopercent+"%"+"\n"+"Percent of times 3 numbers matched: "+threepercent+"%"+"\n"+"Percent of times 4 numbers matched: "+fourpercent+"%"+"\n"+"\n"+"Winnings: "+"$"+totalwinnings, "Pick 4 Lottery", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
