
def remove_greator( items, max):
    
    if min_usable > 0:
        i = 0
        
        while i < len(items):
            if items[i] >= max:
                items.remove(items[i])
                i -= 1
            else:
                i += 1
                # print("item", item, items)
    return items


def get_max( items, max ):
    maxf = -1
    for item in items:
        if item > maxf and item <= max:
            maxf = item
    return maxf



with open("rosin.dat") as f:
    num = int(f.readline())
    for i in range(num):
        f.readline()
        coins = [int(i) for i in f.readline().split()]
        coins_used = 0
        cost = int(f.readline())
        min_usable = get_max(coins, cost)
        coins = remove_greator(coins, min_usable)
        while min_usable > 0:
            coins_used += cost // min_usable
            cost %= min_usable
            min_usable = get_max(coins, cost)
            coins = remove_greator(coins, min_usable)

        if cost == 0:
            print(str(coins_used))

        else:
            print("No rosin for you! Come back in one year!")