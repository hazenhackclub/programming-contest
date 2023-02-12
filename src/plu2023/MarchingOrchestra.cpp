#include <fstream>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int closestDirection( pair<int, int> pos, pair<int, int> des ) {
}

int main( ) {
	ifstream myFile( "marching.dat" );
	if( !myFile.is_open( ) ) {
		cerr << "Unable to open file\n";
		return 1;
	}

	int num;
	myFile >> num;

	for( int i = 0; i < num; i++ ) {
		int n, m;
		myFile >> n;
		myFile >> m;
		for( int row = 0; row < n; row++ ) {
			vector<char> line( m );
			for( int column = 0; column < m; column++ )
				myFile >> line[column];

			// for( auto i : line )
			// 	std::cout << i << ' ';
			// cout << endl;
		}
		cout << endl;

		// cout << n << " and m: " << m << endl;
	}

	myFile.close( );
	return 0;
}