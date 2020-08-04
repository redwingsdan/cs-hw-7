/**
 * Dan Peterson
 * 109091561
 * daniel.peterson@stonybrook.edu
 * Homework #7
 * CSE 214 Recitation #5
 * Sun Lin
 * @author Dan
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The WebGraph class creates a graph to hold all of the WebPage objects as well as their links. Each WebPage is added
 * to an ArrayList of WebPages and the links will be given by a 2D array. If WebPage 1 links to WebPage 2, then the row
 * for WebPage 1 and the column for WebPage 2 will have a 1, indicating that there is a link. The initial WebPages and links
 * are provided by 2 text files. The WebGraph class contains functions to add additional pages and links as well as to
 * remove pages and links. There are functions to print the WebGraph in 3 ways; sorted by index, sorted by rank and sorted
 * by URL. There is a function to update the rank of the WebPages after every modification to the WebGraph. There are also
 * functions to clone the WebGraph and to search for WebPages in the WebGraph which contain a given keyword.
 */
public class WebGraph {
	private static final int MAX_PAGES = 40;
	private ArrayList<WebPage> pages;
	private int[][] edges = new int [MAX_PAGES][MAX_PAGES];
	
	public WebGraph()
	{
		pages = new ArrayList<WebPage>();
		edges = new int [MAX_PAGES][MAX_PAGES];
	}
	/**
	 * Sets the value of <code>pages</code> to the value passed in.
	 * @param pages - ArrayList < WebPage >
	 */
	public void setPages(ArrayList<WebPage>pages)
	{
		this.pages = pages;
	}
	
	/**
	 * Sets the value of <code>edges</code> to the value passed in.
	 * @param edges - Array[][] int
	 */
	public void setEdges(int[][]edges)
	{
		this.edges = edges;
	}
	
	/**
	 * Returns the value of <code>pages</code>
	 * @return pages - ArrayList < WebPage >
	 */
	public ArrayList<WebPage> getPages()
	{
		return pages;
	}
	
	/**
	 * Returns the value of <code>edges</code>
	 * @return edges - Array[][] int
	 */
	public int[][] getEdges()
	{
		return edges;
	}
	
	/**
	 * Creates a WebGraph from two text files containing the URLs and links of assorted WebPages.
	 * @param pagesFile - The name of the file that contains the list of URLs
	 * @param linksFile - The name of the file that contains the list of links the pages link to.
	 * @return web - WebGraph
	 * @throws IllegalArgumentException - Indicates that one or more of the files is invalid and cannot be read.
	 * @throws IOException - Indicates that the reading of the file cannot be done
	 * @throws FileNotFoundException - Indicates that the files does not exist
	 */
	public static WebGraph buildFromFiles(String pagesFile, String linksFile) throws IllegalArgumentException, FileNotFoundException, IOException
	{
		WebGraph web = new WebGraph();
		String everything2 = null;
		
		try(BufferedReader br = new BufferedReader(new FileReader(pagesFile))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    everything2 = everything;
		}
		String[] words = everything2.split("\n");
		String[] pagelist = null;
		String[] pagelist2 = null;
		String[] pagelist3 = null;
		String[] pagelist4 = null;
		String[] pagelist5 = null;
		String[] pagelist6 = null;
		String[] pagelist7 = null;

	    	pagelist = words[0].split(" ");
	    	
	    	pagelist2 = words[1].split(" ");

	    	pagelist3 = words[2].split(" ");
	  
	    	pagelist4 = words[3].split(" ");
	   
	    	pagelist5 = words[4].split(" ");

	    	pagelist6 = words[5].split(" ");
	   
	    	pagelist7 = words[6].split(" ");

	    ArrayList<String> l = new ArrayList<String>();
	    ArrayList<String> l2 = new ArrayList<String>();
	    ArrayList<String> l3 = new ArrayList<String>();
	    ArrayList<String> l4 = new ArrayList<String>();
	    ArrayList<String> l5 = new ArrayList<String>();
	    ArrayList<String> l6 = new ArrayList<String>();
	    ArrayList<String> l7 = new ArrayList<String>();

		for(int i = 1; i < (pagelist.length); i++)
		{
			if(i == (pagelist.length-1))
			{
				String[] teststring = pagelist[i].split("\r");
				l.add(teststring[0]);
			}
			else
			{
				l.add(pagelist[i]);
			}
		}
		for(int i = 1; i < (pagelist2.length); i++)
		{
			if(i == (pagelist2.length-1))
			{
				String[] teststring2 = pagelist2[i].split("\r");
				l2.add(teststring2[0]);
			}
			else
			{
				l2.add(pagelist2[i]);
			}
		}
		for(int i = 1; i < (pagelist3.length); i++)
		{
			if(i == (pagelist3.length-1))
			{
				String[] teststring3 = pagelist3[i].split("\r");
				l3.add(teststring3[0]);
			}
			else
			{
				l3.add(pagelist3[i]);
			}
		}
		for(int i = 1; i < (pagelist4.length); i++)
		{
			if(i == (pagelist4.length-1))
			{
				String[] teststring4 = pagelist4[i].split("\r");
				l4.add(teststring4[0]);
			}
			else
			{
				l4.add(pagelist4[i]);
			}
		}
		for(int i = 1; i < (pagelist5.length); i++)
		{
			if(i == (pagelist5.length-1))
			{
				String[] teststring5 = pagelist5[i].split("\r");
				l5.add(teststring5[0]);
			}
			else
			{
				l5.add(pagelist5[i]);
			}
		}
		for(int i = 1; i < (pagelist6.length); i++)
		{
			if(i == (pagelist6.length-1))
			{
				String[] teststring6 = pagelist6[i].split("\r");
				l6.add(teststring6[0]);
			}
			else
			{
				l6.add(pagelist6[i]);
			}
		}
		for(int i = 1; i < (pagelist7.length); i++)
		{
			if(i == (pagelist7.length-1))
			{
				String[] teststring7 = pagelist7[i].split("\r");
				l7.add(teststring7[0]);
			}
			else
			{
				l7.add(pagelist7[i]);
			}
		}
		try
		{
			web.addPage(pagelist[0], l);
//			System.out.println(pagelist[0] + " has been added to the WebGraph!");	
			web.addPage(pagelist2[0], l2);
//			System.out.println(pagelist2[0] + " has been added to the WebGraph!");
			web.addPage(pagelist3[0], l3);
//			System.out.println(pagelist3[0] + " has been added to the WebGraph!");
			web.addPage(pagelist4[0], l4);
//			System.out.println(pagelist4[0] + " has been added to the WebGraph!");
			web.addPage(pagelist5[0], l5);
//			System.out.println(pagelist5[0] + " has been added to the WebGraph!");
			web.addPage(pagelist6[0], l6);
//			System.out.println(pagelist6[0] + " has been added to the WebGraph!");
			web.addPage(pagelist7[0], l7);
//			System.out.println(pagelist7[0] + " has been added to the WebGraph!");
			web.updatePageRanks();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader(linksFile))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    everything2 = everything;
		}
		
		String[] link = everything2.split("\n");
		String[] linklist = null;
		String[] linklist2 = null;
		String[] linklist3 = null;
		String[] linklist4 = null;
		String[] linklist5 = null;
		String[] linklist6 = null;
		String[] linklist7 = null;
		String[] linklist8 = null;
		String[] linklist9 = null;
		String[] linklist10 = null;
		String[] linklist11 = null;
		String[] linklist12 = null;
		String[] linklist13 = null;
		String[] linklist14 = null;
		
	    	linklist = link[0].split(" ");

	    	linklist2 = link[1].split(" ");
	  
	    	linklist3 = link[2].split(" ");
	    
	    	linklist4 = link[3].split(" ");
	    
	    	linklist5 = link[4].split(" ");
	   
	    	linklist6 = link[5].split(" ");
	
	    	linklist7 = link[6].split(" ");

	    	linklist8 = link[7].split(" ");

	    	linklist9 = link[8].split(" ");

	    	linklist10 = link[9].split(" ");
	    
	    	linklist11 = link[10].split(" ");
	 
	    	linklist12 = link[11].split(" ");

	    	linklist13 = link[12].split(" ");

	    	linklist14 = link[13].split(" ");

	    	String[] teststring = linklist[1].split("\r");
	    	String[] teststring2 = linklist2[1].split("\r");
	    	String[] teststring3 = linklist3[1].split("\r");
	    	String[] teststring4 = linklist4[1].split("\r");
	    	String[] teststring5 = linklist5[1].split("\r");
	    	String[] teststring6 = linklist6[1].split("\r");
	    	String[] teststring7 = linklist7[1].split("\r");
	    	String[] teststring8 = linklist8[1].split("\r");
	    	String[] teststring9 = linklist9[1].split("\r");
	    	String[] teststring10 = linklist10[1].split("\r");
	    	String[] teststring11 = linklist11[1].split("\r");
	    	String[] teststring12 = linklist12[1].split("\r");
	    	String[] teststring13 = linklist13[1].split("\r");
	    	String[] teststring14 = linklist14[1].split("\r");
	    	
	    	try
			{
			web.addLink(linklist[0], teststring[0]);
//			System.out.println("Link successfully added from " + linklist[0] + " to " + teststring[0] + "!");
			web.addLink(linklist2[0], teststring2[0]);
//			System.out.println("Link successfully added from " + linklist2[0] + " to " + teststring2[0] + "!");
			web.addLink(linklist3[0], teststring3[0]);
//			System.out.println("Link successfully added from " + linklist3[0] + " to " + teststring3[0] + "!");
			web.addLink(linklist4[0], teststring4[0]);
//			System.out.println("Link successfully added from " + linklist4[0] + " to " + teststring4[0] + "!");
			web.addLink(linklist5[0], teststring5[0]);
//			System.out.println("Link successfully added from " + linklist5[0] + " to " + teststring5[0] + "!");
			web.addLink(linklist6[0], teststring6[0]);
//			System.out.println("Link successfully added from " + linklist6[0] + " to " + teststring6[0] + "!");
			web.addLink(linklist7[0], teststring7[0]);
//			System.out.println("Link successfully added from " + linklist7[0] + " to " + teststring7[0] + "!");
			web.addLink(linklist8[0], teststring8[0]);
//			System.out.println("Link successfully added from " + linklist8[0] + " to " + teststring8[0] + "!");
			web.addLink(linklist9[0], teststring9[0]);
//			System.out.println("Link successfully added from " + linklist9[0] + " to " + teststring9[0] + "!");
			web.addLink(linklist10[0], teststring10[0]);
//			System.out.println("Link successfully added from " + linklist10[0] + " to " + teststring10[0] + "!");
			web.addLink(linklist11[0], teststring11[0]);
//			System.out.println("Link successfully added from " + linklist11[0] + " to " + teststring11[0] + "!");
			web.addLink(linklist12[0], teststring12[0]);
//			System.out.println("Link successfully added from " + linklist12[0] + " to " + teststring12[0] + "!");
			web.addLink(linklist13[0], teststring13[0]);
//			System.out.println("Link successfully added from " + linklist13[0] + " to " + teststring13[0] + "!");
			web.addLink(linklist14[0], teststring14[0]);
//			System.out.println("Link successfully added from " + linklist14[0] + " to " + teststring14[0] + "!");
			web.updatePageRanks();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		return web;
	}
	
	/**
	 * Adds a WebPage to the WebGraph
	 * @param url - The name of the WebPage being added - String
	 * @param keywords - The keywords used to describe the WebPage - ArrayList < String >
	 * @throws IllegalArgumentException - Indicates that the page cannot be added
	 */
	public void addPage(String url, ArrayList<String> keywords) throws IllegalArgumentException
	{
		if(pages.contains(url))
		{
			throw new IllegalArgumentException("URL already exists. Cannot add page.");
		}
		if(url == null)
		{
			throw new IllegalArgumentException("Cannot add page, url is empty");
		}
		WebPage w = new WebPage(url, keywords);
		for(int i = 0; i < pages.size(); i++)
		{
			WebPage x = pages.get(i);
			if(x.getURL().equals(url))
			{
				throw new IllegalArgumentException("URL already exists. Cannot add page.");
			}
		}
		pages.add(w);
		for(int j = 0; j < pages.size(); j++)
		{
			pages.get(j).setIndex(j);
		}
	}
	
	/**
	 * Removes a WebPage from the WebGraph
	 * @param url - The name of the WebPage being added - String
	 * @throws NullPointerException - Indicates that the WebPage with the given name does not exist
	 * @throws Exception - Indicates that the WebPage is empty
	 */
	public void removePage(String url) throws NullPointerException, Exception
	{
		Boolean flag = false;
		if(pages == null)
		{
			throw new NullPointerException("No elements exists, so nothing can be removed.");
		}
		WebPage w = new WebPage(url, null);
		for(int i = 0; i < pages.size(); i++)
		{
			w = pages.get(i);
			if(w.getURL().equals(url))
			{
				pages.remove(i);
				for(int j = 0; j < pages.size(); j++)
				{
					pages.get(j).setIndex(j);
				}
				flag = true;
			}
		}
		if(flag == false)
		{
			throw new Exception(url + "Does not exist in this graph. Nothing was removed");
		}
		
	}
	
	/**
	 * Adds a link between two WebPages in the WebGraph
	 * @param source - The url of the WebPage containing the link
	 * @param destination - The url of the WebPage being linked to
	 * @throws IllegalArgumentException - Indicates that one of the WebPages is not in the WebGraph
	 */
	public void addLink(String source, String destination) throws IllegalArgumentException
	{
		int index1 = 100;
		int index2 = 100;
		if(source == null || destination == null)
		{
			throw new IllegalArgumentException("Cannot add link, either the source or destination is empty");
		}
		for(int i = 0; i < pages.size(); i++)
		{
			WebPage w = pages.get(i);
			if(w.getURL().equals(source))
			{
				index1 = i;
			}
			if(w.getURL().equals(destination))
			{
				index2 = i;
			}
		}
		
		if(index1 == 100 || index2 == 100)
		{
			throw new IllegalArgumentException("The source or destination does not exist.");
		}
		edges[index2][index1] = 1;		
	}
	
	/**
	 * Removes a link between two WebPages
	 * @param source - The url of the WebPage containing the link
	 * @param destination - The url of the WebPage being linked to
	 */
	public void removeLink(String source, String destination)
	{
		int index1 = 100;
		int index2 = 100;
		if(source == null || destination == null)
		{
			throw new IllegalArgumentException("Cannot remove link, either the source or destination is empty");
		}
		WebPage w = new WebPage(source, null);
		for(int i = 0; i < pages.size(); i++)
		{
			w = pages.get(i);
			if(w.getURL().equals(source))
			{
				index1 = i;
			}
			if(w.getURL().equals(destination))
			{
				index2 = i;
			}
		}
		if(index1 == 100)
		{ 
			throw new IllegalArgumentException(source + " does not exist.");
		}
		if(index2 == 100)
		{
			throw new IllegalArgumentException(destination + " does not exist.");
		}
		edges[index2][index1] = 0;
	}
	
	/**
	 * Calculates the rank of each WebPage based on the number of links to the page. The WebPage's rank value
	 * is then updated to the number of links to the WebPage.
	 */
	public void updatePageRanks()
	{
		//int[] rank = new int[pages.size()];
		WebPage w = new WebPage(null, null);
		for(int i = 0; i < pages.size(); i++)
		{
			//rank[i] = 0;
			pages.get(i).resetRank();
			for(int j = 0; j < pages.size(); j++)
			{
				w = pages.get(i);
				if(edges[i][j] == 1)
				{
					//rank[i]++;
					pages.get(i).setRank();
				}
			}
		}
	}
	
	/**
	 * Prints a formatted table of WebPages sorted by index
	 */
	public void printTable()
	{
		int k, j;
		for (k=0; k<=pages.size()-2; k++)
		{
			for (j=k+1; j<=pages.size()-1; j++)
			{
				if (pages.get(k).getIndex() > pages.get(j).getIndex())
				{
					WebPage x = new WebPage();
					x = pages.get(k);
					pages.set(k, pages.get(j));
					pages.set(j, x);
				}
			}
		}
		System.out.println("\t\t\t\t");
		Object[] w = pages.toArray();
		for(int i = 0; i < w.length; i++)
		{
			//pages.get(i).setIndex(i);
			WebPage x = (WebPage)w[i];
			System.out.print(x.toString());
			System.out.print(" - ");
			for(int h = 0; h < pages.size(); h++)
			{
				if(this.edges[i][h] == 1)
				{
					System.out.print(h + ",");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * Prints a formatted table of WebPages sorted by rank
	 */
	public void printTable3(WebGraph web)
	{
		//ArrayList<WebPage> list = Collections.sort(pages);
			int k, j;
			ArrayList<WebPage> temp;
			WebGraph b = new WebGraph();
			b = (WebGraph) WebGraph.clone(web);
			temp = b.getPages();
			b.setPages(temp);
			for (k=0; k<=temp.size()-2; k++)
			{
				for (j=k+1; j<=temp.size()-1; j++)
				{
					if (temp.get(k).getRank() < temp.get(j).getRank())
					{
						WebPage x = new WebPage();
						x = temp.get(k);
						temp.set(k, temp.get(j));
						temp.set(j, x);
					}
				}
			}
		//printTable();
			Object[] w = temp.toArray();
			for(int i = 0; i < w.length; i++)
			{
				//temp.get(i).setIndex(i);
				WebPage x = (WebPage)w[i];
				System.out.print(x.toString());
				System.out.print("\t - ");
				for(int h = 0; h < temp.size(); h++)
				{
					if(this.edges[x.getIndex()][h] == 1)
					{
						System.out.print(h + ",");
					}
				}
				System.out.println();
			}
		//pages = temp;
	}
	
	/**
	 * Prints a formatted table of WebPages sorted by url
	 */
	public void printTable2()
	{
		int k, j;
		for (k=0; k<=pages.size()-2; k++)
		{
			for (j=k+1; j<=pages.size()-1; j++)
			{
				if (pages.get(k).getURL().compareTo(pages.get(j).getURL()) > 0) //URL
				{
					WebPage x = new WebPage();
					x = pages.get(k);
					pages.set(k, pages.get(j));
					pages.set(j, x);
				}
			}
		}
		
		Object[] w = pages.toArray();
		for(int i = 0; i < w.length; i++)
		{
			//pages.get(i).setIndex(i);
			WebPage x = (WebPage)w[i];
			System.out.print(x.toString());
			System.out.print("\t - ");
			for(int h = 0; h < pages.size(); h++)
			{
				if(this.edges[i][h] == 1)
				{
					System.out.print(h + ",");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * Searches the WebPages for matching keywords. If the keyword is found, the WebPage is printed. All WebPages
	 * containing the keyword are printed, sorted by rank.
	 * @param keyword - The keyword being searched for among the WebPages - String
	 */
	public void search(String keyword)
	{
		int k, j;
		for (k=0; k<=pages.size()-2; k++)
		{
			for (j=k+1; j<=pages.size()-1; j++)
			{
				if (pages.get(k).getRank() < pages.get(j).getRank())
				{
					WebPage x = new WebPage();
					x = pages.get(k);
					pages.set(k, pages.get(j));
					pages.set(j, x);
				}
			}
		}
		int index = 1;
		System.out.println("INDEX\t RANK\t URL");
		for(int i = 0; i < pages.size(); i++)
		{
			if(pages.get(i).getKeywords().contains(keyword))
			{
				System.out.println(index + "\t| " + pages.get(i).getRank() + "\t| " + pages.get(i).getURL());
				index++;
			}
		}
	}

	/**
	 * Creates a deep copy of a WebGraph
	 * @param obj - WebGraph object to be copied
	 * @return temp - Object
	 */
	public static Object clone(WebGraph obj) {

		WebGraph temp = new WebGraph();
		temp.setPages(obj.getPages());
		temp.setEdges(obj.getEdges());
		return temp;
	}
	
}
