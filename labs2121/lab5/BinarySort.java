import java.util.ArrayList;

public class BinarySort {
	ArrayList<Integer> list;
	int high;
	int low;
	int input;
	
	public BinarySort(ArrayList<Integer> list) {
		this.list=list;
	}

	public int sort(ArrayList<Integer> list, int input, int low, int high) {
		if (high < low)
			return -1;
		else {
			int mid=low+((high-low)/2);
			if (list.get(mid)>input)
				return sort(list, input, low, mid-1);
			else if (list.get(mid)<input)
				return sort(list, input, mid+1, high);
			else
				return mid;
		}
	}
}