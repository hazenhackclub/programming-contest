def find_factors(num):
    list = []
    print(num)
    for i in range((num // 2) + 1):
        if i == 0:
            continue
        if num % i == 0:
            list.append(i)
    list.append(num)        
    return list        

with open("metrognome.dat") as f:
    num = int(f.readline())
    for i in range(num):
        f.readline()
        list = f.readline().split()

        list = [int(i) for i in list]

        list.sort(reverse=True)

        print(list)

        
        for item in list:
            print(find_factors(item))
