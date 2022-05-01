SIZE = 6

table = [[0 for x in range(SIZE)] for y in range(SIZE)] 
sumFrom = [0] * SIZE
sumTo = [0] * SIZE

def move(fromID, toID):
    table[fromID][toID] += 1
    sumFrom[fromID] += 1
    sumTo[toID] += 1

def mprint():
    print('  ║  ', end = '')
    for x in range(SIZE):
        print(str(sumTo[x]) + '                  ║  ', end = '')
    print()
    print('══╬═════════════════════╬═════════════════════╬═════════════════════╬═════════════════════╬═════════════════════╬═════════════════════╣')
    for x in range(SIZE):
        print(str(sumFrom[x]) + ' ║ ', end = '')
        for y in range(SIZE):
            print(str(table[x][y]) + '  ', end = '')
            if(sumFrom[x] != 0):
                print('%6.2f' %(table[x][y]*100/sumFrom[x]) + '% ', end = '')
            else:
                print('%6.2f' %(0) + '% ', end = '')
            if(sumTo[y] != 0):
                print('%6.2f' %(table[x][y]*100/sumTo[y]) + '% ', end = '')
            else:
                print('%6.2f' %(0) + '% ', end = '')
            print(" │ ", end = '')
        print("")

#move(2,2)
move(1,2)
move(1,3)
#move(1,4)
mprint()