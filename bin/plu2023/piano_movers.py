import math

with open("piano.dat") as f:
    dataSets = int(f.readline())
    for a in range(dataSets):
        f.readline()
        line = f.readline().strip()
        listOfTiles = line.split("-")
        #print(listOfTiles)
        total = 0
        for elem in listOfTiles:
            total += len(elem) // 3
        print(total)
