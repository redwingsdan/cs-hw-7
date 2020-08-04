import java.util.ArrayList;
import java.util.Comparator;


public class IndexComparator implements Comparator{
	public int compare(ArrayList<WebPage> pages, Object arg1) {
		int k, j;
		for (k=0; k<=pages.size()-2; k++)
		{
			for (j=k+1; j<=pages.size()-1; j++)
			{
				if (pages.get(k).getIndex() > pages.get(j).getIndex())
				{
					return 1;
				}
			}
		}
		return -1;
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
