/**
 * Dan Peterson
 * 109091561
 * daniel.peterson@stonybrook.edu
 * Homework #7
 * CSE 214 Recitation #5
 * Sun Lin
 * @author Dan
 */

import java.util.ArrayList;
import java.util.Scanner;


public class SearchEngine {

	public static final String PAGES_FILE = "pages.txt";
	public static final String LINKS_FILE = "links.txt";
	private static WebGraph web;
	
	public static void main(String[] args)
	{
		WebGraph web = new WebGraph();
		try {
			web = WebGraph.buildFromFiles("pages.txt", "links.txt");
			System.out.println("WebGraph successfully loaded!");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("Cannot load file.");
		}
		Boolean flag = false;
		Boolean flag2 = false;
		String choice = null;
		String choice2 = null;
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		Scanner input3 = new Scanner(System.in);
		System.out.print("\nMenu:\n\t(AP) - Add a new page to the graph\n\t(RP) - Remove a page from the graph");
		System.out.print("\n\t(AL) - Add a link between pages in the graph\n\t(RL) - Remove a link between pages in the graph\n\t(P) - Print the graph");
		System.out.print("\n\t(S) - Search for pages with a keyword\n\t(Q) - Quit\n");
		while(flag == false)
		{
			flag2 = false;
			System.out.print("Please select an option: ");
			choice = input.nextLine();
			switch(choice.toLowerCase())
			{
			case "ap":
				System.out.print("Enter a URL: ");
				String url = input.nextLine();
				System.out.print("Enter keywords (space-separated): ");
				String keywords = input.nextLine();
				String[] keywords2 = keywords.split(" ");
				ArrayList<String> l = new ArrayList<String>();
				for(int i = 0; i < (keywords2.length); i++)
				{
					l.add(keywords2[i]);
				}
				try
				{
					web.addPage(url, l);
					System.out.println(url + " has been added to the WebGraph!");
					web.updatePageRanks();
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				
				break;
			
			case "rp":
				System.out.print("Enter a URL: ");
				String url3 = input.nextLine();
				try
				{
				web.removePage(url3);	
				System.out.println(url3 + " has been removed from the graph!");
				web.updatePageRanks();
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
			
			case "al":
				System.out.print("Enter a source URL: ");
				String url1 = input.nextLine();
				System.out.print("Enter a destination URL: ");
				String url2 = input.nextLine();
				try
				{
				web.addLink(url1, url2);
				web.updatePageRanks();
				System.out.println("Link successfully added from " + url1 + " to " + url2 + "!");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
			
			case "rl":
				System.out.print("Enter a source URL: ");
				String url4 = input.nextLine();
				System.out.print("Enter a destination URL: ");
				String url5 = input.nextLine();
				try
				{
				web.removeLink(url4, url5);
				web.updatePageRanks();
				System.out.println("Link removed from " + url4 + " to " + url5 + "!");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
			
			case "p":
				System.out.println();
				while(flag2 == false)
				{
					System.out.print("\t(I) Sort based on index (ASC)\n\t(U) Sort based on URL (ASC)\n\t(R) Sort based on rank (DSC)\n\nPlease select an option: ");
					choice2 = input.nextLine();
					switch(choice2.toLowerCase())
					{
					case "i":
						System.out.println("Index\tURL\t\tPageRank\t\tKeywords\t\tLinks\n-------------------------------------------------------------------------------------------");
						web.printTable();
						flag2 = true;
						break;
						
					case "u":
						System.out.println("Index\tURL\t\tPageRank\t\tKeywords\t\tLinks\n-------------------------------------------------------------------------------------------");
						web.printTable2();
						flag2 = true;
						break;
						
					case "r":
						System.out.println("Index\tURL\t\tPageRank\t\tKeywords\t\tLinks\n-------------------------------------------------------------------------------------------");
						web.printTable3(web);
						flag2 = true;
						break;
						
					default:	
						System.out.println("Invalid input, please try again.");	
						break;
					}
					System.out.println();
				}
				break;
				
			case "s":
				System.out.print("Search keyword: ");
				String keyword = input.nextLine();
				web.search(keyword);
				break;
				
			case "q":
				flag = true;
				break;
				
			default:	
				System.out.println("Invalid input, please try again.");	
				break;
				
			}
		}
		System.out.println("Program terminating successfully");
	}
}
