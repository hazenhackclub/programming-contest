def funcAllCombos(currentPos, visitedLocs, toolsList, maze):
    global minSolution
    if someCond >= minSolution:
        return 94
    if currentPos in visitedLocs:
        return 100
    visitedLocs.append(currentPos)
    currX, currY = currentPos
    if currX < 0 or currX >= len(maze[0]):
        return 99
    if currY < 0 or currY >= len(maze):
        return 98
    
    if maze[currY][currX] == ".":
        #do something
        pass

    newUpPos = (currX, currY+1)
    funcAllCombos(newUpPos, visitedLocs.copy(), toolsList.copy(), maze.copy())
    newDownPos = (currX, currY-1)
    funcAllCombos(newDownPos, visitedLocs.copy(), toolsList.copy(), maze.copy())
    newLeftPos = (currX - 1, currY)
    funcAllCombos(newLeftPos, visitedLocs.copy(), toolsList.copy(), maze.copy())
    newRightPos = (currX + 1, currY)
    funcAllCombos(newRightPos, visitedLocs.copy(), toolsList.copy(), maze.copy())

    return 11


with open("practice.dat") as f:
    dataSets = int(f.readline())
    for a in range(dataSets):
        minSolution = 3
        numLines = int(f.readline())
        maze = [[] for i in range(numLines)]
        rowN = 0
        for i in range(numLines):
            line = f.readline().strip()
            colN = 0
            for char in line:
                if char == "S":
                    #code here: (always create (x,y) tuples)
                    #startLoc = (colN, rowN)
                    pass
                colN += 1
            rowN += 1
    funcAllCombos(startLoc, visitedLocs.copy(), listOfTolls.copy(), maze.copy())
