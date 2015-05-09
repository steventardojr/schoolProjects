#include <cstdlib>
#include <iomanip>
#include <iostream>
#include <string>

using namespace std;

int main() {
	string input = "abc";
	
	int length = 3;
	
	cout << "{}, ";
	for (int i = 0; i < length; i ++)
		cout << "{" << input.at(i) << "}, ";
	
	for (int i = 0; i < length-1; i++) {
		int j = i + 1;
		while (j < length) {
			cout << "{" << input.at(i) << ","  << input.at(j) << "},";
			cout << " ";
			j++;
		}
		j++;
	}
	
	cout << "{";
	for (int i = 0; i < length - 1; i++) {
		cout << input.at(i) << ",";
	}
	cout << input.at(length -1) << "}";
	cout << endl;
}