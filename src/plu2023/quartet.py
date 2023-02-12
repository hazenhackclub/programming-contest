
with open("quartet.dat") as f:
    num = int(f.readline())
    for i in range(num):
        list = f.readline().split()
        list = [int(i) for i in list]
        
        violin = [max([int(i) for i in f.readline().split()])]
        violin.append(max([int(i) for i in f.readline().split()]))
        violin.append(max([int(i) for i in f.readline().split()]))
        violin.append(max([int(i) for i in f.readline().split()]))

        print(sum(violin))