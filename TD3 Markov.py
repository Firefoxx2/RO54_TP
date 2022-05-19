class HiddenMarkovModel:
    def __init__(self, size) -> None:
        self.SIZE = size
        self.table = [[0 for x in range(self.SIZE)] for y in range(self.SIZE)] 
        self.sumFrom = [0] * self.SIZE
        self.sumTo = [0] * self.SIZE

    def move(self, fromID, toID) -> None:
        self.table[fromID][toID] += 1
        self.sumFrom[fromID] += 1
        self.sumTo[toID] += 1

    def moveXtimes(self, fromID, toID, Ntimes) -> None:
        for i in range(0,Ntimes):
            self.move(fromID, toID)
    
    def compute_coef(self):
        proba_in = [[0 for x in range(self.SIZE)] for y in range(self.SIZE)] 
        proba_out = [[0 for x in range(self.SIZE)] for y in range(self.SIZE)] 
        for x in range(self.SIZE):
            for y in range(self.SIZE):
                proba_in[x][y] = self.table[x][y]*100/self.sumFrom[x] if self.sumFrom[x] != 0 else 0
                proba_out[x][y] = self.table[x][y]*100/self.sumTo[y] if self.sumTo[y] != 0 else 0
        return proba_in, proba_out

    def __str__(self) -> str:
        proba_in, proba_out = self.compute_coef()
        buff = ''
        buff += '  ║  '
        for x in range(self.SIZE):
            buff += str(self.sumTo[x]) + '                  ║  '
        buff += '\n'
        buff += '══╬═════════════════════╬═════════════════════╬═════════════════════╬═════════════════════╬═════════════════════╬═════════════════════╣\n'
        for x in range(self.SIZE):
            buff += str(self.sumFrom[x]) + ' ║ '
            for y in range(self.SIZE):
                buff += str(self.table[x][y]) + '  '
                buff += '%6.2f' %(proba_in[x][y]) + '% '
                buff += '%6.2f' %(proba_out[x][y]) + '% '
                buff += " │ "
            buff += '\n'
        return buff

ext=0
A=1
B=2
C=3
D=4
E=5

HMM = HiddenMarkovModel(6)

HMM.moveXtimes(ext, A, 12)
HMM.moveXtimes(A, B, 18)
HMM.moveXtimes(B, A, 10)
HMM.moveXtimes(ext, B, 2)
HMM.moveXtimes(B, C, 10)
HMM.moveXtimes(C, ext, 20)
HMM.moveXtimes(C, C, 12)
HMM.moveXtimes(D, C,10)
HMM.moveXtimes(D, D,30)
HMM.moveXtimes(A, D, 8)
HMM.moveXtimes(E, D,2)
HMM.moveXtimes(E, E,3)
HMM.moveXtimes(ext, E,6)
HMM.moveXtimes(E, A,4)


print(HMM)