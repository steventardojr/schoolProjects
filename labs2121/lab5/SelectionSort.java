import java.util.ArrayList;

public class SelectionSort {
	ArrayList<Integer> list;
	
	public SelectionSort(ArrayList<Integer> list) {
		this.list=list;
	}
	
	public void swap(int firstIndex, int secondIndex) {
		Integer temp = list.get(firstIndex);
		list.set(firstIndex, list.get(secondIndex));
		list.set(secondIndex, temp);
	}
	
	public int linearSearch(int startIndex) {
		Integer lowestValue = list.get(startIndex);
		int lowestIndex = startIndex;
		for (int i = startIndex; i <list.size(); i++) {
			if (list.get(i)<lowestValue) {
				lowestIndex = i;
				lowestValue = list.get(i);
			}
		}
		return lowestIndex;
	}
	
	public void sort(int startIndex) {
		if (startIndex == list.size()) {
			
		}
		else {
			int lowestIndex = linearSearch(startIndex);
			swap(startIndex, lowestIndex);
			sort(startIndex + 1);
		}
	}
}