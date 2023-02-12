import math

with open("forte.dat") as f:
    dataSets = int(f.readline())
    for a in range(dataSets):
        num = int(f.readline().strip())
        stringToPrint = ""
        if num == -1:
            stringToPrint += "piano"
        if num < -1:
            stringToPrint += "pian"
            numsOfIss = num + 1
            for i in range(numsOfIss*(-1)):
                stringToPrint += "iss"
            stringToPrint += "imo"

        if num == 1:
            stringToPrint += "forte"
        if num > 1:
            stringToPrint += "fort"
            numsOfIss = num - 1
            for i in range(numsOfIss):
                stringToPrint += "iss"
            stringToPrint += "imo"
        print(stringToPrint)
        