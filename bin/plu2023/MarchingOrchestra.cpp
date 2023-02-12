#include <fstream>
#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;

enum Dir { N, E, S, W };

vector<Dir> closestDirection( pair<int, int> pos, pair<int, int> des ) {
	
	int dY = -(des.first - pos.first), dX = des.second - pos.second;
	vector<Dir> arr{4};
	if (abs(dX) > abs(dY)) {
		if (dX > 0) {
			arr[0] = E;
			arr[3] = W;
		} else {
			arr[0] = W;
			arr[3] = E;
		}

		if (dY > 0) {
			arr[1] = N;
			arr[2] = S;
		} else {
			arr[1] = S;
			arr[2] = N;
		}
	} else {
		if (dY > 0) {
			arr[0] = N;
			arr[3] = S;
		} else {
			arr[0] = S;
			arr[3] = N;
		}

		if (dX > 0) {
			arr[1] = E;
			arr[2] = W;
		} else {
			arr[1] = W;
			arr[2] = E;
		}
	}

	return arr;
}

pair<int,  int> moveDirection(pair< int,  int> pos, Dir direction) {
	switch (direction) {
		default:
		case N:
			return pair<int, int>{pos.first - 1, pos.second};
		case E:
			return pair<int, int>{pos.first, pos.second + 1};
		case S:
			return pair<int, int>{pos.first + 1, pos.second};
		case W:
			return pair<int, int>{pos.first, pos.second - 1};
	}
}

bool canMove(pair<int, int> pos, Dir direction, vector< vector<char> > map, vector< vector<bool> > visited) {
	pair<int, int> newPos = moveDirection(pos, direction);
	return newPos.first >= 0 && newPos.second >= 0 && newPos.first < map.size()
			&& newPos.second < map[0].size() && map[newPos.first][newPos.second] != '#'
			&& !visited[newPos.first][newPos.second];
}



// vector< vector<bool> > clone( vector< vector<bool> > clone ) {

// 	vector< vector<bool> > dest[clone.size()];
// 	// std::copy(clone, clone + clone.size(), back_inserter(dest));
// 	std::copy(clone.begin(), clone.end(), back_inserter(dest));
// 	return dest;
// }

int findShortestPath( pair<int, int> pos, pair<int, int> des, vector< vector<char> > map, vector< vector<bool> > visited, int length ) {

	if( pos.first == des.first && pos.second == des.second )
		return length;

	visited[pos.first][pos.second] = true; // check off this square
	vector<Dir> orderedDirections = closestDirection( pos, des );

	for( Dir dir : orderedDirections ) {
		if( canMove( pos, dir, map, visited ) ) {
			int result = findShortestPath( moveDirection( pos, dir ), des, map, visited, length + 1 );
			if( result != -1 )
				return result;
		}
	}

	return -1;
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

		vector< vector<char> > maze; // y, x
		vector< vector<bool> > visited; // y, x
		map<char, pair<int, int> > startingPositions {};
		map<char, pair<int, int> > endingPositions {};

		for( int row = 0; row < n; row++ ) {
			vector<char> line( m );
			for( int column = 0; column < m; column++ ){
				myFile >> line[column];

				int num = (int) line[column];
				if( num >= 65 && num <= 90 )
					startingPositions[line[column]] = pair<int, int>{ row, column } ;
				else if( num >= 97 && num <= 122 )
					endingPositions[line[column]] = pair<int, int>{ row, column } ;
			}

			maze.push_back(line);
			visited.push_back(vector<bool>( m ));
		}

		for( auto row : maze ) {
			for( char i : row )
				std::cout << i << ' ';
			cout << endl;
		}

		int length = 0;
		for( map<char, pair<int, int> >::iterator itr = startingPositions.begin(); itr != startingPositions.end(); itr++){
			int cur = findShortestPath( startingPositions.at( itr->first ), endingPositions.at( (char) tolower(itr->first) ), maze, visited, 0 );
			length += cur;
			cout << itr->first << " " << cur << endl;
}
		cout << length << endl;
	}

	myFile.close( );

	return 0;
}

