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

/**
 * This class creates an object of the type WebPage. This class gives each WebPage object a url, an index,
 * a rank, and a list of keywords. The WebPage url and keywords cannot be changed after being initialized.
 * The WebPage index can be changed to any value and the rank can be reset to 0 or incremented by one whenever
 * a new WebPage links to it. There is also a function to print a string representation of the entire 
 * WebPage.
 */
public class WebPage {
	private String url;
	private int index;
	private int rank;
	private ArrayList<String> keywords;
	
	public WebPage()
	{
		url = null;
		index = 0;
		rank = 0;
		keywords = null;
	}
	
	/**
	 * Creates an instance of <code>WebPage</code> - Constructor
	 * @param url = The name of the url for this WebPage - String
	 * @param index = The index value of the WebPage on a list - int
	 * @param rank = The number of WebPages which have links to this WebPage - int
	 * @param keywords = The list of keywords given for this WebPage - ArrayList < String >
	 */
	public WebPage(String url, ArrayList<String> keywords)
	{
		this.url = url;
		this.index = 0;
		this.rank = 0;
		this.keywords = keywords;
	}
	
	/**
	 * Sets the value of <code>index</code> to the int value passed in.
	 * @param index = The index value of the WebPage on a list - int
	 */
	public void setIndex(int value)
	{
		this.index = value;
	}
	
	/**
	 * Increments the value of <code>rank</code> by one.
	 * @param rank = The number of WebPages which have links to this WebPage - int
	 */
	public void setRank()
	{
		rank = rank + 1;
	}
	
	/**
	 * Sets the value of <code>right</code> to zero.
	 * @param rank = The number of WebPages which have links to this WebPage - int
	 */
	public void resetRank()
	{
		rank = 0;
	}
	
	/**
	 * Returns the value of <code>index</code> - int
	 * @return index - int
	 */
	public int getIndex()
	{
		return this.index;
	}
	
	/**
	 * Returns the value of <code>url</code> - String
	 * @return url - String
	 */
	public String getURL()
	{
		return this.url;
	}
	
	/**
	 * Returns the value of <code>keywords</code> - ArrayList < String >
	 * @return keywords - ArrayList < String >
	 */
	public ArrayList<String> getKeywords()
	{
		return this.keywords;
	}
	
	/**
	 * Returns the value of <code>rank</code> - int
	 * @return rank - int
	 */
	public int getRank()
	{
		return this.rank;
	}
	
	/**
	 * Returns the string representation of the current WebPage - String
	 * @return - String
	 */
	public String toString()
	{
		String msg = String.format("%-14s", index + "  |  " + url + "\t - " + rank + " \t\t| " + keywords + "\t\t");
		return msg;
	}
}
