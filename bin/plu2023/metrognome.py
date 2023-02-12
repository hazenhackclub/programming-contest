import math

with open("metrognome.dat") as f:
    num = int(f.readline())
    for i in range(num):
        f.readline()
        list = f.readline().split()

        list = [int(i) for i in list]

        maximum = max(list)
        i = maximum
        list.remove(maximum)
        list.sort(reverse=True)
        while True:
            works = True
            for item in list:
                if not (i % item == 0):
                    works = False
                    i += maximum
                    break
                else:
                    maximum *= item
                    list.remove(item)
            if works:
                break
        print(i)        