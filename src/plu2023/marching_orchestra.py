def funcAllCombos(currentPos, visitedLocs, stepsTaken, goal):
    
    global minSolution
    global maze
    global badCords
    if currentPos in badCords:
        return False 
    if stepsTaken >= minSolution:
        return False
    if currentPos in visitedLocs:
        return False
    visitedLocs.add(currentPos)
    currX, currY = currentPos
    if currX < 0 or currX >= len(maze[0]):
        badCords.add(currentPos)
        return False
    if currY < 0 or currY >= len(maze):
        badCords.add(currentPos)
        return False
    
    if maze[currY][currX] == "#":
        return False
    elif maze[currY][currX] == goal:
   
        if stepsTaken < minSolution:
            minSolution = stepsTaken
        return False
    stepsTaken += 1
    
    newUpPos = (currX, currY+1)
    funcAllCombos(newUpPos, visitedLocs.copy(), stepsTaken, goal)
    newDownPos = (currX, currY-1)
    funcAllCombos(newDownPos, visitedLocs.copy(), stepsTaken, goal)
    newLeftPos = (currX - 1, currY)
    funcAllCombos(newLeftPos, visitedLocs.copy(), stepsTaken, goal)
    newRightPos = (currX + 1, currY)
    funcAllCombos(newRightPos, visitedLocs.copy(), stepsTaken, goal)

    return False


with open("marching.dat") as f:
    #print(ord('a'))
    #print(ord('z'))
    #print(ord('A'))
    #print(ord('Z'))
    dataSets = int(f.readline())
    for a in range(dataSets):
        
        badCords = set()
        allStartLocs = {}
        allGoalValues = {}
        minNum = 0
        rows, cols = f.readline().split()
        maze = [[] for i in range(int(rows))]
        rowN = 0
        for i in range(int(rows)):
            line = f.readline().strip().strip()
            colN = 0
            for char in line:
                if ord(char) >= 97 and ord(char) <= 122:
                    allGoalValues[ord(char)] = char
                    minNum += 1
                elif ord(char) >= 65 and ord(char) <= 90:
                    allStartLocs[ord(char)] = (colN, rowN)
                    minNum += 1
                elif char == ".":
                    minNum += 1
                maze[rowN].append(char)
                colN += 1
            rowN += 1
        #print(minNum)
        totalSteps = 0
        for key in allStartLocs:
            minSolution = minNum-1
            letterValue = key + 32
            goalLetter = allGoalValues[letterValue]
            #startLoc
            startCord = allStartLocs[key]
            #print(startCord)
            visitedLocs = set()
            funcAllCombos(startCord, visitedLocs.copy(), 0, goalLetter)

            totalSteps += minSolution
            #print(goalLetter)
        print(totalSteps)
    #
    