import java.util.ArrayList;
import java.util.Comparator;


public class URLComparator implements Comparator{

	public int compare(ArrayList<WebPage> pages, Object arg1) 
	{
		int k, j;
		for (k=0; k<=pages.size()-2; k++)
		{
			for (j=k+1; j<=pages.size()-1; j++)
			{
				if (pages.get(k).getURL().compareTo(pages.get(j).getURL()) > 0) //URL
				{
					WebPage x = new WebPage();
					return 1;
				}
			}
		}
		return -1;
	}
	
	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
}
