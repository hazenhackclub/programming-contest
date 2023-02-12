with open("bach.dat") as f:
    movieLines, testLines = f.readline().strip().split()
    dicOfMovieTimes = {}
    for i in range(int(movieLines)):
        line = f.readline().strip()
        name, timePor = line.split()
        hours, minutes = timePor.split(":")
        valueOfTime = int(hours) * 60 + int(minutes)
        dicOfMovieTimes[name] = valueOfTime

    #print(dicOfMovieTimes)
    for j in range(int(testLines)):
        listOfValidMovies = []
        hours, minutes = f.readline().strip().split(":")
        valueOfTime = int(hours) * 60 + int(minutes)
        #print(valueOfTime)
        for key in dicOfMovieTimes.keys():
            if dicOfMovieTimes[key] <= valueOfTime:
                listOfValidMovies.append((dicOfMovieTimes[key], key))
        listOfValidMovies.sort(key = lambda x : x[0])
        #print(listOfValidMovies)
        if len(listOfValidMovies) == 0:
            print("Why Don't You Make Like a Tree and Get Outta Here?")
        else:
            pairIndex = 0
            while pairIndex <  len(listOfValidMovies) -1:
                print(listOfValidMovies[pairIndex][1], end = " ")
                pairIndex +=1
            print(listOfValidMovies[-1][1])
    #print(dicOfMovieTimes)